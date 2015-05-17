package epam.com.game.players;

import java.util.ArrayList;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import epam.com.game.Game;
import epam.com.game.GameTest;

public class HumanTest {
	private static final Logger log = Logger.getLogger(GameTest.class);
	Human hum;

	
	  @BeforeClass
	  public void beforeClassHum() {
		  hum = new Human("Jon");

		  Player.cit = new ArrayList<String>();
		  Player.cit.add("Kiev");
		  Player.cit.add("Vladivostok");
	  }
  
  @Test(description="Check the citi in db")
  public void checkTest() {	
	  Assert.assertTrue(hum.checkTheWord("Kiev"));
	  Assert.assertFalse(hum.checkTheWord("UnknownCity"));
  }
  
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }


}
