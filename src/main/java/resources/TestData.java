package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	
	
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		
		ArrayList<String>al = new ArrayList<String>();
		
		String testDataPath = "C:\\Users\\Abhinay\\Desktop\\Abhi\\Cognizant 2020\\Smoke Testing - Ravi\\AuthenTeak_TestData.xlsx";
		//String testDataPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\AuthenTeak_TestData.xlsx";
		FileInputStream fis = new FileInputStream(testDataPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);//access the workbook
		
		int sheetCount = workbook.getNumberOfSheets();
		for(int i=0;i<sheetCount;i++)	
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);//access TestData sheet
				
				//identify Testcase Name column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();//sheet is collection of rows
				Row firstRow = rows.next();
				
				Iterator<Cell> cells = firstRow.cellIterator();//row is collection of cells
				int k=0;
				int column=0;
				while(cells.hasNext())
				{
					String cell = cells.next().getStringCellValue();
					if(cell.equalsIgnoreCase("Testcase Name"))//identified desired column
					{
						column=k;//column is identified for Testcase Name column
					}
					k++;
				}
				
				//scan each rows of column 0 until get CreateAccount test case
				
				while(rows.hasNext())
				{
					Row r= rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))//identified desired test case CreateAccount
					{
						//pull all the data of of the rows for CreateAccount test case
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext())
						{
							
							Cell c=cv.next();
							if(c.getCellTypeEnum()==CellType.STRING)
							{
								al.add(c.getStringCellValue());//data will be pulled here and store in arraylist
							}
							else
							{
								al.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
							
							
						}
					}
					
				}
				
				
			}
			
		}
		return al;
	}
}
