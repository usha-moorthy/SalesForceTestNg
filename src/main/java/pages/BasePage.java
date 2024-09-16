package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
//	private Object errorMessage;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

/*	public void waitforElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}*/

	public void switchToNewWindow(WebDriver driver) {
		String mainWindow = driver.getWindowHandle();
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}

		}

	}
public String getTextMsg(WebElement element ) {
		
		String actual = element.getText();
		return actual;
	}


	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void switchToframe(WebElement element) {
		driver.switchTo().frame(element);
	}
	

	// Method to handle closing the current window
	public void closeCurrentWindow() {
		driver.close();
	}
	
	public String getValueAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	// Method to switch back to the main window
	public void switchToMainWindow() {
		String mainWindow = driver.getWindowHandles().iterator().next();
		driver.switchTo().window(mainWindow);

	}
	
public String pageTitle(WebDriver driver) {
	String actual=driver.getTitle();
	return actual;
	
}
public void enterText(WebElement obj,String textval) throws Exception

{
	if(obj.isDisplayed())
	{
		Thread.sleep(4000);
		obj.sendKeys(textval);
	}
	else
	{
		System.out.println( "field does not exist please check application");
	//logger.log(LogStatus.FAIL,textval+objName+"field does not exist please check application");
		
	}
}
public static void selectByVisibleText(WebElement ele, String Name) {
	if(ele.isDisplayed()) {
		 Select select = new Select(ele);
		 select.selectByVisibleText(Name);
	 System.out.println("Pass");
	 }else {
	 System.out.println("Fail");
	 }
	 }
public void selectByIndex(WebElement ele, int index) {
	  if(ele.isDisplayed()) {
	   Select select=new Select(ele);
	  select.selectByIndex(index);
	  
	  System.out.println("pass ");
	  }else {
	   System.out.println("Fail:"+index+"is not selected");

	  }
	 }	
public static void SelectByValue(WebElement ele, String val) {
	  
	if(ele.isDisplayed()) {
	   Select select=new Select(ele);
	    
	   select.selectByValue(val);
	 
	 
	  }else {
	   System.out.println("Fail");
	  }
	 }	
	

}
