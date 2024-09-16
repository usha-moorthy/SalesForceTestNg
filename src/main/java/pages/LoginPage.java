package pages;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class LoginPage extends BasePage {
  public LoginPage(WebDriver driver)
  {
	  super(driver);
  }
	@FindBy(xpath = "//input[@id='username']")
	public WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@id='Login']")
	public WebElement login;

	@FindBy(xpath = "//div[@id='error']")
	public WebElement errormsg;

	@FindBy(xpath = "//input[@id='rememberUn']")
	public WebElement rememberme;

	@FindBy(xpath = "//span[@id='userNavLabel']")
	public WebElement usernameddbtn;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	public WebElement logout;

	@FindBy(xpath = "//a[@id='forgot_password_link']")
	public WebElement forgotpasswordlink;

	@FindBy(xpath = "//div[@id='error']")
	public WebElement errorMsg;
	
	@FindBy(xpath = "//div[@class='loginError' and @id='error']")
	public WebElement errorform;
	public void login(String username,String password)
	{
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.login.click();
	}
	
	public void enterUserName(String username) {
		this.username.sendKeys(username);
	}

	
	public void enterPassword(String password) {
    this.password.sendKeys(password);
		
	}
	
	public void clickLogin() {
	    this.login.click();
			
		}
	public String getTextMsg(WebElement element ) {
	
		String actual = element.getText();
		return actual;
	} 
	public String getValueAttribute(WebElement element) {
		return element.getAttribute("value");

}
}
