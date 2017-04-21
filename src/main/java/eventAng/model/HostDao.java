package eventAng.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import eventAng.domain.Host;

@Transactional
public interface HostDao extends CrudRepository<Host, Long> {

}
