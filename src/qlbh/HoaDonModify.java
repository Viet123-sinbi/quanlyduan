package HoaDon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;

import KhachHang.KhachHangs;

public class HoaDonModify {
	public static List<HoaDon> find(){
		List<HoaDon> HD = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=sa;password=123";
			connection = DriverManager.getConnection(dbURL);
			String sql = "select * from HoaDon";
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			
			while (result.next()) {
				HoaDonsetget hd = new HoaDonsetget(result.getString("MaHD"), result.getString("NgayBan"), result.getString("TongTien"),
						result.getString("MaNV"),result.getString("MaKH"));
				HD.add(hd);
			}
			result.close();
			statement.close();
			connection.close();
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return (List<HoaDon>) HD;
	}
	public static void insert(HoaDonsetget hd) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);

			// query
			String sql = "insert into HoaDon(MaHD, NgayBan, TongTien,MaNV,MaKH) values(?,?,?,?,?)";

			statement = conn.prepareCall(sql);
			statement.setString(1, hd.getMaHD());
			statement.setString(2, hd.getNgayBan());
			statement.setString(3, hd.getTongTien());
			statement.setString(4, hd.getMaNV());
			statement.setString(5, hd.getMaKH());
			
			statement.execute();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	public static void delete(String MaHD) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_BanHang;user=SA;password=123";
			conn = DriverManager.getConnection(dbURL);
			String sql = "delete from HoaDon where MaHD=?";
			statement = conn.prepareCall(sql);
			statement.setString(1, MaHD);
			statement.execute();
			statement.close();
			conn.close();

		} 
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
}
