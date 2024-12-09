package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;

    // Singleton pattern to ensure only one instance of ExtentReports
    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        // Define the report file and its configuration
        sparkReporter = new ExtentSparkReporter("SAP_Automation_Regression_Report.html");
        sparkReporter.config().setDocumentTitle("SAP Automation Regression Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("SAP Automation Regression Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        return extent;
    }

    public static synchronized ExtentSparkReporter getSparkReporter() {
        return sparkReporter;
    }

    // Method to close the report and flush it
    public static synchronized void closeExtentReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
