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
import com.MMT.DP.PageObject.Form_AcceptObject;
import com.MMT.DP.PageObject.LoginPageObject;

public class DoE_Functionality {


	static LoginPageObject DoE_Login;
	static Form_AcceptObject Form_Accept_Object;


	@BeforeMethod
	private static void InitialMethod() throws Throwable {

		DriverClass.Initialization("Marketing_URL");
		DoE_Login = new LoginPageObject();
		Form_Accept_Object = new Form_AcceptObject();

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
	
	
	// Data provider
	@DataProvider (name = "StudentReceivedList")
	public Object[] Student_Data() throws IOException{ 
		Object data[] = ExcelData.Data("StudentForm");
		return data; }
	
	
	
	
	
	
	@Test(priority = 1 , dataProvider = "ParentReceivedList", enabled = true )
	private static void DOE_Received_List_Parent(HashMap<String,String> map) throws InterruptedException {

		Form_Accept_Object.Parent_Received_List(map);
	}
	
	@Test(priority = 2, dataProvider = "ParentReceivedList" , enabled = true)
	private static void DOE_Accept_List_Parent(HashMap<String,String> map) throws InterruptedException {

		Form_Accept_Object.Parent_Accept_Test(map);
	}
	
	
	
	
	@Test(priority = 3, dataProvider = "TeacherReceivedList" , enabled = true )
	private static void DOE_Received_List_Teacher (HashMap<String,String> map) throws InterruptedException {

		Form_Accept_Object.Teacher_Received_List(map);
	}
	
	@Test(priority = 4, dataProvider = "TeacherReceivedList" , enabled = true )
	private static void DOE_Accept_List_Teacher (HashMap<String,String> map) throws InterruptedException {

		Form_Accept_Object.Teacher_Accept_Test(map);
	}
	
	
	
	
	@Test(priority = 5, dataProvider = "StudentReceivedList" , enabled = true )
	private static void DOE_Received_List_Student (HashMap<String,String> map) throws InterruptedException {

		Form_Accept_Object.Student_Received_List(map);
	}
	
	
	@Test(priority = 6 , dataProvider = "StudentReceivedList" , enabled = true)
	private static void DOE_Accept_List_Student (HashMap<String,String> map) throws InterruptedException {

		Form_Accept_Object.Student_Accept_Test(map);
	}

	
	
	@AfterMethod
	public void QuitDriver(ITestResult result) {

		long a = result.getEndMillis()-result.getStartMillis();
		System.out.println("Time taken to run test is :"+a+" miliiseconds");
		DriverManager.getDriverRef().quit();
		DriverManager.DriverUnload();
	}

}
