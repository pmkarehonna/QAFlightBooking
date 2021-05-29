package flight.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightsPage {
	
	WebDriver driver;
	
	private By departureCity=By.xpath("//select[@name='fromPort']");
	private By destinationCity=By.xpath("//select[@name='toPort']");
	private By findButton=By.xpath("//input[@type='submit']");
	private By chooseFlight;
	
	public FlightsPage(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement getOrigin()
	{
		
		return driver.findElement(departureCity);
	}
	
	public WebElement getDestination()
	{
		return driver.findElement(destinationCity);
	}

	public WebElement getFindButton()
	{
		return driver.findElement(findButton);
	}
	
	public WebElement getAirline(String airLine)
	{
		chooseFlight=By.xpath("//tr/td[3][contains(text(),'"+airLine+"')]/preceding-sibling::td[2]/input[@type='submit']");
		return driver.findElement(chooseFlight);
		
	}
	
	
	
	
	

}
