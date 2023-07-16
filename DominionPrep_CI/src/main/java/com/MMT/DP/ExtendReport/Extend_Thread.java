package com.MMT.DP.ExtendReport;

import com.aventstack.extentreports.ExtentTest;

public class Extend_Thread {
	
	
	private static ThreadLocal <ExtentTest> Extend_dr = new ThreadLocal<>();

	public static ExtentTest getExtend_dr() {
		return Extend_dr.get();
	}

	public static void  setExtend_dr(ExtentTest extend_dr) {
		Extend_dr.set(extend_dr);
	}
	
	public static void Extend_Unload() {
		Extend_dr.remove();
	}
	
	


}
