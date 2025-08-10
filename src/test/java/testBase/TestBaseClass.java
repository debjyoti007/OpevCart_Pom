package testBase;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


@SuppressWarnings("unused")
public class TestBaseClass {
	public static WebDriver driver;
	public Logger loggers;
	public Properties p; // Make Properties accessible to child classes
	

	@SuppressWarnings("deprecation")
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws Exception {	
		
		FileReader fr = new FileReader("./src//test//resources//config.properties");
		p = new Properties(); // Assign to the protected field
		p.load(fr);
		loggers = LogManager.getLogger(this.getClass());
		String hubUrl = "http://localhost:4444/wd/hub"; // URL for the Selenium Grid Hub
		
		try {			
			
			
			if(p.getProperty("execution_environment").equalsIgnoreCase("remote")) {
				loggers.info("Running in remote mode  Grid environment");
				//DesiredCapabilities cap = new DesiredCapabilities();	
				String  platformName;
				if(os.equalsIgnoreCase("windows")) {
					loggers.info("Running on Windows OS");
					//cap.setPlatform(Platform.WIN11);
					 	platformName = "Windows 11";	
					
				} else if(os.equalsIgnoreCase("mac")) {
					loggers.info("Running on Mac OS");
					//cap.setPlatform(Platform.MAC);
					platformName = "macOS";
				} else if(os.equalsIgnoreCase("linux")) {
					loggers.info("Running on Linux OS");
					//cap.setPlatform(Platform.LINUX);
					platformName = "Linux";
				} else {
					loggers.error("OS Not Supported");
					throw new RuntimeException("OS Not Supported");
				}
				
				switch (br.toLowerCase()) {
				case "chrome":loggers.info("Browser Selected is Chrome");
				System.out.println("Browser Selected is Chrome");
					//cap.setBrowserName("chrome");
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.setPlatformName(platformName);
					driver = new RemoteWebDriver(new URL(hubUrl), chromeOptions);
				
					break;
					
				case "edge":loggers.info("Browser Selected is Edge");
				System.out.println("Browser Selected is Edge");
					//cap.setBrowserName("MicrosoftEdge");
					EdgeOptions edgeOptions = new EdgeOptions();
					edgeOptions.setPlatformName(platformName);
					driver = new RemoteWebDriver(new URL(hubUrl), edgeOptions);
					break;
										
				case "firefox":loggers.info("Browser Selected is Edge");
				System.out.println("Browser Selected is Firefox");
					//cap.setBrowserName("firefox");
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					firefoxOptions.setPlatformName(platformName);
					driver = new RemoteWebDriver(new URL(hubUrl), firefoxOptions);
					break;	
				default:loggers.error("Browser Not Supported");
				System.out.println("Browser Not Supported");
					return;	
						
				}
				
				//driver = new RemoteWebDriver(new URL(hubUrl), cap);
				loggers.info("Remote WebDriver initialized successfully");
				System.out.println("Remote WebDriver initialized successfully");
			} else {
				loggers.info("Running in normal mode");
			}
			
			
			if(p.getProperty("execution_environment").equalsIgnoreCase("local")) {
				
				switch (br.toLowerCase()) {
				case "chrome":loggers.info("Browser Selected is Chrome");driver = new ChromeDriver(); break;
				case "edge":loggers.info("Browser Selected is Edge"); driver=new EdgeDriver(); break;
				default:loggers.error("Browser Not Supported"); 
				return;
				}
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
		
		
		loggers.info("Closing Browser");
		driver.quit();
		loggers.info("Browser Closed Successfully");
		
	}
	
	
	@SuppressWarnings("deprecation")
	public String randomNumber() {
		return  RandomStringUtils.randomNumeric(10);
		
	}	
	@SuppressWarnings("deprecation")
	public String randomString() {
		return  RandomStringUtils.randomAlphabetic(6);
		
	}
	
	public String randomAlphanumeric() {
		@SuppressWarnings("deprecation")
		String num1=  RandomStringUtils.randomAlphabetic(6);
		@SuppressWarnings("deprecation")
		String num2=  RandomStringUtils.randomNumeric(6);
		return (num1+"@"+num2);
		

		
	}



	public String captureScreen(String tname) {
    //String destPath = null;
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String targetFileName=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
    try {
        TakesScreenshot ts = (TakesScreenshot) driver;
		// Create a directory for screenshots if it doesn't exist
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		File targetFile=new File(targetFileName);
		
		sourceFile.renameTo(targetFile);
			
		

        } catch (Exception e) {
        loggers.error("Failed to capture screenshot: " + e.getMessage());
    }
	
	return targetFileName;
    
}



}