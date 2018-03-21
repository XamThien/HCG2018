package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Phuongan;
import controller.test;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class v_AddNewMT {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<String> namePAs,String link) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v_AddNewMT window = new v_AddNewMT( namePAs,link);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_AddNewMT(ArrayList<String> namePAs,String link) {
		initialize(namePAs, link);
	}
	public v_AddNewMT() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void openAndWriteContinusFileExcel(String fileName,ArrayList<JTextField> hihi) {
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
            int colcontinus = sheet1.getColumns();
            //int rowcontinus = sheet1.getRows();
            for(int i =0;i<hihi.size();i++)
            {
            	sheet1.addCell(new Label(colcontinus, i, hihi.get(i).getText()));
            }
            	
                //sheet1.addCell(new Label(2, rowcontinus, String.valueOf("1")));
            
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
	private ArrayList<String> ReadFromExcel(String nameFile){
		Workbook workbook;
		ArrayList<String> namePAs = new ArrayList<String>();
		// create workbook to open file
        try {
			workbook = Workbook.getWorkbook(new File(nameFile));
	        
	        Sheet sheet = workbook.getSheet(0);
	        // get number row and col contain data
	        int rows = sheet.getRows();
	        int cols = sheet.getColumns();
	        
	        
	        for	(int row = 1; row < rows; row++){
	        	String namePa = (sheet.getCell(0, row)).getContents();
	        	namePAs.add(namePa);
	        }
	        
	        workbook.close();
        } catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namePAs;
	}
	private void initialize(ArrayList<String> namePAs,String link) {
		frame = new JFrame();
		frame.setTitle("Thêm mới mục tiêu");
		int so_mt = namePAs.size();
		frame.setBounds(255, 100, 592, 316+so_mt*40);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setBounds(92, 23, 402, 43);
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblPhnMmH);
		frame.setResizable(false);
		
		test ts = new test();
		String fileName = ts.readFileExcel(link,1,2);
		int len = fileName.length();
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
        
        //frame.setIconImage(image);
        String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frame.setIconImage(imageIcon.getImage());
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00EAm mu\u0323c ti\u00EAu:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(66, 103, 466, 90+so_mt*40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane jsc = new JScrollPane(panel);
        jsc.setBounds(66, 103, 466, 90+so_mt*40);
        frame.getContentPane().add(jsc);
		
		ArrayList<JTextField> hihi = new ArrayList<JTextField>();
		
		JLabel lblTnTai1 = new JLabel("Tên mục tiêu");
		lblTnTai1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTnTai1.setBounds(36, 35, 108, 23);
		panel.add(lblTnTai1);
		
		
		JTextField txtName1 = new JTextField();
		txtName1.setHorizontalAlignment(SwingConstants.CENTER);
		txtName1.setBounds(205, 33, 230, 28);
		panel.add(txtName1);
		txtName1.setColumns(10);
		hihi.add(txtName1);
		
		for(int i = 1; i<=so_mt;i++)
		{
			JLabel lblTnTai = new JLabel("Phương án "+namePAs.get(i-1));
			lblTnTai.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblTnTai.setBounds(36, 38+i*40, 160, 16);
			panel.add(lblTnTai);
			
			JTextField txtName = new JTextField();
			txtName.setHorizontalAlignment(SwingConstants.CENTER);
			txtName.setBounds(205, 33+i*40, 230, 28);
			panel.add(txtName);
			txtName.setColumns(10);
			hihi.add(txtName);
			
		}
		
		
		JButton btnNext = new JButton("Thêm");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ck = true;
				if(hihi.get(0).getText().equals("") || hihi.get(0).getText().equals(null))
				{
					ck = false;
					JOptionPane.showMessageDialog(null, "Chưa nhập tên mục tiêu","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				for(int i = 1; i<hihi.size();i++)
				{
					if(hihi.get(i).getText().equals("") || hihi.get(i).getText().equals(null))
					{
						ck = false;
						JOptionPane.showMessageDialog(null, "Chưa nhập giá trị cho phương án "+namePAs.get(i),"Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
				if(ck)
				{
					test ts = new test();
					String fileName = ts.readFileExcel(link,1,2);
					openAndWriteContinusFileExcel(fileName,hihi);
					for(JTextField jt : hihi)
					{
						jt.setText("");
					}
					JOptionPane.showMessageDialog(null, "Thêm mục tiêu thành công. Bạn có thể thêm tiếp tục ở đây.","Lỗi", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNext.setBounds(442, 215+so_mt*40, 90, 28);
		frame.getContentPane().add(btnNext);
		
		JButton btnBack = new JButton("Trở lại");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean ckk = false;
				for(JTextField xx : hihi)
				{
					if(!xx.getText().equals("") || !xx.getText().equals(null))
					{
						ckk = true;
					}
				}
				if(ckk==true)
				{
					int check = JOptionPane.showConfirmDialog(frame, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					
	                if (check == JOptionPane.YES_OPTION) 
	                {
	                	frame.setVisible(false);
	    				new v_SelectMT().main(link);
	                }
				}
				else
				{
					frame.setVisible(false);
					new v_SelectMT().main(link);
				}
			}
		});
		btnBack.setBounds(342, 215+so_mt*40, 90, 28);
		frame.getContentPane().add(btnBack);
	}

}
