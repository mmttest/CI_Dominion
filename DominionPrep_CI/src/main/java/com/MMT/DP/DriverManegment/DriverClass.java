package com.MMT.DP.DriverManegment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.MMT.DP.Configaration.ConfigFileClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass {

	public static void Initialization(String URL) throws Throwable {

		if (DriverManager.getDriverRef() == null) {

			System.out.println(Thread.currentThread().getId());
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			DriverManager.setDriverRef(driver);
			DriverManager.getDriverRef().get(ConfigFileClass.setProperty(URL));
			DriverManager.getDriverRef().manage().window().maximize();
			DriverManager.getDriverRef().manage().deleteAllCookies();
			DriverManager.getDriverRef().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			DriverManager.getDriverRef().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


		}

	}

	public static void TearDownMethod() {
		DriverManager.getDriverRef().quit();
		DriverManager.DriverUnload();
	}


}
