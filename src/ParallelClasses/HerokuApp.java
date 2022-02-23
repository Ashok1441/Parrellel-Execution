package ParallelClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HerokuApp {
	
	WebDriver driver;
	 @Test
		public void fileUpLoad() throws Throwable {
			System.setProperty("webdriver.edge.driver", "D:\\Selenium\\TestNGProject\\Drivers\\msedgedriver.exe");
		    driver= new EdgeDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get("http://the-internet.herokuapp.com/");
			Thread.sleep(2000);
			
			Point locAdd = driver.findElement(By.xpath("//a[text()='Dynamic Content']")).getLocation();
			System.out.println(locAdd);
		
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy"+locAdd);
			driver.findElement(By.xpath("//a[text()='File Upload']")).click();
			driver.findElement(By.id("file-upload")).sendKeys("D:\\Downloads\\certificate.pdf");
			driver.findElement(By.id("file-submit")).click();
			String text = driver.findElement(By.tagName("h3")).getText();
			Reporter.log(text, true);
			driver.close();
	 }
			
		

}
