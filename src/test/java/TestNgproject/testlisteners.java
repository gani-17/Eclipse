package TestNgproject;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testlisteners implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		String testname = result.getName();
		System.out.println(testname + "passed");
	}

	public void onTestSuccess(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname + "success");
		
	}

	public void onTestFailure(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname + "failure");
		WebDriver driver =null;
		
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+ "\\screenshotas\\" + testname + ".png";
		try {
			
		
		FileUtils.copyFile(srcfile, new File(destination));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname + "skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname + "failed");
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname + "failedtimeout");
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println( "start");
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("finish");
		
	}
	

}
