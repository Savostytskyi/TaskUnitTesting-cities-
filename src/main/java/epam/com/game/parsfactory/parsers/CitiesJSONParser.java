package epam.com.game.parsfactory.parsers;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import epam.com.game.parsfactory.AbstractFactory;

public class CitiesJSONParser extends AbstractFactory {

	@Override
	public ArrayList cityesDocumentParser() {
		try {
			FileReader reader = new FileReader(
					"src\\main\\resources\\cities.json");
			
			JSONParser jsonParser = new JSONParser();

			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray lang = (JSONArray) jsonObject.get("City");
			for (int i = 0; i < lang.size(); i++) {
				String city = (String) lang.get(i);
				cities.add(city.toLowerCase());

			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex2) {
			ex2.printStackTrace();
		} catch (ParseException ex3) {
			ex3.printStackTrace();
		} catch (NullPointerException ex4) {
			ex4.printStackTrace();
		}
		return cities;
	}

}
