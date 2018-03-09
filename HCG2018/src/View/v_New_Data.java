package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class v_New_Data {

	private JFrame frame;
	private JFrame frame_1;
	private JTextField txtName;
	private JTextField txtSLMT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
					v_New_Data window = new v_New_Data();
					window.frame_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_New_Data() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame_1 = new JFrame();
		frame_1.setTitle("Hệ Chuyên Gia 2018");
		frame_1.setBounds(400, 100, 592, 413);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnMmH.setBounds(92, 23, 402, 43);
		frame_1.getContentPane().add(lblPhnMmH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00EAm m\u01A1\u0301i CSDL :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(61, 98, 467, 232);
		frame_1.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(150, 53, 247, 28);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblTnTai = new JLabel("Tên đề tài :");
		lblTnTai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTnTai.setBounds(56, 58, 75, 16);
		panel.add(lblTnTai);
		
		JLabel lblSMucTiu = new JLabel("Số mục tiêu :");
		lblSMucTiu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSMucTiu.setBounds(56, 108, 96, 16);
		panel.add(lblSMucTiu);
		
		txtSLMT = new JTextField();
		txtSLMT.setHorizontalAlignment(SwingConstants.CENTER);
		txtSLMT.setColumns(10);
		txtSLMT.setBounds(150, 103, 247, 28);
		panel.add(txtSLMT);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ck = true;
				String ten_de_tai = "";
				int so_mt = 0;
				if(txtName.getText().equals("") || txtName.getText().equals(null))
				{
					ck = false;
					JOptionPane.showMessageDialog(null, "Chưa nhập tên đề tài","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				if(txtSLMT.getText().equals("") || txtSLMT.getText().equals(null))
				{
					ck = false;
					JOptionPane.showMessageDialog(null, "Chưa nhập số lượng mục tiêu","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
						so_mt = Integer.parseInt(txtSLMT.getText());
						if(so_mt<=0)
						{
							ck = false;
							JOptionPane.showMessageDialog(null, "Yêu cầu nhập số mục tiêu là một số nguyên dương","Lỗi", JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception c)
					{
						ck = false;
						JOptionPane.showMessageDialog(null, "Yêu cầu nhập số mục tiêu là một số nguyên dương","Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(ck)
				{
					
					
				}
				
			}
		});
		btnNext.setBounds(307, 160, 90, 28);
		panel.add(btnNext);
	}
}
