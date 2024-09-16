package constants;

import utils.ExtentReportManger;

public class FileConstants {
	public static String ROOT_PATH = System.getProperty("user.dir");

	public static final String LOGIN_TEST_DATA_FILE_PATH = ROOT_PATH + "/src/main/java/testData/loginTestData.properties";
	public static final String REPORTS_FILE_PATH = ROOT_PATH+"/src/main/resources/extentReport/"+ExtentReportManger.getTimeStamp()+"-SFDC.html";  
	
}
