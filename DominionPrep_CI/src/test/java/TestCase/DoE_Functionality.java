package TestCase;

import org.testng.annotations.Test;
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
import com.MMT.DP.PageObject.DoEFunctionalityObject;
import com.MMT.DP.PageObject.LoginPageObject;

public class DoE_Functionality {


	static LoginPageObject DoE_Login;
	static DoEFunctionalityObject DoE_Fucntionality;


	@BeforeMethod
	private static void InitialMethod() throws Throwable {

		DriverClass.Initialization("Marketing_URL");
		DoE_Login = new LoginPageObject();
		DoE_Fucntionality = new DoEFunctionalityObject();

	}

	// Data provider
	@DataProvider (name = "DoeLogin")
	public Object[] Login_Data() throws IOException{ 
		Object data[] = ExcelData.Data("DoE_Login");
		return data; }





	// Data provider
	@DataProvider (name = "ParentReceivedList")
	public Object[] Parent_Data() throws IOException{ 
		Object data[] = ExcelData.Data("ParentForm");
		return data; }
	
	
	
	
	// Data provider
	@DataProvider (name = "TeacherReceivedList")
	public Object[] Teacher_Data() throws IOException{ 
		Object data[] = ExcelData.Data("TeacherForm");
		return data; }
	
	
	
	
	
	
	@Test(dataProvider = "ParentReceivedList" )
	private static void DOE_Accept_List_Parent(HashMap<String,String> map) throws InterruptedException {

		DoE_Fucntionality.Parent_Received_List(map);
	}
	
	
	@Test(dataProvider = "TeacherReceivedList" )
	private static void DOE_Accept_List_Teacher (HashMap<String,String> map) throws InterruptedException {

		DoE_Fucntionality.Teacher_Received_List(map);
	}
	
	

	@AfterMethod
	public void QuitDriver(ITestResult result) {

		long a = result.getEndMillis()-result.getStartMillis();
		System.out.println("Time taken to run test is :"+a+" miliiseconds");
		DriverManager.getDriverRef().quit();
		DriverManager.DriverUnload();
	}

}
