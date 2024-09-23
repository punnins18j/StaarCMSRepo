package com.pabb.staarcms.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Poornima 
 * 
 * This class is used to store all the Generic methods related to Excel file handling
 */
public class ExcelUtility {
	
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Exception
	 * 
	 * This Method is used to get the data from Excel file
	 */
	public String getDataFromExcelFile(String sheetName, int row, int cell) throws Exception
	{
		FileInputStream fis = new FileInputStream("./Testdata/Testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Exception
	 * 
	 * This Method is used to set the data to the excel file
	 */
	public void setDataToExcelFile(String sheetName, int row, int cell,String data) throws Exception
	{
		FileInputStream fis = new FileInputStream("./Testdata/Testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell, CellType.STRING);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(data);
		
		FileOutputStream fout = new FileOutputStream("./Testdata/Testscript.xlsx");
		wb.write(fout);
		fout.close();
	}
	
	/**
	 * 
	 * @param sheetName
	 * @return
	 * @throws Exception
	 * 
	 * This Method is used to get the Last Row Number from the sheet
	 */
	public int getLastRowNum(String sheetName) throws Exception
	{
		FileInputStream fis = new FileInputStream("./Testdata/Testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
}
