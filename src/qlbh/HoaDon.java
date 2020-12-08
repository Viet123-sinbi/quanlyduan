package qlbh;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class HoaDon extends JPanel {
	private JTextField txtMaHD;
	private JTextField txtNgayBan;
	private JTextField txtHoadonSeach;
	private JTable table;
	private JTextField txtMaNV;
	private JTextField txtMaKH;
	private JTextField txtTongTien;
	private DefaultTableModel tableModel = new DefaultTableModel();
	List<HoaDon> HD = new ArrayList<>();
	
	/**
	 * Create the panel.
	 */
	public HoaDon() {
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HO\u00C1 \u0110\u01A0N B\u00C1N H\u00C0NG");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1000, 54);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin chung", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 44, 980, 154);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 ho\u00E1 \u0111\u01A1n:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 21, 100, 30);
		panel.add(lblNewLabel_1);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(120, 21, 303, 30);
		panel.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ng\u00E0y b\u00E1n:");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 61, 100, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 101, 100, 30);
		panel.add(lblNewLabel_1_2);
		
		txtNgayBan = new JTextField();
		txtNgayBan.setColumns(10);
		txtNgayBan.setBounds(120, 61, 303, 30);
		panel.add(txtNgayBan);
		
		JLabel lblNewLabel_1_4 = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng:");
		lblNewLabel_1_4.setForeground(Color.BLUE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(489, 21, 113, 30);
		panel.add(lblNewLabel_1_4);
		
		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(120, 104, 303, 30);
		panel.add(txtMaNV);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(612, 21, 303, 30);
		panel.add(txtMaKH);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("T\u1ED5ng ti\u1EC1n");
		lblNewLabel_1_2_2.setForeground(Color.BLUE);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(489, 61, 110, 30);
		panel.add(lblNewLabel_1_2_2);
		
		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(612, 61, 303, 30);
		panel.add(txtTongTien);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 555, 980, 35);
		add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("      T\u00ECm ki\u1EBFm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<HoaDon> HD = new ArrayList<>();
				String [] dsHD = {"MaHD", "NgayBan","TongTien","MaNV","MaKH"};
				tableModel.setColumnIdentifiers(dsHD);
				
				try {
					String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=SA;password=123";
					Connection conn = DriverManager.getConnection(dbURL);
					String sql = "Select * from HOADON where MaHD='"+txtHoadonSeach.getText()+"'";
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(sql);
					tableModel.setRowCount(0);
					
					if(rs.isBeforeFirst() == false) {
						JOptionPane.showConfirmDialog(null, "Thông tin hoá đơn này không tồn tại");
					}
					
					while(rs.next()) {
						Vector cuscomer = new Vector();
						cuscomer.add(rs.getString("MaHD"));
						cuscomer.add(rs.getString("NgayBan"));
						cuscomer.add(rs.getString("TongTien"));
						cuscomer.add(rs.getString("MaNV"));
						cuscomer.add(rs.getString("MaKH"));
						
						tableModel.addRow(cuscomer);
					}
					table.setModel(tableModel);
			
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("E:\\Java destop\\Icon\\TK.png"));
		btnNewButton.setBounds(287, 0, 168, 35);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1_10 = new JLabel("M\u00E3 ho\u00E1 \u0111\u01A1n");
		lblNewLabel_1_10.setForeground(Color.BLUE);
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_10.setBounds(24, 0, 89, 35);
		panel_2.add(lblNewLabel_1_10);
		
		txtHoadonSeach = new JTextField();
		txtHoadonSeach.setBounds(123, 0, 154, 35);
		panel_2.add(txtHoadonSeach);
		txtHoadonSeach.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("     Th\u00EAm ho\u00E1 \u0111\u01A1n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MaHD = txtMaHD.getText();
				String NgayBan = txtNgayBan.getText();
				String TongTien = txtTongTien.getText();
				String MaNV = txtMaNV.getText();
				String MaKH = txtMaKH.getText();
				HoaDonsetget hd = new HoaDonsetget(MaHD, NgayBan, TongTien, MaNV,MaKH);
				HoaDonModify.insert(hd);

				ShowProduce();
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("E:\\Java destop\\Icon\\c\u1ED9ng.png"));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(51, 497, 203, 40);
		add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("       Xo\u00E1");
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setIcon(new ImageIcon("E:\\Java destop\\Icon\\save.png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if (selectedIndex >= 0) {
					HoaDonsetget hd = HD.get(selectedIndex);
					int option = JOptionPane.showInternalConfirmDialog(null, "Bạn có muốn xóa nhân viên này không", "Xóa", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						HoaDonModify.delete(hd.getMaHD());
						ShowProduce();
					}
				}
			}
		});
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(338, 497, 152, 40);
		add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("       \u0110\u00F3ng");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon("E:\\Java destop\\Icon\\exit.png"));
		btnNewButton_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_2.setForeground(Color.BLUE);
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_2.setBounds(810, 497, 152, 40);
		add(btnNewButton_1_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 208, 960, 265);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 960, 265);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Ma ho\u00E1 \u0111\u01A1n", "Ma nh\u00E2n vi\u00EAn", "Ng\u00E0y b\u00E1n", "M\u00E3 kh\u00E1ch", "T\u1ED5ng ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnHinThDs = new JButton("       Hi\u1EC3n th\u1ECB DS");
		btnHinThDs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] Name = { "MaHD", "NgayBan", "TongTien","MaNV","MaKH" };
				tableModel.setColumnIdentifiers(Name);
				table.setModel(tableModel);
				Connection conn = null;
				Statement st = null;
				ResultSet rs = null;
				try {
					String dbURL = "jdbc:sqlserver://localhost; databaseName=QL_BanHang; user=sa; password=123";
					conn = DriverManager.getConnection(dbURL);
					String sql = "select * from HoaDon";
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					while (rs.next()) {
						String rows[] = new String[5];
						rows[0] = rs.getString(1);
						rows[1] = rs.getString(2);
						rows[2] = rs.getString(3);
						rows[3] = rs.getString(4);
						rows[4] = rs.getString(5);
						tableModel.addRow(rows);
					}
					conn.close();
					st.close();
					rs.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				} 
			}
		});
		btnHinThDs.setForeground(Color.BLUE);
		btnHinThDs.setIcon(new ImageIcon("E:\\Java destop\\Icon\\show.png"));
		btnHinThDs.setHorizontalAlignment(SwingConstants.LEFT);
		btnHinThDs.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHinThDs.setBounds(556, 496, 203, 40);
		add(btnHinThDs);
		
	}
	protected void ShowProduce() {
		HD = HoaDonModify.find();
		tableModel.setRowCount(0);
		for ( HoaDonsetget hd : HD ) { 
			tableModel.addRow(new Object[] { hd.getMaHD(), hd.getNgayBan(), hd.getTongTien(), hd.getMaNV(),hd.getMaKH() });
		}
		
	}

}
