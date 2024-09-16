package tests;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import listeners.listenersSF;
import pages.LoginPage;
import pages.UserMenuDDPage;
import utils.ExtentReportManger;
//import pages.UserMenuDropDown.UserMenuPage;
import utils.FileReadTestDataUtils;
import utils.Screenshots;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Listeners(listenersSF.class)
public class LoginTest extends BaseTest {
	LoginPage lp;
	UserMenuDDPage um;
	WebDriver driver;
	Screenshots ss;
	ExtentTest test;

	@Test(priority = 0)
	public void loginErrorMsgTC1() throws IOException, IOException, InterruptedException {
		WebDriver driver = BaseTest.getBrowser();

		lp = new LoginPage(driver);
		driver.navigate().to(FileReadTestDataUtils.readLoginPropertiesFile("url"));
		logger.info("TC1 Started");
		// lp.enterUserName("usham@tekarch.com");

		lp.enterUserName(FileReadTestDataUtils.readLoginPropertiesFile("username"));
		lp.clickLogin();
		String expected = FileReadTestDataUtils.readLoginPropertiesFile("errormsg");
		Thread.sleep(2000);
		String actual = lp.getTextMsg(lp.errorMsg);
		// String actual = lp.getValueAttribute(lp.errorMsg);
//		System.out.println("Expected msg--->" + expected);
//		System.out.println("Actual msg----->" + actual);
		logger.info("TC1 is ended\n");
		Screenshots.captureScreenshot(driver);
		Assert.assertEquals(actual, expected);

	}

//	enabled=false
	@Test(priority = 1)
	public void loginToSalesForceTC2() throws IOException, FileNotFoundException {
		WebDriver driver = getBrowser();
		lp = new LoginPage(driver);
		String url = FileReadTestDataUtils.readLoginPropertiesFile("url");
		driver.navigate().to("https://login.salesforce.com");
		logger.info("TC2 Started");

		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"),
				FileReadTestDataUtils.readLoginPropertiesFile("password"));

		// lp.clickLogin();
		String actual = lp.pageTitle(driver);
		System.out.println(actual);
		String expected = FileReadTestDataUtils.readLoginPropertiesFile("homePageTitle");
		System.out.println("Expected  msg--->" + expected);
		System.out.println("Actual  msg----->" + actual);
		logger.info("TC2 is  ended\n");
		// Screenshots.captureScreenshot(driver);
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 2)
	public void checkRememberMeTC3() throws IOException, FileNotFoundException, InterruptedException {
		WebDriver driver = getBrowser();
		lp = new LoginPage(driver);
		um = new UserMenuDDPage(driver);
		String url = FileReadTestDataUtils.readLoginPropertiesFile("url");
		driver.navigate().to(url);

		System.out.println("TC3 Started");
		lp.enterUserName(FileReadTestDataUtils.readLoginPropertiesFile("username"));
		lp.enterPassword(FileReadTestDataUtils.readLoginPropertiesFile("password"));
		lp.rememberme.click();
		lp.clickLogin();
		Thread.sleep(2000);
		um.userMenuDD.click();
		Thread.sleep(2000);
		um.logout.click();
		Thread.sleep(2000);
		String actual = lp.getValueAttribute(lp.username);
		String expected = FileReadTestDataUtils.readLoginPropertiesFile("email");
		System.out.println("Expected --->" + expected);
		System.out.println("Actual ----->" + actual);
		System.out.println("TC3 is  ended\n");
		Screenshots.captureScreenshot(driver);
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 3)
	public void forgotPasswordTC4a() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new LoginPage(driver);
		String url = FileReadTestDataUtils.readLoginPropertiesFile("url");
		driver.navigate().to(url);

		logger.info("TC4a Started");
		lp.enterUserName(FileReadTestDataUtils.readLoginPropertiesFile("username"));
		lp.forgotpasswordlink.click();

		String actual = lp.pageTitle(driver);
		System.out.println(actual);
		String expected = FileReadTestDataUtils.readLoginPropertiesFile("forgotPasswordPageTitle");
		System.out.println("Expected --->" + expected);
		System.out.println("Actual ----->" + actual);
		System.out.println("TC4a is  ended\n");

		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 4)
	public void invalidUsernameTC4b() throws IOException, FileNotFoundException, InterruptedException {
		WebDriver driver = getBrowser();
		lp = new LoginPage(driver);
		String url = FileReadTestDataUtils.readLoginPropertiesFile("url");
		driver.navigate().to(url);

		logger.info("TC3 Started");
		lp.enterUserName(FileReadTestDataUtils.readLoginPropertiesFile("inusername"));
		lp.enterPassword(FileReadTestDataUtils.readLoginPropertiesFile("inpassword"));
		lp.clickLogin();
		String actual = lp.getTextMsg(lp.errorform);
		System.out.println(actual);
		String expected = FileReadTestDataUtils.readLoginPropertiesFile("invalidNamePageTitle");

		System.out.println("Expected --->" + expected);
		System.out.println("Actual ----->" + actual);
		System.out.println("TC4b is  ended\n");
		Assert.assertEquals(actual, expected);

	}

}
