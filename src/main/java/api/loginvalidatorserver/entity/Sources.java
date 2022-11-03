package api.loginvalidatorserver.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Sources 
{
	@Id
	@Column(name =  "id")
	private int sourceId;
	
	@Column(name =  "source_name")
	private String sourceName;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "sources")
	List<CustomerLogFile>  customerLogFile;
}