package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import fakeMernisService.FakeMernisService;


@Service
public class MernisAdapter implements MernisService{

	@Override
	public boolean userİnformationValidation(String identityNumber, String firstName, String lastName, int birthYear) {
		
		
    FakeMernisService client = new FakeMernisService();
		
		boolean result = true;
		try {
			result = client.ValidateByPersonalInfo(identityNumber, firstName, lastName, birthYear);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	}

