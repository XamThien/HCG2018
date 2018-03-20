package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


import controller.test;


import java.awt.Font;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class v_SelectFile {

	private JFrame frmLaChonDatabase;

	/**
	 * Launch the application.
	 */
	public static void main(String Link) {
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
					v_SelectFile window = new v_SelectFile(Link);
					window.frmLaChonDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_SelectFile(String Link) {
		
		test ts = new test();
		String filename = ts.readFileExcel(Link,1,1);
		
//		int len = fileName.length();
//		int last = fileName.lastIndexOf('\\');
//		String filename = fileName.substring( 0,last+1);
		initialize(Link,filename);
	}
	public v_SelectFile() {
		
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String Link,String filename) {
		String xx = filename;
		frmLaChonDatabase = new JFrame();
		frmLaChonDatabase.setTitle("Lựa chọn Database");
		frmLaChonDatabase.setBounds(500, 100, 450, 340);
		frmLaChonDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLaChonDatabase.getContentPane().setLayout(null);
		
		/*test ts = new test();
		String xxx = filename;
		
		BufferedImage image = null;
        try
        {
        	
         // image = ImageIO.read(new File(xxx+"\\image.png"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }*/
        
       // frmLaChonDatabase.setIconImage(image);
        String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frmLaChonDatabase.setIconImage(imageIcon.getImage());
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnMmH.setBounds(0, 15, 434, 43);
		frmLaChonDatabase.getContentPane().add(lblPhnMmH);
		
		JLabel lblLaChonC = new JLabel("Lựa chọn cơ sở dữ liệu làm việc");
		lblLaChonC.setBounds(108, 50, 228, 14);
		lblLaChonC.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLaChonC.setHorizontalAlignment(SwingConstants.CENTER);
		frmLaChonDatabase.getContentPane().add(lblLaChonC);
		
		JTable table = new JTable();
		
		
		table.setCellSelectionEnabled(true);
		table.setBounds(27, 69, 380, 159);
		frmLaChonDatabase.getContentPane().add(table);
		
		
		JScrollPane jsc = new JScrollPane(table);
        jsc.setBounds(29, 88, 380, 159);
        frmLaChonDatabase.getContentPane().add(jsc);
        
        File file = new File(filename);
        File[] files = file.listFiles();
        DefaultTableModel dtm = new DefaultTableModel();
        String [] colsName = new String [1];
        colsName[0]="Cơ sở dữ liệu";
        dtm.setColumnIdentifiers(colsName);
       
        Object[] row = new Object[1];
        int dem=0;
        for(int i = 0; i < files.length; i++)
        {
            
            if(files[i].getName().contains("xls") && !files[i].getName().contains("Link.xls"))
            {
            	String fileName = files[i].getName();
        		
        		int last = fileName.lastIndexOf('.');
        		filename = fileName.substring( 0,last);
            	row[0] =filename;
                dtm.addRow(row);
                
            }
            else
            {
            	dem++;
            }
        }
        
        table.setModel(dtm);
        
        if(dem==files.length)
        {
        	JOptionPane.showMessageDialog(null, "Không có CSDL! Bạn hãy thêm mới để làm việc.","Lỗi", JOptionPane.WARNING_MESSAGE);
            
                
            
        }
        
        JButton btnOk = new JButton("Chọn");
        btnOk.setEnabled(false);
        btnOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int currentRow = table.getSelectedRow();
				String name = dtm.getValueAt(currentRow, 0).toString();
				name= xx+"\\"+name+".xls";
				test ts = new test();
				ts.openAndWriteFileExcel(Link,name,1,2);
				frmLaChonDatabase.setVisible(false);
				new v_SelectMT().main(Link);
        	}
        });
        btnOk.setBounds(319, 256, 90, 28);
        frmLaChonDatabase.getContentPane().add(btnOk);
        
        JButton btnong = new JButton("Đóng");
        btnong.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnong.setBounds(25, 256, 90, 28);
        frmLaChonDatabase.getContentPane().add(btnong);
        
        JButton btnNewButton = new JButton("Thêm mới");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// code gọi thêm mới database
        		frmLaChonDatabase.setVisible(false);
        		new v_New_Data().main(Link);
        	}
        });
        btnNewButton.setBounds(220, 256, 90, 28);
        frmLaChonDatabase.getContentPane().add(btnNewButton);
        
        JButton btnDelete = new JButton("Xoá");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
				int check = JOptionPane.showConfirmDialog(frmLaChonDatabase, "Xác nhận xoá?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) {
                	int currentRow = table.getSelectedRow();
    				String name = dtm.getValueAt(currentRow, 0).toString();
    				String name1= xx+"\\"+name+".xls";
    				File file = new File(name1);
    				if(file.delete()){
    					JOptionPane.showMessageDialog(null, "Xoá thành công CSDL : "+name,"Thành công", JOptionPane.INFORMATION_MESSAGE);
    					frmLaChonDatabase.setVisible(false);
    					new v_SelectFile().main(Link);
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "Xoá thành công CSDL : "+name,"Lỗi", JOptionPane.WARNING_MESSAGE);
    				}
                }
        	}
        });
        btnDelete.setBounds(123, 256, 90, 28);
        frmLaChonDatabase.getContentPane().add(btnDelete);
        
        table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDelete.setEnabled(true);
				btnOk.setEnabled(true);
			}
		});
        
	}
}
