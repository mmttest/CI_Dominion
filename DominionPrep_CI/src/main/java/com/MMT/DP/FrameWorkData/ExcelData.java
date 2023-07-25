package com.MMT.DP.FrameWorkData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.MMT.DP.FrameWorkConstant.Paths;

public class ExcelData {
	
	public static  Object[] Data(String Sheet_Name) throws IOException  {

		FileInputStream Excelfile = null;
		try {
			Excelfile = new FileInputStream(Paths.getExcelpath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook(Excelfile);

		XSSFSheet sheet = workBook.getSheet(Sheet_Name);
		Object[] data = new Object[sheet.getLastRowNum()];
		Map<Object,Object> map;

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			map = new HashMap<>();
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				map.put(sheet.getRow(0).getCell(k).toString(), sheet.getRow(i+1).getCell(k).toString());
				data[i] = map;
				
			}

		}
		return data;
	}


}
