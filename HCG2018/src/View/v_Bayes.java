package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class v_Bayes {

	private JFrame frmPhngPhapBayes;
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
					//
					v_Bayes window = new v_Bayes(namePAs,arr,nameMTs);
					window.frmPhngPhapBayes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_Bayes() {
		//initialize();
	}
	public v_Bayes(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		initialize(namePAs,arr,nameMTs);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmPhngPhapBayes = new JFrame();
		frmPhngPhapBayes.setTitle("Phương pháp Bayes");
		frmPhngPhapBayes.setBounds(100, 100, 450, 300);
		frmPhngPhapBayes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhngPhapBayes.getContentPane().setLayout(null);
		
		String mt = nameMTs.get(nameMTs.size()-1);
		JLabel lblNewLabel = new JLabel(mt);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(226, 54, 110, 14);
		frmPhngPhapBayes.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u1EADp m\u1EE9c \u0111\u1ED9 x\u1EA3y ra tr\u1EA1ng th\u00E1i :                          ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.setBounds(25, 53, 383, 102);
		frmPhngPhapBayes.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 38, 202, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(null))
				{
					JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Hệ Số Mức độ trạng thái !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
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
							String dA = paList.Bayes(p, namePAs, arr, nameMTs);
							frmPhngPhapBayes.setVisible(false);
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
		btnNewButton.setBounds(247, 37, 126, 36);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmPhngPhapBayes, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmPhngPhapBayes.setVisible(false);
                }
			}
		});
		btnNewButton_1.setBounds(278, 167, 117, 36);
		frmPhngPhapBayes.getContentPane().add(btnNewButton_1);
	}
}
