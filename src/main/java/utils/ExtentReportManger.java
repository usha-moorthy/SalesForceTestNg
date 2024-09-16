package utils;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FileConstants;


public class ExtentReportManger {
	
	private static ExtentReports extent;
	static FileReadTestDataUtils prop;
	
	private ExtentReportManger() {

	}
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
	}

	public static ExtentReports getInstance() {
		if (extent == null) {
			try {
			
				createInstance( FileConstants.REPORTS_FILE_PATH);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return extent;
	}

	private static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(fileName);
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setDocumentTitle("SFDC Automation Report");
		sparkReport.config().setEncoding("utf-8");
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		return extent;
	}

}
