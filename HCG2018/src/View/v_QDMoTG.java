package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class v_QDMoTG {

	private JFrame frmTrngThiTrung;
	private JTextField textField;

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
		initialize(namePAs,arr,nameMTs);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmTrngThiTrung = new JFrame();
		frmTrngThiTrung.setTitle("Trạng thái trung gian");
		frmTrngThiTrung.setBounds(100, 100, 450, 280);
		frmTrngThiTrung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrngThiTrung.getContentPane().setLayout(null);
		
		String mt = nameMTs.get(nameMTs.size()-1);
		JLabel lblHpDn = new JLabel(mt);
		lblHpDn.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHpDn.setBounds(224, 48, 77, 16);
		frmTrngThiTrung.getContentPane().add(lblHpDn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u1EADp m\u1EE9c \u0111\u1ED9 x\u1EA3y ra tr\u1EA1ng th\u00E1i                        ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.setBounds(32, 48, 375, 168);
		frmTrngThiTrung.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpHS = new JLabel("Nhập hệ số mức độ xảy ra trạng thái :");
		lblNhpHS.setBounds(25, 39, 219, 16);
		panel.add(lblNhpHS);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(25, 67, 325, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnXacNhn = new JButton("Xác nhận");
		btnXacNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(null))
				{
					JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Hệ Số Mức Độ Trạng Thái !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
						String txt = textField.getText();
						if(txt.contains(","))
						{
							txt = txt.replace(",", ".");
						}
						double tg = Double.parseDouble(txt);
						float p = (float)tg;
						if (p>0 && p<=100)
						{
							PhuongAnList paList = new PhuongAnList();
							String dA = paList.QDMoTG(p, namePAs, arr, nameMTs);
							frmTrngThiTrung.setVisible(false);
							new ketqua().main(paList.DisplayPA(arr,dA));
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Hệ Mức độ trạng thái từ 1-100 !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Không đúng định dạng !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		btnXacNhn.setBounds(154, 107, 90, 28);
		panel.add(btnXacNhn);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmTrngThiTrung, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmTrngThiTrung.setVisible(false);
                }
			}
		});
		btnThoat.setBounds(260, 107, 90, 28);
		panel.add(btnThoat);
	}
}
