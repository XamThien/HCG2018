package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.test;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class v_Add_Table_PA {

	private JFrame frmThmPhngAn;

	/**link,String newfileName,ArrayList<String> hehe,int so_pa
	 * Launch the application.
	 */
	public static void main(String ten_de_tai,String link,String newfileName,ArrayList<String> hehe,int so_pa) {
//		try
//		{
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//		} catch (Throwable e)
//		{
//			e.printStackTrace();
//		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v_Add_Table_PA window = new v_Add_Table_PA(ten_de_tai,link,newfileName, hehe,so_pa);
					window.frmThmPhngAn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_Add_Table_PA(String ten_de_tai,String link,String newfileName,ArrayList<String> hehe,int so_pa) {
//		//new v_Add_Table_PA().main(link,newfileName, hehe,so_pa);
//		int so_pa=2;
//		String link = "";
//		String newfileName ="";
//		ArrayList<String> hehe = new ArrayList<String>();
//		hehe.add("ten");
//		hehe.add("tuoi");
//		hehe.add("dia chi");
		
		
		initialize(ten_de_tai,link,newfileName, hehe,so_pa);
	}
	public v_Add_Table_PA() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void writeNewFileExcel(String ten_de_tai,String fileName,ArrayList<String> hihi) {
        WritableWorkbook workbook;
        // create workbook
        try {
            workbook = Workbook.createWorkbook(new File(fileName));
 
            // create sheet
            WritableSheet sheet1 = workbook.createSheet("CSDL HCG", 0);
 
           
            
            // row begin write data
            sheet1.addCell(new Label(0, 0, ten_de_tai.toLowerCase()));
            
            int cols = hihi.size();
            for(int col=1; col<=cols; col++)
            {
            	
            	sheet1.addCell(new Label(col, 0, hihi.get(col-1)));
                
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
	
	private void initialize(String ten_de_tai,String link,String newfileName,ArrayList<String> hehe,int so_pa) {
		frmThmPhngAn = new JFrame();
		frmThmPhngAn.setTitle("Thêm phương án");
		int socot = hehe.size();
		int bonus = 0;
		if(socot>3)
		{
			bonus+=(socot-3)*45;
		}
		frmThmPhngAn.setBounds(450-((socot-2)*bonus)/2, 100, 561+(socot-3)*bonus, 343);
		frmThmPhngAn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThmPhngAn.getContentPane().setLayout(null);
		
		String fileName = newfileName;
		
		int last = fileName.lastIndexOf('\\');
		/*String folderName = fileName.substring( 0,last+1);
		BufferedImage image = null;
        try
        {
        	
        //  image = ImageIO.read(new File(folderName+"image.png"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }*/
        
     //   frmThmPhngAn.setIconImage(image);
        String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frmThmPhngAn.setIconImage(imageIcon.getImage());
     //   ImageIcon imageIcon = new ImageIcon(image);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnMmH.setBounds(0, 15, 561+(socot-3)*bonus, 43);
		frmThmPhngAn.getContentPane().add(lblPhnMmH);
		
		JLabel lblLaChonC = new JLabel("Nhập giá trị cho các phương án ở bảng dưới đây");
		lblLaChonC.setBounds(0, 50, 561+(socot-3)*bonus, 14);
		lblLaChonC.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLaChonC.setHorizontalAlignment(SwingConstants.CENTER);
		frmThmPhngAn.getContentPane().add(lblLaChonC);
		
		JTable table = new JTable();
		
		table.setCellSelectionEnabled(true);
		table.setBounds(27, 69, 380+(socot-3)*bonus, 159);
		frmThmPhngAn.getContentPane().add(table);
		
		
		JScrollPane jsc = new JScrollPane(table);
        jsc.setBounds(29, 88, 493+(socot-3)*bonus, 159);
        frmThmPhngAn.getContentPane().add(jsc);
        
        
        DefaultTableModel dtm = new DefaultTableModel();
        String [] colsName = new String [socot+1];
        colsName[0]="Tên phương án";
        for(int i=1;i<=socot;i++)
        {
        	colsName[i]=hehe.get(i-1);
        }
        dtm.setColumnIdentifiers(colsName);
        
        for(int i = 0;i<so_pa;i++)
        {
        	String rows[] = new String[socot+1];
        	for(int j=0;j<socot+1;j++)
            {
        		rows[j]="";
            }
        	dtm.addRow(rows);
        }
        
        table.setModel(dtm);
        
        JButton btnLu = new JButton("Lưu");
        btnLu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int check = JOptionPane.showConfirmDialog(frmThmPhngAn, "Xác nhận lưu?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) {
                	 boolean checkk = true;
                	 int so_cot= socot+1;
                     int so_hang = so_pa;
                     
                     for(int i= 0;i<so_hang;i++)
                     {
                    	 for(int j= 0;j<so_cot;j++)
                         {
                        	 String content = table.getValueAt(i, j).toString();
                        	 if(content.equals(""))
                        	 {
                        		 checkk = false;
                        		 JOptionPane.showMessageDialog(null, "Vị trí hàng "+(i+1)+" cột "+(j+1)+" chưa điền","Lỗi", JOptionPane.WARNING_MESSAGE);
                        	 }
                         }
                     }
                     // ghi cac value vao excel
                     test ts = new test();
                     if(checkk)
                     {
                    	 for(int i= 0;i<so_hang;i++)
                         {
                        	 for(int j= 1;j<so_cot;j++)
                             {
                            	 String content = table.getValueAt(i, j).toString();
                            	 try
                            	 {
                            		 if(content.contains(","))
                            		 {
                            			 double vl = Double.parseDouble(content.replace(",", "."));
                            			 
                            		 }
                            		 else
                            		 {
                            			 double vl = Double.parseDouble(content);
                            			 
                            		 }
                            	 }
                            	 catch(Exception ee)
                            	 {
                            		 checkk = false;
                            		 JOptionPane.showMessageDialog(null, "Nhập đúng định dạng vị trí hàng "+(i+1)+" cột "+(j+1),"Lỗi", JOptionPane.WARNING_MESSAGE);
                            	 }
                             }
                         }
                     }
                     
                     if(checkk)
                     {
                    	 writeNewFileExcel(ten_de_tai,newfileName,hehe);
                    	 
                    	 for(int i= 0;i<so_hang;i++)
                         {
                        	 for(int j= 1;j<so_cot;j++)
                             {
                            	 String content = table.getValueAt(i, j).toString();
                            	 try
                            	 {
                            		 if(content.contains(","))
                            		 {
                            			 double vl = Double.parseDouble(content.replace(",", "."));
                            			 ts.openAndWriteFileExcel(newfileName,String.valueOf(vl),j,i+1);
                            		 }
                            		 else
                            		 {
                            			 double vl = Double.parseDouble(content);
                            			 ts.openAndWriteFileExcel(newfileName,String.valueOf(vl),j,i+1);
                            		 }
                            	 }
                            	 catch(Exception ee)
                            	 {
                            		 JOptionPane.showMessageDialog(null, "Nhập đúng định dạng vị trí hàng "+(i+1)+" cột "+(j+1),"Lỗi", JOptionPane.WARNING_MESSAGE);
                            	 }
                             }
                         }
                     }
                     
                     if(checkk)
                     {
                    	 
                    	 
                    	 for(int i= 0;i<so_hang;i++)
                         {
                        	 
                            	 String content = table.getValueAt(i, 0).toString();
                            	 ts.openAndWriteFileExcel(newfileName,content,0,i+1);
                             
                         }
                    	 
                    	 frmThmPhngAn.setVisible(false);
                    	 new v_SelectFile().main(link);
                     }
                    
                }
        	}
        });
        btnLu.setBounds(432+(socot-3)*bonus, 259, 90, 28);
        frmThmPhngAn.getContentPane().add(btnLu);
        
        JButton button = new JButton("Thoát");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int check = JOptionPane.showConfirmDialog(frmThmPhngAn, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) {
                	frmThmPhngAn.setVisible(false);
                	new v_SelectFile().main(link);
                }
        	}
        });
        button.setBounds(312+(socot-3)*bonus, 258, 90, 28);
        frmThmPhngAn.getContentPane().add(button);
        
	}
}
