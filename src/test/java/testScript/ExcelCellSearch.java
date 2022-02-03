package testScript;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelCellSearch {

	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("C:\\training\\PrjtMaven\\src\\test\\resources\\searchCellList.xlsx");
		Workbook wb = WorkbookFactory.create(in);
        Sheet sheet = wb.getSheetAt(0);
        System.out.println("Excelfile Opened");
        for (int i =0;i<=5;i++)
        {
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(i);
        System.out.println(cell);

		}
	}
}
