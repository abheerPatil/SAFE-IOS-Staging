package testListeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.DriverClass;


public class ExtentReportingListener implements ITestListener{

	 ExtentHtmlReporter htmlReporter;
	 ExtentReports extent;
	 ExtentTest logger;
	 protected List<String> params; 
	 RetryAnalyser ob = new RetryAnalyser();
	 
	 public String convertToString(Object[] objects){
		String s = "{ ";
		 if(objects.length!=0){
			 s = s+objects[0];
		 }
		 for(int i = 1 ; i < objects.length ; i++)
		 {
			 s = s + " , " + objects[i];
		 }
		 s = s + " }";
		 return s;
	 }
	 
	 public void onTestStart(ITestResult result) {
		 logger = extent.createTest(result.getMethod().getMethodName());
	 }
	 public void onTestSuccess(ITestResult result) {
		 logger.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName() , ExtentColor.GREEN));
		 logger.log(Status.PASS, "DATE USED :-");
		 logger.log(Status.PASS, convertToString(result.getParameters()));
	 }
	 public void onTestFailure(ITestResult result) {
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName() , ExtentColor.RED));
		 logger.log(Status.FAIL, "DATE USED :-");
		 logger.log(Status.FAIL, convertToString(result.getParameters()));
		 File scr = DriverClass.driver.getScreenshotAs(OutputType.FILE);
		 Calendar cal = Calendar.getInstance();
	     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		 String file = "src/test/resources/Screenshots/"+result.getMethod().getMethodName()+sdf.format(cal.getTime())+".png";
		 try {
			 File a = new File(file);
			 FileUtils.copyFile(scr, a);
			 logger.fail("Snapshot below: " + logger.addScreenCaptureFromPath(a.getAbsolutePath()));
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 result.getMethod().getRetryAnalyzer();
	 }
	 public void onTestSkipped(ITestResult result) {
		 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName() , ExtentColor.YELLOW));
		 logger.log(Status.SKIP, "DATE USED :-");
		 logger.log(Status.SKIP, convertToString(result.getParameters()));
	 }
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	 }
	 public void onStart(ITestContext context) {
		 htmlReporter = new ExtentHtmlReporter("ExtentReport/"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date())+" report.html");
		 extent = new ExtentReports ();
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Host Name", "MAC OS");
		 extent.setSystemInfo("Environment", "Automation Testing");
		 extent.setSystemInfo("User Name", "KIWITECH");
		 
		 htmlReporter.config().setDocumentTitle("SAFE AUTOMATION REPORT");
		 htmlReporter.config().setReportName("SAFE");
		 htmlReporter.config().setTheme(Theme.DARK);
		 htmlReporter.config().setCSS("img.r-img { width: 100px; height: 200px;}");
		
	 }
	 public void onFinish(ITestContext context) {
		 extent.flush();
	 
	 }
	
}
