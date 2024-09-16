package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.FileReadTestDataUtils;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//li[@id='Account_Tab']/a")
	public WebElement accountBtn;

	@FindBy(xpath = "//input[@value=' New ']")
	public WebElement newBtn;

	@FindBy(xpath = "//input[@id='acc2']")
	public WebElement acc_Name;

	@FindBy(xpath = "//input[@title='Save']")
	public WebElement CreateAccsave;

	// img[@title='Account']
	@FindBy(xpath = "//h2[@class='topName']")
	public WebElement accIcorn;
	// h2[@class='topName']
	// img[@title='Account']

	// create new view

	@FindBy(xpath = "//a[contains(text(),'Create New View')]")
	public WebElement createNewVeiw;

	@FindBy(xpath = "//input[@id='devname']")
	public WebElement uniqeName;

	@FindBy(xpath = "//input[@id='fname']")
	public WebElement veiwName;

	@FindBy(xpath = "//input[@data-uidsfdc='3']")
	public WebElement newVeiwSave;

	// input[@value='New Account']
	@FindBy(xpath = "//input[@value='New Account']")
	public WebElement vNewAcc;

	// editVeiw
	@FindBy(xpath = "//select[@id='fcf']")
	public WebElement select;
	@FindBy(xpath = "//a[text()='Edit']")
	public WebElement edit;
	@FindBy(xpath = "//select[@id='fcol1']")
	public WebElement filter;
	@FindBy(xpath = "//select[@data-uidsfdc='7']")
	public WebElement opration;
	@FindBy(xpath = "//input[@title='Value 1']")
	public WebElement valuBtn;
	@FindBy(xpath = "//*[@id='colselector_select_0']/option[31]")
	public WebElement lastActivity;
	@FindBy(xpath = "//img[@alt='Add']")
	public WebElement addButton;
	@FindBy(xpath = "//input[@data-uidsfdc='5']")
	public WebElement editsave;

	@FindBy(xpath = "//div[@title='Last Activity']")
	public WebElement vlastActivity;

	// div[@title='Last Activity']

	// merge

	@FindBy(xpath = "//a[contains(text(),'Merge Accounts')]")
	public WebElement Mergeacc;

	@FindBy(id = "srch")
	public WebElement findTxt;

	@FindBy(name = "srchbutton")
	public WebElement findAcc;
	@FindBy(xpath = "//input[@id='cid0']")
	public WebElement Button1;
	@FindBy(xpath = "//input[@id='cid1']")
	public WebElement Button2;
	@FindBy(xpath = "//input[@id='cid2']")
	public WebElement Button3;
	@FindBy(xpath = "//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Next')]")
	public WebElement next;
	@FindBy(xpath = "//div[@class='pbTopButtons']//input[@title='Merge']")
	public WebElement merge;
	@FindBy(xpath = "// h2[@class='pageDescription']")
	public WebElement vmerge;

	// report
	// h2[@class='pageDescription']
	@FindBy(xpath = "//a[text()='Accounts with last activity > 30 days']")
	public WebElement last_activity;
	@FindBy(xpath = "//img[@id='ext-gen152']")
	public WebElement calenderIcon;
	@FindBy(xpath = "//button[@id='ext-gen281']")
	public WebElement todayBtn;
	@FindBy(xpath = "//input[@id='ext-comp-1045']")
	public WebElement toDate;
	@FindBy(xpath = "//img[@id='ext-gen154']")
	public WebElement toCalenderdriverIcon;
	@FindBy(xpath = "//button[@id='ext-gen292']")
	public WebElement toTodayBtn;
	// to Save
	@FindBy(xpath = "//button[@id='ext-gen49']")
	public WebElement save;
	@FindBy(id = "//saveReportDlg_DeveloperName")
	public WebElement uniqueName;
	@FindBy(xpath = "//input[@id='saveReportDlg_reportNameField']")
	public WebElement reportName;
	@FindBy(xpath = "//button[@id='ext-gen312']")
	public WebElement runAndReport;
	@FindBy(xpath = "//img[@id='ext-gen148']")
	public WebElement dropdown1;
	@FindBy(xpath = "//div[contains(text(),'Created Date')]")
	public WebElement createDate;
	
	
	

	public boolean verifyCreateAcc(WebDriver driver, WebElement element) {
		boolean boolvariable = false;

		if (element.isDisplayed()) {
			boolvariable = true;
		} else {
			System.out.println("not working");
		}
		return boolvariable;
	}
	

	public void radioButton(WebElement element) {

		if (element.isDisplayed()) {
			element.click();
			System.out.println("pass");
		} else {
			System.out.println("Fail");
		}
	}
	

	public void switchtoAlert(WebDriver driver) {
		driver.switchTo().alert().accept();

	}
	
}
