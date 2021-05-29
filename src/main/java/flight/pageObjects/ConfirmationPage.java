package flight.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ConfirmationPage {
	
	WebDriver driver;
	

	private By header=By.xpath("//h1");
	private By confId=By.xpath("(//tr/td[2])[1]");
	
	
	public ConfirmationPage(WebDriver driver) {
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
	
	public WebElement getConfId()
	{
		return driver.findElement(confId);
	}
	
	
	
}
