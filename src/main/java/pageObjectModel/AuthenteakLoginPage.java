package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenteakLoginPage {
	
	public WebDriver driver;
	
	private By createAccountButton = By.xpath("//a[@class='button account-button-primary']");
	
	public AuthenteakLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCreateAccountButton()
	{
		return driver.findElement(createAccountButton);
	}
	

}
