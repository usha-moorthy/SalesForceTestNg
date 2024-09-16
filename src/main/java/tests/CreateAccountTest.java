package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.CreateAccountPage;
import pages.DeveloperConsoleAndLogout;
import pages.LoginPage;
import pages.UserMenuDDPage;
import utils.FileReadTestDataUtils;
import utils.Screenshots;

public class CreateAccountTest extends BaseTest {
	BasePage bp;
	UserMenuDDPage um;
	WebDriver driver;
	LoginPage lp;
	// FileReadTestDataUtils prop;
	DeveloperConsoleAndLogout dc;
	CreateAccountPage ca;
	Screenshots ss;

	@BeforeMethod
	public void launchBrowser() throws FileNotFoundException, IOException {
		driver = BaseTest.getBrowser(); 
		//prop = newFileReadTestDataUtils();

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

	@Test(enabled = true, priority = 0)
	public void createAccountTC10() throws Exception {
		lp = new LoginPage(driver);
		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"),
				FileReadTestDataUtils.readLoginPropertiesFile("password"));

		System.out.println("TC10 Started");
		
		Thread.sleep(2000);
		Screenshots.captureScreenshot(driver);
		Assert.assertTrue(ca.verifyCreateAcc(driver, ca.accIcorn), "account page is displayed");

	}

	@Test(enabled = true, priority = 1)
	public void createNewVeiwTC11() throws Exception {
		lp = new LoginPage(BaseTest.getBrowser());
		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"),
				FileReadTestDataUtils.readLoginPropertiesFile("password"));
		System.out.println("TC10 Started");
		Thread.sleep(2000);
		ca.accountBtn.click();
		Thread.sleep(2000);
		ca.createNewVeiw.click();
		um.clear(ca.uniqeName);
		lp.enterText(ca.uniqeName, FileReadTestDataUtils.readLoginPropertiesFile("uniqeName"));
		lp.enterText(ca.veiwName, FileReadTestDataUtils.readLoginPropertiesFile("veiwName"));
		ca.CreateAccsave.click();
		Assert.assertTrue(ca.verifyCreateAcc(driver, ca.vNewAcc), "new account pade is displayed");

	}

	 @Test(enabled = true, priority = 2)
	public void editVeiwTC12() throws Exception {
		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"),
				FileReadTestDataUtils.readLoginPropertiesFile("password"));
		System.out.println("TC10 Started");
		Thread.sleep(2000);
		ca.accountBtn.click();
		Thread.sleep(2000);
		bp.selectByIndex(ca.select, 1);
		Thread.sleep(2000);
		ca.edit.click();
		BasePage.selectByVisibleText(ca.filter, "Account Name");
		BasePage.selectByVisibleText(ca.opration, "contains");
		Thread.sleep(2000);
		um.clear(ca.valuBtn);
		lp.enterText(ca.valuBtn, "a");
		ca.lastActivity.click();
		ca.editsave.click();
		Assert.assertTrue(ca.verifyCreateAcc(BaseTest.getBrowser(), ca.vlastActivity), "last activity is displayed");

	}

	 @Test(enabled = true, priority = 3)
	public void mergeAccountsTC13() throws Exception {
		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"),
				FileReadTestDataUtils.readLoginPropertiesFile("password"));
		System.out.println("TC10 Started");
		Thread.sleep(2000);
		ca.accountBtn.click();
		Thread.sleep(2000);
		ca.Mergeacc.click();
		um.clear(ca.findTxt);
		lp.enterText(ca.findTxt, "ac");
		ca.findAcc.click();
		ca.radioButton(ca.Button1);
		ca.radioButton(ca.Button2);
		ca.next.click();
		ca.merge.click();
		ca.switchtoAlert(BaseTest.getBrowser());
		Assert.assertTrue(ca.verifyCreateAcc(BaseTest.getBrowser(), ca.vmerge), "merge is displayed");

	}

	 @Test(enabled = true, priority = 3)
	public void createReportTC14() throws Exception {
		lp.login(FileReadTestDataUtils.readLoginPropertiesFile("username"),
				FileReadTestDataUtils.readLoginPropertiesFile("password"));
		System.out.println("TC10 Started");
		Thread.sleep(2000);
		ca.accountBtn.click();
		ca.last_activity.click();
		ca.dropdown1.click();
		ca.createDate.click();
		Thread.sleep(2000);
		ca.calenderIcon.click();
		ca.todayBtn.click();
		ca.toDate.clear();
	//	ca.toCalenderdriverIcon.click();
		Thread.sleep(2000);
	//	 ca.todayBtn.click();
		ca.save.click();
		Thread.sleep(2000);
		um.clear(ca.uniqeName);
		lp.enterText(ca.uniqeName, "report8");
		lp.enterText(ca.reportName, " Report8");
		ca.runAndReport.click();

	}

	@AfterTest
	public void TearDoen() throws InterruptedException {
		Thread.sleep(2000);
		BaseTest.getBrowser().quit();
	}

}
