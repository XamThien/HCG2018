package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class v_Hodges_Lehmann {

	private JFrame frmPhngPhapHodges;
	private JTextField textField1;

	/**ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs
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
					v_Hodges_Lehmann window = new v_Hodges_Lehmann(namePAs,arr,nameMTs);
					window.frmPhngPhapHodges.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_Hodges_Lehmann() {
		//initialize();
	}
	public v_Hodges_Lehmann(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
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
		frmPhngPhapHodges = new JFrame();
		frmPhngPhapHodges.setTitle("Phương pháp Hodges Lehmann");
		frmPhngPhapHodges.setBounds(100, 100, 450, 333);
		frmPhngPhapHodges.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhngPhapHodges.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p ca\u0301c h\u00EA\u0323 s\u00F4\u0301 sau \u0111\u00E2y :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(27, 27, 385, 204);
		frmPhngPhapHodges.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpHS = new JLabel("Nhập hệ số tin cậy từ 0 -1: ");
		lblNhpHS.setBounds(31, 27, 158, 16);
		panel.add(lblNhpHS);
		
		JLabel lblNhpMc = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		lblNhpMc.setBounds(31, 106, 232, 16);
		panel.add(lblNhpMc);
		
		textField1 = new JTextField();
		textField1.setBounds(31, 55, 316, 39);
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblHpDn = new JLabel(nameMTs.get(0));
		lblHpDn.setBounds(231, 106, 91, 16);
		panel.add(lblHpDn);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setBounds(31, 125, 316, 73);
		panel.add(slider);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
			    // hien thi thuoc do cua slider 0 10 20 30 40 50 ..
			    slider.setLabelTable(slider.createStandardLabels(10));
		
		JButton btnXacNhn = new JButton("Xác nhận ");
		btnXacNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ck = true;
				if (textField1.getText().equals(null) || textField1.getText().equals(""))
				{
					
					JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Hệ Số Tin Cậy !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
					ck = false;
				}
				
				if (ck == true)
				{
					try
					{
						String txt1 = textField1.getText();
						
						if(txt1.contains(","))
						{
							txt1 = txt1.replace(",", ".");
						}
						
						Double lamdatg = Double.parseDouble(txt1);
						double lamdatg1 = lamdatg;
						float lamda = (float)lamdatg1;
						
						double ptg1 = slider.getValue();
						float p = (float)ptg1;
						ArrayList<Float> xacSuat = new ArrayList<Float>();
						xacSuat.add(p);
						boolean ckk = true;
						if (lamda<0 || lamda>=1)
							{
								ckk = false;
								JOptionPane.showMessageDialog(null, "Hệ số tin cậy phải lớn hơn 0 và nhỏ hơn 1 !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
							}
						if (p<=0 || p >100)
						{
							ckk = false;
							JOptionPane.showMessageDialog(null, "Hệ số mức độ xảy ra trạng thái phải từ 0-100 !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
						}
						if(ckk== true)
						{
							PhuongAnList paList = new PhuongAnList();
							String dA = paList.Hodges_Lehmann(lamda, xacSuat, namePAs, arr, nameMTs);
							frmPhngPhapHodges.setVisible(false);
							new ketqua().main(paList.DisplayPA(arr,dA));
						}
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Không đúng định dạng hệ số !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnXacNhn.setBounds(184, 248, 112, 33);
		frmPhngPhapHodges.getContentPane().add(btnXacNhn);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmPhngPhapHodges, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmPhngPhapHodges.setVisible(false);
                }
			}
		});
		btnThoat.setBounds(300, 248, 112, 33);
		frmPhngPhapHodges.getContentPane().add(btnThoat);
	}
	private void initialize2(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmPhngPhapHodges = new JFrame();
		frmPhngPhapHodges.setTitle("Phương pháp Hodges Lehmann");
		frmPhngPhapHodges.setBounds(100, 100, 450, 460);
		frmPhngPhapHodges.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhngPhapHodges.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p ca\u0301c h\u00EA\u0323 s\u00F4\u0301 sau \u0111\u00E2y :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(27, 27, 385, 298);
		frmPhngPhapHodges.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpHS = new JLabel("Nhập hệ số tin cậy từ 0 -1: ");
		lblNhpHS.setBounds(31, 27, 158, 16);
		panel.add(lblNhpHS);
		
		JLabel lblNhpMc = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		lblNhpMc.setBounds(31, 106, 232, 16);
		panel.add(lblNhpMc);
		
		textField1 = new JTextField();
		textField1.setBounds(31, 55, 316, 39);
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblHpDn = new JLabel(nameMTs.get(0));
		lblHpDn.setBounds(231, 106, 91, 16);
		panel.add(lblHpDn);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setBounds(31, 125, 316, 73);
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
		slider_1.setBounds(31, 219, 316, 73);
		panel.add(slider_1);
		
		JLabel label = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		label.setBounds(31, 200, 232, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel(nameMTs.get(1));
		label_1.setBounds(231, 200, 91, 16);
		panel.add(label_1);
		
			    // hien thi thuoc do cua slider 0 10 20 30 40 50 ..
			    slider.setLabelTable(slider.createStandardLabels(10));
		
		JButton btnXacNhn = new JButton("Xác nhận ");
		btnXacNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ck = true;
				if (textField1.getText().equals(null) || textField1.getText().equals(""))
				{
					
					JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Hệ Số Tin Cậy !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
					ck = false;
				}
				
				if (ck == true)
				{
					try
					{
						String txt1 = textField1.getText();
						
						if(txt1.contains(","))
						{
							txt1 = txt1.replace(",", ".");
						}
						
						Double lamdatg = Double.parseDouble(txt1);
						double lamdatg1 = lamdatg;
						float lamda = (float)lamdatg1;
//						Double ptg = Double.parseDouble(txt2);
//						double ptg1 = ptg;
						
						float p1 = (float)slider.getValue();
						float p2 = (float)slider_1.getValue();
						ArrayList<Float> xacSuat = new ArrayList<Float>();
						xacSuat.add(p1);
						xacSuat.add(p2);
						boolean ckk = true;
						if (lamda<0 || lamda>=1)
							{
								ckk = false;
								JOptionPane.showMessageDialog(null, "Hệ số tin cậy phải lớn hơn 0 và nhỏ hơn 1 !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
							}
						
						if(ckk== true)
						{
							PhuongAnList paList = new PhuongAnList();
							String dA = paList.Hodges_Lehmann(lamda, xacSuat, namePAs, arr, nameMTs);
							frmPhngPhapHodges.setVisible(false);
							new ketqua().main(paList.DisplayPA(arr,dA));
						}
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Không đúng định dạng hệ số !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnXacNhn.setBounds(184, 337, 112, 33);
		frmPhngPhapHodges.getContentPane().add(btnXacNhn);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmPhngPhapHodges, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmPhngPhapHodges.setVisible(false);
                }
			}
		});
		btnThoat.setBounds(300, 337, 112, 33);
		frmPhngPhapHodges.getContentPane().add(btnThoat);
	}
	private void initialize3(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmPhngPhapHodges = new JFrame();
		frmPhngPhapHodges.setTitle("Phương pháp Hodges Lehmann");
		frmPhngPhapHodges.setBounds(100, 100, 450, 496);
		frmPhngPhapHodges.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhngPhapHodges.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p ca\u0301c h\u00EA\u0323 s\u00F4\u0301 sau \u0111\u00E2y :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(27, 27, 385, 383);
		frmPhngPhapHodges.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpHS = new JLabel("Nhập hệ số tin cậy từ 0 -1: ");
		lblNhpHS.setBounds(31, 27, 158, 16);
		panel.add(lblNhpHS);
		
		JLabel lblNhpMc = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		lblNhpMc.setBounds(31, 106, 232, 16);
		panel.add(lblNhpMc);
		
		textField1 = new JTextField();
		textField1.setBounds(31, 55, 316, 39);
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblHpDn = new JLabel(nameMTs.get(0));
		lblHpDn.setBounds(231, 106, 91, 16);
		panel.add(lblHpDn);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setBounds(31, 125, 316, 73);
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
		slider_1.setBounds(31, 210, 316, 73);
		panel.add(slider_1);
		
		JLabel label = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		label.setBounds(31, 200, 232, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel(nameMTs.get(1));
		label_1.setBounds(231, 200, 91, 16);
		panel.add(label_1);
		
		JSlider slider_2 = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 50);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMajorTickSpacing(10);
		slider_2.setBounds(31, 304, 316, 73);
		panel.add(slider_2);
		
		JLabel label_2 = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
		label_2.setBounds(31, 285, 232, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel(nameMTs.get(2));
		label_3.setBounds(231, 285, 91, 16);
		panel.add(label_3);
		
			    // hien thi thuoc do cua slider 0 10 20 30 40 50 ..
			    slider.setLabelTable(slider.createStandardLabels(10));
		
		JButton btnXacNhn = new JButton("Xác nhận ");
		btnXacNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ck = true;
				if (textField1.getText().equals(null) || textField1.getText().equals(""))
				{
					
					JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Hệ Số Tin Cậy !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
					ck = false;
				}
				
				if (ck == true)
				{
					try
					{
						String txt1 = textField1.getText();
						
						if(txt1.contains(","))
						{
							txt1 = txt1.replace(",", ".");
						}
						
						Double lamdatg = Double.parseDouble(txt1);
						double lamdatg1 = lamdatg;
						float lamda = (float)lamdatg1;
//						Double ptg = Double.parseDouble(txt2);
//						double ptg1 = ptg;
						float p1 = (float)slider.getValue();
						float p2 = (float)slider_1.getValue();
						float p3 = (float)slider_2.getValue();
						ArrayList<Float> xacSuat = new ArrayList<Float>();
						xacSuat.add(p1);
						xacSuat.add(p2);
						xacSuat.add(p3);
						boolean ckk = true;
						if (lamda<0 || lamda>=1)
							{
								ckk = false;
								JOptionPane.showMessageDialog(null, "Hệ số tin cậy phải lớn hơn 0 và nhỏ hơn 1 !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
							}
						
						if(ckk== true)
						{
							PhuongAnList paList = new PhuongAnList();
							String dA = paList.Hodges_Lehmann(lamda, xacSuat, namePAs, arr, nameMTs);
							frmPhngPhapHodges.setVisible(false);
							new ketqua().main(paList.DisplayPA(arr,dA));
						}
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Không đúng định dạng hệ số !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnXacNhn.setBounds(184, 422, 112, 33);
		frmPhngPhapHodges.getContentPane().add(btnXacNhn);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmPhngPhapHodges, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmPhngPhapHodges.setVisible(false);
                }
			}
		});
		btnThoat.setBounds(300, 422, 112, 33);
		frmPhngPhapHodges.getContentPane().add(btnThoat);
	}
}
