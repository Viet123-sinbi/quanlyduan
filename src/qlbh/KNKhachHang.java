package qlbh;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;



public class KNKhachHang {
	public static ArrayList<KhachHangs> getAll() {
		ArrayList<KhachHangs> dsKH = new ArrayList<>();
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from Khach";
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {// trung voi ten cot trong csdl
				KhachHangs kh = new KhachHangs(result.getString("MaKH"), result.getString("TenKH"), result.getString("DiaChi"),
						result.getString("SDT"));
				dsKH.add(kh);
			}
			result.close();
			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsKH;
	}

	public static void insert(KhachHangs kh) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			// query
			String sql = "insert into Khach(MaKH, TenKH, DiaChi, SDT) values(?,?,?,?)";

			statement = conn.prepareCall(sql);
			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getTenKH());
			statement.setString(3, kh.getDiaChi());
			statement.setString(4, kh.getSDT());
			statement.execute();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	public static void delete(String MaKH) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=SA;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "delete from Khach where MaKH=?";
			statement = conn.prepareCall(sql);
			statement.setString(1, MaKH);
			statement.execute();
			statement.close();
			conn.close();

		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	public static List<KhachHangs> find (String TenKH) {
		List<KhachHangs> dsKH = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from Khach where TenKH like ?";
			statement = conn.prepareCall(sql);
			statement.setString(1, "%" + TenKH + "%");
			result = statement.executeQuery();

			while (result.next()) {// trung voi ten cot trong csdl
				KhachHangs kh = new KhachHangs(result.getString("MaKH"), result.getString("TenKH"), result.getString("DiaCHi"),
						result.getString("SDT"));
				dsKH.add(kh);
			}
			result.close();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsKH;
	}
	  
	public static void timkiem (KhachHangs kh){
	
	}
	
}
