package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportUtility implements ITestListener {
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extentreport;
	public ExtentTest extenttest;
	
	
	public void onStart(ITestContext context)
	{
		
		SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date d= new Date();
		String report= df.format(d);
		
		String reportname= "\\reports\\"+report+".html";
		sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+reportname);
		
		sparkreporter.config().setDocumentTitle("Automation Document");
		sparkreporter.config().setReportName("Automation Report");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extentreport =new ExtentReports();
		extentreport.attachReporter(sparkreporter);
		
		extentreport.setSystemInfo("Application", "OpenCart");
		extentreport.setSystemInfo("Browser","Chrome");
	
		
		String os=context.getCurrentXmlTest().getParameter("OS");
		extentreport.setSystemInfo("OS", os);
		
		String browser= context.getCurrentXmlTest().getParameter("Browser");
		extentreport.setSystemInfo("Browser",browser);
		
		List<String> groups=context.getCurrentXmlTest().getIncludedGroups();
		if(!groups.isEmpty())
			extentreport.setSystemInfo("Groups",groups.toString());
	
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		extenttest = extentreport.createTest(result.getTestClass().getName());
		extenttest.assignCategory(result.getMethod().getGroups());
		extenttest.log(Status.PASS , "Passed"+result.getName());
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		extenttest=extentreport.createTest(result.getTestClass().getName());
		extenttest.assignCategory(result.getMethod().getGroups());
		extenttest.log(Status.FAIL, "Failed "+result.getName());
		extenttest.log(Status.INFO, result.getThrowable().getMessage());
		
		try
		{
			BaseClass b= new BaseClass();
			String path= b.getScreenShot(result.getName());
			extenttest.addScreenCaptureFromPath(path);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		extenttest=extentreport.createTest(result.getTestClass().getName());
		extenttest.assignCategory(result.getMethod().getGroups());
		extenttest.log(Status.SKIP, "Skipped "+result.getName());
	}
	
	public void onFinish(ITestContext context)
	{
		extentreport.flush();
	}

}
