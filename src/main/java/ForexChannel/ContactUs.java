package ForexChannel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.Function;
import Utils.Log;

public class ContactUs {
	private WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.BASE_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void testForexChannel() throws Exception {

		// check for the home page title
		Assert.assertTrue(driver.getTitle().contains(Constant.TITLE_HOME_PAGE));
		Log.info("So,we landed on the right home page");
		Thread.sleep(5000);

		//click on the side menu
		driver.findElement(By.xpath("//*[@id='home']/nav/div[1]/ul[2]/li[8]/a/img")).click();
		Thread.sleep(2000);
		
		//Click on contact us 
		driver.findElement(By.xpath("//button[contains(text(),'Contact Us')]")).click();
		Thread.sleep(2000);
		
		//check for the mandatory fields
		//name
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(Keys.TAB);
		
		//email
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Keys.TAB);
		
		//issue
		driver.findElement(By.xpath("//select[contains(text(),'Select Issue')]")).sendKeys(Keys.TAB);
		
	    //message
		driver.findElement(By.xpath("//textarea[@placeholder='Message']")).sendKeys(Keys.TAB);
	   
		//get the errors
		
	
	
	
	
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//
//	}

}
