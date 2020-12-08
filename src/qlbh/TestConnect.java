package qlbh;

import java.io.ObjectInputStream.GetField;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestConnect {
	public static ArrayList<String>LoadDatatoComboBox(){
		ArrayList<String> dsach=new ArrayList<String>();
		Connection conn=null;
		ResultSet rs= null;
		try {
			String dbURL="jdbc:sqlserver://LAPTOP-MMENMFDT\\SQLEXPRESS;databaseName:ketnoi_sv;user=sa;password=123";
			conn = DriverManager.getConnection(dbURL);
			//Query
			String sql ="select name from student";
			Statement st = conn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				  // lấy dữ liệu từ data đổ vào combobox
				dsach.add(rs.getString("name"));
				}
			}catch (SQLException ex) {
					}
			return dsach;
		}


}
