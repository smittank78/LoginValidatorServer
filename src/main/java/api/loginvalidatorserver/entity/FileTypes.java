package api.loginvalidatorserver.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "file_type")
public class FileTypes
{
	@Id
	@Column(name = "id")
	private int fileTypeId;
	
	@Column(name = "name")
	private String fileTypeName;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "fileTypes")
	List<CustomerLogFile>  customerLogFile;
}