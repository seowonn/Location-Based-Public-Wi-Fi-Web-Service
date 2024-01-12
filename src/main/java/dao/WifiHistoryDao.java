package dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import dbConnection.ConnectDB;
import dto.WifiHistoryDto;

public class WifiHistoryDao {
	
	public WifiHistoryDao() {}
	
	public static void insertSearchData(String lat, String lnt) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO SEARCH_HISTORY(LNT, LAT, VIEW_DATE)"
				+ "VALUES (?, ?, ?);";
		
		try {
			
			conn = ConnectDB.connectDB();
			
			pstmt = conn.prepareStatement(insertQuery);
			conn.setAutoCommit(false);
			
			pstmt.setString(1, lnt);
			pstmt.setString(2, lat);
			
			String date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
			pstmt.setString(3, date);
			
			pstmt.executeUpdate();
			
			conn.commit();
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectDB.close(conn, pstmt, null);
		}
	}
	
	public List<WifiHistoryDto> getSearchedWifis() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		List<WifiHistoryDto> searchedWifisInfo = new ArrayList<>();
		
		String getSearchedWifisQuery = " SELECT *" +
				" FROM SEARCH_HISTORY" +
				" ORDER BY COL DESC;";
		
		try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			resultSet = stmt.executeQuery(getSearchedWifisQuery);
			
			while(resultSet.next()) {
				
				WifiHistoryDto searchedWifi = WifiHistoryDto.builder()
						.col(resultSet.getInt("col"))
						.lnt(resultSet.getString("lnt"))
						.lat(resultSet.getString("lat"))
						.view_date(resultSet.getString("view_date"))
						.build();
				
				searchedWifisInfo.add(searchedWifi);
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectDB.close(conn, stmt, resultSet);
		}
		
		return searchedWifisInfo;
	}
	
	
	public boolean deleteSearchedWifi(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String deleteQuery = "DELETE FROM SEARCH_HISTORY "
				+ "WHERE COL = ?";
		
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
