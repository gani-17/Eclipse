package TestNgproject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datadriven {
	
	@Test(dataProvider="supplier2",dataProviderClass = objectdatacheck.class)
	public void verifylogin(String uname, String password) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();

		// Remove implicit wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(uname);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		AssertJUnit.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

		

		//driver.quit();
		
		
		
	}
	@DataProvider
	public Object[][] supplier() {
		
		Object [][] data = {{"ganipower3@gmail.com","12345"},{"ganipower4@gmail.com","12345"}};
		
		return data;
		
	}
	

}
