package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobHunter;

public interface JobHunterService {
	
	Result add(JobHunter jobHunter);
	
	DataResult<List<JobHunter>> getAll();
	
	DataResult<JobHunter> getJobHunterByNationaLId(String nationalId);

}
