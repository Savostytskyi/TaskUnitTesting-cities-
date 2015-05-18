package epam.com.game;


import java.util.ArrayList;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import epam.com.game.parsfactory.FactoryBuilder;
import epam.com.game.parsfactory.parsers.CitiesDBParser;
import epam.com.game.players.Player;

public class GameTest {
	private static final Logger log = Logger.getLogger(GameTest.class);
	Game game;
	
	@BeforeClass
	public void beforeClass() {

		Player.cit = new ArrayList<String>();
		Player.cit.add("Kiev");
		Player.cit.add("Vladivostok");
		log.info("All parameters initialized");
		game = new Game();
	}

	@Test
	public void buildTest() {
		CitiesDBParser parsMock = EasyMock.createMock(CitiesDBParser.class);
		ArrayList<String> cities = new ArrayList<String>();
		cities.add("Kiev");
		cities.add("Vladivostok");
		//parsMock.cityesDocumentParser();
		EasyMock.expect(parsMock.cityesDocumentParser()).andReturn(cities).anyTimes();
		//EasyMock.verify(parsMock);
		EasyMock.replay(parsMock);
		EasyMock.verify(parsMock);
	}
	
	@Test(description = "Initialaizin objects of players", dataProvider = "dpPlayersOne")
	public void prepareGameTest(Integer n, Integer s) {
		log.info("Prepare game test with parameters" + n + " " + s);
		log.debug("Hi");
		Assert.assertTrue(game.prepareGame(n, s));
	}

	@Test(description = "Initialaizin objects of players", dataProvider = "dpPlayersTwo")
	public void prepareGameTestF(Integer n, Integer s) {
		log.info("Prepare game test with parameters" + n + " " + s);
		Assert.assertFalse(game.prepareGame(n, s));
	}


	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dpPlayersOne() {
		return new Object[][] { new Object[] { 2, 2 }, new Object[] { 5, 5 }, };
	}

	@DataProvider
	public Object[][] dpPlayersTwo() {
		return new Object[][] { new Object[] { 0, 2 }, new Object[] { 1, 0 },
				new Object[] { -6, 7 }, new Object[] { 18, 7 }, };
	}

	@AfterClass
	public void afterClass() {
	}

}
