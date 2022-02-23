package testNGParllel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ParallelMethods {
	WebDriver driver;
	 @Test
	public void actiTime() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\TestNGProject\\Drivers\\chromedriver.exe" );
		driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		String expTitle="actiTIME - Login";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expTitle);
		driver.findElement(By.id("username")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.name("pwd")).sendKeys("manager");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Thread.sleep(2000);
		String expHometitle = "actiTIME - Enter Time-Track";
		String actHometitle = driver.getTitle();
		Assert.assertEquals(actHometitle, expHometitle);
		driver.close();
		
	 }

	 
	
	 
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
