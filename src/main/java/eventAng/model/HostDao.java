package eventAng.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import eventAng.domain.Host;

@Transactional
public interface HostDao extends CrudRepository<Host, Long> {

	public Host findByEmailId(String emailId);
	
	/*@Query("SELECT * FROM Host h where h.emailId = :emailId") 
    Host findHostbyEmailId(@Param("emailId") String emailId);*/
}
