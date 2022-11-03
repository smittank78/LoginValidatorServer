package api.loginvalidatorserver.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerLogFileTrackingDto 
{
	private int id;
	
	@NotNull(message = "uploadId is null")
	@NotBlank(message = "uploadId is blank")
	private int uploadId;

	@NotNull(message = "updateTimeStamp is null")
	@NotBlank(message = "updateTimeStamp is blank")
	private String updateTimeStamp;

	private int oldStatusId;
	private int newStatusId;
	private String comments;
}