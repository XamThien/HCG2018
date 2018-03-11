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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class v_View_PA_ChuanHoa {

	private JFrame frmDanhSachCac;
	private JTable table;

	/**
	 * Launch the application.
	 */
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
		frmDanhSachCac.setTitle("Danh sách các phương án");
		frmDanhSachCac.setBounds(850, y, 450, 308);
		frmDanhSachCac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDanhSachCac.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(27, 69, 380, 159);
		table.setEnabled(false);
		frmDanhSachCac.getContentPane().add(table);
		
		JLabel lblDanhSachCac = new JLabel(title);
		lblDanhSachCac.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachCac.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDanhSachCac.setBounds(34, 11, 373, 28);
		frmDanhSachCac.getContentPane().add(lblDanhSachCac);
		
		JScrollPane jsc = new JScrollPane(table);
        jsc.setBounds(27, 69, 380, 159);
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
        for(String mt : namePAs)
        {
        	ArrayList<Phuongan> lst = new ArrayList<Phuongan>();
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
        		rows[i]=String.valueOf(lst.get(i-1).getValue());
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
        btnNewButton.setBounds(317, 239, 90, 28);
        frmDanhSachCac.getContentPane().add(btnNewButton);
        

	}
}
