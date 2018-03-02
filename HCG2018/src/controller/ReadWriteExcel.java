package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
 
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
 
/**
 * ----------------- @author nguyenvanquan7826 -----------------
 * ---------------nguyenvanquan7826.wordpress.com --------------
 */
public class ReadWriteExcel {
 
    private final String fileName = "G:/HeChuyenGia/HCG2018/Book1.xls";
 
    // data to write file
    private Object[][] data = { { "STT", "Họ và tên", "Điểm", "Xếp loại" },
            { "1", "Nguyễn Văn Quân", "9.0", "nl" },
            { "2", "Phạm Thị Hà", "8.0", "" },
            { "3", "Nguyễn Bá Cường", "8.5", "" },
            { "4", "Vũ Công Tịnh", "9.0", "" },
            { "5", "Phạm Trọng Khang", "8", "" },
            { "6", "Mai Văn Tài", "8", "" } };
 
    // create and write new file *.xls
    private void writeFileExcel() {
        WritableWorkbook workbook;
        // create workbook
        try {
            workbook = Workbook.createWorkbook(new File(fileName));
 
            // create sheet
            WritableSheet sheet1 = workbook.createSheet("KTPM K10B", 0);
 
            // create Label and add to sheet
            sheet1.addCell(new Label(3, 0, "DANH SÁCH SINH VIÊN TIÊU BIỂU"));
 
            // row begin write data
            int rowBegin = 3;
            int colBegin = 3;
 
            for (int row = rowBegin, i = 0; row < data.length + rowBegin; row++, i++) {
                for (int col = colBegin, j = 0; col < data[0].length + colBegin; col++, j++) {
                    Object obj = data[i][j];
                    sheet1.addCell(new Label(col, row, (String) data[i][j]));
                }
            }
            // write file
            workbook.write();
 
            // close
            workbook.close();
        } catch (IOException e) {
            System.out.println("Error create file\n" + e.toString());
        } catch (RowsExceededException e) {
            System.out.println("Error write file\n" + e.toString());
        } catch (WriteException e) {
            System.out.println("Error write file\n" + e.toString());
        }
        System.out.println("create and write success");
    }
 
    // open and read file *.xls
    private void readFileExcel() {
        Workbook workbook;
        try {
            // create workbook to open file
            workbook = Workbook.getWorkbook(new File(fileName));
            // get sheet want read
            Sheet sheet = workbook.getSheet(0);
            // get number row and col contain data
            int rows = sheet.getRows();
            int cols = sheet.getColumns();
 
            System.out.println("Data in file:");
            // read data in each cell
            for (int col = 0; col < cols; col++) {
            	for (int row = 0; row < rows; row++) {
                    Cell cell = sheet.getCell(col, row);
                    
						System.out.println(cell.getContents());
					
                }
                System.out.println("\n");
            }
            System.out.println( "dòng hiện tại " + rows);
            System.out.println( "cột hiện tại " + cols);
            // close
            workbook.close();
        } catch (BiffException e) {
            System.out.println("File not found\n" + e.toString());
        } catch (IOException e) {
            System.out.println("File not found\n" + e.toString());
        }
    }
 
    // open and write file is exists
    private void openAndWriteFileExcel() {
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
            int col = 3;
            int rowBegin = 3;
            // write data (formula)
            for (int row = rowBegin; row < data.length + rowBegin - 1; row++) {
                Formula f = new Formula(col, row, "IF(C" + (row + 1)
                        + ">8, \"Xuất sắc\", \"Giỏi\")");
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
        System.out.println("open and write success");
    }
 
    private void showMenu() {
        System.out.println();
        System.out.println("Select an integer for process:");
        System.out.println("1 - Create new file and wrire data");
        System.out.println("2 - Read file exits");
        System.out.println("3 - Open and write to file exits");
    }
 
    public static void main(String[] args) {
        ReadWriteExcel rwExcel = new ReadWriteExcel();
        while (true) {
            rwExcel.showMenu();
            Scanner scan = new Scanner(System.in);
            int select = Integer.parseInt(scan.nextLine());
            switch (select) {
            case 1:
                rwExcel.writeFileExcel();
                break;
            case 2:
                rwExcel.readFileExcel();
                break;
            case 3:
                rwExcel.openAndWriteFileExcel();
                break;
            default:
                scan.close();
                break;
            }
        }
    }
}