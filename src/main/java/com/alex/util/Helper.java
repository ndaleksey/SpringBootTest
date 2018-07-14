package com.alex.util;

import com.alex.model.Country;
import com.alex.service.CountryService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Shishkov A.V. on 13.07.18.
 */

@Component
public class Helper {
	@Autowired
	private CountryService countryService;

	@PostConstruct
	public void init() throws IOException, ParseException {
		loadCountriesIntoDb();
	}

	private void loadCountriesIntoDb() throws IOException, ParseException {
		InputStream countriesStream = getClass().getResourceAsStream("/static/countries.json");

		JSONParser parser = new JSONParser();

		try (InputStreamReader reader = new InputStreamReader(countriesStream)) {
			Object object = parser.parse(reader);
			JSONArray countries = (JSONArray) object;

			for (Object e : countries) {
				JSONObject obj = (JSONObject)e;
				String name = (String) obj.get("name");
				String code = (String) obj.get("code");
				countryService.save(new Country(name, code));
			}
		}

	}
}
