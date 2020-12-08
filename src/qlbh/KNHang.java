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

public class KNHang {
	public static ArrayList<Hangs> getAll() {
		ArrayList<Hangs> dsH = new ArrayList<>();
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from Hang";
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {// trung voi ten cot trong csdl
				Hangs kh = new Hangs(result.getString("MaHang"), result.getString("TenHang"), result.getString("SoLuong"),
						result.getString("DonGia"));
				dsH.add(kh);
			}
			result.close();
			statement.close();
			conn.close();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsH;
	}

	public static void insert(Hangs kh) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			// query
			String sql = "insert into Hang(MaHang, TenHang, SoLuong, DonGia) values(?,?,?,?)";

			statement = conn.prepareCall(sql);
			statement.setString(1, kh.getMaHang());
			statement.setString(2, kh.getTenHang());
			statement.setString(3, kh.getSoLuong());
			statement.setString(4, kh.getDonGia());
			statement.execute();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	public static void delete(String MaHang) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=SA;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "delete from Hang where MaHang=?";
			statement = conn.prepareCall(sql);
			statement.setString(1, MaHang);
			statement.execute();
			statement.close();
			conn.close();

		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	public static List<Hangs> find (String TenHang) {
		List<Hangs> dsH = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "select * from Hang where TenHang like ?";
			statement = conn.prepareCall(sql);
			statement.setString(1, "%" + TenHang + "%");
			result = statement.executeQuery();

			while (result.next()) {// trung voi ten cot trong csdl
				Hangs h = new Hangs(result.getString("MaHang"), result.getString("TenHang"), result.getString("SoLuong"),
						result.getString("DonGia"));
				dsH.add(h);
			}
			result.close();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return dsH;
	}
}
