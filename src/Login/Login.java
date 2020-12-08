package Login;

import java.awt.BorderLayout;
import qlbh.MainFrame;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;

public class Login extends JFrame {

	private JPanel contentPanelogin;
	private JTextField Taikhoan;
	private JTextField Matkhau;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 464);
		contentPanelogin = new JPanel();
		setContentPane(contentPanelogin);
		contentPanelogin.setLayout(null);
		contentPanelogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		contentPanelogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanelogin);
		contentPanelogin.setLayout(null);

		Taikhoan = new JTextField();
		Taikhoan.setBounds(319, 138, 452, 49);
		contentPanelogin.add(Taikhoan);
		Taikhoan.setColumns(10);

		Matkhau = new JPasswordField();
		Matkhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						String dbURL = "jdbc:sqlserver://LAPTOP-J2TPH44U\\SQLEXPRESS;databaseName=QL_BanHang;user=sa;password=123456";
						Connection conn = DriverManager.getConnection(dbURL);
						String sql = "select * from Login where Username=? and Password=? ";
						PreparedStatement prst = conn.prepareStatement(sql);
						prst.setString(1, Taikhoan.getText());
						prst.setString(2, Matkhau.getText());

						ResultSet rs = prst.executeQuery();
						if (rs.next()) {
							MainFrame frmSV = new MainFrame();
							frmSV.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(rootPane, "TĂªn Ä‘Äƒng nháº­p khĂ´ng tá»“n táº¡i hoáº·c sai máº­t kháº©u");
							Taikhoan.setText("");
							Matkhau.setText("");
						}
						rs.close();
						prst.close();
						conn.close();
					} catch (Exception ex) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(rootPane, ex.getMessage());
					}
				}
			}
		});
		Matkhau.setBounds(319, 212, 452, 49);
		contentPanelogin.add(Matkhau);
		Matkhau.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(150, 134, 133, 49);
		contentPanelogin.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(150, 208, 133, 49);
		contentPanelogin.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Ä�Äƒng nháº­p ngay");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang"
							+ ""
							+ ";user=sa;password=123456";
					Connection conn = DriverManager.getConnection(dbURL);
					String sql = "select * from Login where Username=? and Password=? ";
					PreparedStatement prst = conn.prepareStatement(sql);
					prst.setString(1, Taikhoan.getText());
					prst.setString(2, Matkhau.getText());

					ResultSet rs = prst.executeQuery();
					if (rs.next()) {
						MainFrame frmSV = new MainFrame();
						frmSV.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(rootPane, "TĂªn Ä‘Äƒng nháº­p khĂ´ng tá»“n táº¡i hoáº·c sai máº­t kháº©u");
						Taikhoan.setText("");
						Matkhau.setText("");
					}
					rs.close();
					prst.close();
					conn.close();
				} catch (Exception ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(rootPane, ex.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(319, 294, 452, 42);
		contentPanelogin.add(btnNewButton);

		JLabel lblNewLabel_4 = new JLabel("Click here to create a new accout");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration frmSV = new Registration();
				frmSV.setVisible(true);
				
				frmSV.setLocationRelativeTo(null);

			}
		});
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(699, 392, 234, 25);
		contentPanelogin.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 943, 124);
		contentPanelogin.add(panel);
				panel.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("LOGIN FORM");
				lblNewLabel.setBounds(380, 42, 178, 37);
				panel.add(lblNewLabel);
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
				
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Nhá»› máº­t kháº©u");
				rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				rdbtnNewRadioButton.setBounds(650, 267, 121, 21);
				contentPanelogin.add(rdbtnNewRadioButton);
	}
}