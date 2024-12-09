package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    public static synchronized ExtentTest createTest(String testName) {
        ExtentTest test = ExtentManager.getInstance().createTest(testName);
        extentTestThreadLocal.set(test);
        return test;
    }

    public static synchronized void setExtentTest(ExtentTest extentTest) {
        extentTestThreadLocal.set(extentTest);
    }

    public static synchronized ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }
}
