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

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practicedatadriven {
	
	@Test(dataProvider="loginData")
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
	@DataProvider(name ="loginData")
	
	public Iterator<Object[]> sampledata() throws IOException{
		
		String path = "./datafiles/automationdata.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(path);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowcount = sheet.getPhysicalNumberOfRows();
		int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		List<Object[]> data = new ArrayList<Object[]>();
		
		for(int i =1; i<rowcount;i++) {
			XSSFRow row = sheet.getRow(i);
			
			Object[]rowdata = new Object[colcount];
			for(int j =0; j<colcount;j++) {
				XSSFCell cell = row.getCell(j);
				
				switch(cell.getCellType()) {
				case STRING:
					rowdata[j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					rowdata[j] = String.valueOf((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					rowdata[j] = cell.getBooleanCellValue();
					break;
					
				}
			}
			data.add(rowdata);
		}
		return data.iterator();
		
		
		

	}
	

}

/*
 * 
 int rowCount = sheet.getPhysicalNumberOfRows();
int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

These lines determine the total number of rows (rowCount) and columns (colCount) in the Excel sheet. 
getPhysicalNumberOfRows() returns the count of rows with actual data, and getPhysicalNumberOfCells() 
returns the count of cells in the first row (assumed to be the header).
Here's how it works:

List<Object[]> data = new ArrayList<>();: This line initializes a new ArrayList named data that will store arrays of Object.

for (int i = 1; i < rowCount; i++) {: This loop iterates through each row in the Excel sheet, starting from the second row (skipping the header row).

Object[] rowData = new Object[colCount];: For each row, a new array named rowData is created. This array will store the values of each cell in the current row.

for (int j = 0; j < colCount; j++) {: This inner loop iterates through each cell in the current row.

switch (cell.getCellType()) {: The switch statement checks the type of the current cell (STRING, NUMERIC, BOOLEAN) and processes it accordingly.

rowData[j] = ...;: The value of the current cell is assigned to the corresponding index in the rowData array.

data.add(rowData);: After processing all cells in a row, the rowData array is added to the data list. This means that data will contain arrays, and each array represents the data for one row in the Excel sheet.

*/
