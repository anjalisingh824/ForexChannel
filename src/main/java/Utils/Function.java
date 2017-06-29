package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Function {
	public static void dropDown(WebDriver driver, int row, int cellno, String sheetName) throws Exception {
		List<WebElement> elementList = driver.findElements(By.tagName("option"));
		System.out.println(elementList.size());
		String str = ExcelUtils.getCellData(row, cellno, sheetName);
		boolean check = false;

		for (int i = 0; i < elementList.size(); i++) {

			if (elementList.get(i).getText().equals(str)) {
				Log.info("entering if condition");
				WebElement elementClick = elementList.get(i);
				Thread.sleep(5000);
				elementClick.click();
				check = true;
				break;
			}

		}
		if (!check) {
			elementList.get(1).click();
		}

	}

	public static void signUp(WebDriver driver, int row) throws Exception {
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

		// country
		driver.findElement(By.xpath("//input[@placeholder='Country']"))
				.sendKeys(ExcelUtils.getCellData(row, 5, Constant.MAIN_SHEET));

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

	}

	public static void loginPage(WebDriver driver,int row) throws Exception
	{
		
		//username/email
		driver.findElement(By.xpath("//input[@placeholder='Enter your email address / username']")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.MAIN_SHEET));
		
		//password
		driver.findElement(By.xpath("//input[@placeholder='********']")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.MAIN_SHEET));
		
		Thread.sleep(2000);
		
		//click on the login button
		driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
	
		
		
	}
	
	
	
}
