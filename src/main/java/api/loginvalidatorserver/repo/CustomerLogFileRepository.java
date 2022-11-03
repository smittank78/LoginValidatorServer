package api.loginvalidatorserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import api.loginvalidatorserver.entity.CustomerLogFile;

@Repository
public interface CustomerLogFileRepository extends JpaRepository<CustomerLogFile, Integer> 
{
	@Query(value = "select count(id) from customer_log_file where uploaded_file_message_digest = ? and case_number = ?",nativeQuery = true)
	int findFileCountByUploadedFileMessageDigestAndCaseNumber(String uploadedFileMessageDigest,String caseNumber);

	@Query(value = "select count(id) from customer_log_file where file_name = ?",nativeQuery = true)
	int findFileCountByFileName(String fileName);

	@Query(value = "select * from customer_log_file where file_name = ? and case_number =? and uploaded_file_message_digest = ? and submitter_name = ? and forwarded_iP = ?;",nativeQuery = true)
  	CustomerLogFile findCustomer(String fileName,String caseNumber,String uploadedFileMessageDigest,String submitterName,String forwardedIP);
}		