package api.loginvalidatorserver.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerLogFileDto 
{

	@NotNull(message = "uploadedFileMessageDigest is null")
	@NotBlank(message = "uploadedFileMessageDigest is blank")
	private String url;
	private int id;
	
	@NotNull(message = "fileName is null")
	@NotBlank(message = "fileName is blank")
	@NotEmpty(message = "fileName is blank")
	private String fileName;
	
	@NotNull(message = "uploadedFileMessageDigest is null")
	@NotBlank(message = "uploadedFileMessageDigest is blank")
	private String uploadedFileMessageDigest;

	@NotNull(message = "type is null")
	@NotBlank(message = "type is blank")
	private String type;

	@NotNull(message = "serialNumber is null")
	@NotBlank(message = "serialNumber is blank")
	private String serialNumber;

	@NotNull(message = "caseNumber is null")
	@NotBlank(message = "caseNumber is blank")
	private String caseNumber;

	@NotNull(message = "submitTimeStamp is null")
	@NotBlank(message = "submitTimeStamp is blank")
	private String submitTimeStamp;

	@NotNull(message = "repositoryLocation is null")
	@NotBlank(message = "repositoryLocation is blank")
	private String repositoryLocation;

	@NotNull(message = "repositoryConnection is null")
	@NotBlank(message = "repositoryConnection is blank")
	private String repositoryConnection;

	@NotNull(message = "originalFileName is null")
	@NotBlank(message = "originalFileName is blank")
	private String originalFileName;

	@NotNull(message = "forwardedIP is null")
	@NotBlank(message = "forwardedIP is blank")
	private String forwardedIP;

	@NotNull(message = "submitterName is null")
	@NotBlank(message = "submitterName is blank")
	private String submitterName;

	@NotNull(message = "userOrgName is null")
	@NotBlank(message = "userOrgName is blank")
	private String userOrgName;
	
	private boolean isRestCall;
	private boolean isAnalytics;

	@NotNull(message = "originator is null")
	@NotBlank(message = "originator is blank")
	private String originator;

	@NotNull(message = "versionNumber is null")
	@NotBlank(message = "versionNumber is blank")
	private String versionNumber;

	@NotNull(message = "permanentFilePath is null")
	@NotBlank(message = "permanentFilePath is blank")
	private String permanentFilePath;

	@NotNull(message = "calculatedFileMessageDigest is null")
	@NotBlank(message = "calculatedFileMessageDigest is blank")
	private String calculatedFileMessageDigest;

	private String updateTimeStamp;

	@NotNull(message = "processedBy is null")
	@NotBlank(message = "processedBy is blank")
	private String processedBy;
	
	private FileTypesDto fileTypes;
	private SourcesDto sources;
	private StatusDto status;

}