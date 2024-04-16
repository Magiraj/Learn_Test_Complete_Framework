package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataExcelProvider {

	public String[][] dataExcelValue() throws IOException {
		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\HP\\Desktop\\Login.xlsx");
		XSSFSheet sheet = book.getSheet("Sheet1");
		int row = sheet.getPhysicalNumberOfRows();
		int cell = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data=new String[row][cell];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i][j]=stringCellValue;
			}
		}
		book.close();
		return data;
	}
	
}
