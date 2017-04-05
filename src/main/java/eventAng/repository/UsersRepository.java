package eventAng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eventAng.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	

}
