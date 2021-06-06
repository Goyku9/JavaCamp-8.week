package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Position;


@Repository
public interface PositionDao extends JpaRepository<Position, Integer>{
	
	Position getByPositionName(String name);

}
