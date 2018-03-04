package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class v_QĐMo {

	private JFrame frmChnThi;

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
					v_QĐMo window = new v_QĐMo(namePAs,arr,nameMTs);
					window.frmChnThi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_QĐMo(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		initialize(namePAs,arr,nameMTs);
	}
	public v_QĐMo() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmChnThi = new JFrame();
		frmChnThi.setTitle("Chọn thái độ muốn quyết định");
		frmChnThi.setBounds(100, 100, 509, 300);
		frmChnThi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChnThi.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ch\u1ECDn th\u00E1i \u0111\u1ED9 mu\u1ED1n quy\u1EBFt \u0111\u1ECBnh:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(28, 48, 434, 150);
		frmChnThi.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rd1 = new JRadioButton("Bi quan");
		rd1.setBounds(23, 36, 80, 18);
		panel.add(rd1);
		
		JRadioButton rd2 = new JRadioButton("Giữa bi quan và trạng thái trung gian");
		rd2.setBounds(179, 36, 230, 18);
		panel.add(rd2);
		
		JRadioButton rd3 = new JRadioButton("Trạng thái trung gian");
		rd3.setBounds(23, 74, 148, 18);
		panel.add(rd3);
		
		JRadioButton rd4 = new JRadioButton("Giữa trạng thái trung gian và lạc quan");
		rd4.setBounds(179, 74, 230, 18);
		panel.add(rd4);
		
		JRadioButton rd5 = new JRadioButton("Lạc quan");
		rd5.setBounds(23, 109, 148, 18);
		panel.add(rd5);
		ButtonGroup btnGroup2 = new ButtonGroup();
		btnGroup2.add(rd1);
		btnGroup2.add(rd2);
		btnGroup2.add(rd3);
		btnGroup2.add(rd4);
		btnGroup2.add(rd5);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhuongAnList paList = new PhuongAnList();
				String dA = "";
				if(rd1.isSelected())
				{
					frmChnThi.setVisible(false);
					dA=paList.Maximin(namePAs,arr);
					new ketqua().main(paList.DisplayPA(arr,dA));
				}
				if(rd2.isSelected())
				{
					dA = paList.QDMoBTG(namePAs,arr);
					frmChnThi.setVisible(false);
					new ketqua().main(paList.DisplayPA(arr,dA));
				}
				if(rd3.isSelected())
				{
					frmChnThi.setVisible(false);
					new v_QDMoTG().main(namePAs,arr,nameMTs);
				}
				if(rd4.isSelected())
				{
					dA = paList.QDMoTGL(namePAs,arr);
					frmChnThi.setVisible(false);
					new ketqua().main(paList.DisplayPA(arr,dA));
				}
				if(rd5.isSelected())
				{
					frmChnThi.setVisible(false);
					dA=paList.Maximax(namePAs,arr);
					new ketqua().main(paList.DisplayPA(arr,dA));
				}
			}
		});
		btnNewButton.setBounds(233, 210, 113, 37);
		frmChnThi.getContentPane().add(btnNewButton);
		
		JButton btnong = new JButton("Đóng");
		btnong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmChnThi, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmChnThi.setVisible(false);
                }
			}
		});
		btnong.setBounds(358, 210, 104, 37);
		frmChnThi.getContentPane().add(btnong);
	}
}
