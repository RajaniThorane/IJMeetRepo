package utilities;

import org.testng.annotations.DataProvider;

import filereader.ReadExcelFile;

public class Dataproviders {
	@DataProvider(name="LoginData")
	public Object[][] signInData() {
		Object[][] obj = ReadExcelFile.excelReader();
		return obj;
		// TODO Auto-generated method stub

	}
}
