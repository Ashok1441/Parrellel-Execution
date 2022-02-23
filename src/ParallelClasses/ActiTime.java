package ParallelClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActiTime {
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

}
