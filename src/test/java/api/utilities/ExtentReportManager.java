package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testcontext) {
		//Time stamp
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-"+timestamp+".html";
		
		//specify the location of the report
		//sparkReporter= new ExtentSparkReporter(".\\reports\\"+repName);
		sparkReporter= new ExtentSparkReporter("/petstoreautomation/reports"+repName);
		
		//Title of the Report
		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
		
		//name of the Report
		sparkReporter.config().setReportName("pet store users Api");
		
		//set theme
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Pet store users api");
		extent.setSystemInfo("Operation System",System.getProperty("os.name"));
		extent.setSystemInfo("user name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("users", "shan");
		
	}
	public void onTestPass(ITestResult result) {
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
		public void onTestFailure(ITestResult result) {
			test=extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL, "Test Failed");
			test.log(Status.FAIL,result.getThrowable().getMessage());
		}
		public void onTestSkipped(ITestResult result) {
			test=extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, "Test Skipped");
			test.log(Status.SKIP,result.getThrowable().getMessage());
			
	}
		public void onFinish(ITestResult testContext) {
			extent.flush();
	}

}
