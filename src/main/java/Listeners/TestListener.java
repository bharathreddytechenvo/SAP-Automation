package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import ExtentReports.ExtentManager;
import ExtentReports.ExtentTestManager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite is starting: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentTest test = extent.createTest(testName);
        ExtentTestManager.setExtentTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getExtentTest().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentTestManager.getExtentTest();
        if (test != null) {
            test.fail("Test failed: " + result.getThrowable().getMessage());
        } else {
            System.err.println("ExtentTest instance is null for " + result.getMethod().getMethodName());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getExtentTest().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.closeExtentReports();
    }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
}
