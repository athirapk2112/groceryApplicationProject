package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;

	public static String getStringData(int row, int col,String Sheet) throws IOException
	{
		f = new FileInputStream("C:\\Users\\Athira PK\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\TestData\\TestData.xlsx");
		w = new XSSFWorkbook(f);
		s = w.getSheet(Sheet);
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}

	public static String getIntegerData(int row, int col,String Sheet) throws IOException
	{
		f = new FileInputStream("C:\\Users\\Athira PK\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\TestData\\TestData.xlsx");
		
		w = new XSSFWorkbook(f);
		s = w.getSheet(Sheet);
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(col);
		int g = (int) c.getNumericCellValue();
		return String.valueOf(g);
	}
}
