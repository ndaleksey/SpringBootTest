package com.alex;

/**
 * Created by Shishkov A.V. on 11.05.18.
 */

import com.alex.model.Country;
import com.alex.model.Person;
import com.alex.service.CountryService;
import com.alex.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.alex")
@SpringBootApplication
public class Application implements ApplicationRunner {


	@Autowired
	private PersonService personService;

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Country russia = countryService.save(new Country("Russia", "RU"));
		Country usa = countryService.save(new Country("USA", "US"));
		Country england = countryService.save(new Country("England", "En"));
		Country ukraine = countryService.save(new Country("Ukraine", "ua"));

		Person alex = new Person("Alex", russia);
		Person nick = new Person("Nick", usa);
		Person ashley = new Person("Ashley", england);
		Person anna = new Person("Anna", russia);

//		Account acc1 = new Account(alex, "Alex12", "1", "2", "3");
		personService.save(alex);
		personService.save(anna);
	}
}