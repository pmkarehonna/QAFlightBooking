package flight.booking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	WebDriver driver;
	public String browserName;
	public String url;
	
public WebDriver intializeDriver() throws IOException
{
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\flight\\resources\\data.properties");
	//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"C:\\B2BiQAAutomationWS\\E2EProject\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	browserName=prop.getProperty("browser");
//	browserName=System.getProperty("browser");
	url=prop.getProperty("url");
	
	switch(browserName)
	{
	case "Firefox":
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
	//	System.setProperty("webdriver.gecko.driver", "C:\\B2BiQAAutomationWS\\E2EProject\\src\\main\\java\\resources\\geckodriver.exe");
	driver=new FirefoxDriver();
	break;

	case "Chrome":
	
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\flight\\resources\\chromedriver.exe");
	//	System.setProperty("webdriver.chrome.driver", "C:\\B2BiQAAutomationWS\\E2EProject\\src\\main\\java\\resources\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	driver=new ChromeDriver(options);
	break;
	
	case "Chromeheadless":
		
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\flight\\resources\\chromedriver.exe");
	//	System.setProperty("webdriver.chrome.driver", "C:\\B2BiQAAutomationWS\\E2EProject\\src\\main\\java\\resources\\chromedriver.exe");
	ChromeOptions options1=new ChromeOptions();
	options1.addArguments("headless");
	driver=new ChromeDriver(options1);
	break;
//	case "IE":
//		System.setProperty("webdriver.chrome.driver", "C:\\Training\\Selenium\\Drivers\\IE\\iedriver.exe");
//		driver=new InternetExplorerDriver();	
		
	default : 	System.out.println("Invalid browser name");
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}

public String getScreenshot(String testcaseName, WebDriver driver) throws IOException
{
	TakesScreenshot ts= (TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
	FileUtils.copyFile(source, new File(destFile));
	return destFile;
}

}
