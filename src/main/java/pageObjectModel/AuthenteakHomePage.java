package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenteakHomePage {
	
	public WebDriver driver;
	
	private By myAccountLink = By.xpath("//span[@class='button-text']");
	private By weAreDoingThisPopUp = By.xpath("//img[@alt='Close form']");
	
	public AuthenteakHomePage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getMyAccountLink()
	{
		return driver.findElement(myAccountLink);
	}
	
	public WebElement getWeAreDoingThisPopUp()
	{
		return driver.findElement(weAreDoingThisPopUp);
	}


}
