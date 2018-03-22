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

import controller.test;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class v_New_Data {

	private JFrame frame;
	private JFrame frame_1;
	private JTextField txtName;
	private JTextField txtSLMT;
	private JTextField txtSLPA;
	private JTextField textField;

	/**
	 * Launch the application. là để thêm đề tài, số mục tiêu và số phương án
	 */
	public static void main(String link) {
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
					v_New_Data window = new v_New_Data(link);
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
	public v_New_Data(String link) {
		initialize(link);
	}
	public v_New_Data() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String link) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame_1 = new JFrame();
		frame_1.setTitle("Hệ Chuyên Gia 2018");
		frame_1.setBounds(400, 100, 592, 475);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);
		frame_1.setResizable(false);
		frame.setResizable(false);
		
		JLabel lblPhnMmH = new JLabel("PHẦN MỀM HỖ TRỢ QUYẾT ĐỊNH 2018");
		lblPhnMmH.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPhnMmH.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhnMmH.setBounds(92, 23, 402, 43);
		frame_1.getContentPane().add(lblPhnMmH);
		
		test ts = new test();
		String fileName = ts.readFileExcel(link,1,1);
		int len = fileName.length();
		int last = fileName.lastIndexOf('\\');
		/*String folderName = fileName.substring( 0,last+1);
		BufferedImage image = null;
        try
        {
        	
        //  image = ImageIO.read(new File(folderName+"image.png"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }*/
        
       // frame_1.setIconImage(image);
        String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frame_1.setIconImage(imageIcon.getImage());
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00EAm m\u01A1\u0301i CSDL :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(61, 98, 467, 326);
		frame_1.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(205, 33, 205, 28);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblTnTai = new JLabel("1: Nhập tên đề tài ");
		lblTnTai.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTnTai.setBounds(56, 38, 122, 16);
		panel.add(lblTnTai);
		
		JButton btnNext = new JButton("Next");

		btnNext.setBounds(320, 265, 90, 28);
		panel.add(btnNext);
		
		JButton btnBack = new JButton("Trở lại");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_1.setVisible(false);
				frame.setVisible(false);
				new v_SelectFile().main(link);
				//new v_SelectMT().main(link);
			}
		});
		btnBack.setBounds(220, 265, 90, 28);
		panel.add(btnBack);
		
		txtSLPA = new JTextField();
		txtSLPA.setBounds(207, 212, 203, 28);
		panel.add(txtSLPA);
		txtSLPA.setHorizontalAlignment(SwingConstants.CENTER);
		txtSLPA.setColumns(10);
		
		JLabel lblSPhngAn = new JLabel("3: Nhập số phương án ");
		lblSPhngAn.setBounds(56, 217, 150, 23);
		panel.add(lblSPhngAn);
		lblSPhngAn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JLabel lblNhpSMuc = new JLabel("2: Chọn nhập số mục tiêu hoặc trạng thái ");
		lblNhpSMuc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNhpSMuc.setBounds(56, 85, 325, 23);
		panel.add(lblNhpSMuc);
		
		txtSLMT = new JTextField();
		txtSLMT.setBounds(207, 121, 203, 28);
		panel.add(txtSLMT);
		txtSLMT.setEnabled(false);
		txtSLMT.setHorizontalAlignment(SwingConstants.CENTER);
		txtSLMT.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(207, 160, 203, 28);
		panel.add(textField);
		textField.setEnabled(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		
		JRadioButton rdbtnSMucTiu = new JRadioButton("Số mục tiêu");
		rdbtnSMucTiu.setBounds(77, 124, 105, 23);
		panel.add(rdbtnSMucTiu);
		
		
		JRadioButton rdbtnSTrangThai = new JRadioButton("Số trạng thái");
		rdbtnSTrangThai.setBounds(77, 163, 105, 23);
		panel.add(rdbtnSTrangThai);
		
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnSMucTiu);
		btnGroup.add(rdbtnSTrangThai);
		
		rdbtnSMucTiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSLMT.setEnabled(true);
				textField.setText(null);
				textField.setEnabled(false);
			}
		});
		rdbtnSTrangThai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSLMT.setText(null);
				txtSLMT.setEnabled(false);
				textField.setEnabled(true);
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ck = true;
				String ten_de_tai = "";
				int so_mt = 0;
				int so_pa = 0;
				if(txtName.getText().equals("") || txtName.getText().equals(null))
				{
					ck = false;
					JOptionPane.showMessageDialog(null, "Chưa nhập tên đề tài","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					ten_de_tai = txtName.getText();
				}
				int soluong_mt_tt =0;
				String LoaiCot = "";
				if(rdbtnSTrangThai.isSelected())
				{
					if(textField.getText().equals("") || textField.getText().equals(null))
					{
						ck = false;
						JOptionPane.showMessageDialog(null, "Chưa nhập số trạng thái","Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						try
						{
							soluong_mt_tt = Integer.parseInt(textField.getText());
							LoaiCot = "Trạng thái";
							if(soluong_mt_tt<=0)
							{
								ck = false;
								JOptionPane.showMessageDialog(null, "Yêu cầu nhập số trạng thái là một số nguyên dương","Lỗi", JOptionPane.ERROR_MESSAGE);
							}
								
						}
						catch (Exception eee)
						{
							ck = false;
							JOptionPane.showMessageDialog(null, "Nhập số trạng thái là số nguyên","Lỗi", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				if(rdbtnSMucTiu.isSelected())
				{
					if(txtSLMT.getText().equals("") || txtSLMT.getText().equals(null))
					{
						ck = false;
						JOptionPane.showMessageDialog(null, "Chưa nhập số mục tiêu","Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						try
						{
							soluong_mt_tt = Integer.parseInt(txtSLMT.getText());
							LoaiCot = "Mục tiêu";
							if(soluong_mt_tt<=0)
							{
								ck = false;
								JOptionPane.showMessageDialog(null, "Yêu cầu nhập số mục tiêu là một số nguyên dương","Lỗi", JOptionPane.ERROR_MESSAGE);
							}
								
						}
						catch (Exception eee)
						{
							ck = false;
							JOptionPane.showMessageDialog(null, "Nhập số mục tiêu là số nguyên","Lỗi", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				if(txtSLPA.getText().equals("") || txtSLPA.getText().equals(null))
				{
					ck = false;
					JOptionPane.showMessageDialog(null, "Chưa nhập số lượng phương án","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
						so_pa = Integer.parseInt(txtSLPA.getText());
						if(so_pa<=0)
						{
							ck = false;
							JOptionPane.showMessageDialog(null, "Yêu cầu nhập số phương án là một số nguyên dương","Lỗi", JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception c)
					{
						ck = false;
						JOptionPane.showMessageDialog(null, "Yêu cầu nhập số phương án là một số nguyên dương","Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(ck)
				{
					frame_1.setVisible(false);
					frame.setVisible(false);
					new v_Add_Data().main(link,ten_de_tai,soluong_mt_tt,so_pa,LoaiCot);
					
				}
				
			}
		});
	}
}
