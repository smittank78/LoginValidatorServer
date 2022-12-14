package api.loginvalidatorserver.controller;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import api.loginvalidatorserver.dto.CustomerLogFileDto;
import api.loginvalidatorserver.dto.CustomerLogFileResponseDto;
import api.loginvalidatorserver.dto.CustomerLogFileTrackingDto;
import api.loginvalidatorserver.dto.FileTypesDto;
import api.loginvalidatorserver.dto.SourcesDto;
import api.loginvalidatorserver.dto.StatusDto;
import api.loginvalidatorserver.entity.CustomerLogFileTracking;
import api.loginvalidatorserver.entity.Sources;
import api.loginvalidatorserver.service.CustomerLofFileService;

@RestController
@PropertySource("status.properties")
@SuppressWarnings(value = { UFRestController.UNUSED })
public class UFRestController 
{
	static final String UNUSED = "unused";

	Logger logger = Logger.getLogger(UFRestController.class.getName());
	
	@Autowired
	org.springframework.core.env.Environment environment;
	
	@Autowired
	CustomerLofFileService service;
	
	@GetMapping("/")
	public void test() 
	{
		logger.info("request received...");
	}
	
	@GetMapping("/insert")
	public void insert(@Valid @RequestBody CustomerLogFileDto customerLogFileDto) throws UnknownHostException 
	{
		CustomerLogFileTrackingDto fileTrackingDto = new CustomerLogFileTrackingDto();
		logger.info("request received for insert..." + customerLogFileDto.toString());
		customerLogFileDto.setForwardedIP(Inet4Address.getLocalHost().getHostAddress());
		customerLogFileDto.setSubmitterName(Inet4Address.getLocalHost().getHostName());
		customerLogFileDto.setUpdateTimeStamp(new Date().toString());

		FileTypesDto fileTypesDto = new FileTypesDto();
		fileTypesDto.setFileTypeId(1);
		
		StatusDto statusDto = new StatusDto();
		statusDto.setStatusId(Integer.parseInt(environment.getProperty("STATUS_RECIEVED_UPLOAD_REQUEST")));
		
		SourcesDto sourcesDto = new SourcesDto();
		sourcesDto.setSourceId(1);
		
		customerLogFileDto.setFileTypes(fileTypesDto);
		customerLogFileDto.setSources(sourcesDto);
		customerLogFileDto.setStatus(statusDto);
		
		int autoGeneratedID = service.insertCustomerLogFile(customerLogFileDto);
		fileTrackingDto.setId(autoGeneratedID);
		fileTrackingDto.setUploadId(autoGeneratedID);
		fileTrackingDto.setOldStatusId(customerLogFileDto.getStatus().getStatusId());
		if(autoGeneratedID > 0)
		{
			customerLogFileDto.setId(autoGeneratedID);
			customerLogFileDto.setStatus(customerLogFileDto.getStatus());
			int newAutoGeneratedId = service.insertCustomerLogFile(customerLogFileDto);		
			if(autoGeneratedID == newAutoGeneratedId)
			{
				logger.info("data updated...");
			}
			else {
				logger.info("new data added...");
			}
		}
		
		boolean IfSameCaseAndFileMD5Exists = service.checkIfSameCaseAndFileMD5Exists(customerLogFileDto);
		boolean IfSameCaseAndFileMD5ExistsAndInProcess = service.checkIfSameCaseAndFileMD5ExistsAndInProcess(customerLogFileDto);
		
		logger.info("checkIfSameCaseAndFileMD5Exists : " + IfSameCaseAndFileMD5Exists);
		logger.info("checkIfSameCaseAndFileMD5ExistsAndInProcess : " + IfSameCaseAndFileMD5ExistsAndInProcess);
		if(IfSameCaseAndFileMD5Exists || IfSameCaseAndFileMD5ExistsAndInProcess)
		{
			logger.info("duplicate found -> updating status...");
			customerLogFileDto.getStatus().setStatusId(Integer.parseInt(environment.getProperty("STATUS_DUPLICATE_FILE_REQUEST")));
			int newAutoGeneratedId = service.insertCustomerLogFile(customerLogFileDto);		
			logger.info("file status updated : " + autoGeneratedID +" = " + newAutoGeneratedId);
			fileTrackingDto.setUpdateTimeStamp(new Date().toString());
			fileTrackingDto.setNewStatusId(customerLogFileDto.getStatus().getStatusId());
			fileTrackingDto.setComments("file status changed from " + fileTrackingDto.getOldStatusId() + " to " + fileTrackingDto.getNewStatusId());
			service.insertCustomerFileTrackingLog(fileTrackingDto);
			
			if(IfSameCaseAndFileMD5ExistsAndInProcess)
			{
				statusDto.setStatusId(200);
				statusDto.setStatusName("sucess");
				statusDto.setDescription("LSC message: Duplicate file request more than three times within an hour: " + autoGeneratedID);				
			}
			else {
					statusDto.setStatusId(200);
					statusDto.setStatusName("sucess");
					statusDto.setDescription("LSC message: Duplicate file request : " + autoGeneratedID);				
			}
			customerLogFileDto.getStatus().setStatusId(Integer.parseInt(environment.getProperty("STATUS_DEFAULT")));
			
			CustomerLogFileResponseDto fileResponseDto = new CustomerLogFileResponseDto();
			fileResponseDto.setCustomerLogFile(customerLogFileDto);
			fileResponseDto.setStatusDTO(statusDto);
			fileTrackingDto.setOldStatusId(fileTrackingDto.getNewStatusId());
			fileTrackingDto.setNewStatusId(customerLogFileDto.getStatus().getStatusId());
			fileTrackingDto.setComments("file status changed from " + fileTrackingDto.getOldStatusId() + " to " + fileTrackingDto.getNewStatusId());
			service.insertCustomerFileTrackingLog(fileTrackingDto);
			logger.info("tracking data updated");
		}
	}
}