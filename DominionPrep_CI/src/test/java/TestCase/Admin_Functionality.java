package TestCase;

import java.io.IOException;
import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MMT.DP.DriverManegment.DriverClass;
import com.MMT.DP.DriverManegment.DriverManager;
import com.MMT.DP.FrameWorkData.ExcelData;
import com.MMT.DP.PageObject.AdminFunctionalityObject;
import com.MMT.DP.PageObject.LoginPageObject;

public class Admin_Functionality {

	static AdminFunctionalityObject admin_object;


	@BeforeMethod
	private static void InitialMethod() throws Throwable {

		DriverClass.Initialization("Marketing_URL");
		admin_object = new AdminFunctionalityObject();


	}



	// Data provider
	@DataProvider (name = "AdminData")
	public Object[] Student_Data() throws IOException{ 
		Object data[] = ExcelData.Data("Admin");
		return data; }



	@Test(priority = 1 , dataProvider = "AdminData" , enabled = true)
	private static void Admin_Dashboard_Check (HashMap<String,String> map) throws InterruptedException {

		admin_object.Admin_Validate_Dashboard(map);
	}







	@AfterMethod
	public void QuitDriver(ITestResult result) {

		long a = result.getEndMillis()-result.getStartMillis();
		System.out.println("Time taken to run test is :"+a+" miliiseconds");
		DriverManager.getDriverRef().quit();
		DriverManager.DriverUnload();
	}



}
