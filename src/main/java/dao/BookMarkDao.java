package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import dbConnection.ConnectDB;
import dto.BookMarkDto;
import dto.WIfiInfosDto;
import dto.WifiHistoryDto;

public class BookMarkDao {
	
	public BookMarkDao() {}
	
	
	private int getBookMarkGroupId(String bmGroup) throws SQLException{
		
		int id = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectQuery = "SELECT ID FROM BOOKMARK_GROUP "
				+ "WHERE NAME = ?";
		
		try {
			
			conn = ConnectDB.connectDB();
			
			pstmt = conn.prepareStatement(selectQuery);
			conn.setAutoCommit(false);
			
			pstmt.setString(1, bmGroup);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getInt("id");
			}
			
			conn.commit();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			ConnectDB.close(conn, pstmt, rs);
		}
		
		return id;
	}
	
	
	public boolean insertBookMark(String mgrNo,  String bmGroup) {
		
		int id = 0;
		
		try {
			id = getBookMarkGroupId(bmGroup);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO BOOKMARKED_WIFI (MGR_NO, BOOKMARK_NO, REGISTER_DTTM)"
				+ " VALUES (?, ?, ?)";
		
		try {
			
			conn = ConnectDB.connectDB();
			
			pstmt = conn.prepareStatement(insertQuery);
			conn.setAutoCommit(false);
			
			pstmt.setString(1, mgrNo);
			pstmt.setInt(2, id);

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

	
	public List<BookMarkDto> getEveryBookMarkWifi() {
		
		List<BookMarkDto> bookmarks = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String getBookMarkWifiQuery = "SELECT bw.ID, bg.NAME, sw.MAIN_NM, bw.REGISTER_DTTM" +
		  " FROM BOOKMARKED_WIFI AS bw" + 
		  " INNER JOIN SEOUL_WIFI AS sw ON sw.MGR_NO = bw.MGR_NO" +
		  " INNER JOIN BOOKMARK_GROUP AS bg ON bg.ID = bw.BOOKMARK_NO";
		
		try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(getBookMarkWifiQuery);
			
			while(rs.next()) {
				
				BookMarkDto bookmark = BookMarkDto.builder()
						.id(rs.getInt("id"))
						.bookmarkName(rs.getString("name"))
						.wifiName(rs.getString("main_nm"))
						.register_dttm(rs.getString("register_dttm"))
						.build();
				
				bookmarks.add(bookmark);
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			ConnectDB.close(conn, stmt, rs);
		}
		
		return bookmarks;
	}
	
	
	public BookMarkDto getOneBookMarkWifi(String id) {
		
		BookMarkDto bookmark = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String getBookMarkWifiQuery = "SELECT bg.NAME, sw.MAIN_NM, bw.REGISTER_DTTM" +
		  " FROM BOOKMARKED_WIFI AS bw" + 
		  " INNER JOIN SEOUL_WIFI AS sw ON sw.MGR_NO = bw.MGR_NO" +
		  " INNER JOIN BOOKMARK_GROUP AS bg ON bg.ID = bw.BOOKMARK_NO" +
		  " WHERE bw.ID = ?";
		
		try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(getBookMarkWifiQuery);
			pstmt.setInt(1, Integer.parseInt(id));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				bookmark = BookMarkDto.builder()
						.bookmarkName(rs.getString("name"))
						.wifiName(rs.getString("main_nm"))
						.register_dttm(rs.getString("register_dttm"))
						.build();
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			ConnectDB.close(conn, pstmt, rs);
		}
		
		return bookmark;
	}


	public boolean deleteBookMark(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String deleteQuery = "DELETE FROM BOOKMARKED_WIFI "
				+ "WHERE ID = ?";
		
		try {
			conn = ConnectDB.connectDB();
			
			pstmt = conn.prepareStatement(deleteQuery);
			conn.setAutoCommit(false);
			
			pstmt.setInt(1, Integer.parseInt(id));

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
}
