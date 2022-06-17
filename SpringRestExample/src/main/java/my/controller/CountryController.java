package my.controller;

import java.util.ArrayList;
import java.util.List;

import my.model.Country;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController = @Controller + @ResponseBody
//@RestController 
/*
 * Add @ResponseBody as return value. Wen Spring sees

Jackson library is existed in the project classpath
The mvc:annotation-driven is enabled
Return method annotated with @ResponseBody
Spring will handle the JSON conversion automatically.
 */
@Controller
@RequestMapping("/countryService")
public class CountryController {
	@RequestMapping(value = "/countries", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Country> getCountries() {
		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries = createCountryList();
		return listOfCountries;
	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public Country getCountryById(@PathVariable int id) {
		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries = createCountryList();
		for (Country country : listOfCountries) {
			if (country.getId() == id)
				return country;
		}
		return null;
	}

	// Utiliy method to create country list.
	public List<Country> createCountryList() {
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");
		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries.add(indiaCountry);
		listOfCountries.add(chinaCountry);
		listOfCountries.add(nepalCountry);
		listOfCountries.add(bhutanCountry);
		return listOfCountries;
	}
}
