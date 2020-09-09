package authenteakSmokeTest;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
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
	public void createAccount() throws IOException
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
		
		createAccount.getEmailAddressTextbox().sendKeys(emailAddress);
		createAccount.getPasswordTextbox().sendKeys(password);
		createAccount.getConfirmPasswordTextbox().sendKeys(confirmPassword);
		createAccount.getTradeAccountRadioButtons().click();
		
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
}
