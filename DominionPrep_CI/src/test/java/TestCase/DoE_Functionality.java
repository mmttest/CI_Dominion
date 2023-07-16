package TestCase;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MMT.DP.DriverManegment.DriverClass;
import com.MMT.DP.FrameWorkData.ExcelData;
import com.MMT.DP.PageObject.DoEFunctionalityObject;
import com.MMT.DP.PageObject.LoginPageObject;

public class DoE_Functionality {
	
	
	static LoginPageObject DoE_Login;
	static DoEFunctionalityObject DoE_Fucntionality;


	@BeforeMethod
	private static void InitialMethod() throws Throwable {

		DriverClass.Initialization("MAIN_URL");
		DoE_Login = new LoginPageObject();
		DoE_Fucntionality = new DoEFunctionalityObject();
		
	}

	@DataProvider (name = "DoeLogin")
	public Object[] StudentForm_Data() throws IOException{ 
		Object data[] = ExcelData.Data("DoE_Login");
		return data; }


	@Test(dataProvider = "DoeLogin", dependsOnMethods={"Parent_Form.FillupForm_Parent"} )
	private static void DOE_Accept_Parent(HashMap<String,String> map) throws InterruptedException {
		
		DoE_Login.Valid_Login(map);
		DoE_Fucntionality.DoE_DashBoard();
		DoE_Fucntionality.DoE_DashBoard_ParentReceivedNumber();
	}
	
	

}
