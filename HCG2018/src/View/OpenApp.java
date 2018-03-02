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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class OpenApp {

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
					OpenApp window = new OpenApp();
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
	public OpenApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
				JFileChooser chooser;
				String choosertitle = null;
				chooser = new JFileChooser(); 
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle(choosertitle);
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    //
			    // disable the "All files" option.
			    //
			    chooser.setAcceptAllFileFilterUsed(false);
			    //    
			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
			      
			    	String path = chooser.getSelectedFile().getAbsolutePath();
			        
			        if (path!=null)
			        {
			        	String cklink = path+"\\savelink.xls";
			        	if(test.checkFileExcel(cklink))
			        	{
			        		textField.setText(chooser.getSelectedFile().getAbsolutePath());
			        		test.openAndWriteContinusFileExcel(cklink,path+"\\savelink.xls");
			        		frmChonViTri.setVisible(false);
					        //BeforeOpen open = new BeforeOpen();
							//open.main(null);
				        	new BeforeOpen().main(cklink);
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
