package com.MMT.DP.PageObject;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.MMT.DP.DriverManegment.DriverManager;
import com.MMT.DP.FrameWorkConstant.Paths;

public class TeacherFormObject {


	@FindBy (xpath = "//*[@id=\"BtnBrowseHidden\"]")
	private static WebElement UploadImage;
	@FindBy (xpath = "//input[@placeholder='Enter First Name']")
	private static WebElement FirstName;
	@FindBy (xpath = "//input[@placeholder='Enter Middle Name']")
	private static WebElement MiddleName;
	@FindBy (xpath = "//input[@placeholder='Enter Last Name']")
	private static WebElement LastName ;
	@FindBy (xpath = "//*[@id=\"s2id_sex\"]/a")
	private static WebElement GenderList ;
	@FindBy (xpath = "//div[text()='Male']")
	private static WebElement GenderSelect;
	@FindBy (xpath = "//input[@placeholder='Enter Your Email']")
	private static WebElement Email;
	@FindBy (xpath = "//span[text()='Select Passport country']")
	private static WebElement Passport_CountyList ;
	@FindBy(xpath = "//div[text()='Select Passport country']// ancestor:: div//child::input[@class='select2-input']")
	private static WebElement Passport_Country_Search;
	@FindBy (xpath = "//div[text()='United States']")
	private static WebElement PassportCountry ;
	@FindBy (xpath = "//input[@id='passport_card_number']")
	private static WebElement Passport_Card_Number ;
	@FindBy (xpath = "//input[@id='teacher_primary_number']")
	private static WebElement Primary_Number ;
	@FindBy (xpath = "//input[@value='yes' and @name='drivingLicenceNumber']")
	private static WebElement DrivingLicense_If_Yes ;
	@FindBy (xpath = "//input[@id='driving_licence_number']")
	private static WebElement DrivingLicense_Number ;
	@FindBy (xpath = "//input[@id='teacher_house_number']")
	private static WebElement Home_Number ;
	@FindBy (xpath = "//input[@id='teacher_street_name_number']")
	private static WebElement Street_Name_OR_Number;
	@FindBy (xpath = "//input[@id='teacher_landmark']")
	private static WebElement Home_Landmark;
	@FindBy (xpath = "//div[@id='s2id_teacher_state']//child::span[text()='Select State']")
	private static WebElement Home_State;
	@FindBy (xpath = "//div[text()='Alaska']")
	private static WebElement Home_State_Select;
	@FindBy (xpath = "//div[@id='s2id_teacher_city']//child::span[text()='Select city']")
	private static WebElement Home_City;
	@FindBy (xpath = "//div[text()='Akutan']")
	private static WebElement Home_City_Select;
	@FindBy (xpath = "//input[@id='teacher_zipcode']")
	private static WebElement Home_ZipCode;
	@FindBy (xpath = "//input[@id='office_name']")
	private static WebElement Office_Name;
	@FindBy (xpath = "//input[@id='office_building_name']")
	private static WebElement Office_Building_Name;
	@FindBy (xpath = "//input[@id='office_building_number']")
	private static WebElement Office_Building_Number;
	@FindBy (xpath = "//input[@id='office_street_name_number']")
	private static WebElement Office_Street_Number_OR_name;
	@FindBy (xpath = "//input[@id='office_landmark']")
	private static WebElement Office_Landmark;
	@FindBy (xpath = "//div[@id='s2id_office_state']//child::span[text()='Select State']")
	private static WebElement Office_State;
	@FindBy (xpath = "//div[text()='Alaska']")
	private static WebElement Office_State_Select;
	@FindBy (xpath = "//div[@id='s2id_office_city']//child::span[text()='Select city']")
	private static WebElement Office_City;
	@FindBy (xpath = "//div[text()='Akutan']")
	private static WebElement Office_City_Select;
	@FindBy (xpath = "//input[@id='office_zipcode']")
	private static WebElement Office_ZipCode;
	@FindBy (xpath = "//input[@id='office_primary_number']")
	private static WebElement Office_Primary_Number;
	@FindBy (xpath = "//input[@id='office_secondry_number']")
	private static WebElement Office_Secondary_Number;
	@FindBy (xpath = "//input[@id='education_school']")
	private static WebElement Primary_School_Name;
	@FindBy (xpath = "//input[@id='education_degree']")
	private static WebElement Primary_School_Degree;
	@FindBy (xpath = "//input[@id='education_year_of_passing']")
	private static WebElement Primary_Calander_Passing;
	@FindBy (xpath = "//div[@class='datepicker-days']//th[@class='today' and text()='Today']")
	private static WebElement Primary_Date_Passing;
	@FindBy (xpath = "//input[@id='edu_exp_school']")
	private static WebElement Education_Teaching_Expirence_School;
	@FindBy (xpath = "//input[@id='edu_exp_degree']")
	private static WebElement Education_Teaching_Degree;
	@FindBy (xpath = "//input[@id='edu_exp_year_of_passing']")
	private static WebElement ExtraEducation_Calander_Passing;
	@FindBy (xpath = "//div[@class='datepicker-days']//th[@class='today' and text()='Today']")
	private static WebElement Education_Date_Passing;
	@FindBy (xpath = "//input[@id='list_teaching_refrences']")
	private static WebElement List_Teaching_References;
	@FindBy (xpath = "//input[@name='educationalLicense' and @value = 'yes']")
	private static WebElement Educational_Licenses_CheckBox;
	@FindBy (xpath = "//input[@id='educational_license']")
	private static WebElement Educational_Licenses_File;
	@FindBy (xpath = "//input[@name='anlegalaltercationswer' and @value = 'yes']")
	private static WebElement Altercation_CheckBox;
	@FindBy (xpath = "//textarea[@id='legal_altercation']")
	private static WebElement Legal_Altercation_Textarea;
	@FindBy (xpath = "//input[@name='terms' and @type='checkbox']")
	private static WebElement TermCheckBox ;
	@FindBy (xpath = "//input[@type='submit']")
	private static WebElement Submit ;


	// marketing site

	@FindBy (xpath = "//a[text()='Apply ']")
	private static WebElement Apply ;
	@FindBy (xpath = "//a[text()='Teacher Application']")
	private static WebElement Teacher_Application ;
	@FindBy (xpath = "//a[text()='Login']")
	private static WebElement Login_Application;

	// Main Application
	@FindBy( xpath = "//input[@placeholder='Enter your email or username']" )
	private static WebElement User_Name;
	@FindBy( xpath = "//input[@placeholder='Enter your password']" )
	private static WebElement Password;
	@FindBy( xpath = "//input[@type='submit']" )
	private static WebElement Login_Button;
	@FindBy (xpath="//p[contains(text(),'Teacher Received')]//parent::div/h3")
	private static WebElement ParentReceivedNumber;

	// After Login validation message
	@FindBy (xpath = "//p[text()='Teacher added successfully.']")
	private static WebElement Succesfull_message ;

	static int Intitial_Teacher_DashBoard_Number;
	static int Increse__Teacher_DashBoard_Number;


	public TeacherFormObject() {
		PageFactory.initElements(DriverManager.getDriverRef(), this);
	}


	public void TeacherFormSubmit(HashMap<String,String> map) throws InterruptedException {

		Login_Application.click();
		Set<String> Window_handel1 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it1 =Window_handel1.iterator();
		String Parent_Window1 = it1.next();
		String Child_Window1 = it1.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window1);
		User_Name.sendKeys("doe@gmail.com");
		Password.sendKeys("password@123");
		Login_Button.click();

		String NumberS = ParentReceivedNumber.getText();
		Intitial_Teacher_DashBoard_Number = Integer.parseInt(NumberS);
		Increse__Teacher_DashBoard_Number= Intitial_Teacher_DashBoard_Number+1;
		System.out.println("The number is:- "+ Intitial_Teacher_DashBoard_Number);
		DriverManager.getDriverRef().close();

		DriverManager.getDriverRef().switchTo().window(Parent_Window1);


		Apply.click();
		Teacher_Application.click();
		Set<String> Window_handel2 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it2 =Window_handel2.iterator();
		String Parent_Window2 = it2.next();
		String Child_Window2 = it2.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window2);
		File file = new File(new File(Paths.getDemo_TEACHER_PROFILE_Image()).getAbsolutePath());		
		UploadImage.sendKeys(file.toString());
		FirstName.sendKeys(map.get("FirstName"));
		LastName.sendKeys(map.get("LastName"));
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriverRef();
		js.executeScript("window.scrollBy(0,300)", "");
		GenderList.click();
		GenderSelect.click();
		Email.sendKeys(map.get("Email"));
		Passport_CountyList.click();
		Thread.sleep(2000);
		PassportCountry.click();
		Passport_Card_Number.sendKeys("0987654321");
		Primary_Number.sendKeys("1234567890");
		DrivingLicense_If_Yes.click();
		WebDriverWait wait1 = new WebDriverWait(DriverManager.getDriverRef(),Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfAllElements(DrivingLicense_Number));
		DrivingLicense_Number.sendKeys("0987654321");
		js.executeScript("window.scrollBy(0,400)", "");
		Home_Number.sendKeys("0987654321");
		Street_Name_OR_Number.sendKeys("7876098765");
		Home_Landmark.sendKeys("TestABC");
		Home_State.click();
		Home_State_Select.click();
		Thread.sleep(2000);
		Home_City.click();
		Home_City_Select.click();
		Home_ZipCode.sendKeys("98765");
		js.executeScript("window.scrollBy(0,500)", "");
		Office_Name.sendKeys("Test_Office");
		Office_Building_Name.sendKeys("Test_Office_building_Name");
		Office_Street_Number_OR_name.sendKeys("Test_Office_Street_Number_OR_name");
		Office_Landmark.sendKeys("Test_Office_Landmark");
		Office_State.click();
		Office_State_Select.click();
		Thread.sleep(2000);
		Office_City.click();
		Office_City_Select.click();
		Office_ZipCode.sendKeys("98789");
		Office_Primary_Number.sendKeys("0987654321");
		Office_Secondary_Number.sendKeys("1234567890");
		js.executeScript("window.scrollBy(0,600)", "");
		Primary_School_Name.sendKeys("Test_Primary_School_Name");
		Primary_School_Degree.sendKeys("Test_Primary_School_Degree");
		Primary_Calander_Passing.click();
		Primary_Date_Passing.click();
		js.executeScript("window.scrollBy(0,650)", "");
		Education_Teaching_Expirence_School.sendKeys("Test_Education_Teaching_Expirence_School");
		Education_Teaching_Degree.sendKeys("Test_Education_Teaching_Degree");
		ExtraEducation_Calander_Passing.click();;
		Education_Date_Passing.click();
		Educational_Licenses_CheckBox.click();
		Thread.sleep(2000);
		File file2 = new File(new File(Paths.getDemo_EDUCATION_LICENSES_FILE()).getAbsolutePath());
		Educational_Licenses_File.sendKeys(file2.toString());
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Altercation_CheckBox.click();
		Legal_Altercation_Textarea.click();
		Legal_Altercation_Textarea.sendKeys("Test_ Legal_Altercation_Textarea_ Legal_Altercation_Textarea_ Legal_Altercation_Textarea");
		TermCheckBox.click();
		Submit.click();
		boolean SuccessfullMesssage = Succesfull_message.isDisplayed();
		Assert.assertEquals(SuccessfullMesssage, true);
		
		DriverManager.getDriverRef().close();
		DriverManager.getDriverRef().switchTo().window(Parent_Window2);

		Login_Application.click();
		Set<String> Window_handel3 = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it3 =Window_handel3.iterator();
		String Parent_Window3 = it3.next();
		String Child_Window3 = it3.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window3);

		//Thread.sleep(5000);
		//User_Name.sendKeys("doe@gmail.com");
		//Thread.sleep(2000);
		//Password.sendKeys("password@123");
		//Thread.sleep(500000);
		//Login_Button.click();



		String Number_Incremented = ParentReceivedNumber.getText();
		int Increse_Real_Parent_DashBoard_Number = Integer.parseInt(Number_Incremented);

		if(Increse_Real_Parent_DashBoard_Number == Increse__Teacher_DashBoard_Number) {
			System.out.println("TestDone" + Increse_Real_Parent_DashBoard_Number);
		}else {
			Assert.fail("The dashboard is not updated");
		} 

	}




}
