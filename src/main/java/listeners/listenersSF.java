package listeners;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import tests.BaseTest;
import utils.Screenshots;

public class listenersSF implements ITestListener{
	

	public void onTestStart(ITestResult result) {
		
		System.out.println(result.getName()+" Started");
	}

	public void onTestFailure(ITestResult result) {
		
		
		System.out.println(result.getName()+" failed");	
		try {
			Screenshots.captureScreenshot(BaseTest.getBrowser());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	BaseTest.test.get().addScreenCaptureFromPath(Screenshots.captureScreenshot(BaseTest.getBrowser()));
	BaseTest.test.get().log(Status.FAIL, result.getName()+" FAILED");
	}


//	public void onFinish(ITestContext context) {
//		System.out.println(context.getName()+" Finished");
//	}
//
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" pass");
	//	BaseTest.test.get().log(Status.PASS, result.getName()+" PASSED");
		
	}

	
	
	
	

}
