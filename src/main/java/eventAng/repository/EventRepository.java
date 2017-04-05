package eventAng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eventAng.domain.Events;

public interface EventRepository extends JpaRepository<Events, Integer>{

}
