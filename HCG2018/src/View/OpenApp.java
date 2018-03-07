package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
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
	public static void main(String[] args) {
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
					OpenApp window = new OpenApp();
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
	public OpenApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHChuynGia = new JFrame();
		frmHChuynGia.setTitle("Hệ Chuyên Gia 2018");
		frmHChuynGia.setBounds(400, 100, 592, 504);
		frmHChuynGia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHChuynGia.getContentPane().setLayout(null);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnMmH.setBounds(67, 18, 402, 43);
		frmHChuynGia.getContentPane().add(lblPhnMmH);
		
		JLabel lblDanhSachChon = new JLabel("Danh sách các mục tiêu chọn lựa cho việc đi làm");
		lblDanhSachChon.setBounds(132, 60, 293, 14);
		frmHChuynGia.getContentPane().add(lblDanhSachChon);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ca\u0301c mu\u0323c ti\u00EAu l\u01B0\u0323a cho\u0323n :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(35, 105, 502, 72);
		frmHChuynGia.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JCheckBox chckbx1 = new JCheckBox("Lương");
		chckbx1.setBounds(37, 29, 104, 18);
		panel.add(chckbx1);
		
		JCheckBox chckbx2 = new JCheckBox("Gần nhà");
		chckbx2.setBounds(198, 28, 104, 18);
		panel.add(chckbx2);
		
		JCheckBox chckbx3 = new JCheckBox("Độ hấp dẫn");
		chckbx3.setBounds(355, 29, 104, 18);
		panel.add(chckbx3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Ph\u01B0\u01A1ng pha\u0301p l\u01B0\u0323a cho\u0323n :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(35, 206, 502, 198);
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
				// check panel 1============================================================================================================
				
				boolean ck = true;
				if(!chckbx1.isSelected() && !chckbx2.isSelected() && !chckbx3.isSelected())
				{
					ck = false;
					JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Các Mục Tiêu Lựa Chọn!!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				
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
				if (ck == true && dem2 != btnGroup2.getButtonCount())
				{
					String dA = "";
					 ArrayList<String> nameMTs = new ArrayList<>();
					 ArrayList<String> namePAs = new ArrayList<>();
					 ArrayList<Phuongan> arr = new ArrayList<Phuongan>();
					 
					 test ts = new test();
					 
					 String fileName = ts.readFileExcel("G:\\Link.xls");
					 PhuongAnList paList = new PhuongAnList();
					 
					 
					 paList.ReadFromExcel(fileName);
					 
					 String strchs = "";
					 if (chckbx1.isSelected())
					 {
						 	 strchs+="0";
					 }
					 if (chckbx2.isSelected())
					 {
						 if(strchs.equals(""))
						 {
							 strchs+="1";
						 }
						 else
						 {
							 strchs+=" 1";
						 }
					 }
					 if (chckbx3.isSelected())
					 {
						 if(strchs.equals(""))
						 {
							 strchs+="2";
						 }
						 else
						 {
							 strchs+=" 2";
						 }
					 }
					 paList.Choose(strchs);
					 arr = paList.getArr();
					 nameMTs = paList.getNameMTs();
					 namePAs = paList.getNamePAs();
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
						 new v_QĐMo().main(namePAs,arr,nameMTs);
					 }
				}
			}
		});
		btnNewButton.setBounds(349, 416, 133, 34);
		frmHChuynGia.getContentPane().add(btnNewButton);
	}
}
