package com.MMT.DP.DriverManegment;
import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal <WebDriver> driverRef = new ThreadLocal<WebDriver> ();


	public static WebDriver getDriverRef() {
		return driverRef.get();
	}

	public static void setDriverRef(WebDriver driver) {
		driverRef.set(driver);
	}

	public static void DriverUnload () {
		driverRef.remove();
		
	}

}
