package com.MMT.DP.PageObject;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MMT.DP.DriverManegment.DriverManager;
import com.MMT.DP.FrameWorkConstant.Paths;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import org.openqa.selenium.JavascriptExecutor;

public class StudentFormObject {

	// Main application from marketing site
	@FindBy (xpath = "//a[text()='Login']")
	private static WebElement Login_Application;

	// main site
	@FindBy( xpath = "//input[@placeholder='Enter your email or username']" )
	private static WebElement User_Name;
	@FindBy( xpath = "//input[@placeholder='Enter your password']" )
	private static WebElement Password;
	@FindBy( xpath = "//input[@type='submit']" )
	private static WebElement Login_Button;
	@FindBy( xpath = "//a[text()=' Forgot Password?']" )
	private static WebElement Forgot_Password;
	@FindBy( xpath = "//a[text()='Back to Login']" )
	private static WebElement Back_To_Login;
	@FindBy( xpath = "//input[@type='submit']" )
	private static WebElement Forgot_Send;
	@FindBy( xpath = "//input[@placeholder='Email']" )
	private static WebElement Forgot_Email_Field;
	
	
	// DoE banner
	
	@FindBy (xpath="//p[contains(text(),'Students Received')]//parent::div/h3")
	private static WebElement StudentReceivedNumber;
	

	// Student Add
	@FindBy (xpath="//span[text()='Students']// parent::a")
	private static WebElement Student_Tab;
	@FindBy (xpath="//a[text()='Add Child']")
	private static WebElement Student_Add_Button;
	@FindBy (xpath="//input[@placeholder='Enter Name']")
	private static WebElement Student_Name;
	@FindBy (xpath="//select[@name='years']")
	private static WebElement Year_Select;
	@FindBy (xpath="//select[@name='sex']")
	private static WebElement Gender_Select;
	@FindBy (xpath="//span[text()='Select Grade']")
	private static WebElement Grade_Dropdown;
	@FindBy (xpath="//div[text()='Grade-4']")
	private static WebElement Grade_Select;
	@FindBy (xpath="//input[@placeholder='Select Date of Birth ']")
	private static WebElement DateOfBirth;
	@FindBy (xpath="//div[@class='datepicker-days']/table/tfoot/tr//th[text()='Today']")
	private static WebElement Today_DOB_Button;
	@FindBy (xpath="//input[@placeholder='Enter Email']")
	private static WebElement Email_Field;
	@FindBy (xpath="//input[@placeholder='XXX-XXX-XXXX']")
	private static WebElement Phone_Field;
	@FindBy (xpath="//input[@name='photo']")
	private static WebElement Photo_Field;
	@FindBy (xpath="(//input[@placeholder='Enter Percentile Scores for math'])[1]")
	private static WebElement State_Public_Percentile_Score;
	@FindBy (xpath="(//input[@placeholder='Enter Reading'])[1]")
	private static WebElement State_Public_Reading;
	@FindBy (xpath="(//input[@placeholder='Enter Overall'])[1]")
	private static WebElement State_Public_Overall_Reading;
	@FindBy (xpath="(//input[@type='file' and@class='form-control'])[1]")
	private static WebElement State_Public_File;
	@FindBy (xpath="(//input[@placeholder='Enter Percentile Scores for math'])[2]")
	private static WebElement ISEE_Percentile_Score;
	@FindBy (xpath="(//input[@placeholder='Enter Reading'])[2]")
	private static WebElement ISEE_Reading;
	@FindBy (xpath="(//input[@placeholder='Enter Overall'])[2]")
	private static WebElement ISEE_Overall_Reading;
	@FindBy (xpath="(//input[@type='file' and@class='form-control'])[2]")
	private static WebElement ISEE_File;
	@FindBy (xpath="(//input[@placeholder='Enter Percentile Scores for math'])[3]")
	private static WebElement IOWA_Tests_Percentile_Score;
	@FindBy (xpath="(//input[@placeholder='Enter Reading'])[3]")
	private static WebElement IOWA_Tests_Reading;
	@FindBy (xpath="(//input[@placeholder='Enter Overall'])[3]")
	private static WebElement IOWA_Tests_Overall_Reading;
	@FindBy (xpath="(//input[@type='file' and@class='form-control'])[3]")
	private static WebElement IOWA_File;
	@FindBy (xpath="//input[@type='password']")
	private static WebElement password;
	@FindBy (xpath="//input[@type='submit']")
	private static WebElement Submit;
	@FindBy (xpath="//select[@id='semesterID']")
	private static WebElement Semester_Dropdown;

	@FindBy (xpath="//option[contains(text(),'(Upcoming 1)')]")
	private static WebElement Semester_Select;
	@FindBy (xpath="(//div[@class='boxYellow'] //input[@type='checkbox'])[1]")
	private static WebElement Grade_CheckBox;
	@FindBy (xpath="//label[text()='All Course Enrollment']//preceding ::input[@type='checkbox']")
	private static WebElement All_Course_CheckBox;
	@FindBy (xpath="(//ul[@class='gridView']/li)[2]//child ::div/h6")
	private static WebElement Student_Added_Name;
	@FindBy (xpath="(//ul[@class='gridView']/li)[2]//child ::div[@class='hoverBox']")
	private static WebElement Student_Added_Hover;
	
	
	//Profile button
	@FindBy (xpath = "//a[@id='logout-btn']")
	private static WebElement Logout_Portal;
	@FindBy (xpath = "//span[@id='usernamehoverbtn']")
	private static WebElement Profile;
	@FindBy (xpath = "//a[@class=\"btn-logout\"]")
	private static WebElement LogOut_Pop_Button;
	
	
	
	static int Intitial_Student_DashBoard_Number;
	static int Increse__Student_DashBoard_Number;
	

	public StudentFormObject() {
		PageFactory.initElements(DriverManager.getDriverRef(),this);
	}



	public  void StudentFormSubmit(Map <String, String> map) throws InterruptedException {

		Login_Application.click();
		Set<String> Window_handel1 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it1 =Window_handel1.iterator();
		String Parent_Window1 = it1.next();
		String Child_Window1 = it1.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window1);
		User_Name.sendKeys(map.get("DoE_Username"));
		Password.sendKeys(map.get("DoE_Password"));
		Login_Button.click();
		String NumberS = StudentReceivedNumber.getText();
		Intitial_Student_DashBoard_Number = Integer.parseInt(NumberS);
		Increse__Student_DashBoard_Number= Intitial_Student_DashBoard_Number+1;
		System.out.println("The present Student number is:-  "+ Intitial_Student_DashBoard_Number);
		Profile.click();
		Logout_Portal.click();
		LogOut_Pop_Button.click();
		DriverManager.getDriverRef().close();
		DriverManager.getDriverRef().switchTo().window(Parent_Window1);
		Login_Application.click();
		Set<String> Window_handel2 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it2 =Window_handel2.iterator();
		String Parent_Window2 = it2.next();
		String Child_Window2 = it2.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window2);
		Thread.sleep(3000);
		User_Name.sendKeys("parents@gmail.com");
		Password.sendKeys("password@123");
		Login_Button.click();
		Student_Tab.click();
		Actions AddChild_Action = new Actions(DriverManager.getDriverRef());
		AddChild_Action.moveToElement(Student_Add_Button).build().perform();
		Thread.sleep(4000);
		Student_Add_Button.click();
		Student_Name.sendKeys(map.get("Name"));
		// If academic Year not selected By default
		//Select YearSelect = new Select(Year_Select);
		//YearSelect.selectByValue("Automation Testing");
		Select GenderSelect = new Select(Gender_Select);
		GenderSelect.selectByValue("Male");
		Grade_Dropdown.click();
		Grade_Select.click();
		File Profilefile = new File(new File(Paths.getDemoStudentProfileImage()).getAbsolutePath());	
		String Profile_image_Path = Profilefile.toString();
		Photo_Field.sendKeys(Profile_image_Path);
		DateOfBirth.click(); Today_DOB_Button.click();
		Email_Field.sendKeys(map.get("Email")); Phone_Field.sendKeys("0987654321");
		State_Public_Percentile_Score.sendKeys("70%");
		State_Public_Reading.sendKeys("50%");
		State_Public_Overall_Reading.sendKeys("100%"); File Pdffile = new File(new
				File(Paths.getDemoPdf()).getAbsolutePath());
		State_Public_File.sendKeys(Pdffile.toString());
		ISEE_Percentile_Score.sendKeys("70%"); ISEE_Reading.sendKeys("50%");
		ISEE_Overall_Reading.sendKeys("100%");
		ISEE_File.sendKeys(Pdffile.toString());
		IOWA_Tests_Percentile_Score.sendKeys("70%");
		IOWA_Tests_Reading.sendKeys("50%");
		IOWA_Tests_Overall_Reading.sendKeys("100%");
		IOWA_File.sendKeys(Pdffile.toString());
		password.sendKeys(map.get("Password")); 
		Submit.click();
		Semester_Dropdown.click(); 
		Semester_Select.click(); Grade_CheckBox.click();
		All_Course_CheckBox.click(); 
		Submit.click();
		Actions Hover_Added_Name = new Actions(DriverManager.getDriverRef());
		Hover_Added_Name.moveToElement(Student_Added_Hover).build().perform(); 
		String Added_name = Student_Added_Name.getText(); 
		Assert.assertEquals(Added_name,map.get("Name"));
		Thread.sleep(5000);
		Profile.click();
		Logout_Portal.click();
		LogOut_Pop_Button.click();
		DriverManager.getDriverRef().switchTo().window(Parent_Window2);
		Login_Application.click();
		Set<String> Window_handel3 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it3 =Window_handel3.iterator();
		String Parent_Window3 = it3.next();
		String Child_Window3 = it3.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window3);
		User_Name.sendKeys(map.get("DoE_Username"));
		Password.sendKeys(map.get("DoE_Password"));
		Login_Button.click();
		String Number_Incremented = StudentReceivedNumber.getText();
		int Increse_Real_Parent_DashBoard_Number = Integer.parseInt(Number_Incremented);

		if(Increse_Real_Parent_DashBoard_Number == Increse__Student_DashBoard_Number) {
			System.out.println("TestDone_New_Student_Number_is :-  " + Increse_Real_Parent_DashBoard_Number);
		}else {
			Assert.fail("   The dashboard is not updated for the Student  ");
		} 
		
		

	}


}
