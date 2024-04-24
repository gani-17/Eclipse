package TestNgproject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dependsonmethod {
	WebDriver driver;
	
	@Test
	public void verifylogin() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();

		// Remove implicit wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("ganipower3@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		AssertJUnit.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		

		//driver.quit();
	
	}
	
	@Test(dependsOnMethods= {"verifylogin"})
	
	public void addProductToWishListAndViewWishList () {
	driver.findElement(By.name ("search")) .sendKeys ("HP", Keys.ENTER) ;
	driver.findElement(By.xpath ("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[2]")).click();
	WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
	WebElement wishListElement = wait.until (ExpectedConditions.presenceOfElementLocated(By.linkText("Wish list")));
	wishListElement.click();
	Assert.assertTrue(driver.getTitle().equals("My Wish List"));
	}
	
	@Test(dependsOnMethods= {"verifylogin","addProductToWishListAndViewWishList"})
	public void removeProductFromWishList() {
	 driver.findElement (By.xpath ("//a[@data-original-title='Remove']")) .click();
	Assert.assertTrue(driver.findElement (By.xpath("//div [@id='content']/p")).getText().equals("Your wish list is empty."));
	}
	

}
