package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	FileReadTestDataUtils prop =new FileReadTestDataUtils() ;
	
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
	}
	public static void captureScreenshot(WebDriver driver) throws FileNotFoundException, IOException
	{
		
		String timeStamp= new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		TakesScreenshot ts=((TakesScreenshot) driver);
//		String filepath=prop.readLoginPropertiesFile("screenFile");
		String filepath="D:\\workspaceJuly\\salesForceTestNG\\screenshots\\Salesforce-"+timeStamp+".png";
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File dstFile=new File(filepath);
		srcFile.renameTo(dstFile);
		
	
	    
	
	}
	
	
	
	

}
