package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import controller.PhuongAnList;
import controller.Phuongan;
import controller.XacSuat_Bayes_hodges_lehmann;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class v_Hodges_Lehmann {

	private JFrame frmPhngPhapHodges;
	private JTextField textField1;

	/**ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs
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
					v_Hodges_Lehmann window = new v_Hodges_Lehmann(namePAs,arr,nameMTs);
					window.frmPhngPhapHodges.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public v_Hodges_Lehmann() {
		//initialize();
	}
	public v_Hodges_Lehmann(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		initialize(namePAs,arr,nameMTs);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> namePAs,ArrayList<Phuongan> arr,ArrayList<String> nameMTs) {
		frmPhngPhapHodges = new JFrame();
		frmPhngPhapHodges.setTitle("Phương pháp Hodges Lehmann");
		int sl = nameMTs.size();
		String path = "/image/image.png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        frmPhngPhapHodges.setIconImage(imageIcon.getImage());
		frmPhngPhapHodges.setBounds(100, 100, 450, 333+(sl-1)*95);
		frmPhngPhapHodges.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhngPhapHodges.getContentPane().setLayout(null);
		frmPhngPhapHodges.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u00E2\u0323p ca\u0301c h\u00EA\u0323 s\u00F4\u0301 sau \u0111\u00E2y :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(27, 27, 385, 204+(sl-1)*95);
		frmPhngPhapHodges.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpHS = new JLabel("Nhập hệ số tin cậy từ 0 -1: ");
		lblNhpHS.setBounds(31, 27, 158, 16);
		panel.add(lblNhpHS);

		textField1 = new JTextField();
		textField1.setBounds(31, 55, 316, 39);
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField1);
		textField1.setColumns(10);
		
		ArrayList<JTextField> txtLst = new ArrayList<JTextField>();
		
		for(int i = 0; i< sl;i++)
		{
			
			JLabel lblNhpMc = new JLabel("Nhập xác suất xảy ra trạng thái cho : "+nameMTs.get(i));
			lblNhpMc.setBounds(31, 106+i*95, 300, 16);
			panel.add(lblNhpMc);
			
			JTextField textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			
			textField.setBounds(31, 106+39+i*95, 316, 35);
			txtLst.add(textField);
			
			}

		for (JTextField tt : txtLst)
		{
			
			panel.add(tt);
		}
		
		JButton btnXacNhn = new JButton("Kết quả");
		btnXacNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ck = true;
				if (textField1.getText().equals(null) || textField1.getText().equals(""))
				{
					
					//JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Hệ Số Tin Cậy !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
					ck = false;
				}
				for (JTextField tt : txtLst)
				{
					if (tt.getText().equals(null) || tt.getText().equals(""))
					{
						
						
						ck = false;
					}
				}
				
				if (ck == false)
				{
					JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ các ô !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					try
					{
						String txt1 = textField1.getText();
						
						if(txt1.contains(","))
						{
							txt1 = txt1.replace(",", ".");
						}
						
						Double lamdatg = Double.parseDouble(txt1);
						double lamdatg1 = lamdatg;
						float lamda = (float)lamdatg1;
						boolean ckk = true;
						if (lamda<=0 || lamda>=1)
							{
								ckk = false;
								JOptionPane.showMessageDialog(null, "Hệ số tin cậy phải lớn hơn 0 và nhỏ hơn 1 !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
							}
						
						// kiểm tra các xác suất
						ArrayList<XacSuat_Bayes_hodges_lehmann> xacSuat = new ArrayList<XacSuat_Bayes_hodges_lehmann>();
						ArrayList<Float> xacSuatF = new ArrayList<Float>();
						boolean ck1 = true;
						for (int i=0;i< txtLst.size();i++)
						{
							JTextField er = txtLst.get(i);
							String value = er.getText();
							if(value.contains(","))
							{
								value = value.replace(',', '.');
							}
							try
							{
								double p = Double.valueOf(value);
								float pp = (float) p;
								if(pp>=0 && pp <=1)
								{
									XacSuat_Bayes_hodges_lehmann xs = new XacSuat_Bayes_hodges_lehmann();
									xs.setNamemt(nameMTs.get(i));
									xs.setXacsuat(pp);
									xacSuatF.add(pp);
									xacSuat.add(xs);
								}
								else
								{
									ck1 = false;
									JOptionPane.showMessageDialog(null, "Nhập giá trị xác suất của \"" +nameMTs.get(i)+"\" từ 0-1","Lỗi", JOptionPane.ERROR_MESSAGE);
								}
							}
							catch(Exception eer)
							{
								ck1 = false;
								JOptionPane.showMessageDialog(null, "Nhập giá trị xác suất của \"" +nameMTs.get(i)+"\" từ 0-1","Lỗi", JOptionPane.ERROR_MESSAGE);
							}
						}
						
						
						
						
						if(ckk== true)
						{
							if(ck1)
							{
								
								float tong = 0;
								for(XacSuat_Bayes_hodges_lehmann xss : xacSuat)
								{
									tong+=xss.getXacsuat();
								}
								
								if(tong!=1)
								{
									
									JOptionPane.showMessageDialog(null, "Yêu cầu nhập tổng các xác suất phải bằng 1 !","Lỗi", JOptionPane.ERROR_MESSAGE);
								}
								else
								{
									PhuongAnList paList = new PhuongAnList();
									String dA = paList.Hodges_Lehmann(lamda,xacSuatF, namePAs, arr, nameMTs);
									frmPhngPhapHodges.setVisible(false);
									new ketqua_bayes().main(xacSuat,arr,dA,"với hệ số tin cậy là "+lamda);
								}
							}
						}
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Không đúng định dạng hệ số !!!!","Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnXacNhn.setBounds(300, 248+(sl-1)*95, 112, 33);
		frmPhngPhapHodges.getContentPane().add(btnXacNhn);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frmPhngPhapHodges, "Bạn chắc chắn muốn thoát?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
                if (check == JOptionPane.YES_OPTION) 
                {
                	frmPhngPhapHodges.setVisible(false);
                }
			}
		});
		btnThoat.setBounds(184, 248+(sl-1)*95, 112, 33);
		frmPhngPhapHodges.getContentPane().add(btnThoat);
	}
	
}
