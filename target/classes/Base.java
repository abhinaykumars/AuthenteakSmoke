package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver launchURL() throws IOException
	{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.getProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		String urlName = prop.getProperty("url");
		driver.get(urlName);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public static String getScreenshots(String testName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destFile= System.getProperty("user.dir")+"\\reports\\"+testName+".png";
		FileUtils.copyFile(source, new File(destFile));
		return destFile;
	}	
	
}
