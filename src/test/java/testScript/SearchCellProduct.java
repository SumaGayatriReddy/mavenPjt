package testScript;

import org.testng.annotations.Test;

import configuration.ActionKeywords;
import utilities.ExcelUtility;

public class SearchCellProduct {

		static String sPath;
		@Test
		public void search() throws Exception {
			sPath = System.getProperty("user.dir")+"\\src\\test\\resources\\searchCellList.xlsx";
			System.out.println(System.getProperty("user.dir"));
			ExcelUtility.setExcelFile(sPath, "searchProduct");
			ActionKeywords.openBrowser();
			ActionKeywords.navigate();
			for (int iCell=0;iCell<=5;iCell++)
			{
				String searchKeyword = ExcelUtility.getCellData(0,iCell);
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

