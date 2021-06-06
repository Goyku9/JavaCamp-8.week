package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobHunterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobHunterDao;
import kodlamaio.hrms.entities.concretes.JobHunter;


@Service
public class JobHunterManager implements JobHunterService{
	
	private JobHunterDao jobHunterDao;

	@Autowired
	public JobHunterManager(JobHunterDao jobHunterDao) {
		super();
		this.jobHunterDao = jobHunterDao;
	}

	@Override
	public Result add(JobHunter jobHunter) {
		
		this.jobHunterDao.save(jobHunter);
		return new SuccessResult(" İş Arayan Eklendi.");
	}

	@Override
	public DataResult<List<JobHunter>> getAll() {
		
		return new SuccessDataResult<List<JobHunter>>(this.jobHunterDao.findAll());
	}

	@Override
	public DataResult<JobHunter> getJobHunterByNationaLId(String nationalId) {
		
		return new SuccessDataResult<JobHunter>(this.jobHunterDao.getJobHunterByNationalId(nationalId));
	}
	
	
	
	

}
