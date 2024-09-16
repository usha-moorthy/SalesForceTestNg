package tests;

import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import pages.LoginPage;
import utils.ExtentReportManger;

public class BaseTest {
	ExtentReports extent;
	
	public static ThreadLocal<WebDriver> threadlocalDriver = new ThreadLocal<>();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	public static Logger logger = LogManager.getLogger("BaseTest");

	public void setDriver(String browserName, boolean headless) {
		WebDriver driver = getDriver(browserName, false);
		threadlocalDriver.set(driver);
	}

	public static WebDriver getBrowser() {
		return threadlocalDriver.get();
	}

	/*
	 * public WebDriver getDriver() {f
	 * 
	 * if(driver==null) { // WebDriverManager.chromedriver().setup(); driver = new
	 * ChromeDriver(); } return driver; }
	 */
	public WebDriver getDriver(String browserName, boolean headless) {
		WebDriver driver = null;
		String browser = browserName.toLowerCase();
		switch (browser) {
		case "chrome":
			if (headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			driver = null;
			break;
		}
		return driver;
	}

	@BeforeSuite
	public void setup() {
		logger.info("@BeforeSuite....");
		extent = ExtentReportManger.getInstance();
	}

	@AfterSuite
	public void tearDownFinal() {
		logger.info("@afterSuite....");
		extent.flush();
	}

	@Parameters("bName")
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("chrome") String browserName, Method name) {
		test.set(extent.createTest(name.getName()));
		setDriver(browserName, false);
		WebDriver driver = getBrowser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		getBrowser().close();
	}

}
