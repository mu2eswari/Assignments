package Week5.Day1.Classroom;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public String[][] excel(String file) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./data/"+file+".xlsx");
		
		XSSFSheet sh = wb.getSheet("Sheet1");
		
		int row = sh.getLastRowNum();
		
		int column = sh.getRow(0).getLastCellNum();
		
		String [][] data = new String[row][column];
		
		for (int i = 1; i <= row; i++) 
		{
		
			for(int j = 0; j < column; j++)
			{
				
				data[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue();
				
			}
			
			System.out.println("");
		}
		
		wb.close();
		return data;
	}



}
