package ParallelClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;
	@BeforeClass
	
	@Parameters("browser")
	
		public void setup(String browser) throws Throwable
		{
			if(browser.equalsIgnoreCase("edge"))
			{
				System.setProperty("webdriver.edge.driver", "D:\\Selenium\\ParallelMethods\\Drivers\\msedgedriver.exe");
				driver=new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ParallelMethods\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
			}			
			else if(browser.equalsIgnoreCase("ff"))
			{
				System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\ParallelMethods\\Drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
			}	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	@Test(priority = 1)
	 public void dargAndDrop() {
				
			driver.get("https://jqueryui.com/droppable/");
			driver.switchTo().frame(0);
			WebElement drag = driver.findElement(By.id("draggable"));
			WebElement drop = driver.findElement(By.id("droppable"));
			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).perform();
			
			
			
			
	 }
	 @Test(priority = 2)
		public void actiTime() throws Throwable {
			driver.get("https://demo.actitime.com/login.do");
			String expTitle="actiTIME - Login";
			String actual = driver.getTitle();
			Assert.assertEquals(actual, expTitle);
			driver.findElement(By.id("username")).sendKeys("admin");
			Thread.sleep(2000);
			driver.findElement(By.name("pwd")).sendKeys("manager");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()='Login ']")).click();
			Thread.sleep(5000);
			String expHometitle = "actiTIME - Enter Time-Track";
			String actHometitle = driver.getTitle();
			Assert.assertEquals(actHometitle, expHometitle);
			
	 }
}
