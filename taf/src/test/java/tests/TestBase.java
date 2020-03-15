package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	//For Initialize the Driver
	
	public static WebDriver driver;
	
	
	@BeforeSuite
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
				
	}
	
	
	
	
	
	
	
	@AfterSuite
	public void StopDriver() {driver.close();}
	
	
	
	
}
