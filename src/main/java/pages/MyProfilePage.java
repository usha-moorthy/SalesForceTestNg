package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePage {
	public MyProfilePage(WebDriver driver) {
		super(driver);

	}


	// My profile

	@FindBy(xpath = "//div[@id='userNav-menuItems']/child::a[1]")
	public WebElement myProfile;

	@FindBy(xpath = "//img[@alt='Edit Profile']")
	public WebElement editMyProfile;
	// iFrame for About Tab

	@FindBy(id = "contactInfoContentId")
	public WebElement frameAbout;

	@FindBy(id = "aboutTab")
	public WebElement aboutTab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement aboutTabLastName;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;
	
	
	public boolean verifyAboutAndContactTab(WebDriver driver) {
		boolean isframeLoaded=false;
		switchToframe(frameAbout);
		if(aboutTab.isDisplayed())
		{
			isframeLoaded=true;
		}
		else {
			System.out.println("no iframe");
		}
		return isframeLoaded;
	}


public void selectMFPage() {
	
}
}