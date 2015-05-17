package epam.com.game.parsfactory.parsers;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import epam.com.game.parsfactory.AbstractFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class CitiesXMLParser extends AbstractFactory {

	String town;

	@Override
	public ArrayList cityesDocumentParser() {

		try {

			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			DefaultHandler defaultHandler = new DefaultHandler() {
				boolean bName = false;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					if (qName.equalsIgnoreCase("name_en")) {
						bName = true;
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {

					if (bName) {
						cities.add(new String(ch, start, length).toLowerCase());
						bName = false;
					}

				}

			};

			saxParser.parse("src/main/resources/cities.xml", defaultHandler);
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		return cities;
	}
}
