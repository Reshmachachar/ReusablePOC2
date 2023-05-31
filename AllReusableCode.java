package ReusableForPowerBI;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllReusableCode {
	public static WebDriver driver;
	
		public static void MonthwiseAttendancePercetage(String month,String monthPercentage) throws InterruptedException
		{
			
			Thread.sleep(6000);
			List<WebElement> monthName=driver.findElements(By.cssSelector(month));

			List<String> mnList=new ArrayList<>();
			List<String> perList=new ArrayList<>();
			for(WebElement ele : monthName)
			{
				mnList.add(ele.getText());
			}
			String Percentage_month="";
			List<WebElement> monthPer=driver.findElements(By.cssSelector(monthPercentage));
			for(WebElement ele : monthPer)
			{
				perList.add(ele.getText());
			}
			System.out.println("MonthList : "+mnList);
			System.out.println("PercentageList : "+perList);
				
		}
		////////////////////
		public static void AllInfo(String Columnheader,String gridCell) {
			List<WebElement> gridList=driver.findElements(By.cssSelector(Columnheader));
			List<String> gridContentList=new ArrayList<>();
			List<String> gridHeadingList=new ArrayList<>();
			for(int j=2;j<=gridList.size();j++)
			{
				WebElement gridEleHeading=driver.findElement(By.cssSelector(Columnheader+":nth-of-type("+j+")"));
				gridHeadingList.add(gridEleHeading.getText());
				
				if(j==4) {

					WebElement gridEleContent=driver.findElement(By.cssSelector(gridCell+":nth-of-type("+j+") :nth-child(1)"));
					gridContentList.add(gridEleContent.getText());
				}
				else 
				{	
					WebElement gridEleContent=driver.findElement(By.cssSelector(gridCell+":nth-of-type("+j+")"));
					gridContentList.add(gridEleContent.getText());
				}
			}
			System.out.println("GrisHeading : "+gridHeadingList);
			System.out.println("GrisContent : "+gridContentList);

		}
		
	}


