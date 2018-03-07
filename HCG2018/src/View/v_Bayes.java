package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class v_Bayes {

	private JFrame frmPhngPhapBayes;

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
					//namePAs,arr,nameMTs
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
		frmPhngPhapBayes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhngPhapBayes.getContentPane().setLayout(null);
		int sl = nameMTs.size();
		frmPhngPhapBayes.setBounds(100, 100, 450, 300+(sl-1)*95);
		
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
		btnNewButton_1.setBounds(278, 182+(sl-1)*95, 117, 36);
		frmPhngPhapBayes.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.setBounds(145, 182+(sl-1)*95, 126, 36);
		frmPhngPhapBayes.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p ca\u0301c h\u00EA\u0323 s\u00F4\u0301 sau \u0111\u00E2y:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(15, 26, 395, 144+sl*95);
		frmPhngPhapBayes.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane jsc = new JScrollPane(panel);
        jsc.setBounds(15, 26, 395, 144+sl*95);
        frmPhngPhapBayes.getContentPane().add(jsc);
		
		ArrayList<JSlider> hihi = new ArrayList<JSlider>();
		ArrayList<JTextField> txtLst = new ArrayList<JTextField>();
		
		for(int i = 0; i< sl;i++)
		{
			
			JLabel lblNhpMc = new JLabel("Nhập mức độ xảy ra trạng thái cho : ");
			lblNhpMc.setBounds(21, 31+i*95, 232, 16);
			panel.add(lblNhpMc);
			/*nameMTs.get(0)*/
			JLabel lblHpDn = new JLabel(nameMTs.get(i));
			lblHpDn.setBounds(221, 31+i*95, 91, 16);
			panel.add(lblHpDn);
			
			JTextField textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			//textField.setEnabled(false);
			textField.setEditable(false);
			textField.setBounds(296, 27+i*95, 60, 28);
			
			JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
			slider.setBounds(21, 50+i*95, 338, 73);
			
			slider.setMinorTickSpacing(1);
			slider.setMajorTickSpacing(10);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			
			
			
			// hien thi thuoc do cua slider 0 10 20 30 40 50 ..
			slider.setLabelTable(slider.createStandardLabels(10));
			slider.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					textField.setText(String.valueOf(slider.getValue()));
					
				}
			});
			txtLst.add(textField);
			hihi.add(slider);
			}
		//panel.add(slider);
		for (JSlider er : hihi)
		{
			
			panel.add(er);
		}
		for (JTextField tt : txtLst)
		{
			
			panel.add(tt);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Float> xacSuat = new ArrayList<Float>();
				
				for (JSlider er : hihi)
				{
					float p = (float)er.getValue();
					
					xacSuat.add(p);
				}
				PhuongAnList paList = new PhuongAnList();
				String dA = paList.Bayes(xacSuat, namePAs, arr, nameMTs);
				frmPhngPhapBayes.setVisible(false);
				new ketqua().main(arr,dA);
			}
		});
			
	}
	
	
}
