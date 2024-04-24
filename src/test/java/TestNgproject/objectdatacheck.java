package TestNgproject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class objectdatacheck {
	@Test(dataProvider = "supplier")
	
	public void sample(Object a , Object b, Object c) {
		System.out.println(a + "-" + b + "-" + c);
	}
	
	
	@DataProvider
	public Object[][] supplier() {
		
		Object [][] data = {{"ganipower3@gmail.com","12345",1},{"ganipower4@gmail.com","12345",2}};
		
		return data;
		
	}
	

	@DataProvider
	public Object[][] supplier2() {
		
		Object [][] data = {{"ganipower3@gmail.com","12345"},{"ganipower4@gmail.com","12345"}};
		
		return data;
		
	}
	
}
