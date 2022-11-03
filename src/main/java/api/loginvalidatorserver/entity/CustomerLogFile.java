package api.loginvalidatorserver.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "customer_log_file")
public class CustomerLogFile 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "uploaded_file_message_digest")
	private String uploadedFileMessageDigest;
	
	@Column(name = "type")
	private String type;

	@Column(name = "serial_number")
	private String serialNumber;
	
	@Column(name = "case_number")
	private String caseNumber;	

	@Column(name = "submit_time_stamp")
	private String submitTimeStamp;

	@Column(name = "repository_location")
	private String repositoryLocation;

	@Column(name = "repository_connection")
	private String repositoryConnection;

	@Column(name = "original_file_name")
	private String originalFileName;	

	@Column(name = "forwarded_iP")
	private String forwardedIP;

	@Column(name = "submitter_name")
	private String submitterName;

	@Column(name = "user_org_name")
	private String userOrgName;

	@Column(name = "is_rest_call")
	private boolean isRestCall;

	@Column(name = "is_analytics")
	private boolean isAnalytics;

	@Column(name = "originator")
	private String originator;

	@Column(name = "version_number")
	private String versionNumber;

	@Column(name = "permanent_file_path")
	private String permanentFilePath;

	@Column(name = "calculated_file_message_digest")
	private String calculatedFileMessageDigest;

	@Column(name = "update_time_stamp")
	private String updateTimeStamp;

	@Column(name = "processed_by")
	private String processedBy;

	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "file_type_id")	
	private FileTypes fileTypes;
	
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "status_id")	
	private Status status;
	
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "sources_id")
	private Sources sources;
}