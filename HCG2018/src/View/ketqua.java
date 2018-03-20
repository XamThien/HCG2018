package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import controller.Phuongan;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ketqua {

	private JFrame frmKtQua;

	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<Phuongan> arr,String namePA) {
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
					ketqua window = new ketqua(arr,namePA);
					window.frmKtQua.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ketqua() {
		//initialize();
	}
	public ketqua(ArrayList<Phuongan> arr,String namePA) {
		initialize(arr,namePA);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Phuongan> arr,String namePA) {
		
		ArrayList<Phuongan> hihi = new ArrayList<Phuongan>();
		
		
		for (Phuongan phuongan : arr) {
			
			if(phuongan.getNamePA().contains(namePA)){
				
				hihi.add(new Phuongan(phuongan.getNamePA(),phuongan.getNameMT(), phuongan.getValue()));
				
				
			}
		}

		
		frmKtQua = new JFrame();
		frmKtQua.setTitle("Kết quả");
		int sl = hihi.size();
		frmKtQua.setBounds(100, 100, 450, 240+(sl-1)*45);
		frmKtQua.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKtQua.getContentPane().setLayout(null);
		
		String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frmKtQua.setIconImage(imageIcon.getImage());
		
		String labelname = "Kết quả của lựa chọn là phương án : "+namePA;
		JLabel lblNewLabel = new JLabel(labelname);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(6, 36, 422, 24);
		frmKtQua.getContentPane().add(lblNewLabel);
		
		//String rtn = "3,Lương,0.3,Gần nhà,0.6,Độ hấp dẫn,0.4";
		
		
//		JLabel label = new JLabel(namePA);
//		label.setFont(new Font("Tahoma", Font.BOLD, 13));
//		label.setBounds(323, 36, 237, 24);
//		frmKtQua.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chi ti\u00EA\u0301t ph\u01B0\u01A1ng a\u0301n l\u01B0\u0323a cho\u0323n : "+namePA, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 84, 358, 24+(sl-1)*45);
		frmKtQua.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		for (int i = 0; i<sl; i++)
		{
			JLabel label_11 = new JLabel("-");
			label_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_11.setBounds(90, 42+(i-1)*25, 249, 24);
			panel.add(label_11);
			
			
			JLabel label_2 = new JLabel(hihi.get(i).getNameMT());
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_2.setBounds(109, 42+(i-1)*25, 230, 24);
			panel.add(label_2);
			
			JLabel label_3 = new JLabel(":");
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_3.setBounds(195, 42+(i-1)*25, 144, 24);
			panel.add(label_3);
			
			JLabel label_4 = new JLabel(String.valueOf(hihi.get(i).getValue()));
			label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_4.setBounds(229, 42+(i-1)*25, 110, 24);
			panel.add(label_4);
			
		}
		
		
		JButton btnNewButton = new JButton("Đóng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKtQua.setVisible(false);
			}
		});
		btnNewButton.setBounds(262, 131+(sl-1)*45, 109, 28);
		frmKtQua.getContentPane().add(btnNewButton);
	}
}
