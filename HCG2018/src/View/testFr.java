package View;

import java.awt.EventQueue;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import controller.Phuongan;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class testFr {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testFr window = new testFr();
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
	public testFr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Kết quả");
		String x = "3,Lương,0.3,Gần nhà,0.6,Độ hấp dẫn,0.4";
		String[] kq = x.split(",");
		frame.setBounds(100, 100, 450, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kết quả của lựa chọn là phương án : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(86, 36, 237, 24);
		frame.getContentPane().add(lblNewLabel);
		
		//String rtn = "3,Lương,0.3,Gần nhà,0.6,Độ hấp dẫn,0.4";
		
		
		JLabel label = new JLabel(kq[0]);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(323, 36, 237, 24);
		frame.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chi ti\u00EA\u0301t ph\u01B0\u01A1ng a\u0301n "+kq[0]+" l\u01B0\u0323a cho\u0323n :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 84, 358, 172);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel(kq[1]);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(109, 42, 230, 24);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel(":");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(195, 42, 144, 24);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel(kq[2]);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(229, 42, 110, 24);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel(kq[3]);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(109, 77, 230, 24);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel(":");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(195, 77, 144, 24);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel(kq[4]);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(229, 77, 110, 24);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel(kq[5]);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(109, 112, 230, 24);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel(":");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_9.setBounds(195, 112, 144, 24);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel(kq[6]);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_10.setBounds(229, 112, 110, 24);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("-");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_11.setBounds(90, 42, 249, 24);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("-");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_12.setBounds(90, 77, 249, 24);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("-");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_13.setBounds(90, 112, 249, 24);
		panel.add(label_13);
		
		JButton btnNewButton = new JButton("Đóng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(262, 268, 109, 28);
		frame.getContentPane().add(btnNewButton);
	}
	

}
