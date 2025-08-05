package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name = "LoginData")
	
	public String[][] getLoginData() throws Exception {

			String path = System.getProperty("user.dir") + "/testData/LoginData.xlsx";
			ExcelUtility excel = new ExcelUtility(path);// Initialize the ExcelUtility with the path to the Excel file
			
			// Get the row and column count from the Excel sheet
			int rowCount = excel.getRowCount("Sheet1");
			int colCount = excel.getCellCount("Sheet1", 1);
			
			String[][] logindata = new String[rowCount][colCount];
			
			for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip header row
				for (int j = 0; j < colCount; j++) {
					logindata[i - 1][j] = excel.getCellData("Sheet1", i, j); // Fill the data into the array
				}
			}
			
			return logindata;	// Return the 2D array containing login data
		}

}
