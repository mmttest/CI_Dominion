package com.MMT.DP.ExtendReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.MMT.DP.DriverManegment.DriverClass;


public class ExtendReportManeger extends DriverClass implements ITestListener {
	private ExtentReports extent;
	public ExtentTest test;
	public ExtentSparkReporter spark;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		Extend_Thread.setExtend_dr(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Extend_Thread.getExtend_dr().log(Status.PASS, MarkupHelper.createLabel("The Test Case is Passed", ExtentColor.GREEN));

	}

	@Override
	public void onTestFailure(ITestResult result) {

		Extend_Thread.getExtend_dr().log(Status.FAIL, MarkupHelper.createLabel("The Test Case is Faild", ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		Extend_Thread.getExtend_dr().log(Status.SKIP, MarkupHelper.createLabel("The Test Case is Skipped", ExtentColor.PURPLE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Dp_Test_Report.html");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("com.MMT.Dominion_Prep");
		spark.config().setReportName("Dominion prep Test Report");
		extent.setSystemInfo("NAME", "Dominion Prep");
		extent.setSystemInfo("os", "Windows");
		extent.setSystemInfo("Project", "Dominion Prep CI");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Test Conducted By", "Akash Saha (QA)");




	}

	@Override
	public void onFinish(ITestContext result) {
		
		

		extent.flush();

		Extend_Thread.Extend_Unload();

	}








}
