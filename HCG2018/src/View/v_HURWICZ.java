package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class v_HURWICZ {

	private JFrame frmPhngPhapHurwicz;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<String> namePAs,ArrayList<Phuongan> arr) {
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
					v_HURWICZ window = new v_HURWICZ(namePAs,arr);
					window.frmPhngPhapHurwicz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_HURWICZ() {
		//initialize();
	}
	public v_HURWICZ(ArrayList<String> namePAs,ArrayList<Phuongan> arr) {
		initialize(namePAs,arr);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> namePAs,ArrayList<Phuongan> arr) {
		frmPhngPhapHurwicz = new JFrame();
		frmPhngPhapHurwicz.setTitle("Phương pháp HURWICZ");
		frmPhngPhapHurwicz.setBounds(100, 100, 450, 279);
		frmPhngPhapHurwicz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhngPhapHurwicz.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u1EADp h\u1EC7 s\u1ED1 l\u1EA1c quan anpha: t\u1EEB 0 -> 100", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 52, 379, 105);
		frmPhngPhapHurwicz.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 38, 199, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals(null))
				{
					JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Hệ Số Lạc Quan !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
						int anpha = Integer.parseInt(textField.getText());
						if (anpha >0 && anpha< 100)
						{
							PhuongAnList paList = new PhuongAnList();
							
							String dA = paList.Hurwicz(namePAs,arr,anpha);
							
							frmPhngPhapHurwicz.setVisible(false);
							new ketqua().main(paList.DisplayPA(arr,dA));
							
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Hệ số lạc quan phải lớn hơn 0 và nhở hơn 100 !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
						}	
						
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Không đúng định dạng !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(259, 38, 110, 34);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmPhngPhapHurwicz, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmPhngPhapHurwicz.setVisible(false);
                }
			}
		});
		btnNewButton_1.setBounds(288, 169, 117, 35);
		frmPhngPhapHurwicz.getContentPane().add(btnNewButton_1);
	}
}
