package my.inno.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.QueryHint;

import my.inno.model.Claim;
import my.inno.service.ClaimManagerImpl;
import my.inno.service.IClaimManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController = @Controller + @ResponseBody
//@RestController 
/*
 * Add @ResponseBody as return value. Wen Spring sees

Jackson library is existed in the project classpath
The mvc:annotation-driven is enabled
Return method annotated with @ResponseBody
Spring will handle the JSON conversion automatically.
 */
/*
 * both @Controller and @RestController are stereotypes. The @Controller is actually a specialization of Spring's @Component stereotype annotation. 
 * This means that class annotated with @Controller will also be automatically be detected by Spring container as part of container's component scanning process.
 * And, @RestController is a specialization of @Controller for RESTful web service. It not only combines @ResponseBody and @Controller annotation but also gives
 * 	more meaning to your controller class to clearly indicate that it deals with RESTful requests
 */

@CrossOrigin
@Controller
@RequestMapping("/claimService")
public class ClaimController {
	
	@Autowired
	private IClaimManager claimManager; //autowire to an interface rather than implementation
	
	public IClaimManager getClaimManager() {
		return claimManager;
	}

	public void setClaimManager(IClaimManager claimManager) {
		this.claimManager = claimManager;
	}

	@CrossOrigin
	@RequestMapping(value = "/claims", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Claim> getClaims() {
		List<Claim> claimsList = new ArrayList<Claim>();

		claimsList = claimManager.getAllClaims();
		
		return claimsList;
	}

	/*@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public Claim getClaimById(@PathVariable int id) {
		List<Claim> listOfCountries = new ArrayList<Claim>();
		
		return null;
	}*/
	
	@CrossOrigin
	@RequestMapping(value = "/claim", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public Claim getClaimByQuery(@RequestParam("input") String input) {
		
		return claimManager.getClaimByQuery(input);
	}

}
