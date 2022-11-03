package api.loginvalidatorserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_log_file_tracking")
public class CustomerLogFileTracking 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
		
	@Column(name = "upload_id")
	private int uploadId;

	@Column(name = "update_time_stamp")
	private String updateTimeStamp;

	@Column(name = "old_status_id")
	private int oldStatusId;

	@Column(name = "new_status_id")
	private int newStatusId;

	@Column(name = "comments")
	private String comments;

}