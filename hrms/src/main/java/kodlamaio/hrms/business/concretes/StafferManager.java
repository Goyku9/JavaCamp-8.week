package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.StafferService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.StafferDao;
import kodlamaio.hrms.entities.concretes.Staffer;


@Service
public class StafferManager implements StafferService {
	
	private StafferDao stafferDao;
	
    @Autowired
	public StafferManager(StafferDao stafferDao) {
		super();
		this.stafferDao = stafferDao;
	}



	@Override
	public DataResult<List<Staffer>> getAll() {
		
		return new SuccessDataResult<List<Staffer>>(this.stafferDao.findAll());
	}

}
