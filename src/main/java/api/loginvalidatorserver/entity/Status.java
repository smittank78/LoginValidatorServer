package api.loginvalidatorserver.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "status")
public class Status 
{
	@Id
	@Column(name = "id")
	private int statusId;
	
	@Column(name = "status_name")
	private String statusName;
	
	@Column(name = "status_description")
	private String description;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "status")
	List<CustomerLogFile>  customerLogFile;
}