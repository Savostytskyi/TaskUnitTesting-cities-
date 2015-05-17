package epam.com.game.parsfactory.parsers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import epam.com.game.parsfactory.AbstractFactory;
import epam.com.game.parsfactory.parsers.dbcon.CitiesDBConnector;

	public class CitiesDBParser extends AbstractFactory {
		public static final String SQL_SELECT_ALL_CITIES = "SELECT `city_name_en` FROM `cities`";
		
	
		public ArrayList cityesDocumentParser() { 
			Connection cn = null;
			Statement st = null;
			try {
				cn = CitiesDBConnector.getConnection();
				st = (Statement) cn.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT_ALL_CITIES);
				while (rs.next()) {

					String citi = rs.getString(1);
					cities.add(citi);
				}

			} catch (SQLException e) {
				System.err.println("SQL Exeption (request or table failed):" + e);
			}
			return cities;
		}

}
