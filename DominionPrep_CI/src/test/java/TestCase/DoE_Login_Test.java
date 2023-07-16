package TestCase;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.MMT.DP.DriverManegment.DriverClass;
import com.MMT.DP.FrameWorkData.ExcelData;
import com.MMT.DP.PageObject.LoginPageObject;

public class DoE_Login_Test {

	static LoginPageObject DoE_Login;

	@BeforeMethod
	private static void InitialMethod() throws Throwable {

		DriverClass.Initialization("MAIN_URL");
		DoE_Login = new LoginPageObject();
	}

	@DataProvider (name = "DoeLogin")
	public Object[] StudentForm_Data() throws IOException{ 
		Object data[] = ExcelData.Data("DoE_Login");
		return data; }


	@Test(dataProvider = "DoeLogin")
	private static void DOE_Login(HashMap<String,String> map) throws InterruptedException {
		DoE_Login.Valid_Login(map);
	}
	
}
