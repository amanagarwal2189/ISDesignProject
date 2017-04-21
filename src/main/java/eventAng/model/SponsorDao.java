package eventAng.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import eventAng.domain.Sponsor;

@Transactional
public interface SponsorDao extends CrudRepository<Sponsor, Long> {

}
