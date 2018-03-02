package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class BeforeOpen {

	private JFrame frame;
	private JTextField txtHiden;

	/**
	 * Launch the application.
	 */
	public static void main(String link) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeforeOpen window = new BeforeOpen(link);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BeforeOpen() {
		initialize();
		
	}
	public BeforeOpen(String link) {
		initialize();
		txtHiden.setText(link);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtHiden = new JTextField();
		txtHiden.setBounds(45, 60, 257, 28);
		frame.getContentPane().add(txtHiden);
		txtHiden.setColumns(10);
	}
}
