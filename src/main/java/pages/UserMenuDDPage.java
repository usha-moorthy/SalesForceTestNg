package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserMenuDDPage extends BasePage {

	public UserMenuDDPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "userNavLabel")
	public WebElement userMenuDD;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/child::a[1]")
	public WebElement myProfile;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/child::a[2]")
	public WebElement mySettings;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/child::a[3]")
	public WebElement developersConsole;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/child::a[4]")
	public WebElement switchToLightningExperience;

	@FindBy(xpath = "//a[@title='Logout']")
	public WebElement logout;
	@FindBy(xpath = "//a[@title='My Settings']")
	public WebElement my_settings;

	// My profile

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

	// postLink
	@FindBy(id = "publisherAttachTextPost")
	// a[@id='publisherAttachTextPost']/span[1]
	public WebElement postLink;

	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	public WebElement iframeLink;

	@FindBy(xpath = "/html/body")
	public WebElement textArea;

	@FindBy(xpath = "//input[@class='zen-btn zen-highlightBtn']")
	public WebElement share;

	// Upload file

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']")
	public WebElement fileLink;

	@FindBy(xpath = "//a[@id='chatterUploadFileAction']")
	public WebElement upload;

	@FindBy(xpath = "//input[@id='chatterFile']")
	public WebElement filepath;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement fileShare;

	// Add Photo

	@FindBy(xpath = "//div[@id='photoSection']/*[1]")
	public WebElement addphoto;

	@FindBy(xpath = "//iframe[@id='uploadPhotoContentId']")
	public WebElement photoiframe;

	@FindBy(xpath = "//input[@class='fileInput']")
	public WebElement chooseFile;

	@FindBy(id = "j_id0:uploadFileForm:uploadBtn")
	public WebElement photosave;

	@FindBy(id = "j_id0:j_id7:save")
	public WebElement save1;
	// j_id0:j_id7:save
	
	
	public void clickUserMenuDD(WebElement userMenu) {
		userMenu.click();
		
	}
	
	public void lodout(WebElement logout) {
		logout.click();
		
	}
	

	public void enterLastName(String aboutTabLastName) {
		this.aboutTabLastName.sendKeys(aboutTabLastName);
	}

	public List<String> selectUserMenu(WebDriver driver) {

		userMenuDD.click();
		List<String> actual = new ArrayList();
		for (WebElement str : userMenuOptions) {
			actual.add(getTextMsg(str));
		}
		return actual;
	}
	
	public MyProfilePage selectMyProfile(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		userMenuDD.click();
		this.myProfile.click();
		return new MyProfilePage( driver);
	}

	public MySettingsPage selectMySetting(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		userMenuDD.click();
		my_settings.click();
		return new MySettingsPage( driver);
	}

	public DeveloperConsoleAndLogout developerConsole(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		userMenuDD.click();
		developersConsole.click();
		return new DeveloperConsoleAndLogout( driver);
	}
	



	public void aboutTab(String abouLastName) throws InterruptedException {
		Thread.sleep(2000);
		userMenuDD.click();
		myProfile.click();
		editMyProfile.click();

		switchToframe(frameAbout);
		aboutTab.click();
		clear(aboutTabLastName);
		enterLastName(abouLastName);
		saveAllButton.click();
		switchToDefaultContent(driver);
	}

	public void postLink(String textAreaMsg) throws Exception {
		postLink.click();
		switchToframe(iframeLink);
		Thread.sleep(3000);
		enterText(textArea, textAreaMsg);
		switchToDefaultContent(driver);
		share.click();
		switchToDefaultContent(driver);
	}

	public void fileUpload(String filep) throws Exception {
		fileLink.click();
		upload.click();
		enterText(filepath, filep);
		fileShare.click();
	}

	public String addPhoto(String file) throws Exception {
		Thread.sleep(2000);
		addphoto.click();
		Thread.sleep(2000);
		switchToframe(photoiframe);
		Thread.sleep(2000);
		enterText(chooseFile, file);
		photosave.click();
		Thread.sleep(2000);
		save1.click();
		String actual = pageTitle(driver);
		return actual;

	}

	public void clear(WebElement element) {
		element.clear();
	}

}
