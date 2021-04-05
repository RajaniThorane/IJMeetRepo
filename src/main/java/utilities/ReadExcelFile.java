package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ReadExcelFile{
	private static final Logger LOG = Logger.getLogger(ReadExcelFile.class);

	
	@DataProvider(name = "LoginData")
	public Object[][] m1() throws IOException {
		Object[][] obj;
		FileInputStream fis = new FileInputStream("LoginCredential.xlsx");
		XSSFWorkbook wbk = new XSSFWorkbook(fis);
		Sheet s = wbk.getSheet("teststeps");
		obj = new Object[s.getLastRowNum()][2];
		int lastRow = s.getLastRowNum();
		for (int i = 1; i <= lastRow; i++) {
			Row row = s.getRow(i);
			int lastCell = row.getLastCellNum();

			for (int j = 1; j < lastCell; j++) {
				Cell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case STRING:
					obj[i - 1][j - 1] = cell.getStringCellValue();
					
					break;
				case NUMERIC:
					obj[i - 1][j - 1] = cell.getNumericCellValue();
				case BOOLEAN:
					obj[i - 1][j - 1] = cell.getBooleanCellValue();
				default:
					break;
				}

			}

		}

		return obj;
	}
}