/*
 * Mahmud Hasan Riad
 */

package Util;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestListener;

public class TestListener implements ITestListener {
	
	public Settings pSettings;
	
	public TestListener(Settings settings){
	    this.pSettings = settings;
    }

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Finished from listener .......");
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		context.setAttribute("setting", pSettings);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Failure from listener .......");
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Skipped from listener .......");
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Started from listener .......");
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test Passed from listener .......");
	}
	
}
