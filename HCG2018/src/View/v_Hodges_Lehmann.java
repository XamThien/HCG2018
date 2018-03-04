package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class v_Hodges_Lehmann {

	private JFrame frmPhngPhapHodges;
	private JTextField textField1;
	private JTextField textField2;

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
		initialize(namePAs,arr,nameMTs);
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
		
		JLabel lblNhpMc = new JLabel("Nhập mức độ xảy ra trạng thái từ 1-100 : ");
		lblNhpMc.setBounds(31, 106, 232, 16);
		panel.add(lblNhpMc);
		
		textField1 = new JTextField();
		textField1.setBounds(31, 55, 316, 39);
		panel.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(31, 134, 316, 39);
		panel.add(textField2);
		
		JLabel lblHpDn = new JLabel("Độ hấp dẫn");
		lblHpDn.setBounds(256, 106, 91, 16);
		panel.add(lblHpDn);
		
		JButton btnXacNhn = new JButton("Xác nhận ");
		btnXacNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ck = true;
				if (textField1.getText().equals(null))
				{
					ck = false;
					JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Hệ Số Tin Cậy !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				if (textField2.getText().equals(null))
				{
					ck = false;
					JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Hệ Số Mức Độ Xảy Ra Trạng Thái !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				if (ck == true)
				{
					try
					{
						String txt1 = textField1.getText();
						String txt2 = textField2.getText();
						if(txt1.contains(","))
						{
							txt1 = txt1.replace(",", ".");
						}
						if(txt2.contains(","))
						{
							txt2 = txt2.replace(",", ".");
						}
						Double lamdatg = Double.parseDouble(txt1);
						double lamdatg1 = lamdatg;
						float lamda = (float)lamdatg1;
						Double ptg = Double.parseDouble(txt2);
						double ptg1 = ptg;
						float p = (float)ptg1;
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
							String dA = paList.Hodges_Lehmann(lamda, p, namePAs, arr, nameMTs);
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
}
