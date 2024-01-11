package dbConnection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	
	public static Connection connectDB() {
				
		Connection connection = null;		 
		
		try {	
			// 메모리에 JDBC 드라이버를 로드한다. 
			Class.forName("org.sqlite.JDBC"); 
			// 주어진 드라이버를 가지고 작성된 경로의 디비에 연결한다. 	
			connection = DriverManager.getConnection("jdbc:sqlite:" + "C:/java/eclipse-workspace/Mission1Project/Mission1.db"); 
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		
		try {		
			
			if(connection != null) connection.close();
			if(statement != null) statement.close();
			if(resultSet != null) resultSet.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
