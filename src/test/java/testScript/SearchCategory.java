package testScript;

import configuration.ActionKeywords;
import utilities.ExcelUtility;

public class SearchCategory {
	static String sPath;
	public static void main(String[] args) throws Exception {
		
			sPath = System.getProperty("user.dir")+"\\src\\test\\resources\\searchCategory.xlsx";
			System.out.println(System.getProperty("user.dir"));
			ExcelUtility.setExcelFile(sPath, "searchProduct");
			ActionKeywords.openBrowser();
			ActionKeywords.navigate();

			for (int iRow=1;iRow<6;iRow++)
			{
				int iCell=1;
				String selectCategory = ExcelUtility.getCellData(iRow,0);
				System.out.println(selectCategory);			
				ActionKeywords.selectCategory(selectCategory);
				String searchKeyword = ExcelUtility.getCellData(iRow,iCell);
				ActionKeywords.searchFunc(searchKeyword);
				ActionKeywords.clickSearchBtn();
				ActionKeywords.waitFor();
				ActionKeywords.verifyTitle(searchKeyword);
				ActionKeywords.navigateBack();
			}
			ActionKeywords.closeBrowser();
		}
		}

