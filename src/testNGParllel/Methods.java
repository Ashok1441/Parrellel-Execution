package testNGParllel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Methods {
	
	WebDriver driver;
	@Test
	public void chrome() {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\TestNGProject\\Drivers\\chromedriver.exe" );
		driver=new ChromeDriver();
	}
	
	@Test
	public void edge() {
		System.setProperty("webdriver.edge.driver", "D:\\Selenium\\TestNGProject\\Drivers\\msedgedriver.exe");
	    driver= new EdgeDriver();
		
	}
	@Test
	public void firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\ParallelMethods\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	

}
