package testScript;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFile {

	public static void main(String[] args) throws Exception {
		
		InputStream inp = new FileInputStream("C:\\training\\PrjtMaven\\src\\test\\resources\\searchList.xlsx");
		Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        System.out.println("Excelfile Opened");
        for (int i =0;i<=4;i++)
        {
        Row row = sheet.getRow(i);
        Cell cell = row.getCell(0);
        System.out.println(cell);

		}

}
}