package ForexChannel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.Function;
import Utils.Log;

public class SignUpDone {

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
		int row = 8;

		// pass the values
		// firstname
		driver.findElement(By.xpath("//input[@placeholder='First name']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constant.MAIN_SHEET));

		// lastname
		driver.findElement(By.xpath("//input[@placeholder='Last name']"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constant.MAIN_SHEET));

		// username
		driver.findElement(By.xpath("//input[@placeholder='User name']"))
				.sendKeys(ExcelUtils.getCellData(row, 3, Constant.MAIN_SHEET));

		// password
		driver.findElement(By.xpath("//input[@placeholder='********']"))
				.sendKeys(ExcelUtils.getCellData(row, 4, Constant.MAIN_SHEET));
		Thread.sleep(2000);

		// country
		driver.findElement(By.xpath("//input[@placeholder='Country']")).sendKeys("uni");
		WebElement name = driver.findElement(By.className("ng2-auto-complete"));
		List<WebElement> storeTag = name.findElements(By.tagName("span"));
		String str = ExcelUtils.getCellData(row, 5, Constant.MAIN_SHEET);
		for (int i = 0; i < storeTag.size(); i++) {
			if (storeTag.get(i).getText().equalsIgnoreCase(str)) {
				System.out.println(storeTag.get(i).getText());
				storeTag.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}

		// contact number
		driver.findElement(By.xpath("//input[@placeholder='Contact number']"))
				.sendKeys(ExcelUtils.getCellData(row, 6, Constant.MAIN_SHEET));

		// email
		driver.findElement(By.xpath("//input[@placeholder='Email']"))
				.sendKeys(ExcelUtils.getCellData(row, 7, Constant.MAIN_SHEET));
		Thread.sleep(2000);

		// subscription package
		Function.dropDown(driver, row, 8, Constant.MAIN_SHEET);
		Thread.sleep(2000);

		// subscription duration
		Function.dropDown(driver, row, 9, Constant.MAIN_SHEET);
		Thread.sleep(2000);

		// click on the signup button
		driver.findElement(By.xpath("//button[contains(text(),'SIGNUP')]")).click();
		Thread.sleep(5000);

		// it will open the otp page
		// now check for the validations
		// press tab for the validation fields
		driver.findElement(By.xpath("//input[@placeholder='OTP']")).sendKeys(Keys.TAB);
		Thread.sleep(5000);

		// get the error
		if (driver.getPageSource().contains(Constant.OTP_MAN_ERROR)) {
			Log.info("otp is required,error is present");
		} else {
			Log.error("otp is required,error is not present");
		}
		Log.info("-----------------------------------------------------");

		// passing validation value 1
		driver.findElement(By.xpath("//input[@placeholder='OTP']"))
				.sendKeys(ExcelUtils.getCellData(20, 1, Constant.MAIN_SHEET));

		// click on the submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// get the error
		if (driver.getPageSource().contains(Constant.OTP_LIMIT_MSG)) {
			Log.info("OTP length should be 6,error is present");
			ExcelUtils.setCellData("PASS", 20, 2, Constant.MAIN_SHEET);
		} else {
			Log.error("OTP length should be 6,error is not present");
			ExcelUtils.setCellData("FAIL", 20, 2, Constant.MAIN_SHEET);
		}

		Log.info("----------------------------------------------------");
		Thread.sleep(5000);
		
		//clear the field
		driver.findElement(By.xpath("//input[@placeholder='OTP']")).clear();
	

		// passing validation value 2

		driver.findElement(By.xpath("//input[@placeholder='OTP']"))
				.sendKeys(ExcelUtils.getCellData(21, 1, Constant.MAIN_SHEET));

		// click on the submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// get the error
		if (driver.getPageSource().contains(Constant.VALID_OTP_MSG)) {
			Log.info("Enter valid otp,error is present");
			ExcelUtils.setCellData("PASS", 21, 2, Constant.MAIN_SHEET);
		} else {
			Log.error("Enter valid otp,error is not present");
			ExcelUtils.setCellData("FAIL", 21, 2, Constant.MAIN_SHEET);
		}

		Log.info("-----------------------------------------------------");
		
	}

	// @AfterTest
	// public void tearDown() {
	// driver.quit();
	//
	// }

}
