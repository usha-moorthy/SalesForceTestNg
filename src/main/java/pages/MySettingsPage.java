package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MySettingsPage  extends BasePage{
	
	public MySettingsPage(WebDriver driver) {
		super(driver);

	}
	

	//Tc7
	@FindBy(id = "userNavLabel")
	public WebElement userMenuDD;
//	@FindBy(xpath = "//div[@id='userNavButton']/span]")
//	public WebElement my_settings;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']/child::a[2]")
	public WebElement my_settings;
	
	
	@FindBy(id = "PersonalInfo_font")
	public WebElement verifyMysets;
	@FindBy(id = "PersonalInfo_font")
	public WebElement personal;
	
	@FindBy(id = "LoginHistory_font")
	public WebElement loginHistory;
	
	
	@FindBy(xpath = "//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1")
	public WebElement vhistory;
	
	
//display and layout
	

	@FindBy(id = "DisplayAndLayout_font")
	public WebElement Display_Layout;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizeTab;

	@FindBy(id = "p4")
	public WebElement customApp;
	
	
	@FindBy(xpath = "//option[@value='report']")
	public WebElement report;
	
	@FindBy(xpath = "//img[@alt='Add']")
	public WebElement addButton;
	
	@FindBy(xpath = "//input[@value=' Save ']")
	public WebElement displaysave;
	
	@FindBy(xpath = "//div[@id='tsidButton']")
	public WebElement contentBtnArrow;
	
	@FindBy(xpath = "//a[contains(text(),'Salesforce Chatter')]")
	public WebElement salesForceChatter;
	
	@FindBy(xpath = "//div[@id='tsidButton']")
	public WebElement contentBtnArrow1;
	
	@FindBy(xpath = "//div[@id='tsid-menuItems']/a[7]")
	public WebElement content;
	
	@FindBy(xpath = "//a[@title='Reports Tab']")
	public WebElement vDisplay;
	//a[@title='Reports Tab']
	
//myEmailSetting
	
	@FindBy(id ="EmailSetup_font")
	public WebElement emailSetup;
	
	@FindBy(xpath = "//span[(text()='My Email Settings')]")
	public WebElement myemailSett;
	@FindBy(id = "sender_name")
	public WebElement emailName;
	@FindBy(id = "sender_email")
	public WebElement emailAdd;
	@FindBy(xpath = "//input[@value='1']")
	public WebElement radioBtn;
	@FindBy(xpath = "//input[@class='btn primary']")
	public WebElement emailSave;
	
	@FindBy(xpath = "//*[@id=\"bodyCell\"]/div/div[1]/div[1]/h1")
	public WebElement vmySettings;
	
//calendarAndReminders
	
	@FindBy(xpath = "//span[@id='CalendarAndReminders_font']")
	public WebElement calendarAndReminders;
	
	@FindBy(xpath = "//span[text()='Activity Reminders']")
	public WebElement activity;
	
	@FindBy(id = "testbtn")
	public WebElement testReminder;
	
	@FindBy(xpath = "//input[@value=' Save ']")
	public WebElement calSave;
	
	@FindBy(xpath = "//a[@class='debugLogLink menuButtonMenuLink']")
	public WebElement developerConsole;
	
	
	
	
	
	
	public  void calendarAndReminders() throws Exception {
		
		calendarAndReminders.click();
		activity.click();
		testReminder.click();
		switchToNewWindow(driver);
		
	//	calSave.click();
	}
		
	
		
	public boolean verifyCalenderAndReminder(WebDriver driver) {
		boolean isCalender=false;
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
		}
		String pageheading = driver.getTitle();
		if (pageheading.contains("Reminder")) {
			driver.switchTo().defaultContent();
	
			 isCalender=true;
			//System.out.println("poped up page title = " + pageheading);*/
		
		}
		return isCalender;
	}
	
	public void displayAndLayout() throws InterruptedException {
		Display_Layout.click();
		CustomizeTab.click();
		selectByVisibleText(customApp,"Salesforce Chatter");
		report.click();
		addButton.click();
		displaysave.click();
		contentBtnArrow.click();
		Thread.sleep(2000);
	//	salesForceChatter.click();
	//	contentBtnArrow1.click();
	//	content.click();
	}
		
	public void switchToNewWindow(WebDriver driver) {
		String mainWindow = driver.getWindowHandle();
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}

		}

	}	
		
		
		public void personalAndLoginHistory() throws Exception {
			Thread.sleep(2000);
			personal.click();
			loginHistory.click();
			// download link
			// driver.findElement(By.xpath("//a[@href='/servlet/servlet.LoginHistory?id=005ak000002GwDO']")).click();
		}
	
	public void  myEmailSetting(String name,String email) throws Exception {
		Thread.sleep(2000);
		emailSetup.click();
		myemailSett.click();
		emailName.clear();
		Thread.sleep(2000);
		enterText(emailName,name);
		Thread.sleep(2000);
		enterText(emailAdd,email);
		radioBtn.click();
		emailSave.click();
	}
	
	
	public boolean verifyMySettingPage(WebDriver driver) {
		boolean isMysetting=false;
	
		if(verifyMysets.isDisplayed())
		{
			isMysetting=true;
		}
		else {
			System.out.println("mysetting pade is not visible");
		}
		return isMysetting;
	}
	
	
	public boolean verifyLoginHistoryPage(WebDriver driver) {
		boolean isLoginHistory=false;
	
		if(vhistory.isDisplayed())
		{
			isLoginHistory=true;
		}
		else {
			System.out.println("login history pade is not visible");
		}
		return isLoginHistory;
	}
	
	
	public boolean verifyDisplayAndLayout(WebDriver driver) {
		boolean DisplayAndLayout=false;
	
		if(vDisplay.isDisplayed())
		{
			DisplayAndLayout=true;
		}
		else {
			System.out.println("display ad layout pade is not visible");
		}
		return DisplayAndLayout;
	}

	public boolean verifyMyemailSettings(WebDriver driver) {
		boolean isMyemailSettings=false;
	
		if(vmySettings.isDisplayed())
		{
			isMyemailSettings=true;
		}
		else {
			System.out.println("my email settings pade is not visible");
		}
		return isMyemailSettings;
	}



}
