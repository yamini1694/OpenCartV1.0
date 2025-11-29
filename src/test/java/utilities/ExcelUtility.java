package utilities;

import java.io.*;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {
	
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook workbook;
	XSSFRow row;
	XSSFSheet sheet;
	XSSFCell cell;
	String filepath;
	
	public ExcelUtility(String filepath)
	{
		this.filepath=filepath;
	}
	public int getRowCount( String sheetname) throws IOException
	{
		fi= new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetname);
		int rowcount= sheet.getLastRowNum();
		
		workbook.close();
		fi.close();
		
		return rowcount;
		
	}
	
	public int getCellCount(String sheetname, int rownum) throws IOException
	{
		fi= new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetname);
		row= sheet.getRow(rownum);
		int cellcount= row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
		
	}
	
	public String getCellData(String sheetname, int rownum, int colnum) throws IOException
	{
		fi= new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetname);
		row= sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		String data= cell.toString();
		workbook.close();
		fi.close();
		return data;
		
	}
	
	public void setCellData( String sheetname, int rownum, int colnum, String data) throws IOException
	{
		File f= new File(filepath);
		
		if (!f.exists())
		{
			fo= new FileOutputStream(filepath);
			workbook= new XSSFWorkbook();
			workbook.write(fo);
		}
		
		
		fi= new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(sheetname)==-1)
		{
			workbook.createSheet(sheetname);
		}
		sheet= workbook.getSheet(sheetname);
		
		
		if(sheet.getRow(rownum) == null)
		{
			sheet.createRow(rownum);
		}
			row= sheet.getRow(rownum);
		
		row.createCell(colnum).setCellValue(data);
		
		fo=new FileOutputStream(filepath);
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
		
		
	}
	
	
	
	

}
