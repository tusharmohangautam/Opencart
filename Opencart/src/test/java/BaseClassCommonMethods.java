

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.LogManager;  //Log4j2
import org.apache.logging.log4j.Logger;      //Log4j2


public class BaseClassCommonMethods {

public WebDriver driver;
public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger=LogManager.getLogger(this.getClass());  //It will dynamicaly work for all testcase class
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	
	public String randomNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	
	public String randomAlphaNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return (generatedstring+"@"+generatednumber);
	}
	
	
	
	
	
	
}
