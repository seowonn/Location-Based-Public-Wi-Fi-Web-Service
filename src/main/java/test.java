import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DBConnection.ConnectDB;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {			
			String sql = "SELECT * FROM sqlite_master WHERE type = 'table' AND name NOT LIKE 'sqlite_%'";
			
			Connection connection = ConnectDB.connectDB();
			System.out.println(connection);
//			connection.setAutoCommit(false);
			
			
			System.out.println("0");
			connection.setAutoCommit(false);
			
			System.out.println("1");
			Statement st = connection.createStatement();
			System.out.println("2");
			ResultSet rs = st.executeQuery(sql);
			System.out.println("3");
			
			while(rs.next()) {
				System.out.println(rs.getString("tbl_name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
