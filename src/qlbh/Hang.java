package qlbh;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Hang extends JPanel {
	
	private JTextField textMH;
	private JTextField txtSL;
	private JTextField  txtDG;
	private JTable table;
	ArrayList<Hangs> dsH = new ArrayList<>();
	private DefaultTableModel tableModel= new DefaultTableModel();
	private JTextField txtTenHang;
	
	protected Object cmd1;
	private JTextField texttkhh;
	/**
	 * Create the panel.
	 */
	public Hang() {
		setLayout(null);
		
		JLabel lblDanhMcHng = new JLabel("DANH M\u1EE4C H\u00C0NG HO\u00C1");
		lblDanhMcHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhMcHng.setForeground(Color.BLUE);
		lblDanhMcHng.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDanhMcHng.setBounds(10, 10, 980, 54);
		add(lblDanhMcHng);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 81, 980, 384);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 h\u00E0ng");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 10, 100, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn h\u00E0ng");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 50, 100, 30);
		panel.add(lblNewLabel_1_1);
		
		textMH = new JTextField();
		textMH.setColumns(10);
		textMH.setBounds(120, 10, 300, 30);
		panel.add(textMH);
		
		 txtTenHang = new JTextField();
		txtTenHang.setColumns(10);
		txtTenHang.setBounds(120, 50, 300, 30);
		panel.add(txtTenHang);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(515, 10, 100, 30);
		panel.add(lblNewLabel_1_1_1);
		
		txtSL = new JTextField();
		txtSL.setColumns(10);
		txtSL.setBounds(652, 10, 300, 30);
		panel.add(txtSL);
		
		txtDG = new JTextField();
		txtDG.setColumns(10);
		txtDG.setBounds(652, 50, 300, 30);
		panel.add(txtDG);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel_1_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(515, 50, 100, 30);
		panel.add(lblNewLabel_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 960, 239);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 h\u00E0ng", "T\u00EAn h\u00E0ng", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 470, 970, 120);
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("   Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MaHang = textMH.getText();
				String TenHang = txtTenHang.getText();
				String SoLuong = txtSL.getText();
				String DonGia = txtDG.getText();
				//
				Hangs h = new Hangs(MaHang, TenHang, SoLuong, DonGia);
				KNHang.insert(h);
				ShowProduce();
			}
			
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("E:\\Java destop\\Icon\\c\u1ED9ng.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(117, 10, 150, 40);
		panel_1.add(btnNewButton);
		
		JButton btnTmKim = new JButton("  T\u00ECm ki\u1EBFm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<HoaDon> HD = new ArrayList<>();
				String [] dsHD = {"MaHang", "TenHang","SoLuong","DonGia"};
				tableModel.setColumnIdentifiers(dsHD);
				
				try {
					String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=SA;password=123";
					Connection conn = DriverManager.getConnection(dbURL);
					String sql = "Select * from Hang where MaHang='"+texttkhh.getText()+"'";
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(sql);
					tableModel.setRowCount(0);
					
					if(rs.isBeforeFirst() == false) {
						JOptionPane.showConfirmDialog(null, "thông tin đã tồn tại trong tài khoản");
					}
					
					while(rs.next()) {
						Vector cuscomer = new Vector();
						cuscomer.add(rs.getString("MaHang"));
						cuscomer.add(rs.getString("TenHang"));
						cuscomer.add(rs.getString("SoLuong"));
						cuscomer.add(rs.getString("DonGia"));
					
						
						tableModel.addRow(cuscomer);
					}
					table.setModel(tableModel);
			
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnTmKim.setIcon(new ImageIcon("E:\\Java destop\\Icon\\TK.png"));
		btnTmKim.setHorizontalAlignment(SwingConstants.LEFT);
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTmKim.setBounds(117, 70, 150, 40);
		panel_1.add(btnTmKim);
		
		JButton btnXo = new JButton("     Xo\u00E1");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				if (selectedIndex >= 0) {
					Hangs kh = dsH.get(selectedIndex);
					int option = JOptionPane.showInternalConfirmDialog(null, "Báº¡n cĂ³ muá»‘n xĂ³a nhĂ¢n viĂªn nĂ y khĂ´ng", "XĂ³a", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						KNHang.delete(kh.getMaHang());
						ShowProduce();
					}
				}
			}
		});
		btnXo.setIcon(new ImageIcon("E:\\Java destop\\Icon\\delete.png"));
		btnXo.setHorizontalAlignment(SwingConstants.LEFT);
		btnXo.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnXo.setBounds(398, 10, 159, 40);
		panel_1.add(btnXo);
		
		JButton btnHinThDs = new JButton("   Hi\u1EC3n th\u1ECB DS");
		btnHinThDs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] Name = { "MaHang", "TenHang", "SoLuong","DonGia" };
				tableModel.setColumnIdentifiers(Name);
				table.setModel(tableModel);
				Connection conn = null;
				Statement st = null;
				ResultSet rs = null;
				try {
					String dbURL = "jdbc:sqlserver://LAPTOP-MMENMFDT\\SQLEXPRESS; databaseName=QL_BanHang; user=sa; password=123";
					conn = DriverManager.getConnection(dbURL);
					String sql = "select* from Hang";
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
				} 
			}
		});
		btnHinThDs.setIcon(new ImageIcon("E:\\Java destop\\Icon\\show.png"));
		btnHinThDs.setHorizontalAlignment(SwingConstants.LEFT);
		btnHinThDs.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHinThDs.setBounds(684, 10, 159, 40);
		panel_1.add(btnHinThDs);
		
		JButton btnng = new JButton("     \u0110\u00F3ng");
		btnng.setIcon(new ImageIcon("E:\\Java destop\\Icon\\exit.png"));
		btnng.setHorizontalAlignment(SwingConstants.LEFT);
		btnng.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnng.setBounds(684, 70, 150, 40);
		panel_1.add(btnng);
		
		texttkhh = new JTextField();
		texttkhh.setBounds(277, 70, 281, 40);
		panel_1.add(texttkhh);
		texttkhh.setColumns(10);

	}
	protected void ShowProduce() {
		dsH = KNHang.getAll();
		tableModel.setRowCount(0);
		for (Hangs sp : dsH) { // TEN BEN LIST
			tableModel.addRow(new Object[] { sp.getMaHang(), sp.getTenHang(), sp.getSoLuong(), sp.getDonGia() });
		}
		
	}
}
