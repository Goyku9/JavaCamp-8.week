package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Staffer;


@Repository
public interface StafferDao extends JpaRepository<Staffer, Integer>{

}
