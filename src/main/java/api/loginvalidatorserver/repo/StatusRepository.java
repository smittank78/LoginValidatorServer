package api.loginvalidatorserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.loginvalidatorserver.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> 
{

}