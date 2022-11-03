package api.loginvalidatorserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.loginvalidatorserver.entity.FileTypes;

@Repository
public interface FileTypeRepository extends JpaRepository<FileTypes, Integer> 
{

}