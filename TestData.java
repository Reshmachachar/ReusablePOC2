package ReusableForPowerBI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {
	
	 public static String Month;
	public static String Per;
	 
public static void TestData1() throws Exception
	{
   FileInputStream fis=new FileInputStream("F:\\Workspace3\\My_Selenium\\src\\test\\java\\ReusableForPowerBI\\resource\\MonthWise.xlsx");
		
		XSSFWorkbook wrk=new XSSFWorkbook(fis);
		XSSFSheet sht=wrk.getSheet("Book1");
		
		int rows=sht.getLastRowNum();
		int cols=sht.getRow(1).getLastCellNum();
				
		for(int r=1;r<=rows;r++)
		{
			XSSFRow row=sht.getRow(r);
			 Month=row.getCell(0).getStringCellValue();
			 Per=row.getCell(1).getStringCellValue();
			
		}
		
	}
}



