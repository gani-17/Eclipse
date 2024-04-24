package TestNgproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testngassertions {
	
	@Test
	
	public void sampleone() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		String title = driver.getTitle();
		String exptitle = "Your Store";
		
		//Assert.assertEquals(title, exptitle);
		//Assert.assertNotEquals(title, "king");
		//Assert.assertTrue(title.contains("S"));
		//Assert.assertFalse(title.contains("gani"));
		//Assert.assertNotNull(title);
		
	}
	//Hard assertions
	@Test
	
	public void assertions() {
		WebDriverManager.chromedriver ().setup ();
		WebDriver driver = new ChromeDriver ();
		driver.manage ().window () .maximize ();
		driver.get ("http://tutorialsninja.com/demo/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Your Store";
		Assert.assertEquals (actualTitle, expectedTitle);
		String actualURL = driver.getCurrentUrl ();
		String expectedURL = "http://tutorialsninja.com/demo/";
		Assert.assertEquals (actualURL, expectedURL);
		driver.findElement (By.name ("search")) .sendKeys ("HP", Keys.ENTER) ;
		Assert.assertTrue (driver.findElement (By.linkText("HP LP3065")).isDisplayed ());
		driver.quit();
	}
	
	//soft assertions
	
	@Test
	
	public void softassertions() {
		
		WebDriverManager.chromedriver ().setup ();
		WebDriver driver = new ChromeDriver ();
		driver.manage ().window () .maximize ();
		driver.get ("http://tutorialsninja.com/demo/");
		SoftAssert sa = new SoftAssert();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Your Storeabc";
		sa.assertEquals (actualTitle, expectedTitle);
		String actualURL = driver.getCurrentUrl ();
		String expectedURL = "http://tutorialsninja.com/demo/";
		sa.assertEquals (actualURL, expectedURL);
		driver.findElement (By.name ("search")) .sendKeys ("HP", Keys.ENTER) ;
		Assert.assertTrue (driver.findElement (By.linkText("HP LP3065")).isDisplayed ());
		driver.quit();
		sa.assertAll();		
	}

}
