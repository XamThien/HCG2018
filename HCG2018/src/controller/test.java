package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class test {
	// mo file excel len va doc noi dung
	public static  String readFileExcel(String fileName) {
        Workbook workbook;
        
        String xx= null;
        try {
        	
            workbook = Workbook.getWorkbook(new File(fileName));
            
            Sheet sheet = workbook.getSheet(0);
            
            Cell cell = sheet.getCell(1, 1);
            xx = cell.getContents();
            
            workbook.close();
        } catch (BiffException e) {
        	return xx;
        } catch (IOException e) {
        	return xx;
        }
		return xx;
    }
    // tao moi file excel
    public static void writeNewFileExcel(String fileName,String link) {
        WritableWorkbook workbook;
        // create workbook
        try {
            workbook = Workbook.createWorkbook(new File(fileName));
 
            // create sheet
            WritableSheet sheet1 = workbook.createSheet("Link lưu file CSDL HCG2018", 0);
 
            sheet1.addCell(new Label(1, 1,link));
           
            // write file
            workbook.write();
 
            // close
            workbook.close();
        } catch (IOException e) {
            System.out.println("Không tìm thấy file");
        } catch (RowsExceededException e) {
        	System.out.println("Không tìm thấy file");
        } catch (WriteException e) {
        	System.out.println("Không tìm thấy file");
        }
       
    }
    // mo file excel va ghi de mot 
    public static void openAndWriteFileExcel(String fileName, int dongghi) {
        Workbook workbook;
        WritableWorkbook writeWorkbook;
        try {
            // open file
            workbook = Workbook.getWorkbook(new File(fileName));
            // create file copy of root file to write file
            writeWorkbook = Workbook.createWorkbook(new File(fileName),
                    workbook);
            
            
            
            // get sheet to write
            WritableSheet sheet1 = writeWorkbook.getSheet(0);

            int countrows = sheet1.getRows();
            int col = 2;
            int rowBegin = 1;
            // write data (formula)
            
            Cell cell = sheet1.getCell(col, dongghi);
            int curval= Integer.parseInt(cell.getContents())+1;
            
            for (int row = rowBegin; row < countrows; row++) {
                Formula f = new Formula(col, dongghi, Integer.toString(curval));
                sheet1.addCell(f);
            }
            writeWorkbook.write();
 
            // close
            writeWorkbook.close();
        } catch (IOException e) {
            System.out.println("File not found\n" + e.toString());
        } catch (RowsExceededException e) {
            System.out.println("File not found\n" + e.toString());
        } catch (WriteException e) {
            System.out.println("File not found\n" + e.toString());
        } catch (BiffException e) {
            System.out.println("File not found\n" + e.toString());
        }
        
    }
    // mo file excel va ghi them mot dong moi
    public static void openAndWriteContinusFileExcel(String fileName,String name) {
        Workbook workbook;
        WritableWorkbook writeWorkbook;
        try {
            // open file
            workbook = Workbook.getWorkbook(new File(fileName));
            // create file copy of root file to write file
            writeWorkbook = Workbook.createWorkbook(new File(fileName),
                    workbook);
 
            // get sheet to write
            WritableSheet sheet1 = writeWorkbook.getSheet(0);
            //int colcontinus = sheet1.getRows();
            int rowcontinus = sheet1.getRows();
            	sheet1.addCell(new Label(1, rowcontinus, name.toString()));
                sheet1.addCell(new Label(2, rowcontinus, String.valueOf("1")));
            System.out.println(rowcontinus);
            writeWorkbook.write();
 
            // close
            writeWorkbook.close();
        } catch (IOException e) {
            System.out.println("File not found\n" + e.toString());
        } catch (RowsExceededException e) {
            System.out.println("File not found\n" + e.toString());
        } catch (WriteException e) {
            System.out.println("File not found\n" + e.toString());
        } catch (BiffException e) {
            System.out.println("File not found\n" + e.toString());
        }
        
    }
    
    // kiểm tra tồn tại một file
    public static boolean checkFileExcel(String fileName) {
    	File file = new File(fileName);
        return file.exists();
    }
	public static void main(String[] args) {
		 
		test ts = new test();
		 
		 String fileName = ts.readFileExcel("G:\\Link.xls");
		 System.out.println(fileName);
	}
	
	
	

	

}
