package filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelFile {
	private static final Logger LOG = Logger.getLogger(ReadExcelFile.class);

	@DataProvider(name = "LoginData")
	public static Object[][] excelReader() {
		Object[][] obj = null ;
		String path = System.getProperty("user.dir");
		FileInputStream fs = null ;
		try {
			//fs= new FileInputStream("TestData\\amazonTestData.xlsx");
			fs = new FileInputStream(path+"\\src\\main\\resources\\LoginCredential.xlsx");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook book = null;
		try {
			book = new XSSFWorkbook(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = book.getSheet("teststeps");
		int lastrow = sheet.getLastRowNum();
		obj = new Object[lastrow][2];
		for (int i = 1; i <= lastrow; i++) {
			Row row = sheet.getRow(i);
			int lastcell = row.getLastCellNum();
			for (int j = 1; j < lastcell; j++) {
				Cell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case STRING:
					//System.out.print(cell.getStringCellValue() + "\t");
					obj[i-1][j-1] = cell.getStringCellValue();
					break;
				case NUMERIC:
					//System.out.print(cell.getNumericCellValue() + "\t");
					obj[i-1][j-1] = cell.getNumericCellValue();
					break;
				case BLANK:
					//System.out.print(" " + "\t");
					obj[i-1][j-1] = " ";
					break;
				case FORMULA:
					//System.out.print(cell.getCellFormula());
					obj[i-1][j-1] = cell.getCellFormula();
					break;
				case _NONE:
					//System.out.print("none" + "\t");
					obj[i-1][j-1] = " ";
					break;
				case BOOLEAN:
					//System.out.print(cell.getBooleanCellValue() + "\t");
					obj[i-1][j-1] = cell.getBooleanCellValue();
					
					break;
				/*case ERROR:
					System.out.print(cell.getErrorCellValue() + "\t");
					break;*/
				default:
					System.out.println("Invalid Data");
				}

			}
			System.out.println();
		}
	
		return obj;
	}
}