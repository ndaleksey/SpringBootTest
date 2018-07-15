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

import java.util.Arrays;

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
	public void run(ApplicationArguments args) {
		Country russia = countryService.findByCode("ru");
		Country usa = countryService.findByCode("us");
		Country uk = countryService.findByCode("uk");
		Country ukraine = countryService.findByCode("ua");

		Person alex = new Person("Alex", russia);
		Person nick = new Person("Nick", usa);
		Person ashley = new Person("Ashley", uk);
		Person anna = new Person("Anna", ukraine);

		personService.saveAll(Arrays.asList(alex, nick, ashley, anna));
	}
}