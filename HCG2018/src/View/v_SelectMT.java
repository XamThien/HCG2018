package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;
import controller.test;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class v_SelectMT {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String link) {
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
					v_SelectMT window = new v_SelectMT( link);
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
	
	public v_SelectMT(String link) {
		PhuongAnList paList = new PhuongAnList();
		test ts = new test();
		String fileName = ts.readFileExcel(link);
		paList.ReadFromExcel(fileName);
		 ArrayList<String> nameMTs = new ArrayList<>();
		 ArrayList<String> namePAs = new ArrayList<>();
		 ArrayList<Phuongan> arr = new ArrayList<Phuongan>();
		 String name_de_tai = paList.getNameDSS(); 
		 arr = paList.getArr();
		 nameMTs = paList.getNameMTs();
		 namePAs = paList.getNamePAs();
		
		initialize(link, paList,name_de_tai, nameMTs, namePAs, arr);
		new v_View_PA().main(100,link,"Danh sách các phương án", nameMTs, namePAs, arr);
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public v_SelectMT() {
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String link,PhuongAnList paList,String name_de_tai,ArrayList<String> nameMTs,ArrayList<String> namePAs,ArrayList<Phuongan> arr) {
		
		
		frame = new JFrame();
		frame.setTitle("Hệ Chuyên Gia 2018");
		int sl_mt = nameMTs.size();
		int so_dong = sl_mt / 3;
		int so_du_dong = sl_mt % 3 ; 
		if(so_du_dong!=0)
		{
			so_dong =so_dong +1;
		}
		
		frame.setBounds(400, 100, 592, 293+(so_dong-1)*40);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnMmH.setBounds(67, 18, 402, 43);
		frame.getContentPane().add(lblPhnMmH);
		
		JLabel lblDanhSachChon = new JLabel("Danh sách các mục tiêu chọn lựa cho việc");
		lblDanhSachChon.setBounds(123, 60, 237, 14);
		frame.getContentPane().add(lblDanhSachChon);
		
		JLabel lbliDuLich = new JLabel(name_de_tai.toLowerCase());
		lbliDuLich.setBounds(357, 59, 91, 16);
		frame.getContentPane().add(lbliDuLich);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ca\u0301c mu\u0323c ti\u00EAu l\u01B0\u0323a cho\u0323n :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(35, 105, 502, 70+(so_dong-1)*40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		int dem = 0;
		ArrayList<JCheckBox> hihi = new ArrayList<JCheckBox>();
		for(int j = 0; j < so_dong;j++)
		{
			for(int i = 0;i<3;i++)
			{
				
				JCheckBox chckbx1 = new JCheckBox(nameMTs.get(dem));
				chckbx1.setBounds(37+i*160, 29+j*40, 104, 18);
				panel.add(chckbx1);
				hihi.add(chckbx1);
				dem++;
				if(dem+1 > nameMTs.size())
				{
					break;
				}
			}
		}
		
		
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String strch="";
				boolean ck = false;
				for(JCheckBox x : hihi)
				{
					if(x.isSelected())
					{
						ck= true;
					}
				}
				
				if(ck== true)
				{
					for(int i=0;i<hihi.size();i++)
					{
						JCheckBox x =hihi.get(i);
						if(x.isSelected())
						{
							if(strch.equals(""))
							{
								strch=String.valueOf(i);
							}
							else
							{
								strch+=","+String.valueOf(i);
							}
							
							
						}
					}
					frame.setVisible(false);
					new OpenApp().main(link,name_de_tai,strch);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn mục tiêu","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				
				//paList.Choose(strch);
				//OptionPane.showMessageDialog(null, strch,"Lỗi", JOptionPane.ERROR_MESSAGE);
				
				
			}
		});
		btnNewButton.setBounds(418, 196+(so_dong-1)*40, 114, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewMT = new JButton("Thêm mục tiêu");
		btnNewMT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				test ts = new test();
//				String fileName = ts.readFileExcel(link);
//				frame.setVisible(false);
//				new v_Add_PA().main(fileName, nameMTs);
				
				//JOptionPane.showMessageDialog(null, "Chưa có gì hihi","Lỗi", JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				new v_AddNewMT().main(namePAs, link);
				
			}
		});
		btnNewMT.setBounds(289, 196+(so_dong-1)*40, 114, 36);
		frame.getContentPane().add(btnNewMT);
		
		JButton btnChuyen = new JButton("Chuyển CSDL");
		btnChuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) 
				{
					String path = fileChooser.getSelectedFile().getAbsolutePath();
			        
			        if (path!=null)
			        {
			        	String cklink = path;
			        	if(test.checkFileExcel(cklink))
			        	{
			        		//textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			        		test.writeNewFileExcel(link,cklink);
			        		frame.setVisible(false);
			        		new v_SelectMT().main(link);
			        	}
			        	else
			        	{
			        		JOptionPane.showMessageDialog(null, "Folder không chứa các file cần thiết","Lỗi", JOptionPane.ERROR_MESSAGE);
			        	}
			        }
				}
				else {
			    	JOptionPane.showMessageDialog(null, "Chưa chọn vị trí tệp","Lỗi", JOptionPane.ERROR_MESSAGE);
			    	//new BeforeOpenApp().main(null);
			      }
				
			}
		});
		btnChuyen.setBounds(160, 196+(so_dong-1)*40, 114, 36);
		frame.getContentPane().add(btnChuyen);
		
		JButton btnNewCSDL = new JButton("Thêm CSDL");
		btnNewCSDL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new v_New_Data().main(link);
				
			}
		});
		btnNewCSDL.setBounds(32, 196+(so_dong-1)*40, 114, 36);
		frame.getContentPane().add(btnNewCSDL);
	}
}
