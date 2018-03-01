package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

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
public class hihi {

	public static String removeAccent(String s) {
		  
		  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		  return pattern.matcher(temp).replaceAll("").replace('đ','d').replace('Đ','D');
		 }
	public static String convertUTF8(String s) throws UnsupportedEncodingException {
		String name1="";
		
	    byte ptext[] = s.getBytes("UTF8");
	   
	    for (int i = 0; i < ptext.length; i++) {
	      
	      name1+=ptext[i];
	      
	    }
		
		
		return name1;
	}
    public static  void docFileWord (ArrayList<Detail> ten,ArrayList<String> so1,String path,int de){
    	
        try{
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            BufferedReader bfr = new BufferedReader(isr);
            String line = bfr.readLine();
            Detail dt = new Detail();
            int n=1;
            while(line != null)
            {
            	
            	
                String []array = line.split(",");
                if(array.length==1)
                {
//                	if(!array[0].equals("x"))
//                	{
//                		dt.setName(array[0]);
//                    	
//                	}
//                	else
//                	{
//                		dt.setTt("Nghỉ");
//                		dt.setBatdau(0);
//                    	dt.setKetthuc(0);
//                    	ten.add(dt);
//                    	 n++;
//                    	dt=new Detail();
//                    	
//                	}
                	
                }
                else
                {
                	dt=new Detail();
                	int len = array[0].length();
                	String name = array[0].substring(0, len-2);
                	
                	dt.setName(name);
                	String sothu1 = array[0].substring(len-2,len);
                	so1.add(sothu1);
                	dt.setBatdau(so1.size());
                	dt.setKetthuc(so1.size()+array.length+1);
                	
                	int ck = 0;
                	for(int i=1;i<array.length;i++)
                	{
                		String so = array[i].trim().replaceAll("\\s+", "");
                		so1.add(so);
                		if(Integer.parseInt(so)==de)
                		{
                			ck=1;
                		}
                	}
                	if(ck==1)
                	{
                		dt.setTt("Ăn");
                	}
                	else
                	{
                		dt.setTt("Xịt");
                	}
                	ten.add(dt);
	               	n++;
	               	dt=new Detail();
                }
                line = bfr.readLine();
            }
            fis.close();
            isr.close();
            bfr.close();
        }
        catch(Exception ex ){
        	System.out.println();
            ex.printStackTrace();
        }
        
        
    }
    
    public static  int readFileExcel(String fileName,String name) {
        Workbook workbook;
        
        int stt = -1;
        try {
        	// create workbook to open file
            workbook = Workbook.getWorkbook(new File(fileName));
            // get sheet want read
            Sheet sheet = workbook.getSheet(0);
            // get number row and col contain data
            int rows = sheet.getRows();
            //int cols = sheet.getColumns();
 
            
            for (int row = 1; row < rows; row++) {
            		
                    Cell cell = sheet.getCell(1, row);
                    String name1 = convertUTF8(cell.getContents());
                    String name2 = convertUTF8(name);
                    if(name2.equals(name1))
					{
						stt=row;
						break;
					}
            }
            
            // close
            workbook.close();
        } catch (BiffException e) {
        	return stt;
        } catch (IOException e) {
        	return stt;
        }
		return stt;
    }
    
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
    
    
    public static boolean checkFileExcel(String fileName) {
    	File file = new File(fileName);
        return file.exists();
    }
    
    public static StringBuilder demsolan() {
    	StringBuilder str = new StringBuilder("");
    	
    	try{
			
			ArrayList<Number> sox = new ArrayList<Number>();
			ArrayList<Integer> tanxuat = new ArrayList<Integer>();
			//new InputStreamReader(new FileInputStream("G:\\LocSo.txt"), "UTF8")
            FileInputStream fis = new FileInputStream("D:\\ssorg\\LocSo.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            BufferedReader bfr = new BufferedReader(isr);
            String line = bfr.readLine();
            line = line.trim();
            line = line.replaceAll("\\\t+", " ");
            line = line.replaceAll("\\s+", " ");
            Number num = new Number();
            
            while(line != null)
            {
            	line = line.trim();
                line = line.replaceAll("\\\t+", " ");
                line = line.replaceAll("\\s+", " ");
            	
                String []array = line.split(" ");
                //System.out.println(array.length );
                for (int i=0;i<array.length;i++) 
                {
            		if(sox.isEmpty())
            		{
            			
            			String xc = array[i];
            			num.setSo(xc);
            			num.setTanxuat(1);
            			
            			sox.add(num);
            			num=new Number();
            		}
            		else
            		{
            			int ck = 0;
            			for(int j=0;j<sox.size();j++) 
            			{
            				Number xxx = (Number) sox.get(j);
            				if(xxx.getSo().equals(String.valueOf(array[i])))
            				{
            					String a = array[i];
            					int b = xxx.getTanxuat();
            					sox.remove(j);
            					
            					Number xx = new Number(a,b+1);
            					sox.add(j, xx);
            					//sox.add(xx);
            					
            					ck++;
            					xx= new Number();
            				}
            			}
            			if(ck==0)
            			{
            				num.setSo(array[i]);
                			num.setTanxuat(1);
                			sox.add(num);
                			num=new Number();
            			}
            		}
            	}
            	
               
                line = bfr.readLine();
                
            }
            fis.close();
            isr.close();
            bfr.close();
            // xoa phan tu dau tien vi no la cai linh tinh
            sox.remove(0);	
            	
            	
			// tao mang tan xuat de hien thi theo nhom
            for (Number dc : sox )
            {
            	if(tanxuat.size()==0)
            	{
            		tanxuat.add(dc.getTanxuat());
            		
            	}
            	else
            	{
            		int ckk=0;
            		for(int i=0;i<tanxuat.size();i++)
            		{
            			if(dc.getTanxuat()==tanxuat.get(i))
            			{
            				ckk=1;
            			}
            		}
            		if(ckk==0)
            		{
            			tanxuat.add(dc.getTanxuat());
            		}
            	}
            }
            tanxuat.sort(null);
            //hien thi
            for(int i=0;i<tanxuat.size();i++)
            {
            	str.append("Nhóm các số xuất hiện "+tanxuat.get(i)+" lần :");
            	str.append("\n");
            	//System.out.println("Nhóm các số xuất hiện "+tanxuat.get(i)+" lần :");
            	for(int j=0;j<sox.size();j++)
            	{
            		if(sox.get(j).getTanxuat()==tanxuat.get(i))
            		{
            			str.append(sox.get(j).getSo()+", ");
            			//System.out.print(sox.get(j).getSo()+", ");
            		}
            	}
            	//System.out.println();
            	str.append("\n");
            }
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return str;
	}
    
    public static void body() {
    	System.out.println();
    	System.out.println("_____________________________________________________________________");
    	System.out.println();
    	
    	System.out.println("Nhấn số 1 để biết đc ai trúng.");
    	System.out.println("Nhấn số 2 để đếm số lần xuất hiện các số.");
    	System.out.println("Nhấn số 3 để test đọc ghi file excel.");
    	System.out.println("Nhấn số 4 để test ghi mới file excel.");
    	System.out.println("Nhấn số 5 để ghi đè 1 ô trong 1 file excel");
    	System.out.println("Nhấn số 6 để ghi tiếp 1 file excel");
    	System.out.print("Anh lựa chọn chức năng số : ");
    	
    	
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int sel = sc.nextInt();
    	System.out.println();
    	System.out.println("_____________________________________________________________________");
    	System.out.println();
    	try
    	{
    		switch (sel) {
    		case 1:
    			ArrayList<Detail> ten = new ArrayList<Detail>();
    		    ArrayList<String> so1 = new ArrayList<String>();
    		    
    		    Date dNow = new Date( );
    		    SimpleDateFormat ftt = new SimpleDateFormat ("dd-MM-yyyy");
    		    String date =  ftt.format(dNow);
    		    
    		    
    		    System.out.print("Nhập số đề về hôm nay ngày "+date+": DE = ");
    		    int de = sc.nextInt();
    		    
    			docFileWord(ten,so1,"G:\\exampleNumber.txt",de);
    			if(ten.size()==0)
    			{
    				System.out.println("khong co gi ca");
    			}
    			else
    			{
    				 for(Detail s: ten)
    		         {
    		         	System.out.println(s.getName()+"======>"+s.getTt());
    		         	if(s.getBatdau()==s.getKetthuc())
    		         	{
    		         		System.out.println();
    		         	}
    		         	else
    		         	{
    		         		for(int i=s.getBatdau()-1;i<=s.getKetthuc()-1;i++)
    		             	{
    		             		System.out.print(so1.get(i)+",");
    		             	}
    		         	}
    		         	System.out.println();
    		         }
    			}
    			body();
    			break;
    		case 2:
    			demsolan();
    			body();
    			break;
    		case 3 : 
    			int pos = readFileExcel("G:\\thongke23.xls","Huỷ");
    			System.out.println(pos);
    			body();
    			break;
    		case 4 : 
    			Detail a = new Detail("Ăn", "Huỷ",1,2);
    			Detail b = new Detail("Nghỉ", "xxx",1,2);
    			Detail c = new Detail("Xịt", "yyy",1,2);
    			Detail d = new Detail("Ăn", "đù",1,2);
    			ArrayList<Detail> hihii = new ArrayList<Detail>();
    			hihii.add(a);
    			hihii.add(b);
    			hihii.add(c);
    			hihii.add(d);
    			writeNewFileExcel("G:\\thongke23.xls",hihii);
    			System.out.println(readFileExcel("G:\\thongke23.xls",d.getName()));
    			body();
    			break;
    		case 5 :
    			openAndWriteFileExcel("G:\\thongke1.xls",1);
    			body();
    			break;
    		case 6 : 
    			openAndWriteContinusFileExcel("G:\\thongke4.xls","huytest13");
    			body();
    			break;
    		case 7 :
    			System.out.println(checkFileExcel("G:\\thongke4.xls"));
    			body();
    			break;
    		default:
    			System.out.println("Chức năng không hỗ trợ.");
    			body();
    			break;
    		}
    	}
    	catch (Exception e)
    	{
    		
    		System.out.println("Nhập cái gì vi diệu thế.");
    		body();
    	}
    	
    }
public static void main(String[] args) {
	body();
	
}
}
