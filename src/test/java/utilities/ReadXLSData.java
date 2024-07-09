package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXLSData
{

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		ReadXLSData read = new ReadXLSData();
		read.getData("login");
	}

	public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException
	{
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetname = wb.getSheet(excelSheetName);

		int totalRows = sheetname.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetname.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);

		DataFormatter format = new DataFormatter(); // format the data which is picking up from the sheet and store it
													// in either string or object and pass it

		String testData[][] = new String[totalRows][totalCols];
		for (int i = 1; i <= totalRows; i++)
		{
			for (int j = 0; j < totalCols; j++) // here totalCols return 2 thats why j<totalCols
			{
				testData[i - 1][j] = format.formatCellValue(sheetname.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);
			}
		}

		return testData;
	}
}
