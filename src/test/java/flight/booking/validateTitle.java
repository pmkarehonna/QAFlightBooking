package flight.booking;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import flight.pageObjects.LandingPage;

public class validateTitle extends Base{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	flight.pageObjects.LandingPage lp;
	@BeforeTest
	public void prereqs() throws IOException
	{
		driver=intializeDriver();
		driver.get(url);	
	}
	
@Test 
public void validateTitleOfPage() throws IOException
{

	lp=new LandingPage(driver);
	String titleText=lp.getTitle();
	Assert.assertEquals(titleText,"BlazeDemo");
	log.info("Verified the title of the page is displayed");
	
	
	
}

@Test
public void validateHeaderOfPage() throws IOException
{

	lp=new LandingPage(driver);
	String titleHeader=lp.getHeader().getText();
	
	Assert.assertEquals(titleHeader, "Welcome to the Simple Travel Agency!");
	log.info("Header is verified to be displayed correctly");
	
}




@AfterTest
public void closeBrowser()
{
	driver.close();
}
}
