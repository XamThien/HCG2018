package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Detail;
import controller.test;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class v_Add_Data {

	private JFrame frmThmMiMuc;

	/**
	 * Launch the application. Là để nhập tên các mục tiêu
	 */
	public static void main(String link,String ten_de_tai,int so_mt,int so_pa) {
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
					v_Add_Data window = new v_Add_Data(link,ten_de_tai, so_mt,so_pa);
					window.frmThmMiMuc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_Add_Data(String link,String ten_de_tai,int so_mt,int so_pa) {
		//String linksavelinkDB = "G:\\Link.xls";
		initialize(link,ten_de_tai, so_mt,so_pa);
	}
	public v_Add_Data() {
		//initialize( );
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void writeNewFileExcel(String ten_de_tai,String fileName,ArrayList<JTextField> hihi) {
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
            	
            	sheet1.addCell(new Label(col, 0, hihi.get(col-1).getText()));
                
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
	private void initialize(String link,String ten_de_tai,int so_mt,int so_pa) {
		frmThmMiMuc = new JFrame();
		frmThmMiMuc.setTitle("Thêm mới mục tiêu");
		frmThmMiMuc.setBounds(400, 100, 592, 316+(so_mt-1)*40);
		frmThmMiMuc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThmMiMuc.getContentPane().setLayout(null);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setBounds(92, 23, 402, 43);
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		frmThmMiMuc.getContentPane().add(lblPhnMmH);
		
		test ts = new test();
		String fileName = ts.readFileExcel(link,1,2);
		int len = fileName.length();
		int last = fileName.lastIndexOf('\\');
		String folderName = fileName.substring( 0,last+1);
		BufferedImage image = null;
        try
        {
        	
          image = ImageIO.read(new File(folderName+"image.png"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }
        
        frmThmMiMuc.setIconImage(image);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p t\u00EAn các mu\u0323c ti\u00EAu:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.setBounds(66, 103, 466, 90+(so_mt-1)*40);
		frmThmMiMuc.getContentPane().add(panel);
		panel.setLayout(null);
		
		ArrayList<JTextField> hihi = new ArrayList<JTextField>();
		
		for(int i = 1; i<=so_mt;i++)
		{
			JLabel lblTnTai = new JLabel("Mục tiêu");
			lblTnTai.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblTnTai.setBounds(36, 38+(i-1)*40, 75, 16);
			panel.add(lblTnTai);
			
			JLabel label = new JLabel(String.valueOf(i));
			label.setFont(new Font("SansSerif", Font.PLAIN, 14));
			label.setBounds(94, 38+(i-1)*40, 75, 16);
			panel.add(label);
			
			JTextField txtName = new JTextField();
			txtName.setHorizontalAlignment(SwingConstants.CENTER);
			txtName.setBounds(145, 33+(i-1)*40, 270, 28);
			panel.add(txtName);
			txtName.setColumns(10);
			hihi.add(txtName);
			
		}
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ck = true;
				for(int i = 1; i<=hihi.size();i++)
				{
					if(hihi.get(i-1).getText().equals("") || hihi.get(i-1).getText().equals(null))
					{
						ck = false;
						JOptionPane.showMessageDialog(null, "Chưa nhập mục tiêu "+i,"Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
				if(ck)
				{
					test ts = new test();
					String fileName = ts.readFileExcel(link,1,2);
					
					int last = fileName.lastIndexOf('\\');
					String folderName = fileName.substring(0, last+1);
					String newfileName = folderName+ten_de_tai+".xls";
					if(ts.checkFileExcel(newfileName))
					{
						newfileName = folderName+ten_de_tai+"-1.xls";
					}
					//writeNewFileExcel(ten_de_tai,newfileName,hihi);
					frmThmMiMuc.setVisible(false);
					ArrayList<String> hehe = new ArrayList<String>();
					for(JTextField ee : hihi)
					{
						hehe.add(ee.getText());
					}
					//new v_Add_PA().main(link,newfileName, hehe);
					frmThmMiMuc.setVisible(false);
					new v_Add_Table_PA().main(ten_de_tai,link,newfileName, hehe,so_pa);
				}
			}
		});
		btnNext.setBounds(442, 215+(so_mt-1)*40, 90, 28);
		frmThmMiMuc.getContentPane().add(btnNext);
		
		JButton btnback = new JButton("Trở lại");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThmMiMuc.setVisible(false);
				new v_New_Data().main(link);
			}
		});
		btnback.setBounds(342, 215+(so_mt-1)*40, 90, 28);
		frmThmMiMuc.getContentPane().add(btnback);
	}

}
