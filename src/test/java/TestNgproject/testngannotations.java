package TestNgproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testngannotations {
	WebDriver driver;
	
	@BeforeMethod
	
	public void beforemethod() {
		WebDriverManager.chromedriver ().setup ();
		 driver = new ChromeDriver ();
		driver.manage ().window ().maximize ();
		driver.get("http://tutorialsninja.com/demo/");
		
	}
	
	@AfterMethod
	public void aftermethod() {
		
		driver.quit();
		}
	
	@Test(priority =1)
	
	public void verifyUserLoginWithValidCredentials () {
		
		
		driver .findElement (By.xpath ("//span [text ()='My Account']")).click ();
		driver.findElement (By.linkText ("Login")).click ();
		driver .findElement (By.id("input-email")) .sendKeys ("ganipower3@gmail.com");
		driver.findElement (By.id ("input-password")) .sendKeys ("12345");
		driver.findElement (By.xpath("//input [ @value='Login']")).click();
		Assert.assertTrue(driver.findElement (By.linkText ("Edit your account information")).isDisplayed());
		}
	
@Test(priority =2)
	
	public void verifyUserLoginWithinValidCredentials () {
		
		
		driver .findElement (By.xpath ("//span [text ()='My Account']")).click ();
		driver.findElement (By.linkText ("Login")).click ();
		driver .findElement (By.id("input-email")) .sendKeys ("amotooricap9@gmail.com");
		driver.findElement (By.id ("input-password")) .sendKeys ("123455678");
		driver.findElement (By.xpath("//input [ @value='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),"Warning: No match for E-Mail Address and/or Password.");
		}
	
	

}
