package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.test;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class BeforeOpenApp {

	private JFrame frmChonViTri;
	private JTextField textField;

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
					BeforeOpenApp window = new BeforeOpenApp();
					window.frmChonViTri.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BeforeOpenApp() {
		test ts = new test();
		// tạo file excel luu địa chỉ của file database, nếu không tồn tại file này, sẽ dc tạo mới theo địa chỉ này
		String link = "G:\\Link.xls";
		if(!ts.checkFileExcel(link))
		{
			initialize(link);
		}
		else
		{
			new v_SelectMT().main(null);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String Link) {
		frmChonViTri = new JFrame();
		frmChonViTri.setTitle("Chọn vị trí lưu các file");
		frmChonViTri.setBounds(500, 150, 541, 296);
		frmChonViTri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChonViTri.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cho\u0323n folder l\u01B0u ca\u0301c file gia\u0309i ne\u0301n :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.setBounds(19, 88, 487, 116);
		frmChonViTri.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(29, 46, 296, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Chọn folder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) 
				{
					String path = fileChooser.getSelectedFile().getAbsolutePath();
			        
			        if (path!=null)
			        {
			        	String cklink = path;
			        	if(test.checkFileExcel(cklink))
			        	{
			        		textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			        		test.writeNewFileExcel(Link,cklink);
			        		frmChonViTri.setVisible(false);
			        		new v_SelectMT().main(null);
			        	}
			        	else
			        	{
			        		JOptionPane.showMessageDialog(null, "Folder không chứa các file cần thiết","Lỗi", JOptionPane.ERROR_MESSAGE);
			        	}
			        }
				}
				else {
			    	JOptionPane.showMessageDialog(null, "Chưa chọn vị trí tệp","Lỗi", JOptionPane.ERROR_MESSAGE);
			      }
				

			}
		});
		btnNewButton.setBounds(351, 46, 112, 28);
		panel.add(btnNewButton);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnMmH.setBounds(67, 18, 402, 43);
		frmChonViTri.getContentPane().add(lblPhnMmH);
	}
}
