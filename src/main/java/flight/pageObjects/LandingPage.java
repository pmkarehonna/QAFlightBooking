package flight.pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LandingPage {
	
	WebDriver driver;
	

	private By header=By.xpath("//div/h1");
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	

	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	
	
	
	
	
}
