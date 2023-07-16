package com.MMT.DP.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MMT.DP.DriverManegment.DriverManager;

public class DoEFunctionalityObject {

	static int Intitial_Parent_DashBoard_Number;
	static int Increse__Parent_DashBoard_Number;

	@FindBy (xpath="//span[text()='Parents']//parent::a")
	private static WebElement ParentTab;
	@FindBy (xpath="//span[text()='Parent Received List']//parent::a")
	private static WebElement ParentReceivedList;
	@FindBy (xpath="//span[text()='Parent Approved List']//parent::a")
	private static WebElement ParentApproveList;
	@FindBy (xpath="//p[contains(text(),'Parents Received')]//parent::div/h3")
	private static WebElement ParentReceivedNumber;

	public DoEFunctionalityObject() {
		PageFactory.initElements(DriverManager.getDriverRef(),this);
	}

	public void DoE_DashBoard() {
		String NumberS = ParentReceivedNumber.getText();
		Intitial_Parent_DashBoard_Number = Integer.parseInt(NumberS);
		Increse__Parent_DashBoard_Number= Intitial_Parent_DashBoard_Number+1;
		System.out.println("The number is:- "+ Intitial_Parent_DashBoard_Number);

	}

	public void DoE_DashBoard_ParentReceivedNumber() {
		String NumberS = ParentReceivedNumber.getText();
		int Increse_Real_Parent_DashBoard_Number = Integer.parseInt(NumberS);

		if(Increse_Real_Parent_DashBoard_Number != Increse__Parent_DashBoard_Number) {
			System.out.println("TestDone");
		}else {
			Assert.fail("The dashboard is not updated");
		}


	}



}
