package utilities;

import org.testng.annotations.DataProvider;

import filereader.ReadExcelFile;

public class Dataproviders {
	
	@DataProvider(name="LoginData")
	public Object[][] signInData() {
		Object[][] obj = ReadExcelFile.excelReader("\\src\\main\\resources\\LoginCredential.xlsx","teststeps");
		return obj;
		// TODO Auto-generated method stub
	}
	@DataProvider(name="jmeetData")
	public Object[][] joinMeteting() {
		Object[][] obj=ReadExcelFile.excelReader("\\src\\main\\resources\\join_meet_data.xlsx", "joinmeetdata");
		return obj;
		// TODO Auto-generated method stub

	}
}

