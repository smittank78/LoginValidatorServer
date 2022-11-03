package api.loginvalidatorserver.convertor;

import org.springframework.stereotype.Service;

import api.loginvalidatorserver.dto.CustomerLogFileDto;
import api.loginvalidatorserver.dto.CustomerLogFileTrackingDto;
import api.loginvalidatorserver.dto.FileTypesDto;
import api.loginvalidatorserver.dto.SourcesDto;
import api.loginvalidatorserver.dto.StatusDto;
import api.loginvalidatorserver.entity.CustomerLogFile;
import api.loginvalidatorserver.entity.CustomerLogFileTracking;
import api.loginvalidatorserver.entity.FileTypes;
import api.loginvalidatorserver.entity.Sources;
import api.loginvalidatorserver.entity.Status;

@Service
public class DtoToEntityConvertor 
{
	public CustomerLogFile getCustomerLofFileEntity(CustomerLogFileDto dto) 
	{
		CustomerLogFile customerLogFile = new CustomerLogFile();
		customerLogFile.setId(dto.getId());
		customerLogFile.setUrl(dto.getUrl());
		customerLogFile.setFileName(dto.getFileName());
		customerLogFile.setUploadedFileMessageDigest(dto.getUploadedFileMessageDigest());
		customerLogFile.setType(dto.getType());
		customerLogFile.setSerialNumber(dto.getSerialNumber());
		customerLogFile.setCaseNumber(dto.getCaseNumber());
		customerLogFile.setSubmitTimeStamp(dto.getSubmitTimeStamp());
		customerLogFile.setRepositoryLocation(dto.getRepositoryLocation());
		customerLogFile.setRepositoryConnection(dto.getRepositoryConnection());
		customerLogFile.setOriginalFileName(dto.getOriginalFileName());
		customerLogFile.setForwardedIP(dto.getForwardedIP());
		customerLogFile.setSubmitterName(dto.getSubmitterName());
		customerLogFile.setUserOrgName(dto.getUserOrgName());
		customerLogFile.setRestCall(dto.isRestCall());
		customerLogFile.setAnalytics(dto.isAnalytics());
		customerLogFile.setOriginator(dto.getOriginator());
		customerLogFile.setVersionNumber(dto.getVersionNumber());
		customerLogFile.setPermanentFilePath(dto.getPermanentFilePath());
		customerLogFile.setCalculatedFileMessageDigest(dto.getCalculatedFileMessageDigest());
		customerLogFile.setUpdateTimeStamp(dto.getUpdateTimeStamp());
		customerLogFile.setProcessedBy(dto.getProcessedBy());
		
		return customerLogFile;
	}
	
	public CustomerLogFileTracking getCustomerLofFileTrackingEntity(CustomerLogFileTrackingDto dto) 
	{
		CustomerLogFileTracking customerLogFileTracking = new CustomerLogFileTracking();
		customerLogFileTracking.setId(dto.getId());
		customerLogFileTracking.setUploadId(dto.getUploadId());
		customerLogFileTracking.setOldStatusId(dto.getOldStatusId());
		customerLogFileTracking.setNewStatusId(dto.getNewStatusId());
		customerLogFileTracking.setComments(dto.getComments());
		customerLogFileTracking.setUpdateTimeStamp(dto.getUpdateTimeStamp());
		
		return customerLogFileTracking;
	}
	
	public FileTypes getFileTypeEntity(FileTypesDto dto) 
	{
		FileTypes fileTypes = new FileTypes();
		fileTypes.setFileTypeId(dto.getFileTypeId());
		fileTypes.setFileTypeName(dto.getFileTypeName());
		
		return fileTypes;
	}
	
	public Status getStatusEntity(StatusDto dto) 
	{
		Status status = new Status();
		status.setStatusId(dto.getStatusId());
		status.setStatusName(dto.getStatusName());
		status.setDescription(dto.getDescription());
		
		return status;
	}
	
	public Sources getSourceEntity(SourcesDto dto) 
	{
		Sources sources = new Sources();
		sources.setSourceId(dto.getSourceId());
		//sources.setSourceName(dto.getSourceName());
		
		return sources;
	}
}