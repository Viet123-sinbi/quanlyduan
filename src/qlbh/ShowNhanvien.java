package qlbh;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class ShowNhanvien {
	public static List<NHANVIEN1> findAll() {
		List<NHANVIEN1> list = new ArrayList<>();
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://LAPTOP-J2TPH44U\\SQLEXPRESS;databaseName=QL_BanHang;user=sa;password=123456";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from NhanVien";
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				NHANVIEN1 nhanvien1 = new NHANVIEN1(result.getString("MaNV"), result.getString("TenNV"), result.getString("DiaChi"),
						result.getFloat("SDT"), result.getString("NgaySinh"));
				list.add(nhanvien1);
			}
			result.close();
			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return list;
	}
	
	public static void insert(NHANVIEN1 Nhanvien) {
		String dbURL = "jdbc:sqlserver://LAPTOP-J2TPH44U\\SQLEXPRESS;databaseName=QL_BanHang;user=sa;password=123456";
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DriverManager.getConnection(dbURL);

			String sql = "insert into NhanVien (MaNV, TenNV, DiaChi, DianThoai, NgaySinh) values(?,?,?,?,?)";
			st = conn.prepareCall(sql);
			st.setString(1, Nhanvien.getMaNV());
			st.setString(2, Nhanvien.getTenNV());
			st.setString(3, Nhanvien.getDiaChi());
			st.setFloat(4, Nhanvien.getSDT());
			st.setString(5, Nhanvien.getNgaySinh());
			st.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	public static void delete(String MaNV) {
		String dbURL = "jdbc:sqlserver://LAPTOP-J2TPH44U\\SQLEXPRESS;databaseName=QL_BanHang;user=sa;password=123456";
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DriverManager.getConnection(dbURL);

			String sql = "delete from NhanVien where MaNV=?";
			st = conn.prepareCall(sql);

			st.setString(1, MaNV);
			st.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	public static void insert(LOGIN1 lg) {
		String dbURL = "jdbc:sqlserver://LAPTOP-MMENMFDT\\SQLEXPRESS;databaseName=QL_BanHang;user=sa;password=123456";
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DriverManager.getConnection(dbURL);

			String sql = "insert into dbo.Login (Username, Password) values(?,?)";
			st = conn.prepareCall(sql);
			st.setString(1, lg.getUsername());
			st.setString(2, lg.getPassword());
			st.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

	public static List<NHANVIEN1> find(String TenNV) {
		List<NHANVIEN1> dsSP = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from DIENTHOAI where TENDT like ?";
			statement = conn.prepareCall(sql);
			statement.setString(1, "%" + TenNV + "%");

			rs = statement.executeQuery();

			while (rs.next()) {// trung voi ten cot trong csdl
				NHANVIEN1 sp = new NHANVIEN1(rs.getString("MaNV"), rs.getString("HoTenNV"), rs.getString("DiaChi"),
						rs.getFloat("DienThoai"),rs.getString("NgaySinh"));
				dsSP.add(sp);
			}
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsSP;
	}
}



