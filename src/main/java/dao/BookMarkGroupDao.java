package dao;

import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dbConnection.ConnectDB;
import dto.BookMarkGroupDto;

public class BookMarkGroupDao {
	
	
	public BookMarkGroupDao() {}
	
	
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
	
	
	public boolean insertBookMarkGroup(String bookMarkName, String order) {
		
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
	
	
	public BookMarkGroupDto selectOneBookMarkGroup(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BookMarkGroupDto bmd = null;
		
		String selectQuery = "SELECT * FROM BOOKMARK_GROUP WHERE ID = ? ";
		
		try {
			conn = ConnectDB.connectDB();
			pstmt = conn.prepareStatement(selectQuery);
			conn.setAutoCommit(false);
			pstmt.setInt(1, Integer.parseInt(id));
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				bmd = BookMarkGroupDto.builder()
						.bookmarkName(rs.getString("name"))
						.order(rs.getString("order"))
						.build();
			}
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectDB.close(conn, pstmt, rs);
		}
		
		return bmd;
	}
	
	
	public boolean deleteBookMarkGroup(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String deleteQuery = "DELETE FROM BOOKMARK_GROUP "
				+ "WHERE ID = ?";
		
		try {
			conn = ConnectDB.connectDB();
			
			pstmt = conn.prepareStatement(deleteQuery);
			conn.setAutoCommit(false);
			
			pstmt.setInt(1, Integer.parseInt(id));

			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch(Exception e) {
			
			return false;
			
		} finally {
			ConnectDB.close(conn, pstmt, null);
		}
		
		return true;
	}
	
	
	public boolean updateBookMarkGroup(String id, String bookMarkName, String order) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String updateQuery = "UPDATE BOOKMARK_GROUP "
				+ "SET NAME = ?, \"ORDER\" = ?, UPDATE_DTTM = ? "
				+ "WHERE ID = ?";
		
		try {
			conn = ConnectDB.connectDB();
			
			pstmt = conn.prepareStatement(updateQuery);
			conn.setAutoCommit(false);
			
			pstmt.setString(1, bookMarkName);
			pstmt.setString(2, order);
			
			String date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
			pstmt.setString(3, date);
			
			pstmt.setInt(4, Integer.parseInt(id));
		
			pstmt.executeUpdate();
			conn.commit();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
			
		} finally {
			ConnectDB.close(conn, pstmt, null);
		}
		
		return true;
	}
	
	
	public List<String> getBookMarkGroup(){
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<String> list = new ArrayList<>();
		
		String selectQuery = "SELECT DISTINCT NAME FROM BOOKMARK_GROUP";
		
		try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
			
			while(rs.next()) {
				list.add(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectDB.close(conn, stmt, rs);
		}
		
		return list;
	}
}
