package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class v_QDMoTG {

	private JFrame frmTrngThiTrung;

	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
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
					//namePAs,arr,nameMTs
					v_QDMoTG window = new v_QDMoTG(namePAs,arr,nameMTs);
					window.frmTrngThiTrung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_QDMoTG() {
		//initialize();
	}
	public v_QDMoTG(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		int sel = nameMTs.size();
		if (sel ==1)
		{
			initialize(namePAs,arr,nameMTs);
		}
		if (sel ==2)
		{
			initialize2(namePAs,arr,nameMTs);
		}
		if (sel ==3)
		{
			initialize3(namePAs,arr,nameMTs);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmTrngThiTrung = new JFrame();
		frmTrngThiTrung.setTitle("Phương pháp quyết định mờ trung gian");
		frmTrngThiTrung.setBounds(100, 100, 450, 300);
		frmTrngThiTrung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrngThiTrung.getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmTrngThiTrung, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmTrngThiTrung.setVisible(false);
                }
			}
		});
		btnNewButton_1.setBounds(278, 182, 117, 36);
		frmTrngThiTrung.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.setBounds(145, 182, 126, 36);
		frmTrngThiTrung.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p ca\u0301c h\u00EA\u0323 s\u00F4\u0301 sau \u0111\u00E2y:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(15, 26, 380, 144);
		frmTrngThiTrung.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpMc = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		lblNhpMc.setBounds(21, 31, 232, 16);
		panel.add(lblNhpMc);
		/*nameMTs.get(0)*/
		JLabel lblHpDn = new JLabel(nameMTs.get(0));
		lblHpDn.setBounds(221, 31, 91, 16);
		panel.add(lblHpDn);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setBounds(21, 50, 338, 73);
		panel.add(slider);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
			    // hien thi thuoc do cua slider 0 10 20 30 40 50 ..
			    slider.setLabelTable(slider.createStandardLabels(10));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float p = (float)slider.getValue();
				ArrayList<Float> trongSo = new ArrayList<Float>();
				trongSo.add(p);
				
				PhuongAnList paList = new PhuongAnList();
				String dA = paList.QDMoTG(trongSo, namePAs, arr, nameMTs);
				frmTrngThiTrung.setVisible(false);
				new ketqua().main(paList.DisplayPA(arr,dA));
			}
		});
	}
	private void initialize2(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmTrngThiTrung = new JFrame();
		frmTrngThiTrung.setTitle("Phương pháp quyết định mờ trung gian");
		frmTrngThiTrung.setBounds(100, 100, 450, 355);
		frmTrngThiTrung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrngThiTrung.getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmTrngThiTrung, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmTrngThiTrung.setVisible(false);
                }
			}
		});
		btnNewButton_1.setBounds(290, 262, 117, 36);
		frmTrngThiTrung.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.setBounds(157, 262, 126, 36);
		frmTrngThiTrung.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p ca\u0301c h\u00EA\u0323 s\u00F4\u0301 sau \u0111\u00E2y:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(27, 25, 380, 224);
		frmTrngThiTrung.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpMc = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		lblNhpMc.setBounds(21, 31, 232, 16);
		panel.add(lblNhpMc);
		/*nameMTs.get(0)*/
		JLabel lblHpDn = new JLabel(nameMTs.get(0));
		lblHpDn.setBounds(221, 31, 91, 16);
		panel.add(lblHpDn);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setBounds(21, 50, 338, 73);
		panel.add(slider);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		JSlider slider_1 = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 50);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMajorTickSpacing(10);
		slider_1.setBounds(21, 141, 338, 73);
		panel.add(slider_1);
		
		JLabel label = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		label.setBounds(21, 122, 232, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel(nameMTs.get(1));
		label_1.setBounds(221, 122, 91, 16);
		panel.add(label_1);
		
			    // hien thi thuoc do cua slider 0 10 20 30 40 50 ..
			    slider.setLabelTable(slider.createStandardLabels(10));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float p = (float)slider.getValue();
				float p1 = (float)slider_1.getValue();
				ArrayList<Float> trongSo = new ArrayList<Float>();
				trongSo.add(p);
				trongSo.add(p1);

				PhuongAnList paList = new PhuongAnList();
				String dA = paList.QDMoTG(trongSo, namePAs, arr, nameMTs);
				frmTrngThiTrung.setVisible(false);
				new ketqua().main(paList.DisplayPA(arr,dA));
				
			}
		});
	}
	private void initialize3(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmTrngThiTrung = new JFrame();
		frmTrngThiTrung.setTitle("Phương pháp quyết định mờ trung gian");
		frmTrngThiTrung.setBounds(100, 100, 450, 443);
		frmTrngThiTrung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrngThiTrung.getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmTrngThiTrung, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmTrngThiTrung.setVisible(false);
                }
			}
		});
		btnNewButton_1.setBounds(289, 356, 117, 36);
		frmTrngThiTrung.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.setBounds(156, 356, 126, 36);
		frmTrngThiTrung.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p ca\u0301c h\u00EA\u0323 s\u00F4\u0301 sau \u0111\u00E2y:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(27, 25, 380, 319);
		frmTrngThiTrung.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpMc = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		lblNhpMc.setBounds(21, 31, 232, 16);
		panel.add(lblNhpMc);
		/*nameMTs.get(0)*/
		JLabel lblHpDn = new JLabel(nameMTs.get(0));
		lblHpDn.setBounds(221, 31, 91, 16);
		panel.add(lblHpDn);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setBounds(21, 50, 338, 73);
		panel.add(slider);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		JSlider slider_1 = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 50);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMajorTickSpacing(10);
		slider_1.setBounds(21, 141, 338, 77);
		panel.add(slider_1);
		
		JLabel label = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		label.setBounds(21, 122, 232, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel(nameMTs.get(1));
		label_1.setBounds(221, 122, 91, 16);
		panel.add(label_1);
		
		JSlider slider_2 = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 50);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMajorTickSpacing(10);
		slider_2.setBounds(21, 236, 338, 77);
		panel.add(slider_2);
		
		JLabel label_2 = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		label_2.setBounds(21, 217, 232, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel(nameMTs.get(2));
		label_3.setBounds(221, 217, 91, 16);
		panel.add(label_3);
		
			    // hien thi thuoc do cua slider 0 10 20 30 40 50 ..
			    slider.setLabelTable(slider.createStandardLabels(10));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float p = (float)slider.getValue();
				float p1 = (float)slider_1.getValue();
				float p2 = (float)slider_2.getValue();
				ArrayList<Float> trongSo = new ArrayList<Float>();
				trongSo.add(p);
				trongSo.add(p1);
				trongSo.add(p2);

				PhuongAnList paList = new PhuongAnList();
				String dA = paList.QDMoTG(trongSo, namePAs, arr, nameMTs);
				frmTrngThiTrung.setVisible(false);
				new ketqua().main(paList.DisplayPA(arr,dA));
			}
		});
	}
}
