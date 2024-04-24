package TestNgproject;

import org.testng.annotations.Test;

public class Demo {
	@Test(groups= {"windows.smoke"},invocationCount =5)
	public void sample() {
		System.out.println("kingmaker");
	}

}
