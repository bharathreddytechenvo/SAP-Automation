package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import ExtentReports.ExtentManager;
import ExtentReports.ExtentTestManager;
import Tests.TestBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	private TestBase testBase;
	
    private ExtentReports extent = ExtentManager.getInstance();
    private static final Logger log = LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        log.info("Test Suite is starting: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        String className = result.getTestClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        ExtentTest test = extent.createTest(className);
        ExtentTestManager.setExtentTest(test);
        log.info("Test is starting: " + className);
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Test Suite is ending: " + context.getName());
        ExtentManager.closeExtentReports();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getExtentTest().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String className = result.getTestClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);

        // Log failure in the report
        ExtentTestManager.getExtentTest().fail("Test failed");

        // Capture screenshot (ensure you have implemented this method)
        Utils.ScreenShot.TakesScreenShot(className);
        
        testBase = new TestBase();
        testBase.quitDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getExtentTest().skip("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("Test failed but it is in defined success ratio: " + getTestMethodName(result));
    }

    private String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }
}
