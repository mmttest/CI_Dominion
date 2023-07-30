package TestCase;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.MMT.DP.DriverManegment.DriverClass;
import com.MMT.DP.DriverManegment.DriverManager;
import com.MMT.DP.FrameWorkData.ExcelData;
import com.MMT.DP.PageObject.StudentFormObject;

public class Student_Form {

	static StudentFormObject Studentform ;


	@BeforeMethod
	private static void InitialMethod() throws Throwable {

		DriverClass.Initialization("Marketing_URL");
		Studentform = new StudentFormObject();
	}




	@DataProvider (name = "StudentForm")
	public Object[] StudentForm_Data() throws IOException{ 
		Object data[] = ExcelData.Data("StudentForm");
		return data;
}

	@Test(dataProvider = "StudentForm")
	private static void FillupForm_Student(HashMap<String,String> map) throws InterruptedException {
		Studentform.StudentFormSubmit(map);
	}




	@AfterMethod
	public void QuitDriver(ITestResult result) {
		long a = result.getEndMillis()-result.getStartMillis();
		System.out.println("Time taken to run test is :"+a+" miliiseconds");
		DriverManager.getDriverRef().quit();
		DriverManager.DriverUnload();
	}
}