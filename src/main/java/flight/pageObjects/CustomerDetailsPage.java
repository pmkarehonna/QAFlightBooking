package flight.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerDetailsPage {
	WebDriver driver;
	
	private By fullName=By.id("inputName");
	private By address=By.id("address");
	private By city=By.id("city");
	private By state=By.id("state");
	private By zipCode=By.id("zipCode");
	private By cardType=By.id("cardType");
	private By cardNumber=By.id("creditCardNumber");
	private By cardMonth=By.id("creditCardMonth");
	private By cardYear=By.id("creditCardYear");
	private By nameOnCard=By.id("nameOnCard");
	private By submitButton=By.xpath("//input[@type='submit']");
	
	public CustomerDetailsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getName()
	{
		return driver.findElement(fullName);
	}
	
	public WebElement getAddress()
	{
		return driver.findElement(address);
	}

	public WebElement getCity()
	{
		return driver.findElement(city);
	}

	public WebElement getState()
	{
		return driver.findElement(state);
	}

	public WebElement getZipCode()
	{
		return driver.findElement(zipCode);
	}
	
	public WebElement getCardType()
	{
		return driver.findElement(cardType);
	}

	public WebElement getCreditCardNumber()
	{
		return driver.findElement(cardNumber);
	}
	
	public WebElement getCreditCardMonth()
	{
		return driver.findElement(cardMonth);
	}
	
	public WebElement getCreditCardYear()
	{
		
		return driver.findElement(cardYear);
	}
	
	public WebElement getNameOnCard()
	{
		
		return driver.findElement(nameOnCard);
	}
	
	public WebElement getSubmitButton()
	{
		
		return driver.findElement(submitButton);
	}
	
	
	
	
	
}
