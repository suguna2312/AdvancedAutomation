package vtiger.genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---failed");
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String screenshotname = methodname+" "+jutil.toGetSystemDateInFormat();
		try {
			wutil.toTakeScreenshot(BaseClass.sDriver, screenshotname);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("----Suite execution Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("----Suite execution finished");
		
	}
	
	

}
