package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.Phuongan;
import controller.test;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;



public class v_View_PA_ChuanHoa {

	private JFrame frmDanhSachCac;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static String remove(String xxx)
	{
		
		
		if(!xxx.startsWith("1,0"))
		{
			while(xxx.endsWith("0"))
			{
				if(!xxx.endsWith(".00") || !xxx.endsWith(",00") )
				{
					 int last = xxx.lastIndexOf('0');
					 xxx = xxx.substring(0, last-1);
					 remove(xxx);
				 }
				
			}
		}
		else 
		{
			return "1";
		}
		if(xxx.equals("0,"))
		{xxx="0";}
		return xxx;
	}
	public static void main(int y ,String link,String title,ArrayList<String> nameMTs,ArrayList<String> namePAs,ArrayList<Phuongan> arr) {
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
					v_View_PA_ChuanHoa window = new v_View_PA_ChuanHoa(y,link,title,nameMTs,namePAs,arr);
					window.frmDanhSachCac.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_View_PA_ChuanHoa(int y,String link,String title,ArrayList<String> nameMTs,ArrayList<String> namePAs,ArrayList<Phuongan> arr) {
		
		initialize(y,link,title,nameMTs,namePAs,arr);
	}
	public v_View_PA_ChuanHoa() {
		
		//initialize(title,nameMTs,namePAs,arr);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int y,String link,String title,ArrayList<String> nameMTs,ArrayList<String> namePAs,ArrayList<Phuongan> arr) {
		frmDanhSachCac = new JFrame();
		frmDanhSachCac.setTitle("Danh sách các phương án sau chuẩn hoá");
		frmDanhSachCac.setBounds(750, y, 550, 308);
		frmDanhSachCac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDanhSachCac.getContentPane().setLayout(null);
		frmDanhSachCac.setResizable(false);
		
		String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frmDanhSachCac.setIconImage(imageIcon.getImage());
		test ts = new test();
		String fileName = ts.readFileExcel(link,1,2);
		int len = fileName.length();
		/*int last = fileName.lastIndexOf('\\');
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
        }*/
        
        
      //  frmDanhSachCac.setIconImage(image);
		
		table = new JTable();
		table.setBounds(27, 69, 380+100, 159);
		table.setEnabled(false);
		frmDanhSachCac.getContentPane().add(table);
		
		JLabel lblDanhSachCac = new JLabel(title);
		lblDanhSachCac.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachCac.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDanhSachCac.setBounds(1, 11, 550, 28);
		frmDanhSachCac.getContentPane().add(lblDanhSachCac);
		
		JScrollPane jsc = new JScrollPane(table);
        jsc.setBounds(27, 69, 380+100, 159);
        frmDanhSachCac.getContentPane().add(jsc);
        
        DefaultTableModel dtm = new DefaultTableModel();
        int so_cot = nameMTs.size();
        String [] colsName = new String [so_cot+1];
        colsName[0]="Phương án";
		for(int i=0;i<so_cot;i++)
		{
			colsName[i+1]=nameMTs.get(i);
		}
		
		
		
        dtm.setColumnIdentifiers(colsName);
        //int j = 0; j<nameMTs.size();j++
        for(String mt : namePAs)
        {
        	ArrayList<Phuongan> lst = null;
        	lst = new ArrayList<Phuongan>();
        	for (Phuongan pa : arr) {
        		if(pa.getNamePA().contains(mt))
        		{
        			lst.add(pa);
        		}
    		}
        	String rows[] = new String[so_cot+1];
        	rows[0]=mt;
        	for(int i=1; i<so_cot+1;i++)
        	{
        		Float currency = Float.valueOf(lst.get(i-1).getValue());
	       		String xxx = String.format("%,.10f", currency);
	       		rows[i]=remove(xxx);
        	}
        	dtm.addRow(rows);
        }
        table.setModel(dtm);
        
        JButton btnNewButton = new JButton("Đóng");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frmDanhSachCac.setVisible(false);
        	}
        });
        btnNewButton.setBounds(317+100, 239, 90, 28);
        frmDanhSachCac.getContentPane().add(btnNewButton);
        

	}
}
