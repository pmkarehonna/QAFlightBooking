package flight.booking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import flight.pageObjects.ConfirmationPage;
import flight.pageObjects.CustomerDetailsPage;
import flight.pageObjects.LandingPage;
import flight.pageObjects.FlightsPage;

public class BookFlight extends Base{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

@BeforeTest
public void initialize() throws IOException
{
	driver=intializeDriver();
}
	
@Test (dataProvider="getFlightData")
public void flightSelection(String origCity, String destCity, String airLineToBook) throws IOException
{

	FlightsPage fp=new FlightsPage(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	Select origList=new Select(fp.getOrigin());
	origList.selectByVisibleText(origCity);
	Select destList=new Select(fp.getDestination());
	destList.selectByVisibleText(destCity);
	fp.getFindButton().click();
	fp.getAirline(airLineToBook).click();	
	
	
}

@Test (dataProvider="getPersonData", dependsOnMethods= {"flightSelection"})
public void provideBookingDetails(String name, String address, String city, String state, String zip, String cardType, String cardNum, String cardMonth, String cardYear, String nameOnCard ) throws IOException
{

	CustomerDetailsPage fcp=new CustomerDetailsPage(driver);
	fcp.getName().sendKeys(name);
	fcp.getAddress().sendKeys(address);
	fcp.getCity().sendKeys(city);
	fcp.getState().sendKeys(state);
	fcp.getZipCode().sendKeys(zip);
	Select cardList=new Select(fcp.getCardType());
	cardList.selectByVisibleText(cardType);
	fcp.getCreditCardNumber().sendKeys(cardNum);
	fcp.getCreditCardMonth().clear();
	fcp.getCreditCardMonth().sendKeys(cardMonth);
	fcp.getCreditCardYear().clear();
	fcp.getCreditCardYear().sendKeys(cardYear);
	fcp.getNameOnCard().sendKeys(nameOnCard);
	fcp.getSubmitButton().click();

	
}


@Test(dependsOnMethods= {"provideBookingDetails"})
public void bookingConfirmation()
{
	ConfirmationPage cp=new ConfirmationPage(driver);
	String titleText=cp.getTitle();
	Assert.assertEquals(titleText,"BlazeDemo Confirmation");	
	log.info("Verified the confirmation page title is displayed");
	
	String titleHeader=cp.getHeader().getText();
	
	Assert.assertEquals(titleHeader, "Thank you for your purchase today!");
	log.info("Header of confirmation is verified to be displayed correctly");
	
	String OrderId=cp.getConfId().getText();
	log.info("Order id displayed for the booking is--"+OrderId);
}

//Following will be typically done using Excel sheet in order to test varying input data. In the interest of time I have used TestNG data provider

@DataProvider
public Object[][] getFlightData()
{
	Object[][] data=new Object[1][3];
	
	data[0][0]="Boston";
	data[0][1]="London";
	data[0][2]="Lufthansa";
	
	return data;
}

@DataProvider
public Object[][] getPersonData()
{
	Object[][] data=new Object[1][10];
	
	data[0][0]="Prashant Karehonna";
	data[0][1]="RMNagar";
	data[0][2]="Bangalore";
	data[0][3]="Karnataka";
	data[0][4]="561001";
	data[0][5]="American Express";
	data[0][6]="1234 5678 1011";
	data[0][7]="09";
	data[0][8]="21";
	data[0][9]="Prashant K";
	
	
	
	return data;
}

//@AfterTest
//public void closeBrowser()
//{
//	driver.close();
//}
}
