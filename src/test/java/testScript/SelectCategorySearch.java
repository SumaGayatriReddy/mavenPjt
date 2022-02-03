package testScript;

import org.testng.annotations.Test;

import configuration.ActionKeywords;
import utilities.ExcelUtility;

public class SelectCategorySearch {
	static String sPath;
	@Test
	public void SelectCategory() throws Exception{
		sPath = System.getProperty("user.dir")+"\\src\\test\\resources\\searchCategory.xlsx";
		System.out.println(System.getProperty("user.dir"));
		ExcelUtility.setExcelFile(sPath, "searchProduct");
		ActionKeywords.openBrowser();
		ActionKeywords.navigate();
		for (int iRow=8;iRow<10;iRow++)
				{
					int iCell=1;
					ActionKeywords.navigate();
					String selectCategory = ExcelUtility.getCellData(iRow,0);
					System.out.println(selectCategory);			
					ActionKeywords.selectCategory(selectCategory);
					String searchKeyword = ExcelUtility.getCellData(iRow,iCell);
					System.out.println(searchKeyword);	
					ActionKeywords.searchFunc(searchKeyword);
					ActionKeywords.clickSearchBtn();
					ActionKeywords.waitFor();
					ActionKeywords.verifyTitle(searchKeyword);
				}
		ActionKeywords.navigateBack();
		ActionKeywords.closeBrowser();
	}

}
