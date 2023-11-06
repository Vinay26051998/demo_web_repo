package genericUtilities;

import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 * @author vinay
 *
 */
public class ITestListernersUtility extends BaseClass implements ITestListener{

	ExtentReports report;

	public void onStart(ITestContext context) {
//		String time = LocalDateTime.now().toString().replace(':','-');
		ExtentSparkReporter reporter=new ExtentSparkReporter("./report/ExtentReport.html");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Sample extent report Title");
		reporter.config().setReportName("Sample_Extent_Report");
		report=new ExtentReports();
		report.attachReporter(reporter);
	}
	
	public void onTestStart(ITestResult result) {
		logger = report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {	
		logger.log(Status.PASS, "The test "+result.getName() +"is passed");
	}

	public void onTestFailure(ITestResult result) {
		logger.addScreenCaptureFromPath(screenshotUtility.capturingScreenShot(result.getName()));
		logger.log(Status.FAIL, "The test "+result.getName() +"is failed");
	}
	
	public void onFinish(ITestContext context) {
		report.flush();
	} 
}
