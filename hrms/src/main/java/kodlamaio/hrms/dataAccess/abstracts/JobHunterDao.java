package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobHunter;


@Repository
public interface JobHunterDao extends JpaRepository<JobHunter, Integer> {
	
	JobHunter getJobHunterByNationalId(String nationalId);
	

}
