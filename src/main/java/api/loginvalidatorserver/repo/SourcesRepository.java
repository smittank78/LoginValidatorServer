package api.loginvalidatorserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.loginvalidatorserver.entity.Sources;

@Repository
public interface SourcesRepository extends JpaRepository<Sources, Integer> 
{

}