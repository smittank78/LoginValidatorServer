package api.loginvalidatorserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.loginvalidatorserver.entity.CustomerLogFileTracking;

@Repository
public interface CustomerLogFileTrackingRepository extends JpaRepository<CustomerLogFileTracking, Integer> 
{

}		