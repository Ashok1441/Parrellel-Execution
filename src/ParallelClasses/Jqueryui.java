package ParallelClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Jqueryui {
	
	WebDriver driver;
	
	 @Test
	 public void dargAndDrop() {
			

			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\TestNGProject\\Drivers\\chromedriver.exe" );
			driver=new ChromeDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
			driver.get("https://jqueryui.com/droppable/");
			
			driver.switchTo().frame(0);
			WebElement drag = driver.findElement(By.id("draggable"));
			WebElement drop = driver.findElement(By.id("droppable"));
			
			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).perform();
			driver.close();
			
			
		}

}
