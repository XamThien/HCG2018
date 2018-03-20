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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class v_QĐMo {

	private JFrame frmChnThi;

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
					v_QĐMo window = new v_QĐMo(namePAs,arr,nameMTs);
					window.frmChnThi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_QĐMo(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		initialize(namePAs,arr,nameMTs);
	}
	public v_QĐMo() {
		//initialize();
	}

//	/**
//	 * Initialize the contents of the frame.
//	 */
	private void initialize(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmChnThi = new JFrame();
		frmChnThi.setTitle("Chọn thái độ muốn quyết định");
		frmChnThi.setBounds(100, 100, 509, 300);
		String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frmChnThi.setIconImage(imageIcon.getImage());
		frmChnThi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChnThi.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "L\u01B0\u0323a cho\u0323n tra\u0323ng tha\u0301i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(37, 31, 422, 158);
		frmChnThi.getContentPane().add(panel);
		panel.setLayout(null);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
		slider.setBounds(42, 45, 345, 73);
		panel.add(slider);
		slider.setMinorTickSpacing(1);
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
		
		JLabel lblNewLabel = new JLabel("Giữa bi quan và ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(77, 88, 114, 22);
		panel.add(lblNewLabel);
		
		JLabel lblTrngThiTrung = new JLabel("trạng thái trung gian");
		lblTrngThiTrung.setBounds(77, 105, 114, 16);
		panel.add(lblTrngThiTrung);
		
		JLabel lblGiaTrngThi = new JLabel("Giữa trạng thái");
		lblGiaTrngThi.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiaTrngThi.setBounds(243, 88, 114, 22);
		panel.add(lblGiaTrngThi);
		
		JLabel lblTrungGianV = new JLabel(" trung gian và lạc quan");
		lblTrungGianV.setBounds(243, 105, 128, 16);
		panel.add(lblTrungGianV);
		
		// hien thi thuoc do cua slider 0 10 20 30 40 50 ..
		//slider.setLabelTable(slider.createStandardLabels(1));
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = slider.getValue();

				PhuongAnList paList = new PhuongAnList();
				String dA = "";
				switch (sel)
				{
				case 1:
					frmChnThi.setVisible(false);
					dA=paList.Maximin(namePAs,arr);
					new ketqua().main(arr,dA);
					break;
				case 2:
					dA = paList.QDMoBTG(namePAs,arr);
					frmChnThi.setVisible(false);
					new ketqua().main(arr,dA);
					break;
				case 3:
					frmChnThi.setVisible(false);
					new v_QDMoTG().main(namePAs,arr,nameMTs);
					break;
				case 4:
					dA = paList.QDMoTGL(namePAs,arr);
					frmChnThi.setVisible(false);
					new ketqua().main(arr,dA);
					break;
				case 5:
					frmChnThi.setVisible(false);
					dA=paList.Maximax(namePAs,arr);
					new ketqua().main(arr,dA);
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
