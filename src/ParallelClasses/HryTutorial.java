package ParallelClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HryTutorial {
	
	WebDriver driver;
	
	 @Test
	 public void dropDown() {
			
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\ParallelMethods\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
			driver.get("https://www.hyrtutorials.com/");
			Actions ac = new Actions(driver);
			WebElement eleAdd1 = driver.findElement(By.xpath("//a[text()='Selenium Practice']"));
			WebElement eleAdd2 = driver.findElement(By.xpath("//a[text()='Dropdowns']"));
			ac.moveToElement(eleAdd1).moveToElement(eleAdd2).click().perform();		
			WebElement ddAdd = driver.findElement(By.id("course"));
			Select sec = new Select(ddAdd);
			sec.selectByVisibleText("Java");
			driver.close();
		}

}
