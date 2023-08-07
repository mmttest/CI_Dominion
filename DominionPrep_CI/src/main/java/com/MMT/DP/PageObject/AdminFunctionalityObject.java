package com.MMT.DP.PageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MMT.DP.DriverManegment.DriverManager;

public class AdminFunctionalityObject {


;

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


	// Banners

	@FindBy( xpath = "//p[contains(text(),'Students')]" )
	private static WebElement Student_banner;
	@FindBy( xpath = "//p[contains(text(),'Parents')]" )
	private static WebElement Parents_banner;
	@FindBy( xpath = "//p[contains(text(),'Teachers')]" )
	private static WebElement Teacher_banner;
	@FindBy( xpath = "//p[contains(text(),'Payment History')]" )
	private static WebElement Payment_History_banner;
	@FindBy( xpath = "//h3[contains(text(),'Ongoing')]" )
	private static WebElement Ongoing_banner;
	@FindBy( xpath = "//p[contains(text(),'Notice')]" )
	private static WebElement Notice_banner;

	// Student tile in dashboard
	@FindBy (xpath="//p[contains(text(),'Students')]//parent::div/h3")
	private static WebElement StudentReceivedNumber;
	@FindBy (xpath="//ul[@class='pagination']/li[@class='paginate_button ']/a")
	private static WebElement Student_table_Pagination;


	// Teacher tile in dashboard
	@FindBy (xpath="//p[contains(text(),'Teachers')]//parent::div/h3")
	private static WebElement TeacherReceivedNumber;

	// Parents tile in dashboard
	@FindBy (xpath="//p[contains(text(),'Parents')]//parent::div/h3")
	private static WebElement ParentReceivedNumber;
	@FindBy (xpath="//p[contains(text(),'Notice')]//parent::div/h3")
	private static WebElement NoticeReceivedNumber;

	// tabs

	@FindBy (xpath="//span[text()='Students']// parent::a")
	private static WebElement Student_Tab;
	@FindBy (xpath="//span[text()='Teachers']// parent::a")
	private static WebElement Teacher_Tab;
	@FindBy (xpath="//span[text()='Parents']// parent::a")
	private static WebElement Parent_Tab;
	@FindBy (xpath="//span[text()='Dashboard']// parent::a")
	private static WebElement Dashboard_Tab;


	// Marketing site login
	@FindBy (xpath = "//a[text()='Login']")
	private static WebElement Login_Application;





	static int Student_DashBoard_Number;
	static int Student_Last_SL_No;
	static int Teacher_DashBoard_Number;
	static int Teacher_Last_SL_No;
	static int Parent_DashBoard_Number;
	static int Parent_Last_SL_No;


	public AdminFunctionalityObject() {

		PageFactory.initElements(DriverManager.getDriverRef(),this);
	}

	public void Admin_Validate_Dashboard(Map <String, String> map) {

		Login_Application.click();
		Set<String> Window_handel1 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it1 =Window_handel1.iterator();
		String Parent_Window1 = it1.next();
		String Child_Window1 = it1.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window1);
		User_Name.sendKeys(map.get("Username"));
		Password.sendKeys(map.get("Password"));
		Login_Button.click();
		boolean StudentTabPresent = Student_banner.isDisplayed();
		Assert.assertEquals(StudentTabPresent, true);
		boolean ParentsTabPresent = Parents_banner.isDisplayed();
		Assert.assertEquals(ParentsTabPresent, true);
		boolean TeacherTabPresent = Teacher_banner.isDisplayed();
		Assert.assertEquals(TeacherTabPresent, true);
		boolean OngoingTabPresent = Ongoing_banner.isDisplayed();
		Assert.assertEquals(OngoingTabPresent, true);
		boolean Payment_HistoryTabPresent = Payment_History_banner.isDisplayed();
		Assert.assertEquals(Payment_HistoryTabPresent, true);
		boolean NoticeTabPresent = Notice_banner.isDisplayed();
		Assert.assertEquals(NoticeTabPresent, true);

		Student_Tab.click();
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriverRef();
		js.executeScript("window.scrollBy(0,500)", "");
		List<WebElement> Student_List = DriverManager.getDriverRef().findElements(By.xpath("//ul[@class='pagination']/li[@class='paginate_button ']/a"));
		Student_List.get(Student_List.size()-1).click();
		js.executeScript("window.scrollBy(0,500)", "");
		List<WebElement> Student_Sl_No = DriverManager.getDriverRef().findElements(By.xpath("//table[@id='parentstudentListing']/tbody/tr/td[1]"));
		String StudentSL_No = Student_Sl_No.get(Student_Sl_No.size()-1).getText();
		System.out.println("The students is present in the table is :-  " +StudentSL_No);

		Student_Last_SL_No = Integer.parseInt(StudentSL_No);
		Dashboard_Tab.click();
		String Total_Student = StudentReceivedNumber.getText();
		Student_DashBoard_Number = Integer.parseInt(Total_Student);
		System.out.println("The student is present in the Dashboard is :-  " +Student_DashBoard_Number);
		if (Student_Last_SL_No ==Student_DashBoard_Number) {
			System.out.println("The dashboard number is same as the total number of student");
		} else {
			Assert.fail("The dashboard is not updated for the Student in Admin dashboard ");
		}


		Parent_Tab.click();
		js.executeScript("window.scrollBy(0,500)", "");
		List<WebElement> Parent_List = DriverManager.getDriverRef().findElements(By.xpath("//ul[@class='pagination']/li[@class='paginate_button ']/a"));
		Parent_List.get(Parent_List.size()-1).click();
		js.executeScript("window.scrollBy(0,500)", "");
		List<WebElement>Parent_Sl_No = DriverManager.getDriverRef().findElements(By.xpath("//table[@id='parentListing']/tbody/tr/td[1]"));
		System.out.println(Parent_Sl_No.size());
		String ParentSL_No = Parent_Sl_No.get(Parent_Sl_No.size()-1).getText();
		System.out.println("The parents is present in the table is :-  " +ParentSL_No);
		Parent_Last_SL_No = Integer.parseInt(ParentSL_No);
		Dashboard_Tab.click();
		String Total_Parent = ParentReceivedNumber.getText();
		Parent_DashBoard_Number = Integer.parseInt(Total_Parent);
		System.out.println("The parents is present in the Dashboard is :-  " +Parent_DashBoard_Number);
		if (Parent_Last_SL_No ==Parent_DashBoard_Number) {
			System.out.println("The dashboard number is same as the total number of Parent");
		} else {
			Assert.fail("The dashboard is not updated for the Parent in Admin dashboard ");
		}
		
		Teacher_Tab.click();
		js.executeScript("window.scrollBy(0,500)", "");
		List<WebElement> Teacher_List = DriverManager.getDriverRef().findElements(By.xpath("//ul[@class='pagination']/li[@class='paginate_button ']/a"));
		Teacher_List.get(Teacher_List.size()-1).click();
		js.executeScript("window.scrollBy(0,500)", "");
		List<WebElement>Teacher_Sl_No = DriverManager.getDriverRef().findElements(By.xpath("//table[@id='teacherListing']/tbody/tr/td[1]"));
		System.out.println(Teacher_Sl_No.size());
		String TeacherSL_No = Teacher_Sl_No.get(Teacher_Sl_No.size()-1).getText();
		System.out.println("The teachers is present in the table is :-  " +TeacherSL_No);
		Teacher_Last_SL_No = Integer.parseInt(TeacherSL_No);
		Dashboard_Tab.click();
		String Total_Teacher = TeacherReceivedNumber.getText();
		Teacher_DashBoard_Number = Integer.parseInt(Total_Teacher);
		System.out.println("The teachers is present in the table is :-  " +Teacher_DashBoard_Number);
		if (Teacher_Last_SL_No ==Teacher_DashBoard_Number) {
			System.out.println("The dashboard number is same as the total number of Teacher");
		} else {
			Assert.fail("The dashboard is not updated for the Teacher in Admin dashboard ");
		}




	}








}
