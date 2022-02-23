package ParallelClasses;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.Systematiser;

public class CrossBrowsingTesting {
	
	WebDriver driver;
	@BeforeClass
	@Parameters("browserName")
	public void openBrowser(String browserName) {
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\TestNGProject\\Drivers\\chromedriver.exe" );
			driver=new ChromeDriver();
		}
		else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Selenium\\TestNGProject\\Drivers\\msedgedriver.exe");
		    driver= new EdgeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\ParallelMethods\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
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
	 @Test(priority = 2)
	 public void dargAndDrop() {	
		 
			driver.get("https://jqueryui.com/droppable/");
			driver.switchTo().frame(0);
			WebElement drag = driver.findElement(By.id("draggable"));
			WebElement drop = driver.findElement(By.id("droppable"));
			
			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).perform();
			
			
		}
	 
	 @Test(priority = 3)
	 public void dropDown() {
		 
			driver.get("https://www.hyrtutorials.com/");
			Actions ac = new Actions(driver);
			WebElement eleAdd1 = driver.findElement(By.xpath("//a[text()='Selenium Practice']"));
			WebElement eleAdd2 = driver.findElement(By.xpath("//a[text()='Dropdowns']"));
			ac.moveToElement(eleAdd1).moveToElement(eleAdd2).click().perform();		
			WebElement ddAdd = driver.findElement(By.id("course"));
			Select sec = new Select(ddAdd);
			sec.selectByVisibleText("Java");
			
		}
	 @Test(priority = 4)
		public void fileUpLoad() throws Throwable {
	
			driver.get("http://the-internet.herokuapp.com/");
			Thread.sleep(2000);
			
			Point locAdd = driver.findElement(By.xpath("//a[text()='Dynamic Content']")).getLocation();
//			System.out.println(locAdd);
		
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
