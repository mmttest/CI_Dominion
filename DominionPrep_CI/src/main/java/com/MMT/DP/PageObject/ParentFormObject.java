package com.MMT.DP.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.MMT.DP.DriverManegment.DriverManager;
import com.MMT.DP.FrameWorkConstant.Paths;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentFormObject {



	// Parent Form Xpaths
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
	@FindBy (xpath = "//input[@id='home_primary_number']")
	private static WebElement Primary_Number ;
	@FindBy (xpath = "//input[@value='yes' and @name='drivingLicenceNumber']")
	private static WebElement DrivingLicense_If_Yes ;
	@FindBy (xpath = "//input[@id='driving_licence_number']")
	private static WebElement DrivingLicense_Number ;
	@FindBy (xpath = "//input[@id='home_house_number']")
	private static WebElement Home_Number ;
	@FindBy (xpath = "//input[@id='home_street_name_number']")
	private static WebElement Street_Name_OR_Number;
	@FindBy (xpath = "//input[@id='home_landmark']")
	private static WebElement Home_Landmark;
	@FindBy (xpath = "//div[@id='s2id_home_state']//child::span[text()='Select State']")
	private static WebElement Home_State;
	@FindBy (xpath = "//div[text()='Alaska']")
	private static WebElement Home_State_Select;
	@FindBy (xpath = "//div[@id='s2id_home_city']//child::span[text()='Select city']")
	private static WebElement Home_City;
	@FindBy (xpath = "//div[text()='Akutan']")
	private static WebElement Home_City_Select;
	@FindBy (xpath = "//input[@id='home_zipcode']")
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
	@FindBy (xpath = "//input[@id='extra_curriculum_school']")
	private static WebElement Extra_School_Name;
	@FindBy (xpath = "//input[@id='extra_curriculum_degree']")
	private static WebElement Extra_School_Degree;
	@FindBy (xpath = "//input[@id='extra_curriculum_year_of_passing']")
	private static WebElement ExtraEducation_Calander_Passing;
	@FindBy (xpath = "//div[@class='datepicker-days']//th[@class='today' and text()='Today']")
	private static WebElement ExtraEducation_Date_Passing;
	@FindBy (xpath = "//input[@value = 'yes' and @name = 'anlegalaltercationswer']")
	private static WebElement Legal_Altercation_CheckBox;
	@FindBy (xpath = "//textarea[@id='legal_altercation']")
	private static WebElement Legal_Altercation_Textarea;
	@FindBy (xpath = "//input[@name='terms' and @type='checkbox']")
	private static WebElement TermCheckBox ;
	@FindBy (xpath = "//input[@type='submit']")
	private static WebElement Submit ;

	// marketing site
	
	@FindBy (xpath = "//a[text()='Apply ']")
	private static WebElement Apply ;
	@FindBy (xpath = "//a[text()='Parent Application']")
	private static WebElement Parent_Application ;


	// After Login
	
	@FindBy (xpath = "//p[text()='Parent added successfully.']")
	private static WebElement Succesfull_message ;
	
	
	
	public ParentFormObject() {
		PageFactory.initElements(DriverManager.getDriverRef(), this);
	}


	public void ParentFormSubmit(HashMap<String,String> map) throws InterruptedException {
		
		Apply.click();
		Parent_Application.click();
		Set<String> Window_handel = DriverManager.getDriverRef().getWindowHandles();
		Iterator<String> it =Window_handel.iterator();
		String Parent_Window = it.next();
		String Child_Window = it.next();
		DriverManager.getDriverRef().switchTo().window(Child_Window);
		File file = new File(new File(Paths.getDemo_PARENT_PROFILE_Image()).getAbsolutePath());		
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
		Extra_School_Name.sendKeys("Test_Extra_School_Name");
		Extra_School_Degree.sendKeys("Test_Extra_School_Degree");
		ExtraEducation_Calander_Passing.click();
		ExtraEducation_Date_Passing.click();
		Legal_Altercation_CheckBox.click();
		Legal_Altercation_Textarea.click();
		Legal_Altercation_Textarea.sendKeys("Test_ Legal_Altercation_Textarea_ Legal_Altercation_Textarea_ Legal_Altercation_Textarea");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		TermCheckBox.click();
		//Submit.click();


	}




}
