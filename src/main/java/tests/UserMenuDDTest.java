package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.CreateAccountPage;
import pages.DeveloperConsoleAndLogout;
import pages.LoginPage;
import pages.MyProfilePage;
import pages.MySettingsPage;
import pages.UserMenuDDPage;
import utils.FileReadTestDataUtils;
import utils.Screenshots;

public class UserMenuDDTest extends BaseTest {
	BasePage bp;
	UserMenuDDPage um;
	LoginPage lp;
	WebDriver driver;
	FileReadTestDataUtils prop;
	DeveloperConsoleAndLogout dc;
	CreateAccountPage ca;
	Screenshots ss;
	@BeforeMethod
	public void launchBrowser() throws FileNotFoundException, IOException {
		driver = BaseTest.getBrowser(); // prop = new
		// FileReadTestDataUtils();

		String url = FileReadTestDataUtils.readLoginPropertiesFile("url");
		lp = new LoginPage(driver);

		um = new UserMenuDDPage(driver);
		bp = new LoginPage(driver);
		ss = new Screenshots();
		ca = new CreateAccountPage(driver);
		dc = new DeveloperConsoleAndLogout(driver);

		driver.navigate().to(url);
		driver.manage().window().maximize();

	}


/*	@BeforeMethod
	public void launchBrowser() throws FileNotFoundException, IOException {
		driver = getDriver();
		prop = new FileReadTestDataUtils();
		
	//	String url = prop.readLoginPropertiesFile("url");
		
		
	//	setDriver("chrome", false);
	//	WebDriver driver=getBrowser();
		
		lp = new LoginPage(driver);
		um = new UserMenuDDPage(driver);
		bp = new LoginPage(driver);
		dc=new DeveloperConsoleAndLogout(driver);
		driver.navigate().to("https://login.salesforce.com");
		driver.manage().window().maximize();
	}*/

	@Test(enabled=true,priority = 0)
	public void userMenuDropDownTC5() throws IOException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"), FileReadTestDataUtils.readLoginPropertiesFile("password"));

		System.out.println("TC5 Started");
		Thread.sleep(2000);
		List<String> actual = um.selectUserMenu(driver);
		String expected = FileReadTestDataUtils.readLoginPropertiesFile("dropdownText");
		System.out.println("Expected --->" + expected);
		System.out.println("Actual ----->" + actual);
		System.out.println("TC5 is ended\n");
		
		Assert.assertEquals(actual.toString(), expected);

	}

	@Test(enabled = true,priority = 1)
	public void clickMyprofileTC6a() throws Exception {
		lp = new LoginPage(driver);
		System.out.println("*** TC6 Started ***\n");
		System.out.println("TC6a Started");
		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"), FileReadTestDataUtils.readLoginPropertiesFile("password"));

		Thread.sleep(2000);

		um.userMenuDD.click();
	//	MyProfilePage pp=um.selectMyProfile(driver);
		Thread.sleep(2000);
		um.myProfile.click();
		String actual = lp.pageTitle(driver);
		String expected = FileReadTestDataUtils.readLoginPropertiesFile("myprofileTitle");
		System.out.println("Expected --->" + expected);
		System.out.println("Actual ----->" + actual);
		System.out.println("TC6a is ended\n");
		Assert.assertEquals(actual, expected);

		Thread.sleep(2000);
		MyProfilePage pp=um.selectMyProfile(driver);

		System.out.println("TC6b Started --> About Tab");
		um.aboutTab(FileReadTestDataUtils.readLoginPropertiesFile("aboutTabLastName"));
		System.out.println("TC6b ended  --> About Tab\n");
		

		System.out.println("TC6c Started  --> PostLink");
		Thread.sleep(2000);
		um.postLink(FileReadTestDataUtils.readLoginPropertiesFile("textArea"));
		System.out.println("TC6c ended   -->PostLink\n");
		

		System.out.println("TC6d Started -->File Upload");
		Thread.sleep(2000);
		um.fileUpload(FileReadTestDataUtils.readLoginPropertiesFile("filePath"));
		System.out.println("TC6d ended   -->File Upload\n");
		

		System.out.println("TC6e Started -->Add Photo");
		String actual1=um.addPhoto(FileReadTestDataUtils.readLoginPropertiesFile("chooseFile"));
		String expected1 = FileReadTestDataUtils.readLoginPropertiesFile("TC6");
		
		System.out.println("Expected --->" + expected1);
		System.out.println("Actual ----->" + actual1);
		System.out.println("TC6e is ended\n");
		Assert.assertEquals(actual, expected1);
}	
	
	@Test(enabled=true,priority = 2)
	public void userMenuMySettingTC7() throws Exception {
		System.out.println("*** TC7 Started ***\n");
		lp = new LoginPage(driver);
		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"), FileReadTestDataUtils.readLoginPropertiesFile("password"));

		MySettingsPage sp=um.selectMySetting(driver);
		Assert.assertTrue(sp.verifyMySettingPage(driver), "My setting page is displayed");
		sp.personalAndLoginHistory();
		Assert.assertTrue(sp.verifyLoginHistoryPage(driver), "Login History is displayed");
		sp.displayAndLayout();
		Assert.assertTrue(sp.verifyDisplayAndLayout(driver), "display and layout is displayed");
		sp.myEmailSetting(FileReadTestDataUtils.readLoginPropertiesFile("emailNamevalue"), FileReadTestDataUtils.readLoginPropertiesFile("emailId"));
		Assert.assertTrue(sp.verifyMyemailSettings(driver),"my email page");
		sp.calendarAndReminders();
		Assert.assertTrue(sp.verifyCalenderAndReminder(driver),"sample event pop windw is displayed");
		
		System.out.println("*** TC7 ended ***\n");

	}
	@Test(priority = 3)
	public void developerConsoleTC8() throws InterruptedException, FileNotFoundException, IOException {
		System.out.println("*** TC8 Started ***\n");
		lp = new LoginPage(driver);
		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"), FileReadTestDataUtils.readLoginPropertiesFile("password"));

	 dc=um.developerConsole(driver);
		Assert.assertTrue(dc.verifyDevConsole(driver),"Devloper console");
	}
	
	@Test(priority = 4)
	public void logoutTC9() throws FileNotFoundException, IOException, InterruptedException {
		System.out.println("*** TC9 Started ***\n");
		lp = new LoginPage(driver);
		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"), FileReadTestDataUtils.readLoginPropertiesFile("password"));
		Thread.sleep(3000);
		um.clickUserMenuDD(um.userMenuDD);
		um.lodout(um.logout);
		Assert.assertTrue(dc.verifyLogout(driver),"logged ut");

		
	}
	@AfterTest
		public void TearDoen() throws InterruptedException {
			Thread.sleep(2000);
			driver.quit();
		}
	

}
