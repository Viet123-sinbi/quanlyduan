package qlbh;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.jdi.connect.spi.TransportService.ListenKey;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class KhachHang extends JPanel {
	protected static final int MaKH = 0;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTable table;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTextField txtTimKiem;
	protected String dbURL;
	protected Object cmd1;
	ArrayList<KhachHangs> dsKH = new ArrayList<>();


	/**
	 * Create the panel.
	 */
	public KhachHang() {
		setLayout(null);
		
		JLabel lblDanhMcKhch = new JLabel("DANH M\u1EE4C KH\u00C1CH H\u00C0NG");
		lblDanhMcKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhMcKhch.setForeground(Color.BLUE);
		lblDanhMcKhch.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDanhMcKhch.setBounds(10, 10, 980, 54);
		add(lblDanhMcKhch);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 74, 965, 386);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 24, 119, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 64, 119, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(515, 24, 100, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblNewLabel_1_3.setForeground(Color.BLUE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(515, 64, 100, 30);
		panel.add(lblNewLabel_1_3);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(139, 24, 300, 30);
		panel.add(txtMaKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(139, 64, 300, 30);
		panel.add(txtTenKH);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(625, 24, 300, 30);
		panel.add(txtDiaChi);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(625, 64, 300, 30);
		panel.add(txtSDT);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 945, 253);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 470, 970, 120);
		add(panel_1);
		
		JButton btnNewButton = new JButton("   Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MaKH = txtMaKH.getText();
				String TenKH = txtTenKH.getText();
				String DiaChi = txtDiaChi.getText();
				String SDT = txtSDT.getText();
				// pháº£i Ä‘Ăºng trĂ¬nh tá»± bĂªn LĂ�
				KhachHangs kh = new KhachHangs(MaKH, TenKH, DiaChi, SDT);
				KNKhachHang.insert(kh);

				ShowProduce();
			}
		});
		btnNewButton.setIcon(new ImageIcon("E:\\Java destop\\Icon\\c\u1ED9ng.png"));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(61, 10, 150, 40);
		panel_1.add(btnNewButton);
		
		JButton btnTmKim = new JButton("  T\u00ECm ki\u1EBFm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<KhachHang> kh= new ArrayList<>();
				String [] kh1 = {"MaKH", "TenKH","DiaChi","SDT"};
				tableModel.setColumnIdentifiers(kh1);
				
				try {
					String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=SA;password=123";
					Connection conn = DriverManager.getConnection(dbURL);
					String sql = "Select * from Khach where MaKH='"+txtTimKiem.getText()+"'";
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(sql);
					tableModel.setRowCount(0);
					
					if(rs.isBeforeFirst() == false) {
						JOptionPane.showConfirmDialog(null, "Thông tin hoá đơn này không tồn tại");
					}
					
					while(rs.next()) {
						Vector cuscomer = new Vector();
						cuscomer.add(rs.getString("MaKH"));
						cuscomer.add(rs.getString("TenKH"));
						cuscomer.add(rs.getString("DiaChi"));
						cuscomer.add(rs.getString("SDT"));
						
						
						tableModel.addRow(cuscomer);
					}
					table.setModel(tableModel);
					txtMaKH.setText("");
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}	
			}
		});
		
		btnTmKim.setIcon(new ImageIcon("E:\\Java destop\\Icon\\TK.png"));
		btnTmKim.setHorizontalAlignment(SwingConstants.LEFT);
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTmKim.setBounds(292, 70, 150, 40);
		panel_1.add(btnTmKim);
		
		JButton btnXo = new JButton("     Xo\u00E1");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if (selectedIndex >= 0) {
					KhachHangs kh = dsKH.get(selectedIndex);
					int option = JOptionPane.showInternalConfirmDialog(null, "Báº¡n cĂ³ muá»‘n xĂ³a nhĂ¢n viĂªn nĂ y khĂ´ng", "XĂ³a", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						KNKhachHang.delete(kh.getMaKH());
						ShowProduce();
					}
				}
			}
		});
		btnXo.setIcon(new ImageIcon("E:\\Java destop\\Icon\\delete.png"));
		btnXo.setHorizontalAlignment(SwingConstants.LEFT);
		btnXo.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnXo.setBounds(307, 10, 159, 40);
		panel_1.add(btnXo);
		
		JButton btnHinThDs = new JButton("   Hi\u1EC3n th\u1ECB DS");
		btnHinThDs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String note = JOptionPane.showInputDialog(panel, "Nháº­p tĂªn báº¡n muá»‘n tĂ¬m kiáº¿m?");
//				if (note.length() >= 0) {
//					dsKH = KhachHangs.find(note);
//				}
//				tableModel.setRowCount(0);
//				for (KhachHangs kh : dsKH ) {
//					tableModel.addRow(new Object[] { kh.getMaKH(), kh.getTenKH(), kh.getDiaChi(), kh.getSDT() });
//				}
				String[] Name = { "MaKH", "TenKH", "DiaChi","SDT" };
				tableModel.setColumnIdentifiers(Name);
				table.setModel(tableModel);
				Connection conn = null;
				Statement st = null;
				ResultSet rs = null;
				try {
					String dbURL = "jdbc:sqlserver://localhost; databaseName=QL_BanHang; user=sa; password=123";
					conn = DriverManager.getConnection(dbURL);
					String sql = "select * from Khach";
					st = conn.createStatement();
					rs = st.executeQuery(sql);
					while (rs.next()) {
						String rows[] = new String[4];
						rows[0] = rs.getString(1);
						rows[1] = rs.getString(2);
						rows[2] = rs.getString(3);
						rows[3] = rs.getString(4);
						tableModel.addRow(rows);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					try {
						if (conn != null) {
							conn.close();
						}
						if (st != null) {
							st.close();
						}
						if (rs != null) {
							rs.close();
						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
				}
			}
		});
		btnHinThDs.setIcon(new ImageIcon("E:\\Java destop\\Icon\\show.png"));
		btnHinThDs.setHorizontalAlignment(SwingConstants.LEFT);
		btnHinThDs.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHinThDs.setBounds(536, 10, 172, 40);
		panel_1.add(btnHinThDs);
		
		JButton btnng = new JButton("     \u0110\u00F3ng");
		btnng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnng.setIcon(new ImageIcon("E:\\Java destop\\Icon\\exit.png"));
		btnng.setHorizontalAlignment(SwingConstants.LEFT);
		btnng.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnng.setBounds(792, 10, 150, 40);
		panel_1.add(btnng);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(452, 70, 211, 40);
		panel_1.add(txtTimKiem);
		txtTimKiem.setColumns(10);

	}

	protected void ShowProduce() {
		dsKH = KNKhachHang.getAll();
		tableModel.setRowCount(0);
		for (KhachHangs sp : dsKH) { // TEN BEN LIST
			tableModel.addRow(new Object[] { sp.getMaKH(), sp.getTenKH(), sp.getDiaChi(), sp.getSDT() });
		}
		
	}

}
