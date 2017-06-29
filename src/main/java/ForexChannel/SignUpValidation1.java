package ForexChannel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class SignUpValidation1 {

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

		int row = 5;
		// pass the validation value 5
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
		driver.findElement(By.xpath("//input[@placeholder='Country']")).sendKeys("ind");
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

		// click on the signup button
		driver.findElement(By.xpath("//button[contains(text(),'SIGNUP')]")).click();
		Thread.sleep(1000);

		// get the error for repeated username
		if (driver.getPageSource().contains(Constant.TOAST_USERNAME_ERROR)) {
			Log.info("Username already taken,error is present");
			ExcelUtils.setCellData("PASS", row, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Username already taken,error is not present");
			ExcelUtils.setCellData("FAIL", row, 10, Constant.MAIN_SHEET);
		}
		Thread.sleep(2000);
		Log.info("------------------------------------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// pass the validation value 6
		int row1 = 6;

		// firstname
		driver.findElement(By.xpath("//input[@placeholder='First name']"))
				.sendKeys(ExcelUtils.getCellData(row1, 1, Constant.MAIN_SHEET));

		// lastname
		driver.findElement(By.xpath("//input[@placeholder='Last name']"))
				.sendKeys(ExcelUtils.getCellData(row1, 2, Constant.MAIN_SHEET));

		// username
		driver.findElement(By.xpath("//input[@placeholder='User name']"))
				.sendKeys(ExcelUtils.getCellData(row1, 3, Constant.MAIN_SHEET));

		// password
		driver.findElement(By.xpath("//input[@placeholder='********']"))
				.sendKeys(ExcelUtils.getCellData(row1, 4, Constant.MAIN_SHEET));
		Thread.sleep(2000);

		// country
		driver.findElement(By.xpath("//input[@placeholder='Country']")).sendKeys("uni");
		WebElement name1 = driver.findElement(By.className("ng2-auto-complete"));
		List<WebElement> storeTag1 = name1.findElements(By.tagName("span"));
		String str1 = ExcelUtils.getCellData(row1, 5, Constant.MAIN_SHEET);
		for (int i = 0; i < storeTag1.size(); i++) {
			if (storeTag1.get(i).getText().equalsIgnoreCase(str1)) {
				System.out.println(storeTag1.get(i).getText());
				storeTag1.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}

		// contact number
		driver.findElement(By.xpath("//input[@placeholder='Contact number']"))
				.sendKeys(ExcelUtils.getCellData(row1, 6, Constant.MAIN_SHEET));

		// email
		driver.findElement(By.xpath("//input[@placeholder='Email']"))
				.sendKeys(ExcelUtils.getCellData(row1, 7, Constant.MAIN_SHEET));
		Thread.sleep(2000);

		// subscription package
		Function.dropDown(driver, row1, 8, Constant.MAIN_SHEET);
		Thread.sleep(2000);

		// subscription duration
		Function.dropDown(driver, row1, 9, Constant.MAIN_SHEET);

		// click on the signup button
		driver.findElement(By.xpath("//button[contains(text(),'SIGNUP')]")).click();
		Thread.sleep(1000);

		// get the error now
		if (driver.getPageSource().contains(Constant.TOAST_EMAIL_ERROR)) {
			Log.info("Email already taken.,error is present");
			ExcelUtils.setCellData("PASS", row1, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Email already taken.,error is not present");
			ExcelUtils.setCellData("FAIL", row1, 10, Constant.MAIN_SHEET);
		}
		Thread.sleep(2000);
		Log.info("---------------------------------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// passing validation value 7
		int row2 = 7;

		// firstname
		driver.findElement(By.xpath("//input[@placeholder='First name']"))
				.sendKeys(ExcelUtils.getCellData(row2, 1, Constant.MAIN_SHEET));

		// lastname
		driver.findElement(By.xpath("//input[@placeholder='Last name']"))
				.sendKeys(ExcelUtils.getCellData(row2, 2, Constant.MAIN_SHEET));

		// username
		driver.findElement(By.xpath("//input[@placeholder='User name']"))
				.sendKeys(ExcelUtils.getCellData(row2, 3, Constant.MAIN_SHEET));

		// password
		driver.findElement(By.xpath("//input[@placeholder='********']"))
				.sendKeys(ExcelUtils.getCellData(row2, 4, Constant.MAIN_SHEET));
		Thread.sleep(2000);

		// country
		driver.findElement(By.xpath("//input[@placeholder='Country']")).sendKeys("uni");
		WebElement name3 = driver.findElement(By.className("ng2-auto-complete"));
		List<WebElement> storeTag3 = name3.findElements(By.tagName("span"));
		String str3 = ExcelUtils.getCellData(row2, 5, Constant.MAIN_SHEET);
		for (int i = 0; i < storeTag3.size(); i++) {
			if (storeTag3.get(i).getText().equalsIgnoreCase(str3)) {
				System.out.println(storeTag3.get(i).getText());
				storeTag3.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}

		// contact number
		driver.findElement(By.xpath("//input[@placeholder='Contact number']"))
				.sendKeys(ExcelUtils.getCellData(row2, 6, Constant.MAIN_SHEET));

		// email
		driver.findElement(By.xpath("//input[@placeholder='Email']"))
				.sendKeys(ExcelUtils.getCellData(row2, 7, Constant.MAIN_SHEET));
		Thread.sleep(2000);

		// subscription package
		Function.dropDown(driver, row2, 8, Constant.MAIN_SHEET);
		Thread.sleep(2000);

		// subscription duration
		Function.dropDown(driver, row2, 9, Constant.MAIN_SHEET);

		// click on the signup button
		driver.findElement(By.xpath("//button[contains(text(),'SIGNUP')]")).click();
		Thread.sleep(1000);

		// get the error now
		if (driver.getPageSource().contains(Constant.TOAST_CONTACT_ERROR)) {
			Log.info("Contact number is already registered with us.,error is present");
			ExcelUtils.setCellData("PASS", row2, 10, Constant.MAIN_SHEET);
		} else {
			Log.error("Contact number is already registered with us.,error is not present");
			ExcelUtils.setCellData("FAIL", row2, 10, Constant.MAIN_SHEET);
		}
		Thread.sleep(2000);
		Log.info("---------------------------------------------------------");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
