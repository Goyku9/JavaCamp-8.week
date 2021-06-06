package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobHunter;

public interface AuthenticationService {
	
	Result registerEmployer(Employer employer, String confirmPassword);
	Result registerJobHunter(JobHunter jobHunter, String confirmPassword);

}
