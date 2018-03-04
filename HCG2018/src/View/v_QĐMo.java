package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;

import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class v_QĐMo {

	private JFrame frmChnThi;

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
					v_QĐMo window = new v_QĐMo(namePAs,arr,nameMTs);
					window.frmChnThi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**namePAs,arr,nameMTs
	 * Create the application.
	 */
	public v_QĐMo(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		initialize(namePAs,arr,nameMTs);
	}
	public v_QĐMo() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmChnThi = new JFrame();
		frmChnThi.setTitle("Chọn thái độ muốn quyết định");
		frmChnThi.setBounds(100, 100, 509, 300);
		frmChnThi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChnThi.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "L\u01B0\u0323a cho\u0323n tra\u0323ng tha\u0301i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(37, 31, 422, 158);
		frmChnThi.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 10, 50, 30);
		slider.setBounds(42, 45, 345, 73);
		panel.add(slider);
		slider.setMinorTickSpacing(10);
		//slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		JLabel lblBiQuan = new JLabel("Bi quan");
		lblBiQuan.setBounds(23, 45, 55, 16);
		panel.add(lblBiQuan);
		
		JLabel lblTrungGian = new JLabel("Trung gian");
		lblTrungGian.setBounds(185, 45, 68, 16);
		panel.add(lblTrungGian);
		
		JLabel lblLacQuan = new JLabel("Lạc quan");
		lblLacQuan.setBounds(350, 45, 55, 16);
		panel.add(lblLacQuan);
		
		// hien thi thuoc do cua slider 0 10 20 30 40 50 ..
		//slider.setLabelTable(slider.createStandardLabels(10));
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = 0;
				if (slider.getValue()==10)
				{
					sel = 1;
				}
				if (slider.getValue()==30)
				{
					sel = 3;
				}
				if (slider.getValue()==50)
				{
					sel = 5;
				}
				if (slider.getValue()>10 && slider.getValue()<30)
				{
					sel = 2;
				}
				if (slider.getValue()>30 && slider.getValue()<50)
				{
					sel = 4;
				}
				PhuongAnList paList = new PhuongAnList();
				String dA = "";
				switch (sel)
				{
				case 1:
					frmChnThi.setVisible(false);
					dA=paList.Maximin(namePAs,arr);
					new ketqua().main(paList.DisplayPA(arr,dA));
					break;
				case 2:
					dA = paList.QDMoBTG(namePAs,arr);
					frmChnThi.setVisible(false);
					new ketqua().main(paList.DisplayPA(arr,dA));
					break;
				case 3:
					frmChnThi.setVisible(false);
					new v_QDMoTG().main(namePAs,arr,nameMTs);
					break;
				case 4:
					dA = paList.QDMoTGL(namePAs,arr);
					frmChnThi.setVisible(false);
					new ketqua().main(paList.DisplayPA(arr,dA));
					break;
				case 5:
					frmChnThi.setVisible(false);
					dA=paList.Maximax(namePAs,arr);
					new ketqua().main(paList.DisplayPA(arr,dA));
					break;
				}
				
			}
		});
		btnNewButton.setBounds(233, 210, 113, 37);
		frmChnThi.getContentPane().add(btnNewButton);
		
		JButton btnong = new JButton("Đóng");
		btnong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmChnThi, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmChnThi.setVisible(false);
                }
			}
		});
		btnong.setBounds(358, 210, 104, 37);
		frmChnThi.getContentPane().add(btnong);
		
		
		
		
	}
}
