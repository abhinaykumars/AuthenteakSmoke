package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AuthenteakCreateAccountPage {
	
	public WebDriver driver;
	
	private By emailAddressTextbox = By.xpath("//input[@data-field-type='EmailAddress']");
	private By passwordTextbox = By.xpath("//input[@data-field-type='Password']");
	private By confirmPasswordTextbox = By.xpath("//input[@data-field-type='ConfirmPassword']");
	private By tradeAccountRadioButtons = By.xpath("//input[@id='radio-FormField[1][26]-']");
	private By countryDropdown = By.xpath("//select[@data-field-type='Country']");
	private By firstNameTextbox = By.xpath("//input[@data-field-type='FirstName']");
	private By lastNameTextbox = By.xpath("//input[@data-field-type='LastName']");
	private By addressLine1Textbox = By.xpath("//input[@data-field-type='AddressLine1']");
	private By cityTextbox = By.xpath("//input[@data-field-type='City']");
	private By stateDropdown = By.xpath("//select[@data-field-type='State']");
	private By postCodeTextbox = By.xpath("//input[@data-field-type='Zip']");
	private By phoneNumberTextbox = By.xpath("//input[@data-field-type='Phone']");
	private By createAccountButton = By.xpath("//button[@value='Create Account']");
	private By signMeUpcheckBox = By.xpath("//input[@type='checkbox']");
	private By exixtingEmailAlertText = By.xpath("//div[@class='alert-message']");

	
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
	
	public WebElement getCountryDropdown()
	{
				
		return driver.findElement(countryDropdown);
	}
	
	public WebElement getFirstNameTextbox()
	{
		return driver.findElement(firstNameTextbox);
	}
	
	public WebElement getLastNameTextbox()
	{
		return driver.findElement(lastNameTextbox);
	}
	
	public WebElement getAddressLine1Textbox()
	{
		return driver.findElement(addressLine1Textbox);
	}
	
	public WebElement getCityTextbox()
	{
		return driver.findElement(cityTextbox);
	}
	
	public WebElement getStateDropdown()
	{
		return driver.findElement(stateDropdown);
	}
	
	public WebElement getPostCodeTextbox()
	{
		return driver.findElement(postCodeTextbox);
	}
	
	public WebElement getPhoneNumberTextbox()
	{
		return driver.findElement(phoneNumberTextbox);
	}
	
	public WebElement getCreateAccountButton()
	{
		return driver.findElement(createAccountButton);
	}
	
	public WebElement getScrollDown()
	{
		return driver.findElement(signMeUpcheckBox);
	}
	
	public WebElement getExixtingEmailAlertText()
	{
		return driver.findElement(exixtingEmailAlertText);
	}
}
