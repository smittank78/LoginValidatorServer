package api.loginvalidatorserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLogFileResponseDto 
{	private CustomerLogFileDto customerLogFile;
	private StatusDto statusDTO;

}