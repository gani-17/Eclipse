package TestNgproject;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({testlisteners.class})
public class listenersdemo  {
	@Test(groups= {"windows.smoke"},invocationCount =5)
	public void sample() {
		System.out.println("gani");
	}
	
	
	

}
