package Database;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DBConnection.ConnectDB;

public class BookMarkedGroups {
	
	public BookMarkedGroups() {}
	
	public boolean insertBookMark(String bookMarkName, String order) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO BOOKMARK_GROUP (NAME, \"ORDER\", REGISTER_DTTM)"
				+ " VALUES (?, ?, ?)";
		
		try {
			
			conn = ConnectDB.connectDB();
			
			pstmt = conn.prepareStatement(insertQuery);
			conn.setAutoCommit(false);
			
			pstmt.setString(1, bookMarkName);
			pstmt.setInt(2, Integer.parseInt(order));

			String date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
			pstmt.setString(3, date);
			
			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
			
		} finally {
			ConnectDB.close(conn, pstmt, null);
		}
		
		return true;
	}
}
