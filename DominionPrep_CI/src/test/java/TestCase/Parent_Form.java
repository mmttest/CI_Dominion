package TestCase;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MMT.DP.DriverManegment.DriverClass;
import com.MMT.DP.DriverManegment.DriverManager;
import com.MMT.DP.FrameWorkData.ExcelData;
import com.MMT.DP.PageObject.ParentFormObject;
import org.testng.ITestResult;




public class Parent_Form {
	static ParentFormObject parentform;

	@BeforeMethod
	private static void InitialMethod() throws Throwable {

		DriverClass.Initialization("Marketing_URL");
		parentform = new ParentFormObject();
	}


	@DataProvider (name = "ParentForm")
	public Object[] StudentForm_Data() throws IOException{ 
		Object data[] = ExcelData.Data("ParentForm");
		return data; }

	@Test(dataProvider = "ParentForm")
	private static void FillupForm_Parent(HashMap<String,String> map) throws InterruptedException {
		parentform.ParentFormSubmit(map);
	}
	

	@AfterMethod
	public void QuitDriver(ITestResult result) {
	      long a = result.getEndMillis()-result.getStartMillis();
	      System.out.println("Time taken to run test is :"+a+" miliiseconds");
		DriverManager.getDriverRef().quit();
		DriverManager.DriverUnload();
	}



}
