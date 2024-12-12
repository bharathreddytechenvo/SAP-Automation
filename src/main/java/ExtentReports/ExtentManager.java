package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        sparkReporter = new ExtentSparkReporter("SAP Automation_Regression_Report.html");
        sparkReporter.config().setDocumentTitle("SAP Automation_Regression_Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("SAP Automation_Regression_Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        return extent;
    }

    public static synchronized ExtentSparkReporter getSparkReporter() {
        return sparkReporter;
    }

    public static synchronized void closeExtentReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}