package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import controller.test;
import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class v_Add_PA {

	private JFrame frmThmPhngAn;

	/**
	 * Launch the application.
	 */
	public static void main(String link,String newfileName,ArrayList<String> hihi) {
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
					v_Add_PA window = new v_Add_PA(link,newfileName,hihi);
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
	public v_Add_PA(String link,String newfileName,ArrayList<String> hihi) {
		
		initialize(link,newfileName,hihi);
	}
	public v_Add_PA() {
		//initialize(newfileName,hihi);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void openAndWriteContinusFileExcel(String newfileName,ArrayList<String> rtnlst) {
        Workbook workbook;
        WritableWorkbook writeWorkbook;
        try {
            // open file
            workbook = Workbook.getWorkbook(new File(newfileName));
            // create file copy of root file to write file
            writeWorkbook = Workbook.createWorkbook(new File(newfileName),
                    workbook);
 
            // get sheet to write
            WritableSheet sheet1 = writeWorkbook.getSheet(0);
            //int colcontinus = sheet1.getRows();
            int rowcontinus = sheet1.getRows();
            for(int i=0; i<rtnlst.size();i++)
            {
            	sheet1.addCell(new Label(i, rowcontinus, rtnlst.get(i)));
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
	
	// mo ra va ghi de mot ô
	private void openAndWriteFileExcel(String linksavelinkDB, String newfileName) {
        Workbook workbook;
        WritableWorkbook writeWorkbook;
        try {
            // open file
            workbook = Workbook.getWorkbook(new File(linksavelinkDB));
            // create file copy of root file to write file
            writeWorkbook = Workbook.createWorkbook(new File(linksavelinkDB),
                    workbook);
            
            
            
            // get sheet to write
            WritableSheet sheet1 = writeWorkbook.getSheet(0);
            Label f = new Label(1, 1, newfileName);
            sheet1.addCell(f);
           
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
	private void initialize(String link,String newfileName,ArrayList<String> hihi) {
		frmThmPhngAn = new JFrame();
		frmThmPhngAn.setTitle("Thêm Phương Án");
		int so_mt = hihi.size();
		frmThmPhngAn.setBounds(100, 100, 592, 316+so_mt*40);
		frmThmPhngAn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThmPhngAn.getContentPane().setLayout(null);
		frmThmPhngAn.setResizable(false);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setBounds(92, 23, 402, 43);
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		frmThmPhngAn.getContentPane().add(lblPhnMmH);
		
		test ts = new test();
		String fileName = ts.readFileExcel(link,1,2);
		int len = fileName.length();
		int last = fileName.lastIndexOf('\\');
		/*String folderName = fileName.substring( 0,last+1);
		BufferedImage image = null;
        try
        {
        	
      //    image = ImageIO.read(new File(folderName+"image.png"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }*/
        
       // frmThmPhngAn.setIconImage(image);
        String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frmThmPhngAn.setIconImage(imageIcon.getImage());
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00EAm mu\u0323c ti\u00EAu:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(66, 103, 466, 90+so_mt*40);
		frmThmPhngAn.getContentPane().add(panel);
		panel.setLayout(null);
		
		ArrayList<JTextField> haha = new ArrayList<JTextField>();
		
		JLabel lblTnTai1 = new JLabel("Tên phương án");
		lblTnTai1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTnTai1.setBounds(36, 35, 108, 23);
		panel.add(lblTnTai1);
		
		
		JTextField txtName1 = new JTextField();
		txtName1.setHorizontalAlignment(SwingConstants.CENTER);
		txtName1.setBounds(145, 33, 270, 28);
		panel.add(txtName1);
		txtName1.setColumns(10);
		
		haha.add(txtName1);
		
		
		ArrayList<JLabel> hoho = new ArrayList<JLabel>();
		
		for(int i = 1; i<=so_mt;i++)
		{
			JLabel lblTnTai = new JLabel(hihi.get(i-1));
			lblTnTai.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblTnTai.setBounds(36, 38+i*40, 75, 16);
			panel.add(lblTnTai);
			hoho.add(lblTnTai);
			
			
			
			JTextField txtName = new JTextField();
			txtName.setHorizontalAlignment(SwingConstants.CENTER);
			txtName.setBounds(145, 33+i*40, 270, 28);
			panel.add(txtName);
			txtName.setColumns(10);
			haha.add(txtName);
			
		}
		
		
		JButton btnBack = new JButton("Trang chủ");
		//btnBack.setEnabled(true);
		btnBack.setBounds(342, 255+(so_mt-1)*40, 90, 28);
		frmThmPhngAn.getContentPane().add(btnBack);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> rtnlst = new  ArrayList<String>();
				
				boolean ck = true;
				String namepa = "";
				if(txtName1.getText().equals("") || txtName1.getText().equals(null))
				{
					ck = false;
					JOptionPane.showMessageDialog(null, "Chưa nhập tên phương án","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					namepa = txtName1.getText();
					rtnlst.add(namepa);
				}
				
				
				for(int i = 1; i<=so_mt;i++)
				{
					if(haha.get(i).getText().equals("") || haha.get(i).getText().equals(null))
					{
						ck = false;
						JOptionPane.showMessageDialog(null, "Chưa nhập giá trị cho mục tiêu "+hoho.get(i-1).getText(),"Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						try
						{
							
							if(haha.get(i).getText().contains(","))
							{
								double vl = Double.parseDouble(haha.get(i).getText().replace(",", "."));
								rtnlst.add(String.valueOf(vl));
							}
							else
							{
								double vl = Double.parseDouble(haha.get(i).getText());
								rtnlst.add(String.valueOf(vl));
							}
						}
						catch(Exception ex)
						{
							ck = false;
							JOptionPane.showMessageDialog(null, "Nhập sai định dạng giá trị cho mục tiêu "+hoho.get(i-1).getText(),"Lỗi", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				if(ck)
				{
					openAndWriteContinusFileExcel(newfileName,rtnlst);
					JOptionPane.showMessageDialog(null, "Đã thêm phương án thành công. Bạn có thể tiếp tục thêm các phương án.","Thành công", JOptionPane.INFORMATION_MESSAGE);
					btnBack.setEnabled(true);
					txtName1.setText("");
					
					for(JTextField ec : haha)
					{
						ec.setText("");
					}					
				}
			}
		});
		btnThm.setBounds(442, 255+(so_mt-1)*40, 90, 28);
		frmThmPhngAn.getContentPane().add(btnThm);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmThmPhngAn.setVisible(false);
				//new BeforeOpenApp().main(null);
				new v_SelectMT().main(link);
				
			}
		});
	}
}
