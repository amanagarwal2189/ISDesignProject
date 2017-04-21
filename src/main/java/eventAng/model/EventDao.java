package eventAng.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import eventAng.domain.Event;

@Transactional
public interface EventDao extends CrudRepository<Event, Long> {

	public Event getById(Long id);
}
