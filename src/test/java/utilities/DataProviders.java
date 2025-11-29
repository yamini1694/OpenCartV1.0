package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="logindata")
	public String[][] getData() throws IOException
	{
		ExcelUtility xlutil= new ExcelUtility(System.getProperty("user.dir")+"//testdata//LoginTestData.xlsx");
		
		int totalRow= xlutil.getRowCount("Sheet1");
		int totalCol=xlutil.getCellCount("Sheet1", totalRow);
		
		String[][] data= new String[totalRow][totalCol];
		
		for(int i=1;i<=totalRow;i++)
		{
			for(int j=0;j<totalCol;j++)
			{
				data[i-1][j]= xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return data;
	}

}
