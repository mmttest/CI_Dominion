package com.MMT.DP.PageObject;

import static org.testng.Assert.assertEquals;

import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MMT.DP.DriverManegment.DriverManager;

public class LoginPageObject {


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


	//DoE Login Assert
	@FindBy( xpath = "//span[@id='usernamehoverbtn']" )
	private static WebElement User_Button;
	@FindBy( xpath = "//div[@class='col-xs-4 text-center']" )
	private static WebElement Profile;
	@FindBy( xpath = "//p[text()='Doe']" )
	private static WebElement DOE;
	
	
	

	public LoginPageObject() {

		PageFactory.initElements(DriverManager.getDriverRef(),this);
	}


	public void DoE_Valid_Login(Map <String, String> map) {
		
		User_Name.sendKeys(map.get("Username"));
		Password.sendKeys(map.get("Password"));
		Login_Button.click();
		User_Button.click();
		Profile.click();
		boolean profile_name = DOE.isDisplayed();
		Assert.assertEquals(profile_name, true);

	}









}
