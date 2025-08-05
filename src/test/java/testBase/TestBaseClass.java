package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class TestBaseClass {
	public WebDriver driver;
	public Logger loggers;
	public Properties p; // Make Properties accessible to child classes
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws Exception {	
		
		FileReader fr = new FileReader("./src//test//resources//config.properties");
		p = new Properties(); // Assign to the protected field
		p.load(fr);
		
		try {			
			
			loggers = LogManager.getLogger(this.getClass());
			System.setProperty("webdriver.chrome.driver", "D:\\bin\\chromedriver.exe");
			System.setProperty("webdriver.edge.driver", "D:\\bin\\msedgedriver.exe");
			
			switch (br.toLowerCase()) {
			case "chrome":loggers.info("Browser Selected is Chrome");driver = new ChromeDriver(); break;
			case "edge":loggers.info("Browser Selected is Edge"); driver=new EdgeDriver(); break;
			default:loggers.error("Browser Not Supported"); throw new RuntimeException("Browser Not Supported");
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().deleteAllCookies();
			
			driver.get(p.getProperty("appurl"));
			driver.manage().window().maximize();
			loggers.info("Browser Opened Successfully");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		loggers.info("Browser Closed Successfully");
		
	}
	
	
	public String randomNumber() {
		return  RandomStringUtils.randomNumeric(10);
		
	}	
	public String randomString() {
		return  RandomStringUtils.randomAlphabetic(6);
		
	}
	
	public String randomAlphanumeric() {
		String num1=  RandomStringUtils.randomAlphabetic(6);
		String num2=  RandomStringUtils.randomNumeric(6);
		return (num1+"@"+num2);
		

		
	}



}