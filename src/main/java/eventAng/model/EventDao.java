package eventAng.model;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import eventAng.domain.Event;

@Transactional
public interface EventDao extends CrudRepository<Event, Long> {

	public Event getById(Long id);
	
	//@Query(value="SELECT * FROM Event e LIMIT 0,4",  nativeQuery=true) 
	public List<Event> findTop8ByOrderByTitleDesc();
	
	@Query("SELECT e FROM Event e where e.host_id=:host_id") 
	public List<Event> getEventByHostId(@Param("host_id") Long host_id);
	
	@Query(value="SELECT * FROM Event e where e.date>=:fromDate and "
			+ "e.date<=:toDate and e.city=:city and e.state=:state and "
			+ "e.zip=:zip", nativeQuery=true) 
	public List<Event> getEventForSponsors(@Param("fromDate") Date fromDate,
			@Param("toDate") Date toDate, @Param("city") String city,
			@Param("state") String state, @Param("zip") int zip);
	
}
