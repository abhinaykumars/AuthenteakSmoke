package authenteakSmokeTest;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.AuthenteakCreateAccountPage;
import pageObjectModel.AuthenteakHomePage;
import pageObjectModel.AuthenteakLoginPage;
import resources.Base;
import resources.TestData;

public class CreateAccount extends Base{
	
	public WebDriver driver;
	AuthenteakHomePage homePage;
	AuthenteakLoginPage loginPage;
	AuthenteakCreateAccountPage createAccount;
	public TestData td;
	
	@BeforeTest
	public void getLaunchURL() throws IOException
	{
		driver=launchURL(); // launch Authenteak home page
	}
	
	@Test
	public void createAccount() throws IOException, InterruptedException
	{
		
		homePage = new AuthenteakHomePage(driver);
		if(homePage.getWeAreDoingThisPopUp().isDisplayed())
		{
			homePage.getWeAreDoingThisPopUp().click(); //close the pop up message
		}
		homePage.getMyAccountLink().click();// click on My Account link
		
		loginPage = new AuthenteakLoginPage(driver);
		loginPage.getCreateAccountButton().click(); // click on create account button
		
		createAccount = new AuthenteakCreateAccountPage(driver);
		
		td = new TestData();
		ArrayList data = td.getData("CreateAccount");
		String emailAddress = data.get(1).toString();
		String password = data.get(2).toString();
		String confirmPassword = data.get(3).toString();
		String country = data.get(4).toString();
		String firstName = data.get(5).toString();
		String lasttName = data.get(6).toString();
		String addressLine1 = data.get(7).toString();
		String city = data.get(8).toString();
		String state = data.get(9).toString();
		String postCode = data.get(10).toString();
		String phoneNumber = data.get(11).toString();
		
		
		createAccount.getEmailAddressTextbox().sendKeys(emailAddress);
		createAccount.getPasswordTextbox().sendKeys(password);
		createAccount.getConfirmPasswordTextbox().sendKeys(confirmPassword);
		createAccount.getTradeAccountRadioButtons().click();
		
		Select countrylist = new Select(driver.findElement(By.xpath("//select[@data-field-type='Country']")));//Not the correct place to use this code
		countrylist.selectByVisibleText(country);
		
		createAccount.getFirstNameTextbox().sendKeys(firstName);
		createAccount.getLastNameTextbox().sendKeys(lasttName);
		createAccount.getAddressLine1Textbox().sendKeys(addressLine1);
		createAccount.getCityTextbox().sendKeys(city);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(createAccount.getStateDropdown()));//explicit wait
		
		Select stateList = new Select(driver.findElement(By.xpath("//select[@data-field-type='State']"))); //Not the correct place to use this code
		stateList.selectByValue(state);
		
		createAccount.getPostCodeTextbox().sendKeys(postCode);
		createAccount.getPhoneNumberTextbox().sendKeys(phoneNumber);
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", createAccount.getCreateAccountButton());

		System.out.println("User is created successfully");
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
}
