package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;
import controller.test;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class BeforeOpenApp {

	private JFrame frmChonViTri;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeforeOpenApp window = new BeforeOpenApp();
					window.frmChonViTri.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BeforeOpenApp() {
		test ts = new test();
		// tạo file excel luu địa chỉ của file database, c:\\users\\user-name
		String folder = System.getProperty("user.home")+"\\HeChuyenGia";
		//File f=new File(folder);
		 //boolean flag=f.mkdir();
		if(ts.checkFileExcel(folder))
		{
			String link = folder+"\\Link.xls";
			if(!ts.checkFileExcel(link))
			{
				String test = folder+"\\ExampleCSDL.xls";
				writeNewFileExcel(test);
				initialize(link);
			}
			else
			{
				new v_SelectFile().main(link);
			}
		}
		else
		{
			File f=new File(folder);
			boolean flag=f.mkdir();
			String link = folder+"\\Link.xls";
			if(ts.checkFileExcel(link))
			{
				
				new v_SelectFile().main(link);
				
			}
			else
			{
				String test = folder+"\\ExampleCSDL.xls";
				writeNewFileExcel(test);
				initialize(link);
				
			}
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	public static void writeNewFileExcel(String fileName) {
        WritableWorkbook workbook;
        // create workbook
        try {
        	ArrayList<String> arr1 = new ArrayList<String>();
        	arr1.add("Đi làm");
        	arr1.add("Lương");
        	arr1.add("Gần nhà");
        	arr1.add("Độ hấp dẫn");
        	ArrayList<String> arr2 = new ArrayList<String>();
        	arr2.add("1");
        	arr2.add("0.4"); 	
        	arr2.add("0.1");
        	arr2.add("0.7");
        	ArrayList<String> arr3 = new ArrayList<String>();
        	arr3.add("2");
        	arr3.add("0.2"); 	
        	arr3.add("0.9");
        	arr3.add("0.5");
        	ArrayList<String> arr4 = new ArrayList<String>();
        	arr4.add("3");
        	arr4.add("0.3");
        	arr4.add("0.6"); 		
        	arr4.add("0.4");
        	ArrayList<String> arr5 = new ArrayList<String>();
        	arr5.add("4"); 	
        	arr5.add("0.8");
        	arr5.add("0.5");
        	arr5.add("0.1");
        	ArrayList<String> arr6 = new ArrayList<String>();
        	arr6.add("5"); 	
        	arr6.add("0.3");
        	arr6.add("0.4");
        	arr6.add("0.7");
            workbook = Workbook.createWorkbook(new File(fileName));
 
            // create sheet
            WritableSheet sheet1 = workbook.createSheet("Link lưu file CSDL HCG2018", 0);
 
            //sheet1.addCell(new Label(cot, hang,link));
           for(int i=0; i<arr1.size();i++)
           {
        	   sheet1.addCell(new Label(i, 0,arr1.get(i)));
           }
           for(int i=0; i<arr1.size();i++)
           {
        	   sheet1.addCell(new Label(i, 1,arr2.get(i)));
           }
           for(int i=0; i<arr1.size();i++)
           {
        	   sheet1.addCell(new Label(i, 2,arr3.get(i)));
           }
           for(int i=0; i<arr1.size();i++)
           {
        	   sheet1.addCell(new Label(i, 3,arr4.get(i)));
           }
           for(int i=0; i<arr1.size();i++)
           {
        	   sheet1.addCell(new Label(i, 4,arr5.get(i)));
           }
           for(int i=0; i<arr1.size();i++)
           {
        	   sheet1.addCell(new Label(i, 5,arr6.get(i)));
           }
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
	
	private void initialize(String Link) {
//		frmChonViTri = new JFrame();
//		frmChonViTri.setTitle("Chọn vị trí lưu các file");
//		frmChonViTri.setBounds(500, 150, 541, 296);
//		frmChonViTri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frmChonViTri.getContentPane().setLayout(null);
//
//		String path = "/image/image.png";
//        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
//        frmChonViTri.setIconImage(imageIcon.getImage());
//		
//		JPanel panel = new JPanel();
//		panel.setBorder(new TitledBorder(null, "Cho\u0323n folder l\u01B0u ca\u0301c file gia\u0309i ne\u0301n :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
//		panel.setBounds(19, 88, 487, 116);
//		frmChonViTri.getContentPane().add(panel);
//		panel.setLayout(null);
//		
//		textField = new JTextField();
//		textField.setEditable(false);
//		textField.setBounds(29, 46, 259, 37);
//		panel.add(textField);
//		textField.setColumns(10);
//		
//		JButton btnNewButton = new JButton("Chọn thư mục giải nén");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser fileChooser = new JFileChooser();
//				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//				int result = fileChooser.showOpenDialog(null);
//				if (result == JFileChooser.APPROVE_OPTION) 
//				{
//					String path = fileChooser.getSelectedFile().getAbsolutePath();
//			        
//			        if (path!=null)
//			        {
//			        	String cklink = path;
//			        	if(test.checkFileExcel(cklink))
//			        	{
//			        			boolean ck = true;
//			        			int len = cklink.length();
//			        			int last = cklink.lastIndexOf('.');
//			        			String filettpe = cklink.substring( last+1,len);
//			        			if(filettpe.equals("xls"))
//			        			{
//			        				try {
//			        					PhuongAnList paList = new PhuongAnList();
//			        					test ts = new test();
//			        					
//			        					try {
//			        						paList.ReadFromExcel(cklink);
//			        						ck = true;
//										} catch (Exception e2) {
//											ck = false;
//											JOptionPane.showMessageDialog(null, "File lỗi. Yêu cầu chọn file khác","Lỗi", JOptionPane.ERROR_MESSAGE);
//										}
//			        					
//			        					
//
//			        				}
//					        		catch (Exception eq)
//					        		{
//					        			ck = false;
//					        			JOptionPane.showMessageDialog(null, "File lỗi. Yêu cầu chọn file khác","Lỗi", JOptionPane.ERROR_MESSAGE);
//					        		}
//			        				if(ck==true)
//			        				{
//				        				textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
//						        		test.writeNewFileExcel(Link,cklink);
//						        		frmChonViTri.setVisible(false);
//						        		new v_SelectMT().main(Link);
//			        				}
//			        			}
//			        			else
//			        			{
//			        				ck = false;
//			        				JOptionPane.showMessageDialog(null, "File lỗi. Yêu cầu chọn file khác","Lỗi", JOptionPane.ERROR_MESSAGE);
//			        			}
//			        			
//			        		
//			        		
//			        		
//			        	}
//			        	else
//			        	{
//			        		JOptionPane.showMessageDialog(null, "Folder không chứa các file cần thiết","Lỗi", JOptionPane.ERROR_MESSAGE);
//			        	}
//			        }
//				}
//				else {
//			    	JOptionPane.showMessageDialog(null, "Chưa chọn vị trí tệp","Lỗi", JOptionPane.ERROR_MESSAGE);
//			      }
				
//				JFileChooser chooser = new JFileChooser(); 
//			    chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//			    
//			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//			    chooser.setAcceptAllFileFilterUsed(false);
//			       
//			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
			      
			    	String path =  System.getProperty("user.home")+"\\HeChuyenGia";
			    	
				        	/*String cklink = path+"\\image.png";
				        	if(test.checkFileExcel(cklink))
				        	{
				        		textField.setText(chooser.getSelectedFile().getAbsolutePath());
				        	*/	test.writeNewFileExcel(Link,path,1,1);
				        		//frmChonViTri.setVisible(false);
				        		new v_SelectFile().main(Link);
				        		
				        		/*
				        		
				        		
				        	}
				        	else
				        	{
				        		JOptionPane.showMessageDialog(null, "Đây không phải thư mục giải nén Hệ Chuyên Gia","Lỗi", JOptionPane.ERROR_MESSAGE);
				        	}*/
//				        }
//			    	
//			      }
//			    else 
//			    {
//			    	JOptionPane.showMessageDialog(null, "Chưa chọn vị trí tệp","Lỗi", JOptionPane.ERROR_MESSAGE);
//			    }
//
//			}
//		});
//		btnNewButton.setBounds(300, 46, 163, 37);
//		panel.add(btnNewButton);
//		
//		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
//		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
//		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
//		lblPhnMmH.setBounds(67, 18, 402, 43);
//		frmChonViTri.getContentPane().add(lblPhnMmH);
	}

}