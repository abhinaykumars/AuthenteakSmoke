package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenteakCreateAccountPage {
	
	public WebDriver driver;
	
	private By emailAddressTextbox = By.xpath("//input[@data-field-type='EmailAddress']");
	private By passwordTextbox = By.xpath("//input[@data-field-type='Password']");
	private By confirmPasswordTextbox = By.xpath("//input[@data-field-type='ConfirmPassword']");
	By tradeAccountRadioButtons = By.xpath("//input[@id='radio-FormField[1][26]-']");

	
	public AuthenteakCreateAccountPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getEmailAddressTextbox()
	{
		return driver.findElement(emailAddressTextbox);
	}
	
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(passwordTextbox);
	}
	
	public WebElement getConfirmPasswordTextbox()
	{
		return driver.findElement(confirmPasswordTextbox);
	}
	
	public WebElement getTradeAccountRadioButtons()
	{
		return driver.findElements(tradeAccountRadioButtons).get(0);//select No radio button
		
	}
	
}
