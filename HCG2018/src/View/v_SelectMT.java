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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class v_SelectMT {

	private JFrame frame;

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
					v_SelectMT window = new v_SelectMT( Link);
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
	
	public v_SelectMT(String Link) {
		PhuongAnList paList = new PhuongAnList();
		test ts = new test();
		String fileName = ts.readFileExcel(Link,1,2);
		paList.ReadFromExcel(fileName);
		 ArrayList<String> nameMTs = new ArrayList<>();
		 ArrayList<String> namePAs = new ArrayList<>();
		 ArrayList<Phuongan> arr = new ArrayList<Phuongan>();
		 String name_de_tai = paList.getNameDSS(); 
		 arr = paList.getArr();
		 nameMTs = paList.getNameMTs();
		 namePAs = paList.getNamePAs();
		
		initialize(Link,fileName, paList,name_de_tai, nameMTs, namePAs, arr);
		new v_View_PA().main(100,Link,"Danh sách các phương án", nameMTs, namePAs, arr);
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
	private void initialize(String Link,String link,PhuongAnList paList,String name_de_tai,ArrayList<String> nameMTs,ArrayList<String> namePAs,ArrayList<Phuongan> arr) {
		
		
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
		//frame.getContentPane().setBackground(new Color(255,255,255));
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnMmH.setBounds(67+50, 18, 402, 43);
		frame.getContentPane().add(lblPhnMmH);
		
		JLabel lblDanhSachChon = new JLabel("Danh sách các mục tiêu chọn lựa cho việc");
		lblDanhSachChon.setBounds(123+50, 60, 237, 14);
		frame.getContentPane().add(lblDanhSachChon);
		
		JLabel lbliDuLich = new JLabel(name_de_tai.toLowerCase());
		lbliDuLich.setBounds(357+50, 59, 91, 16);
		frame.getContentPane().add(lbliDuLich);
		
		test ts = new test();
		String fileName = link;
		int len = fileName.length();
		int last = fileName.lastIndexOf('\\');
		String folderName = fileName.substring( 0,last+1);
		/*BufferedImage image = null;
        try
        {
        	
          image = ImageIO.read(new File(folderName+"image.png"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }
        
        frame.setIconImage(image);
        ImageIcon imageIcon = new ImageIcon(image);*/
		String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frame.setIconImage(imageIcon.getImage());
        frame.getContentPane().setLayout(null);
		JLabel jLabel = new JLabel();
		jLabel.setBounds(38+45, 18, 82, 73);
		frame.getContentPane().add(jLabel);
		jLabel.setIcon(imageIcon);
		jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		
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
					new OpenApp().main(Link,link,name_de_tai,strch);
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
				new v_AddNewMT().main(namePAs, Link);
				
			}
		});
		btnNewMT.setBounds(289, 196+(so_dong-1)*40, 114, 36);
		frame.getContentPane().add(btnNewMT);
		
		JButton btnChuyen = new JButton("Chuyển CSDL");
		btnChuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				new v_SelectFile().main(Link);
			}
		});
		btnChuyen.setBounds(160, 196+(so_dong-1)*40, 114, 36);
		frame.getContentPane().add(btnChuyen);
		
//		JButton btnNewCSDL = new JButton("Làm mới");
//		btnNewCSDL.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.setVisible(false);
//				new v_SelectMT().main(Link);
//				
//			}
//		});
//		btnNewCSDL.setBounds(32, 196+(so_dong-1)*40, 114, 36);
//		frame.getContentPane().add(btnNewCSDL);
	}
}
