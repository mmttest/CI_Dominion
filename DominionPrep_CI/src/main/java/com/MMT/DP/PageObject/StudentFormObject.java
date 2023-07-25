package com.MMT.DP.PageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MMT.DP.DriverManegment.DriverManager;
import com.MMT.DP.FrameWorkConstant.Paths;
import com.google.auto.common.Visibility;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.io.File;

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
	@FindBy (xpath="//input[@class='form-control image-preview-filename']")
	private static WebElement Photo_Field;
	@FindBy (xpath="(//input[@placeholder='Enter Percentile Scores for math'])[1]")
	private static WebElement State_Public_Percentile_Score;
	@FindBy (xpath="(//input[@placeholder='Enter Reading'])[1]")
	private static WebElement State_Public_Reading;
	
	
	
	
	public StudentFormObject() {
		PageFactory.initElements(DriverManager.getDriverRef(),this);
	}
	
	
	
	public  void StudentFormSubmit(Map <String, String> map) {
		
		Login_Application.click();
		Set<String> Window_handel1 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it1 =Window_handel1.iterator();
		String Parent_Window1 = it1.next();
		String Child_Window1 = it1.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window1);
		User_Name.sendKeys("parents@gmail.com");
		Password.sendKeys("password@123");
		Login_Button.click();
		Student_Tab.click();
		Student_Name.sendKeys(map.get("Name"));
		
		Actions AddChild_Action = new Actions(DriverManager.getDriverRef());
		AddChild_Action.moveToElement(Student_Add_Button).build().perform();
		Student_Add_Button.click();
		
		// If academic Year not selected By default
		
		//Select YearSelect = new Select(Year_Select);
		//YearSelect.selectByValue("Automation Testing");
		
		Select GenderSelect = new Select(Gender_Select);
		GenderSelect.selectByValue("Male");
		
		
		
		File file = new File(new File(Paths.getDemoPdf()).getAbsolutePath());		
		Photo_Field.sendKeys(file.toString());
		
	}
	
	
}
