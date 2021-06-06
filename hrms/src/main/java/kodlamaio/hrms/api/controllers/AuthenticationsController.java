package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthenticationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobHunter;

@RestController
@RequestMapping("/api/auths")
public class AuthenticationsController {

	private AuthenticationService authenticationService;

	@Autowired
	public AuthenticationsController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	
@PostMapping("/registerEmployer")
public Result registerEmployers(@RequestBody Employer employer, String confirmPassword) {
	
	return this.authenticationService.registerEmployer(employer, confirmPassword);
}

@PostMapping("/registerJobHunter")
public Result registerJobHunters(@RequestBody JobHunter jobHunter, String confirmPassword) {
	
	return this.authenticationService.registerJobHunter(jobHunter, confirmPassword);
}
	
}
