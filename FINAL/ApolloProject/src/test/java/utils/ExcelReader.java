
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	
	public static Object[][] readDataFromExcelFile() throws IOException {
		
		String excelFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\data.xlsx";
		File excelFile = new File(excelFilePath);
		FileInputStream fis = new FileInputStream(excelFile);
		
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Sheet1");
		
		int rows = sheet.getLastRowNum(); 
		int c=0;
		
		Object[][] obj = new Object[rows][c+1];
		for (int r=1;r<=rows;r++)
		{
			obj[r-1][c]= getCellData(c,r);
		}
		
		return obj;
		
	}
	
	public static String getCellData(int colNum,int rowNum) {
							
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			

			return cell.getStringCellValue();
				 		
	}

}