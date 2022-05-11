package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @author Madhusudana
 *
 */

public class ExceellUtility  {
	
		/**
		 *  its used read the data from excel base don below arguments 
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @return Data
		 * @throws Throwable
		 */
	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/organi1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
     */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/organi1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/organi1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel =  row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/organi1.xlsx");
		wb.write(fos);
		wb.close();
		
	}


//This method is used to create and read data from dataprovider
/**
 * This method is used to read data from excel sheet and provide that data to dataprovider
 * @param sheetName
 * @return
 * @throws Throwable
 */
public Object[][] readDataForDataProvider(String sheetName) throws Throwable
{
	//Step 1:
	FileInputStream fis = new FileInputStream(IConstants.Excellpath );
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetName);
	int lastRow = sheet.getLastRowNum();
	int lastCell = sheet.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[lastRow][lastCell];
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	
	return data;
	
}

}

	

