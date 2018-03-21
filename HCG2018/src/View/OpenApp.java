package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;
import controller.test;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JCheckBox;

public class OpenApp {

	private JFrame frmHChuynGia;

	/**
	 * Launch the application.
	 */
	public static void main(String saveLink,String link,String name_de_tai,String strch) {
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
					OpenApp window = new OpenApp(saveLink,link,name_de_tai,strch);
					window.frmHChuynGia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OpenApp(String saveLink,String link,String name_de_tai,String strch/*,ArrayList<String> nameMTs,ArrayList<String> namePAs,ArrayList<Phuongan> arr*/) {
		
		initialize(saveLink,link,name_de_tai,strch);
	}
	public OpenApp() {
		//initialize(paList,name_de_tai, nameMTs, namePAs, arr);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String saveLink,String link,String name_de_tai,String strch) {
		
		 
		frmHChuynGia = new JFrame();
		frmHChuynGia.setTitle("Hệ Chuyên Gia 2018");
		frmHChuynGia.setBounds(400, 100, 592, 413);
		frmHChuynGia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHChuynGia.getContentPane().setLayout(null);
		frmHChuynGia.setResizable(false);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnMmH.setBounds(67+50, 18, 402, 43);
		frmHChuynGia.getContentPane().add(lblPhnMmH);
		
		JLabel lblDanhSachChon = new JLabel("Danh sách các mục tiêu chọn lựa cho việc");
		lblDanhSachChon.setBounds(123+50, 60, 237, 14);
		frmHChuynGia.getContentPane().add(lblDanhSachChon);
		
		JLabel lbliDuLich = new JLabel(name_de_tai.toLowerCase());
		lbliDuLich.setBounds(357+50, 59, 91, 16);
		frmHChuynGia.getContentPane().add(lbliDuLich);
		
		test ts = new test();
		String fileName = link;
		int len = fileName.length();
		/*int last = fileName.lastIndexOf('\\');
		String folderName = fileName.substring( 0,last+1);
		BufferedImage image = null;
        try
        {
        	
          //image = ImageIO.read(new File(folderName+"image.png"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }*/
        
     //   frmHChuynGia.setIconImage(image);
       // ImageIcon imageIcon = new ImageIcon(image);
        String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frmHChuynGia.setIconImage(imageIcon.getImage());
        frmHChuynGia.getContentPane().setLayout(null);
		JLabel jLabel = new JLabel();
		jLabel.setBounds(38+45, 18, 82, 73);
		frmHChuynGia.getContentPane().add(jLabel);
		jLabel.setIcon(imageIcon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Ph\u01B0\u01A1ng pha\u0301p l\u01B0\u0323a cho\u0323n :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(38, 103, 502, 198);
		frmHChuynGia.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton pp_rd1 = new JRadioButton("Phương Pháp Maximin");
		pp_rd1.setBounds(22, 35, 210, 18);
		panel_1.add(pp_rd1);
		
		JRadioButton pp_rd2 = new JRadioButton("Phương Pháp Maximax");
		pp_rd2.setBounds(22, 74, 210, 18);
		panel_1.add(pp_rd2);
		
		JRadioButton pp_rd3 = new JRadioButton("Phương Pháp HURWICZ");
		pp_rd3.setBounds(22, 111, 210, 18);
		panel_1.add(pp_rd3);
		
		JRadioButton pp_rd5 = new JRadioButton("Phương Pháp BAYES");
		pp_rd5.setBounds(244, 35, 236, 18);
		panel_1.add(pp_rd5);
		
		JRadioButton pp_rd6 = new JRadioButton("Phương Pháp LAPACE");
		pp_rd6.setBounds(244, 74, 236, 18);
		panel_1.add(pp_rd6);
		
		JRadioButton pp_rd7 = new JRadioButton("Phương Pháp HODGES-LEHMANN");
		pp_rd7.setBounds(244, 111, 236, 18);
		panel_1.add(pp_rd7);
		
		JRadioButton pp_rd4 = new JRadioButton("Phương Pháp SAVAGE-NIEHANS");
		pp_rd4.setBounds(22, 150, 210, 18);
		panel_1.add(pp_rd4);
		
		JRadioButton pp_rd8 = new JRadioButton("Phương Pháp Quyết Định Mờ");
		pp_rd8.setBounds(244, 150, 236, 18);
		panel_1.add(pp_rd8);
		
		ButtonGroup btnGroup2 = new ButtonGroup();
		btnGroup2.add(pp_rd1);
		btnGroup2.add(pp_rd2);
		btnGroup2.add(pp_rd3);
		btnGroup2.add(pp_rd4);
		btnGroup2.add(pp_rd5);
		btnGroup2.add(pp_rd6);
		btnGroup2.add(pp_rd7);
		btnGroup2.add(pp_rd8);
		
		JButton btnNewButton = new JButton("Kết Quả");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PhuongAnList paList = new PhuongAnList();
				test ts = new test();
				String fileName = link;
				paList.ReadFromExcel(fileName);
				 ArrayList<String> nameMTs = new ArrayList<>();
				 ArrayList<String> nameMTs_root = new ArrayList<>();
				 nameMTs_root = paList.getNameMTs();
				 ArrayList<String> namePAs = new ArrayList<>();
				 ArrayList<String> namePAs_root = new ArrayList<>();
				 namePAs_root = paList.getNamePAs();
				 ArrayList<Phuongan> arr = new ArrayList<Phuongan>();
				 paList.Choose(strch);
				 arr = paList.getArr();
				 nameMTs = paList.getNameMTs();
				 namePAs = paList.getNamePAs();
				 
				
				// check panel 2 ==========================================================================================================
				
				int dem2=0;
				for (Enumeration<AbstractButton> buttons = btnGroup2.getElements(); buttons.hasMoreElements();) {
		            AbstractButton button = buttons.nextElement();
		            if (!button.isSelected()) {
		                dem2++;
		            }
		        }
				if(dem2==btnGroup2.getButtonCount())
				{
					JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Phương Pháp Lựa Chọn!!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				// Thực hiện chương trình ================================================================================================
				if (dem2 != btnGroup2.getButtonCount())
				{
					String dA = "";
					 
					 
					 
					 
					 if (pp_rd1.isSelected())
					 {
						 dA=paList.Maximin(namePAs,arr);
						 new ketqua().main(arr,dA);
					 }
					 if (pp_rd2.isSelected())
					 {
						 dA=paList.Maximax(namePAs,arr);
						 new ketqua().main(arr,dA);
					 }
					 if (pp_rd3.isSelected())
					 {
						
						 new v_HURWICZ().main(namePAs,arr);
					 }
					 if (pp_rd4.isSelected())
					 {
						 dA=paList.Savage_Niehans(namePAs,arr,nameMTs);
						 new ketqua().main(arr,dA);
					 }
					 if (pp_rd5.isSelected())
					 {
						 new v_Bayes().main(namePAs,arr,nameMTs);
					 }
					 if (pp_rd6.isSelected())
					 {
						 dA=paList.Laplace(namePAs,arr,nameMTs);
						 new ketqua().main(arr,dA);
					 }
					 if (pp_rd7.isSelected())
					 {
						 new v_Hodges_Lehmann().main(namePAs,arr,nameMTs);
					 }
					 if (pp_rd8.isSelected())
					 {
						 ArrayList<Phuongan>arr1 = new ArrayList<Phuongan>();
							if (!paList.KtraChuanhoa(paList.getArrGoc())) {
								arr1 = paList.Chuanhoa(paList.getArrGoc(), paList.getNameMTsGoc());
								new v_View_PA_ChuanHoa().main(420,saveLink,"Danh sách các phương án sau chuẩn hoá", nameMTs_root, namePAs_root, arr1);
							
							} else arr1 = paList.getArrGoc();
						
						 new v_QĐMo().main(namePAs,arr1,nameMTs);
						 
					 }
				}
			}
		});
		btnNewButton.setBounds(352, 313, 133, 34);
		frmHChuynGia.getContentPane().add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("Trở về");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmHChuynGia.setVisible(false);
				new v_SelectMT().main(saveLink);
			}
		});
		btnNewButton1.setBounds(199, 313, 133, 34);
		frmHChuynGia.getContentPane().add(btnNewButton1);
	}
}
