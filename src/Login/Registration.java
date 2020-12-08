package Login;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.event.AncestorListener;

import qlbh.ShowNhanvien;

import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField Taikhoan1;
	private JTextField Matkhau1;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 529, 67);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(180, 10, 178, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(89, 82, 90, 32);
		contentPane.add(lblNewLabel_1);
		
		Taikhoan1 = new JTextField();
		Taikhoan1.setBounds(179, 82, 291, 37);
		contentPane.add(Taikhoan1);
		Taikhoan1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(90, 145, 68, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Ä�Äƒng kĂ­ ngay");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
					String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=sa;password=123";
					Connection conn = null;
					Statement st = null;
					try {
						conn = DriverManager.getConnection(dbURL);
						String sql = "select * from Login where Username = ?";
						PreparedStatement prst = conn.prepareStatement(sql);
						prst.setString(1, Taikhoan1.getText());
						ResultSet rs = prst.executeQuery();
						if (rs.next()) {
							JOptionPane.showMessageDialog(rootPane, "TĂ i khoáº£n Ä‘Ă£ tá»“n táº¡i");
							Taikhoan1.setText("");
						}
						else {
	
							int iD;
							String username = Taikhoan1.getText();
							String password = Matkhau1.getText();
							LOGIN1 lg = new LOGIN1( username, password);
							ShowNhanvien.insert(lg);
							
							JOptionPane.showMessageDialog(rootPane, "Ä�Äƒng kĂ­ thĂ nh cĂ´ng");
						}
							
					}
					catch (Exception ex) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(rootPane, ex.getMessage());
					}
			}
		});
		btnNewButton.setBounds(179, 266, 291, 48);
		contentPane.add(btnNewButton);
		
		Matkhau1 = new JTextField();
		Matkhau1.setBounds(179, 140, 291, 37);
		contentPane.add(Matkhau1);
		Matkhau1.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("TĂ´i Ä‘á»“ng Ă½ Ä‘iá»�u khoáº£n, dá»‹ch vá»¥");
		rdbtnNewRadioButton.setBounds(270, 239, 221, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter the password");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(24, 201, 145, 23);
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(179, 196, 291, 37);
		contentPane.add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("Quay láº¡i Ä‘Äƒng nháº­p");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration SV = new Registration();
				SV.setVisible(false);
				Login frmSV = new Login();
				frmSV.setVisible(true);
				
			}
		});
		lblNewLabel_3.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(401, 338, 118, 23);
		contentPane.add(lblNewLabel_3);
	}
}
