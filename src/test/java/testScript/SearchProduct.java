package testScript;

import configuration.ActionKeywords;
import utilities.ExcelUtility;


public class SearchProduct {
	static String sPath;
	public static void main(String[] args) throws Exception {
		sPath = System.getProperty("user.dir")+"\\src\\test\\resources\\searchList.xlsx";
		System.out.println(System.getProperty("user.dir"));
		ExcelUtility.setExcelFile(sPath, "searchProduct");
		ActionKeywords.openBrowser();
		ActionKeywords.navigate();
		for (int iRow=0;iRow<=4;iRow++)
		{
			String searchKeyword = ExcelUtility.getCellData(iRow, 0);
			System.out.println(searchKeyword);			
			ActionKeywords.searchFunc(searchKeyword);
			ActionKeywords.clickSearchBtn();
			ActionKeywords.waitFor();
			ActionKeywords.verifyTitle(searchKeyword);
			ActionKeywords.waitFor();
			ActionKeywords.navigateBack();
		}
		ActionKeywords.closeBrowser();
	}
	}



