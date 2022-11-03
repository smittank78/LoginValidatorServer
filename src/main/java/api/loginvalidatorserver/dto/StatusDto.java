package api.loginvalidatorserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto 
{
	private int statusId;
	private String statusName;
	private String description;
}