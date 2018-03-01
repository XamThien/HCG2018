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
	public static  int readFileExcel(String fileName) {
        Workbook workbook;
        
        int stt = -1;
        try {
        	// create workbook to open file
            workbook = Workbook.getWorkbook(new File(fileName));
            // trong 1 file excel co nhieu sheet, chỉ định rõ đọc sheet nào
            Sheet sheet = workbook.getSheet(0);
            // get number row and col contain data
            int rows = sheet.getRows();
            //int cols = sheet.getColumns();
 
            
//            for (int row = 1; row < rows; row++) {
//            		
//                    Cell cell = sheet.getCell(1, row);
//                    String name1 = cell.getContents();
//                    System.out.println(name1);
//                    
//            }
            // cell là một ô 
            Cell cell = sheet.getCell(1, 0);
            String xx = cell.getContents();
            System.out.println(xx);
//            String ck = "Một buổi chiều êm đềm quá, ";
//            if (xx.equals(ck))
//            { System.out.println(true);}
//            else
//            { System.out.println(false);}
//            
            // close
            workbook.close();
        } catch (BiffException e) {
        	return stt;
        } catch (IOException e) {
        	return stt;
        }
		return stt;
    }
    // tao moi file excel
    public static void writeNewFileExcel(String fileName,ArrayList<Detail> ten) {
        WritableWorkbook workbook;
        // create workbook
        try {
            workbook = Workbook.createWorkbook(new File(fileName));
 
            // create sheet
            WritableSheet sheet1 = workbook.createSheet("Thống kê", 0);
 
            // create Label and add to sheet
            //sheet1.addCell(new Label(3, 0, "DANH SÁCH SINH VIÊN TIÊU BIỂU"));
            Date dnow = new Date();
            SimpleDateFormat fttt = new SimpleDateFormat ("MM-yyyy");
    	    String month =  fttt.format(dnow);
            // row begin write data
            sheet1.addCell(new Label(1, 0, "Bản thống kê số lượt win trong tháng "+month));
            int rowBegin = 1;
            int colBegin = 1;
            
            for(Detail x : ten)
            {
            	if(x.getTt().equals("Ăn"))
            	{
            		String name = x.getName();
            		sheet1.addCell(new Label(colBegin, rowBegin, String.valueOf(name)));
                	sheet1.addCell(new Label(colBegin+1, rowBegin, String.valueOf(1)));
                	rowBegin++;
            	}
            }
           
            // write file
            workbook.write();
 
            // close
            workbook.close();
        } catch (IOException e) {
            System.out.println("Không tìm thấy file");
        } catch (RowsExceededException e) {
        	System.out.println("Không tìm thấy file");
        } catch (WriteException e) {
        	System.out.println("Không tìm thấy file");
        }
       
    }
    // mo file excel va ghi de mot ô
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
    
    // kiểm tra tồn tại của một file
    public static boolean checkFileExcel(String fileName) {
    	File file = new File(fileName);
        return file.exists();
    }
	public static void main(String[] args) {
		 
		//readFileExcel("G:\\nguyenvanquan7826.xls");
		
		openAndWriteContinusFileExcel("G:\\nguyenvanquan7826.xls", "Một buổi chiều êm đềm quá, lòng bỗng nhớ về một nơi xa, Hà nội bình yêu quá, nơi có những bản tình ca.");
	}
	
	
	

	

}
