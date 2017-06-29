package ForexChannel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.Log;

public class ForgetPassword {
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

		// click on the login button
		driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
		Thread.sleep(2000);

		// click on the forget password
		driver.findElement(By.linkText("Forgot password?")).click();
		Thread.sleep(2000);

		// pass the email
		driver.findElement(By.xpath("//input[@placeholder='Enter your email address or mobile number']"))
				.sendKeys(ExcelUtils.getCellData(16, 1, Constant.MAIN_SHEET));

		// click on the send otp button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		// get the toast error
		if (driver.getPageSource().contains(Constant.TOAST_USER_NOT_EXIST)) {
			Log.info("User does not exists.,error is present");
			ExcelUtils.setCellData("PASS", 16, 2, Constant.MAIN_SHEET);
		} else {
			Log.error("User does not exists.,error is not present");
			ExcelUtils.setCellData("FAIL", 16, 2, Constant.MAIN_SHEET);
		}

		Log.info("----------------------------------------------");

		// clear the value
		driver.findElement(By.xpath("//input[@placeholder='Enter your email address or mobile number']")).clear();

		// pass the value
		driver.findElement(By.xpath("//input[@placeholder='Enter your email address or mobile number']"))
				.sendKeys(ExcelUtils.getCellData(17, 1, Constant.MAIN_SHEET));

		// click on the send otp button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		// get the error
		if (driver.getPageSource().contains(Constant.EMAIL_USERNAME_ERROR)) {
			Log.info("Email min length is 6 and mobile no min length is 7,error is present");
			ExcelUtils.setCellData("PASS", 17, 2, Constant.MAIN_SHEET);
		} else {
			Log.error("Email min length is 6 and mobile no min length is 7,error is not present");
			ExcelUtils.setCellData("FAIL", 17, 2, Constant.MAIN_SHEET);
		}

		Thread.sleep(2000);
		Log.info("---------------------------------------------------------------------");

		// clear the value
		driver.findElement(By.xpath("//input[@placeholder='Enter your email address or mobile number']")).clear();

		// pass the value
		driver.findElement(By.xpath("//input[@placeholder='Enter your email address or mobile number']"))
				.sendKeys(ExcelUtils.getCellData(18, 1, Constant.MAIN_SHEET));

		// click on the send otp button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	}

	// @AfterTest
	// public void tearDown() {
	// driver.quit();
	//
	// }
}
