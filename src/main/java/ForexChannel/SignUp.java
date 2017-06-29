package ForexChannel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.Function;
import Utils.Log;

public class SignUp {

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

		// click on the signup page
		driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).click();
		Thread.sleep(2000);

		// click on the signup button to check for the mandatory fields
		driver.findElement(By.xpath("//button[contains(text(),'SIGNUP')]")).click();
		Thread.sleep(5000);

		// now get the errors mandatory field errors
		// first name

		if (driver.getPageSource().contains(Constant.MAN_FIRSTNAME)) {
			Log.info("Firstname is required,error is present");
		} else {
			Log.error("Firstname is required,error is not present");
		}
		Thread.sleep(2000);

		// last name

		if (driver.getPageSource().contains(Constant.MAN_LASTNAME)) {
			Log.info("Lastname is required,error is present");
		} else {
			Log.error("Lastname is required,error is not present");
		}
		Thread.sleep(2000);

		// username

		if (driver.getPageSource().contains(Constant.MAN_USERNAME)) {
			Log.info("Username is required,error is present");
		} else {
			Log.error("Username is required,error is not present");
		}
		Thread.sleep(2000);

		// password

		if (driver.getPageSource().contains(Constant.MAN_PASSWORD)) {
			Log.info("Password is required,error is present");
		} else {
			Log.error("Password is required,error is not present");
		}
		Thread.sleep(2000);

		// country

		if (driver.getPageSource().contains(Constant.MAN_COUNTRY_NAME)) {
			Log.info("Select country name,error is present");
		} else {
			Log.error("Select country name,error is not present");
		}
		Thread.sleep(2000);

		// contact number

		if (driver.getPageSource().contains(Constant.MAN_CONTACT_NUMBER)) {
			Log.info("Contact number is required error is present");
		} else {
			Log.error("Contact number is required,error is not present");
		}
		Thread.sleep(2000);

		// email

		if (driver.getPageSource().contains(Constant.MAN_EMAIL)) {
			Log.info("Email is required,error is present");
		} else {
			Log.error("Email is required,error is not present");
		}
		Thread.sleep(2000);

		// subscription package

		if (driver.getPageSource().contains(Constant.MAN_SUBSCRIPTION_PACKAGE)) {
			Log.info("Select subscription package,error is present");
		} else {
			Log.error("Select subscription package,error is not present");
		}
		Thread.sleep(2000);

		// select subscription duration

		if (driver.getPageSource().contains(Constant.MAN_SUBSCRIPTION_DURATION)) {
			Log.info("Select subscription duration,error is present");
		} else {
			Log.error("Select subscription duration,error is not present");
		}
		Thread.sleep(2000);

		Log.info("-------------------------------------------------------------");

		// referesh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// call for the first validation value
		Function.signUp(driver, 1);
		Thread.sleep(1000);
		int row = 1;

		// get country toast message first,for entering the invalid country
		if (driver.getPageSource().contains(Constant.TOAST_VALID_COUNTRY_MSG)) {
			Log.info("Select Valid Country...,error is present");
			ExcelUtils.setCellData("PASS", row, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Select Valid Country...,error is not present");
			ExcelUtils.setCellData("FAIL", row, 10, Constant.MAIN_SHEET);
		}

		// get the remaining errors now
		// firstname
		if (driver.getPageSource().contains(Constant.LIMIT_FIRSTNAME)) {
			Log.info("First name between 3 to 20 characters,error is present");
			ExcelUtils.setCellData("PASS", row, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("First name between 3 to 20 characters,error is not present");
			ExcelUtils.setCellData("FAIL", row, 10, Constant.MAIN_SHEET);
		}

		// lastname
		if (driver.getPageSource().contains(Constant.LIMIT_LASTNAME)) {
			Log.info("Last name between 3 to 20 characters,error is present");
			ExcelUtils.setCellData("PASS", row, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Last name between 3 to 20 characters,error is not present");
			ExcelUtils.setCellData("FAIL", row, 10, Constant.MAIN_SHEET);
		}

		// username
		if (driver.getPageSource().contains(Constant.LIMIT_USERNAME)) {
			Log.info("User name between 6 to 50 characters,error is present");
			ExcelUtils.setCellData("PASS", row, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("User name between 6 to 50 characters,error is not present");
			ExcelUtils.setCellData("FAIL", row, 10, Constant.MAIN_SHEET);
		}

		// password
		if (driver.getPageSource().contains(Constant.LIMIT_PASSWORD)) {
			Log.info("Password length between 8 to 50,error is present");
			ExcelUtils.setCellData("PASS", row, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Password length between 8 to 50,error is not present");
			ExcelUtils.setCellData("FAIL", row, 10, Constant.MAIN_SHEET);
		}

		// contact number
		if (driver.getPageSource().contains(Constant.LIMIT_CONTACT)) {
			Log.info("Contact number length between 7 to 13,error is present");
			ExcelUtils.setCellData("PASS", row, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Contact number length between 7 to 13,error is not present");
			ExcelUtils.setCellData("FAIL", row, 10, Constant.MAIN_SHEET);
		}

		// email
		if (driver.getPageSource().contains(Constant.VALID_EMAIL)) {
			Log.info("Email address is not valid,error is present");
			ExcelUtils.setCellData("PASS", row, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Email address is not valid,error is not present");
			ExcelUtils.setCellData("FAIL", row, 10, Constant.MAIN_SHEET);
		}

		Thread.sleep(5000);
		Log.info("---------------------------------------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// pass validation values 2
		Function.signUp(driver, 2);
		Thread.sleep(1000);
		int row1 = 2;

		// get country toast message first,for entering the invalid country
		if (driver.getPageSource().contains(Constant.TOAST_VALID_COUNTRY_MSG)) {
			Log.info("Select Valid Country...,error is present");
			ExcelUtils.setCellData("PASS", row1, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Select Valid Country...,error is not present");
			ExcelUtils.setCellData("FAIL", row1, 10, Constant.MAIN_SHEET);
		}

		// get the remaining errors now
		// firstname
		if (driver.getPageSource().contains(Constant.LIMIT_FIRSTNAME)) {
			Log.info("First name between 3 to 20 characters,error is present");
			ExcelUtils.setCellData("PASS", row1, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("First name between 3 to 20 characters,error is not present");
			ExcelUtils.setCellData("FAIL", row1, 10, Constant.MAIN_SHEET);
		}

		// lastname
		if (driver.getPageSource().contains(Constant.LIMIT_LASTNAME)) {
			Log.info("Last name between 3 to 20 characters,error is present");
			ExcelUtils.setCellData("PASS", row1, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Last name between 3 to 20 characters,error is not present");
			ExcelUtils.setCellData("FAIL", row1, 10, Constant.MAIN_SHEET);
		}

		// contact number
		if (driver.getPageSource().contains(Constant.LIMIT_CONTACT)) {
			Log.info("Contact number length between 7 to 13,error is present");
			ExcelUtils.setCellData("PASS", row1, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Contact number length between 7 to 13,error is not present");
			ExcelUtils.setCellData("FAIL", row1, 10, Constant.MAIN_SHEET);
		}

		// email
		if (driver.getPageSource().contains(Constant.LIMIT_EMAIL__MESSAGE)) {
			Log.info("Email address length between 6 to 50,error is present");
			ExcelUtils.setCellData("PASS", row1, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Email address length between 6 to 50,error is not present");
			ExcelUtils.setCellData("FAIL", row1, 10, Constant.MAIN_SHEET);
		}

		Log.info("-----------------------------------------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// Passing validation value 3
		Function.signUp(driver, 3);
		Thread.sleep(1000);
		int row2 = 3;

		// get the errors
		// get country toast message first,for entering the invalid country
		if (driver.getPageSource().contains(Constant.TOAST_VALID_COUNTRY_MSG)) {
			Log.info("Select Valid Country...,error is present");
			ExcelUtils.setCellData("PASS", row2, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Select Valid Country...,error is not present");
			ExcelUtils.setCellData("FAIL", row2, 10, Constant.MAIN_SHEET);
		}

		// firstname
		if (driver.getPageSource().contains(Constant.VALID_FIRSTNAME)) {
			Log.info("First name is not valid,error is present");
			ExcelUtils.setCellData("PASS", row2, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("First name is not valid,error is not present");
			ExcelUtils.setCellData("FAIL", row2, 10, Constant.MAIN_SHEET);
		}

		// lastname
		if (driver.getPageSource().contains(Constant.VALID_LASTNAME)) {
			Log.info("Last name is not valid,error is present");
			ExcelUtils.setCellData("PASS", row2, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Last name is not valid,error is not present");
			ExcelUtils.setCellData("FAIL", row2, 10, Constant.MAIN_SHEET);
		}

		// username
		if (driver.getPageSource().contains(Constant.VALID_USERNAME)) {
			Log.info("User name is not valid,error is present");
			ExcelUtils.setCellData("PASS", row2, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("User name is not valid,error is not present");
			ExcelUtils.setCellData("FAIL", row2, 10, Constant.MAIN_SHEET);
		}

		// country name
		if (driver.getPageSource().contains(Constant.VALID_COUNTRY)) {
			Log.info("Enter valid country name,error is present");
			ExcelUtils.setCellData("PASS", row2, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Enter valid country name,error is not present");
			ExcelUtils.setCellData("FAIL", row2, 10, Constant.MAIN_SHEET);
		}

		// contact number
		if (driver.getPageSource().contains(Constant.VALID_CONTACT)) {
			Log.info("Enter valid contact number,error is present");
			ExcelUtils.setCellData("PASS", row2, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Enter valid contact number,error is not present");
			ExcelUtils.setCellData("FAIL", row2, 10, Constant.MAIN_SHEET);
		}

		// email
		if (driver.getPageSource().contains(Constant.VALID_EMAIL)) {
			Log.info("Email address is not valid,error is present");
			ExcelUtils.setCellData("PASS", row2, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Email address is not valid,error is not present");
			ExcelUtils.setCellData("FAIL", row2, 10, Constant.MAIN_SHEET);
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// passing validation value 4
		Function.signUp(driver, 4);
		Thread.sleep(1000);
		int row3 = 4;

		// get country toast message first,for entering the invalid country
		if (driver.getPageSource().contains(Constant.TOAST_VALID_COUNTRY_MSG)) {
			Log.info("Select Valid Country...,error is present");
			ExcelUtils.setCellData("PASS", row3, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Select Valid Country...,error is not present");
			ExcelUtils.setCellData("FAIL", row3, 10, Constant.MAIN_SHEET);
		}

		// firstname
		if (driver.getPageSource().contains(Constant.VALID_FIRSTNAME)) {
			Log.info("First name is not valid,error is present");
			ExcelUtils.setCellData("PASS", row3, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("First name is not valid,error is not present");
			ExcelUtils.setCellData("FAIL", row3, 10, Constant.MAIN_SHEET);
		}

		// lastname
		if (driver.getPageSource().contains(Constant.VALID_LASTNAME)) {
			Log.info("Last name is not valid,error is present");
			ExcelUtils.setCellData("PASS", row3, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Last name is not valid,error is not present");
			ExcelUtils.setCellData("FAIL", row3, 10, Constant.MAIN_SHEET);
		}

		// contact number
		if (driver.getPageSource().contains(Constant.LIMIT_CONTACT)) {
			Log.info("Contact number length between 7 to 13,error is present");
			ExcelUtils.setCellData("PASS", row3, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Contact number length between 7 to 13,error is not present");
			ExcelUtils.setCellData("FAIL", row3, 10, Constant.MAIN_SHEET);
		}

		// country name
		if (driver.getPageSource().contains(Constant.VALID_COUNTRY)) {
			Log.info("Enter valid country name,error is present");
			ExcelUtils.setCellData("PASS", row3, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Enter valid country name,error is not present");
			ExcelUtils.setCellData("FAIL", row3, 10, Constant.MAIN_SHEET);
		}

		// contact number
		if (driver.getPageSource().contains(Constant.LIMIT_CONTACT)) {
			Log.info("Contact number length between 7 to 13,error is present");
			ExcelUtils.setCellData("PASS", row3, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Contact number length between 7 to 13,error is not present");
			ExcelUtils.setCellData("FAIL", row3, 10, Constant.MAIN_SHEET);
		}

		// email
		if (driver.getPageSource().contains(Constant.VALID_EMAIL)) {
			Log.info("Email address is not valid,error is present");
			ExcelUtils.setCellData("PASS", row3, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Email address is not valid,error is not present");
			ExcelUtils.setCellData("FAIL", row3, 10, Constant.MAIN_SHEET);
		}

		Log.info("---------------------------------------------------------------");
		
		
	}

	 @AfterTest
	 public void tearDown(){
	 driver.quit();
	
	
	 }

}
