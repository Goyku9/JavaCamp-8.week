package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.AuthenticationCode;


@Repository
public interface AuthenticationCodeDao extends JpaRepository<AuthenticationCode, Integer> {

}
