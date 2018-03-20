package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class v_HURWICZ {

	private JFrame frmPhngPhapHurwicz;
	private JTextField textField;

	/**ArrayList<String> namePAs,ArrayList<Phuongan> arr
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

	/**ArrayList<String> namePAs,ArrayList<Phuongan> arr
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> namePAs,ArrayList<Phuongan> arr) {
		frmPhngPhapHurwicz = new JFrame();
		frmPhngPhapHurwicz.setTitle("Phương pháp HURWICZ");
		String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frmPhngPhapHurwicz.setIconImage(imageIcon.getImage());
		frmPhngPhapHurwicz.setBounds(100, 100, 450, 279);
		frmPhngPhapHurwicz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhngPhapHurwicz.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		//textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(188, 49, 60, 28);
		frmPhngPhapHurwicz.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				textField.setText(String.valueOf(slider.getValue()));
				
			}
		});
		
		
		
		slider.setBorder(new TitledBorder(null, "Cho\u0323n h\u00EA\u0323 s\u00F4\u0301 la\u0323c quan :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		slider.setBounds(21, 36, 395, 121);
		slider.setMinorTickSpacing(1);
	    slider.setMajorTickSpacing(10);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);

	    // hien thi thuoc do cua slider 0 10 20 30 40 50 ..
	    slider.setLabelTable(slider.createStandardLabels(10));
	    frmPhngPhapHurwicz.getContentPane().add(slider);
		
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
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.setBounds(155, 169, 110, 34);
		frmPhngPhapHurwicz.getContentPane().add(btnNewButton);
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int anpha = slider.getValue();
				if (anpha >0 && anpha< 100)
				{
					PhuongAnList paList = new PhuongAnList();
					
					String dA = paList.Hurwicz(namePAs,arr,anpha);
					
					frmPhngPhapHurwicz.setVisible(false);
					new ketqua().main(arr,dA);
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Hệ số lạc quan phải lớn hơn 0 và nhở hơn 100 !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
	}
}
