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

	static int Intitial_Parent_DashBoard_Number;
	static int Increse__Parent_DashBoard_Number;

	
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
	
	//Teacher Tab
	@FindBy (xpath="//span[text()='Teacher']// parent::a")
	private static WebElement Teacher_Tab;
	@FindBy (xpath="//span[text()='Teacher Received List']// parent::a")
	private static WebElement Teacher_Received_List;
	@FindBy (xpath="//span[text()='Teacher Approved List']// parent::a")
	private static WebElement Teacher_Approved_List;
	@FindBy (xpath="//td[@class='sorting_1' and text()=1]// following :: td[2]")
	private static WebElement Received_Teacher;
	
	//Student tab
	@FindBy (xpath="//span[text()='Student']// parent::a")
	private static WebElement Student_Tab;
	@FindBy (xpath="//span[text()='Student Received List']// parent::a")
	private static WebElement Student_Received_List;
	@FindBy (xpath="//span[text()='Student Approved List']// parent::a")
	private static WebElement Student_Approved_List;
	
	//Notice
	@FindBy (xpath="//span[text()='Notice']// parent::a")
	private static WebElement Notice_Tab;
	
	// Main application from marketing site
	@FindBy (xpath = "//a[text()='Login']")
	private static WebElement Login_Application;
	
	
	

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
	



}
