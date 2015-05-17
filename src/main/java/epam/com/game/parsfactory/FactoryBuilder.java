package epam.com.game.parsfactory;

import java.util.ArrayList;

import epam.com.game.parsfactory.parsers.CitiesDBParser;
import epam.com.game.parsfactory.parsers.CitiesEXELParser;
import epam.com.game.parsfactory.parsers.CitiesJSONParser;
import epam.com.game.parsfactory.parsers.CitiesTXTParser;
import epam.com.game.parsfactory.parsers.CitiesXMLParser;

public class FactoryBuilder {

	private enum TypeParser {
		DB,EXEL,XML,JSON,FILE
	}

	public static ArrayList createCitiesBuilder(String typeParser) {
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		switch (type) {
		case XML:
			return new CitiesXMLParser().cityesDocumentParser();
		case EXEL:
			return new CitiesEXELParser().cityesDocumentParser();
		case DB:
			return new CitiesDBParser().cityesDocumentParser();
		case JSON:
			return new CitiesJSONParser().cityesDocumentParser();
		case FILE:
			return new CitiesTXTParser().cityesDocumentParser();
		default:
			throw new EnumConstantNotPresentException(type.getDeclaringClass(),
					type.name());
		}
	}
}
