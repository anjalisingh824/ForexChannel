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
import Utils.Function;
import Utils.Log;

public class Login {
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

		// check for the mandatory field,click on the login button
		driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
		Thread.sleep(2000);

		// get the mandatory errors
		// username
		if (driver.getPageSource().contains(Constant.MAN_USERNAMEMAIL)) {
			Log.info("Email address / Username is required,error is present");
		} else {
			Log.error("Email address / Username is required,error is not present");
		}

		// password
		if (driver.getPageSource().contains(Constant.MAN_PASSWORD)) {
			Log.info("Password is required,error is present");
		} else {
			Log.error("Password is required,error is not present");
		}

		Log.info("------------------------------------------------------------");

		int row = 10;
		// passing validation value 1
		Function.loginPage(driver, 10);
		Thread.sleep(1000);

		// get the toast message
		if (driver.getPageSource().contains(Constant.TOAST_LOGIN_ERROR)) {
			Log.info("Username and password do not match.,error is present");
			ExcelUtils.setCellData("PASS", row, 3, Constant.MAIN_SHEET);
		} else {
			Log.error("Username and password do not match.,error is not present");
			ExcelUtils.setCellData("FAIL", row, 3, Constant.MAIN_SHEET);
		}

		Log.info("-------------------------------------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		int row1 = 11;

		// passing validation value 2
		Function.loginPage(driver, 11);
		Thread.sleep(1000);

		// get the error messages
		// username/email
		if (driver.getPageSource().contains(Constant.MIN_USERNAME_ERROR)) {
			Log.info("Email address / Username length between 6 to 50,error is present");
			ExcelUtils.setCellData("PASS", row1, 3, Constant.MAIN_SHEET);
		} else {
			Log.error("Email address / Username length between 6 to 50,error is not present");
			ExcelUtils.setCellData("FAIL", row1, 3, Constant.MAIN_SHEET);
		}

		// password
		if (driver.getPageSource().contains(Constant.LIMIT_PASSWORD)) {
			Log.info("Password length between 8 to 50,error is present");
			ExcelUtils.setCellData("PASS", row1, 3, Constant.MAIN_SHEET);
		} else {
			Log.error("Password length between 8 to 50,error is not present");
			ExcelUtils.setCellData("FAIL", row1, 3, Constant.MAIN_SHEET);
		}

		Log.info("---------------------------------------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// passing validation value 3
		Function.loginPage(driver, 12);
		Thread.sleep(1000);
		int row2 = 12;

		// get the error messages
		// username/email
		if (driver.getPageSource().contains(Constant.MIN_USERNAME_ERROR)) {
			Log.info("Email address / Username length between 6 to 50,error is present");
			ExcelUtils.setCellData("PASS", row2, 3, Constant.MAIN_SHEET);
		} else {
			Log.error("Email address / Username length between 6 to 50,error is not present");
			ExcelUtils.setCellData("FAIL", row2, 3, Constant.MAIN_SHEET);
		}

		// password
		if (driver.getPageSource().contains(Constant.LIMIT_PASSWORD)) {
			Log.info("Password length between 8 to 50,error is present");
			ExcelUtils.setCellData("PASS", row2, 3, Constant.MAIN_SHEET);
		} else {
			Log.error("Password length between 8 to 50,error is not present");
			ExcelUtils.setCellData("FAIL", row2, 3, Constant.MAIN_SHEET);
		}

		Log.info("------------------------------------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// passing validation value 4
		Function.loginPage(driver, 13);
		Thread.sleep(2000);
		Log.info("------------------------------PASSED---------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// passing validation value 5
		Function.loginPage(driver, 14);
		Thread.sleep(1000);
		int row3 = 14;

		// get the toast message
		if (driver.getPageSource().contains(Constant.TOAST_LOGIN_ERROR)) {
			Log.info("Username and password do not match.,error is present");
			ExcelUtils.setCellData("PASS", row3, 3, Constant.MAIN_SHEET);
		} else {
			Log.error("Username and password do not match.,error is not present");
			ExcelUtils.setCellData("FAIL", row3, 3, Constant.MAIN_SHEET);
		}

		Log.info("-------------------------------------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// passing validation value 6
		Function.loginPage(driver, 23);
		Thread.sleep(1000);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
