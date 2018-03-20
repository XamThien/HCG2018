package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;
import controller.test;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
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
				initialize(link);
			}
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
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