package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.FileReadTestDataUtils;

public class DeveloperConsoleAndLogout extends BasePage {
	FileReadTestDataUtils prop = new FileReadTestDataUtils();
	public DeveloperConsoleAndLogout(WebDriver driver) {
		super(driver);

	}
	@FindBy(id = "userNavLabel")
	public WebElement userMenuDD;
	@FindBy(xpath = "//a[@class='debugLogLink menuButtonMenuLink']")
	public WebElement developerConsole;
	
	@FindBy(xpath = "//a[@href='/secur/logout.jsp']")
	public WebElement use_menu_logout;
	
	
	

	
	
	public boolean verifyDevConsole(WebDriver driver) throws IOException, IOException, InterruptedException {
	boolean	isDev=false;
		String parentWindow=this.driver.getWindowHandle();
		for(String handle:driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
			String title=driver.getTitle();
			System.out.println(title);
			if (title.contains(prop.readLoginPropertiesFile("pagetit")));
			{
		//	System.out.println("Developer console window is displayed");
				isDev=true;	
			
		}
			
		driver.switchTo().window(parentWindow);
		Thread.sleep(10000);
	//	driver.quit();
		
	}
		return isDev;
		
	}
	
	
	public boolean verifyLogout(WebDriver driver) {
		boolean isLogout=false;
		String url= driver.getCurrentUrl();
		System.out.println(url);
		if (url.contains("logout"))
		{
			isLogout=true;
		
	}
		else {
			System.out.println("not logged out");	
		}
		
		return isLogout;
		
	}
	

}
