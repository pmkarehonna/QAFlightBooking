package flight.utilities;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;

public class FlightUtil {
	
public WebElement airLineFinder(List<WebElement> airlinesall, String airLineToSelect)
{
	
	Iterator<WebElement> iter=airlinesall.iterator();
	
	for(int i=1;i<airlinesall.size();i++)
	{
		if(airlinesall.get(i).getText().equalsIgnoreCase(airLineToSelect))
				{
				return airlinesall.get(i);
				}

	}
	
	return null;
		
}
	

}
