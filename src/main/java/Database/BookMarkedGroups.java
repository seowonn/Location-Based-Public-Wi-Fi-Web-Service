package Database;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import DTO.BookMarkGroupDto;
import DBConnection.ConnectDB;

public class BookMarkedGroups {
	
	public BookMarkedGroups() {}
	
	public List<BookMarkGroupDto> getEveryBookMarks(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<BookMarkGroupDto> bookMarkGroups = new ArrayList<>();
		
		String selectQuery = "SELECT * FROM BOOKMARK_GROUP";
		
		try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
			
			while(rs.next()) {
				
				BookMarkGroupDto bmd = BookMarkGroupDto.builder()
						.id(rs.getInt("id"))
						.bookmarkName(rs.getString("name"))
						.order(rs.getString("order"))
						.register_date(rs.getString("register_dttm"))
						.update_date(rs.getString("update_dttm"))
						.build();
				
				bookMarkGroups.add(bmd);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectDB.close(conn, stmt, rs);
		}
		return bookMarkGroups;
	}
	
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
