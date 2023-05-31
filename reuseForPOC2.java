package ReusableForPowerBI;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class reuseForPOC2 extends AllReusableCode{

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cop=new ChromeOptions();
		cop.addArguments("--remote-allow-origins=*");

		driver=new ChromeDriver(cop);
		driver.get("https://app.powerbi.com/groups/me/reports/bd94c985-4215-4a22-91e3-f84904b6315e/ReportSection636ad135e9e45a659c88");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("tableau.guest@emergys.com");
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("i0118")).sendKeys("Ellicium@2022");
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();

		Thread.sleep(6000);
		Thread.sleep(10000);
		
		//path to click learning process   
	
		
		
		
		
		driver.findElement(By.xpath("(//span[@class='itemName'])[2]")).click();
		Thread.sleep(6000);


		String[] expData=new String[]{"G P Mumbai","Computer Engineering","Semester 1","Engineering Drawing","V V Marathe","Arati M."};
		String[] checkBoxTitle=new String[]{"Institute_name","Course_name","semester","Subject_name","Teacher Name","Student_name"};

		for(int i=0;i<expData.length;i++)
		{
			dropDownSelection(driver, expData[i],checkBoxTitle[i]);
		}
		TestData.TestData1();
		MonthwiseAttendancePercetage(TestData.Month,TestData.Per);

		TestDataLevel.TestData1();
		MonthwiseAttendancePercetage(TestDataLevel.Level,TestDataLevel.Per);
		
		Thread.sleep(10000);
		TestDataGridLevel.TestData1();
		AllInfo(TestDataGridLevel.Grid, TestDataGridLevel.Info);

	}

	
	
	
	



	public static void dropDownSelection(WebDriver driver,String expVal,String dropDownName) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slicer-dropdown-menu' and @aria-label='"+dropDownName+"']/i")).click();
		Thread.sleep(3000);
		List<WebElement> dropDownList=driver.findElements(By.xpath("//div[@class='slicerBody'and @aria-label='"+dropDownName+"' ]//div[@class='slicerItemContainer']/span"));
		//String selVal="G P Mumbai";
		List<String> textList=new ArrayList<>();
		for(WebElement ele : dropDownList)
		{
			textList.add(ele.getText());
		}
		System.out.println(dropDownName+" List "+textList);

		for(int i=1;i<=dropDownList.size();i++)
		{

			WebElement name=driver.findElement(By.xpath("(//div[@class='slicerBody'and @aria-label='"+dropDownName+"' ]//div[@class='slicerItemContainer']/span)["+i+"]"));
			WebElement nameSel=driver.findElement(By.xpath("(//div[@class='slicerBody'and @aria-label='"+dropDownName+"' ]//div[@class='slicerItemContainer']/span)["+i+"]/preceding-sibling::div"));

			System.out.println("Name : "+name.getText());
			System.out.println("NameSel : "+nameSel.getAttribute("class"));

			if(name.getText().equals(expVal))
			{
				if(!nameSel.getAttribute("class").equals("slicerCheckbox selected"))
				{
					name.click();
					System.out.println("Selected "+expVal);
					break;
				}
				else {
					System.out.println("Already Selected "+expVal);
					break;
				}
			}
		}
	}
}