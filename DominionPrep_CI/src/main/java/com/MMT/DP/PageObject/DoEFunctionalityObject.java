package com.MMT.DP.PageObject;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MMT.DP.DriverManegment.DriverManager;

public class DoEFunctionalityObject {




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

	@FindBy (xpath="//p[contains(text(),'Parents Received')]//parent::div/h3")
	private static WebElement ParentReceivedNumber;

	//Parents tab
	@FindBy (xpath="//span[text()='Parents']// parent::a")
	private static WebElement Parent_Tab;
	@FindBy (xpath="//span[text()='Parent Received List']// parent::a")
	private static WebElement Parent_Received_List;
	@FindBy (xpath="//span[text()='Parent Approved List']// parent::a")
	private static WebElement Parent_Approved_List;
	@FindBy (xpath="//td[@class='sorting_1' and text()='1']/following :: td[2]")
	private static WebElement Received_Parent;

	// received list 
	@FindBy (xpath="//td[@class='sorting_1' and text()=1]// following :: td[2]")
	private static WebElement Approved_Parent;





	//Teacher Tab
	@FindBy (xpath="//span[text()='Teacher']// parent::a")
	private static WebElement Teacher_Tab;
	@FindBy (xpath="//span[text()='Teacher Received List']// parent::a")
	private static WebElement Teacher_Received_List;
	@FindBy (xpath="//span[text()='Teacher Approved List']// parent::a")
	private static WebElement Teacher_Approved_List;
	@FindBy (xpath="//td[@class='sorting_1' and text()=1]// following :: td[2]")
	private static WebElement Received_Teacher;

	// received list 
	@FindBy (xpath="//td[@class='sorting_1' and text()=1]// following :: td[2]")
	private static WebElement Approved_Teacher;



	//Student tab
	@FindBy (xpath="//span[text()='Student']// parent::a")
	private static WebElement Student_Tab;
	@FindBy (xpath="//span[text()='Student Received List']// parent::a")
	private static WebElement Student_Received_List;
	@FindBy (xpath="//span[text()='Student Approved List']// parent::a")
	private static WebElement Student_Approved_List;
	@FindBy (xpath="//td[@class='sorting_1' and text()=1]// following :: td[2]")
	private static WebElement Received_Student;

	// received list 
	@FindBy (xpath="//td[@class='sorting_1' and text()=1]// following :: td[2]")
	private static WebElement Approved_Student;


	//Notice
	@FindBy (xpath="//span[text()='Notice']// parent::a")
	private static WebElement Notice_Tab;

	// Main application from marketing site
	@FindBy (xpath = "//a[text()='Login']")
	private static WebElement Login_Application;
	@FindBy (xpath = "//a[@id='logout-btn']")
	private static WebElement Logout_Portal;
	@FindBy (xpath = "//span[@id='usernamehoverbtn']")
	private static WebElement Profile;
	@FindBy (xpath = "//a[@class=\"btn-logout\"]")
	private static WebElement LogOut_Pop_Button;


	//Common Accept and Reject  button 

	@FindBy (xpath="(//button[@type='button'and@class='btn btn-success btn-sm btn-circle succes-color-cross'])[1]")
	private static WebElement Accept_button;
	@FindBy (xpath="(//button[@type='button'and@class='btn btn-danger btn-sm btn-circle reject'])[1]")
	private static WebElement Reject_button;
	@FindBy (xpath="(//button[@class='yes-button accept'])[1]")
	private static WebElement Yes_button;
	

	// DoE banner

	@FindBy (xpath="//p[contains(text(),'Students Received')]//parent::div/h3")
	private static WebElement StudentReceivedNumber;
	@FindBy (xpath="//p[contains(text(),'Teacher Received')]//parent::div/h3")
	private static WebElement TeacherReceivedNumber;

	// Dashboard

	@FindBy (xpath="//span[text()='Dashboard']// parent::a")
	private static WebElement Dashboard;



	static int Intitial_Student_DashBoard_Number;
	static int Decrese__Student_DashBoard_Number;
	
	static int Intitial_Teacher_DashBoard_Number;
	static int Decrese__Teacher_DashBoard_Number;
	
	static int Intitial_Parent_DashBoard_Number;
	static int Decrese__Parent_DashBoard_Number;


	public DoEFunctionalityObject() {
		PageFactory.initElements(DriverManager.getDriverRef(),this);
	}





	public  void Parent_Received_List(Map <String, String> map) {

		Login_Application.click();
		Set<String> Window_handel1 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it1 =Window_handel1.iterator();
		String Parent_Window1 = it1.next();
		String Child_Window1 = it1.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window1);
		User_Name.sendKeys(map.get("DoE_Username"));
		Password.sendKeys(map.get("DoE_Password"));
		Login_Button.click();
		Parent_Tab.click();
		Parent_Received_List.click();
		String Added_parent = Received_Parent.getText();
		Assert.assertEquals(Added_parent, map.get("Email"));


	}

	public  void Teacher_Received_List(Map <String, String> map) {

		Login_Application.click();
		Set<String> Window_handel1 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it1 =Window_handel1.iterator();
		String Parent_Window1 = it1.next();
		String Child_Window1 = it1.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window1);
		User_Name.sendKeys(map.get("DoE_Username"));
		Password.sendKeys(map.get("DoE_Password"));
		Login_Button.click();
		Teacher_Tab.click();
		Teacher_Received_List.click();
		String Added_parent = Received_Teacher.getText();
		Assert.assertEquals(Added_parent, map.get("Email"));


	}


	public  void Student_Received_List(Map <String, String> map) throws InterruptedException {

		Login_Application.click();
		Set<String> Window_handel1 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it1 =Window_handel1.iterator();
		String Parent_Window1 = it1.next();
		String Child_Window1 = it1.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window1);
		User_Name.sendKeys(map.get("DoE_Username"));
		Password.sendKeys(map.get("DoE_Password"));
		Login_Button.click();
		Student_Tab.click();
		Thread.sleep(2000);
		Student_Received_List.click();
		Thread.sleep(2000);
		String Added_parent = Received_Student.getText();
		Assert.assertEquals(Added_parent, map.get("Email"));


	}


	public  void Parent_Accept_Test(Map <String, String> map) throws InterruptedException {


		Login_Application.click();
		Set<String> Window_handel1 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it1 =Window_handel1.iterator();
		String Parent_Window1 = it1.next();
		String Child_Window1 = it1.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window1);
		User_Name.sendKeys(map.get("DoE_Username"));
		Password.sendKeys(map.get("DoE_Password"));
		Login_Button.click();
		String NumberS = ParentReceivedNumber.getText();
		Intitial_Parent_DashBoard_Number = Integer.parseInt(NumberS);
		Decrese__Parent_DashBoard_Number= Intitial_Parent_DashBoard_Number-1;
		System.out.println("Before accept by DoE,  Parents number is:-  "+ Intitial_Parent_DashBoard_Number);
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
		User_Name.sendKeys(map.get("DoE_Username"));
		Password.sendKeys(map.get("DoE_Password"));
		Login_Button.click();
		Parent_Tab.click();
		Parent_Received_List.click();
		Thread.sleep(2000);
		Accept_button.click();
		Thread.sleep(2000);
		Yes_button.click();
		Thread.sleep(6000);
		Parent_Approved_List.click();
		Thread.sleep(6000);
		String approvedParent = Approved_Parent.getText();
		Assert.assertEquals(approvedParent, map.get("Email"));
		Dashboard.click();

		String Number_Decremented = ParentReceivedNumber.getText();
		int Decrese_Real_Parent_DashBoard_Number = Integer.parseInt(Number_Decremented);

		if(Decrese_Real_Parent_DashBoard_Number == Decrese__Parent_DashBoard_Number) {
			System.out.println("The parent is accepted, now the dashboard received list will decrese, the new parent number in the dashboard is  :-  " + Decrese_Real_Parent_DashBoard_Number);
		}else {
			Assert.fail("   The dashboard is not updated for the Parents  ");
		}

	}


	public  void Student_Accept_Test(Map <String, String> map) throws InterruptedException {


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
		Decrese__Student_DashBoard_Number= Intitial_Student_DashBoard_Number-1;
		System.out.println("Before accepted by DoE, the student number is:-  "+ Intitial_Student_DashBoard_Number);
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
		User_Name.sendKeys(map.get("DoE_Username"));
		Password.sendKeys(map.get("DoE_Password"));
		Login_Button.click();
		Student_Tab.click();
		Student_Received_List.click();
		Thread.sleep(2000);
		Accept_button.click();
		Thread.sleep(2000);
		Yes_button.click();
		Thread.sleep(6000);
		Student_Approved_List.click();
		Thread.sleep(6000);
		String approvedStudent = Approved_Student.getText();
		Assert.assertEquals(approvedStudent, map.get("Email"));
		Dashboard.click();

		String Number_Decremented = StudentReceivedNumber.getText();
		int Decrese_Real_Student_DashBoard_Number = Integer.parseInt(Number_Decremented);

		if(Decrese_Real_Student_DashBoard_Number == Decrese__Student_DashBoard_Number) {
			System.out.println("The Student is accepted, now the dashboard received list will decrese, the new Student number in the dashboard is :-  " + Decrese_Real_Student_DashBoard_Number);
		}else {
			Assert.fail("   The dashboard is not updated for the Student  ");
		}

	}
	
	public  void Teacher_Accept_Test(Map <String, String> map) throws InterruptedException {


		Login_Application.click();
		Set<String> Window_handel1 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it1 =Window_handel1.iterator();
		String Parent_Window1 = it1.next();
		String Child_Window1 = it1.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window1);
		User_Name.sendKeys(map.get("DoE_Username"));
		Password.sendKeys(map.get("DoE_Password"));
		Login_Button.click();
		String NumberS = TeacherReceivedNumber.getText();
		Intitial_Teacher_DashBoard_Number = Integer.parseInt(NumberS);
		Decrese__Teacher_DashBoard_Number= Intitial_Teacher_DashBoard_Number-1;
		System.out.println("Before Accept by DoE, the Teacher  number is:-  "+ Intitial_Teacher_DashBoard_Number);
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
		User_Name.sendKeys(map.get("DoE_Username"));
		Password.sendKeys(map.get("DoE_Password"));
		Login_Button.click();
		Teacher_Tab.click();
		Teacher_Received_List.click();
		Thread.sleep(2000);
		Accept_button.click();
		Thread.sleep(2000);
		Yes_button.click();
		Thread.sleep(6000);
		Teacher_Approved_List.click();
		Thread.sleep(6000);
		String approvedTeacher = Approved_Teacher.getText();
		Assert.assertEquals(approvedTeacher, map.get("Email"));
		Dashboard.click();

		String Number_Incremented = TeacherReceivedNumber.getText();
		int Decrese_Real_Teacher_DashBoard_Number = Integer.parseInt(Number_Incremented);

		if(Decrese_Real_Teacher_DashBoard_Number == Decrese__Teacher_DashBoard_Number) {
			System.out.println("The Teacher is accepted, now the dashboard received list will decrese,  the new Teacher number in the dashboard is :-  " + Decrese_Real_Teacher_DashBoard_Number);
		}else {
			Assert.fail("   The dashboard is not updated for the Teacher  ");
		}

	}





}
