package TestNgproject;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldata {

	public static void main(String[] args)throws IOException {
String path = ".\\datafiles\\readdata.xlsx";
		
		//FileInputStream fs = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//using Iterator
		
		Iterator itr = sheet.iterator(); // add the sheet in to iterator
		
		while(itr.hasNext()) {
			
			XSSFRow row = (XSSFRow)itr.next(); // get the row
			
			Iterator itr2 = row.cellIterator();
			
			while(itr2.hasNext()) {
				XSSFCell cell = (XSSFCell)itr2.next();
				
				switch(cell.getCellType())
				{
				case STRING : System.out.print(cell.getStringCellValue());break;
				case NUMERIC : System.out.print(cell.getNumericCellValue());break;
				case BOOLEAN : System.out.print(cell.getBooleanCellValue());break;
				}
				System.out.print(" | ");
			}
			System.out.println();

	}

	}
}
