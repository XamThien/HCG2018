package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class v_Add_Data {

	private JFrame frmThmMiMuc;

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
					v_Add_Data window = new v_Add_Data();
					window.frmThmMiMuc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_Add_Data() {
		String ten_de_tai = "Chời đụ";
		int so_mt = 4;
		initialize( ten_de_tai, so_mt);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String ten_de_tai,int so_mt) {
		frmThmMiMuc = new JFrame();
		frmThmMiMuc.setTitle("Thêm mới mục tiêu");
		frmThmMiMuc.setBounds(400, 100, 592, 316+(so_mt-1)*40);
		frmThmMiMuc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThmMiMuc.getContentPane().setLayout(null);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setBounds(92, 23, 402, 43);
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		frmThmMiMuc.getContentPane().add(lblPhnMmH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00EAm mu\u0323c ti\u00EAu:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(66, 103, 466, 90+(so_mt-1)*40);
		frmThmMiMuc.getContentPane().add(panel);
		panel.setLayout(null);
		
		ArrayList<JTextField> hihi = new ArrayList<JTextField>();
		
		for(int i = 1; i<=so_mt;i++)
		{
			JLabel lblTnTai = new JLabel("Mục tiêu");
			lblTnTai.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblTnTai.setBounds(36, 38+(i-1)*40, 75, 16);
			panel.add(lblTnTai);
			
			JLabel label = new JLabel(String.valueOf(i));
			label.setFont(new Font("SansSerif", Font.PLAIN, 14));
			label.setBounds(94, 38+(i-1)*40, 75, 16);
			panel.add(label);
			
			JTextField txtName = new JTextField();
			txtName.setHorizontalAlignment(SwingConstants.CENTER);
			txtName.setBounds(145, 33+(i-1)*40, 270, 28);
			panel.add(txtName);
			txtName.setColumns(10);
			hihi.add(txtName);
			
		}
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ck = true;
				for(int i = 1; i<=hihi.size();i++)
				{
					if(hihi.get(i-1).getText().equals("") || hihi.get(i-1).getText().equals(null))
					{
						ck = false;
						JOptionPane.showMessageDialog(null, "Chưa nhập mục tiêu "+i,"Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
				if(ck)
				{
					
				}
			}
		});
		btnNext.setBounds(442, 215+(so_mt-1)*40, 90, 28);
		frmThmMiMuc.getContentPane().add(btnNext);
	}

}
