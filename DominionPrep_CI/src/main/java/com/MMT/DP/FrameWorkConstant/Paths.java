package com.MMT.DP.FrameWorkConstant;

public class Paths {


	private Paths() {

	}

	private static final String CONFIGFILEPATH = ".\\src\\main\\resources\\ConfigFile\\Config.properties";
	private static final String EXCELFILE = ".\\src\\main\\resources\\Excel\\DP_Data.xlsx";
	private static final String DEMO_PARENT_PROFILE_IMAGE = ".\\src\\main\\resources\\DemoImages\\Parent_Profile_Image.jpg";
	private static final String DEMO_TEACHER_PROFILE_IMAGE = ".\\src\\main\\resources\\DemoImages\\Parent_Profile_Image.jpg";
	private static final String DEMO_EDUCATION_LICENSES_FILE= ".\\src\\main\\resources\\Demo_Files\\Demo_Educational_Licenses.pdf";
    private static final String DEMO_PDF = ".\\src\\main\\resources\\Demo_Files\\Demo_PDF_Test.pdf";
    private static final String DEMO_STUDENT_PROFILE_IMAGE = ".\\src\\main\\resources\\DemoImages\\Student_Demo_Image.jpg";
	public static String getDemoPdf() {
		return DEMO_PDF;
	}
	public static String getConfigpath() {
		return CONFIGFILEPATH;
	}
	public static String getDemoStudentProfileImage() {
		return DEMO_STUDENT_PROFILE_IMAGE;
	}
	public static String getExcelpath() {
		return EXCELFILE;
	}

	public static String getDemo_PARENT_PROFILE_Image() {
		return DEMO_PARENT_PROFILE_IMAGE;
	}

	public static String getDemo_TEACHER_PROFILE_Image() {
		return DEMO_TEACHER_PROFILE_IMAGE;
	}

	public static String getDemo_EDUCATION_LICENSES_FILE() {
		return DEMO_EDUCATION_LICENSES_FILE;
	}
}
