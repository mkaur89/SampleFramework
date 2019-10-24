package com.edureka.common;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	static File file = null;
	static FileInputStream fin = null;
	static Workbook workBook = null;
	static Sheet sheet = null;

	public static String[][] fetchData(String filePath, String fileName, String sheetName)
	{
		try
		{
			file = new File(filePath + fileName); //specify file
			fin = new FileInputStream(file); //specify input stream to read from that file
			workBook = new XSSFWorkbook(fin); //specify type of file
			sheet = workBook.getSheet(sheetName); //Fetch the particular sheet

			int rowsCount = sheet.getLastRowNum() + 1;
			int colsCount = sheet.getRow(0).getLastCellNum(); 

			String[][] data = new String[rowsCount][colsCount];

			for(int indexRow = 0; indexRow<rowsCount; indexRow++)
			{
				Row row = sheet.getRow(indexRow);
				for(int indexCol = 0;indexCol<colsCount; indexCol++)
				{
					data[indexRow][indexCol] = row.getCell(indexCol).getStringCellValue();
				}
			}
			return data;

			/*
			 * for(Row row: sheet) { for(Cell cell: row) { cell.getStringCellValue(); } }
			 */		}
		catch(Exception e)
		{
			return null;
		}
		finally 
		{
			try 
			{
				workBook.close();
				workBook = null;
				sheet = null;
				fin.close();
				fin = null;
				file = null;
			}
			catch(Exception e) 
			{

			}

		}
	}
}
