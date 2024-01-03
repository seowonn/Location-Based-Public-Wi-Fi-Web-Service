package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class PublicWifiInfo {
    private String X_SWIFI_MGR_NO;   
    private String X_SWIFI_WRDOFC;   
    private String X_SWIFI_MAIN_NM;   
    private String X_SWIFI_ADRES1;   
    private String X_SWIFI_ADRES2;   
    private String X_SWIFI_INSTL_FLOOR;   
    private String X_SWIFI_INSTL_TY;   
    private String X_SWIFI_INSTL_MBY;   
    private String X_SWIFI_SVC_SE;   
    private String X_SWIFI_CMCWR;   
    private String X_SWIFI_CNSTC_YEAR;   
    private String X_SWIFI_INOUT_DOOR;   
    private String X_SWIFI_REMARS3;   
    private String LAT;   
    private String LNT;   
    private String WORK_DTTM;   
    
    PublicWifiInfo(){}
    
    public PublicWifiInfo(String x_SWIFI_MGR_NO, String x_SWIFI_WRDOFC, String x_SWIFI_MAIN_NM, String x_SWIFI_ADRES1,
			String x_SWIFI_ADRES2, String x_SWIFI_INSTL_FLOOR, String x_SWIFI_INSTL_TY, String x_SWIFI_INSTL_MBY,
			String x_SWIFI_SVC_SE, String x_SWIFI_CMCWR, String x_SWIFI_CNSTC_YEAR, String x_SWIFI_INOUT_DOOR,
			String x_SWIFI_REMARS3, String lAT, String lNT, String wORK_DTTM) {
		this.X_SWIFI_MGR_NO = x_SWIFI_MGR_NO;
		this.X_SWIFI_WRDOFC = x_SWIFI_WRDOFC;
		this.X_SWIFI_MAIN_NM = x_SWIFI_MAIN_NM;
		this.X_SWIFI_ADRES1 = x_SWIFI_ADRES1;
		this.X_SWIFI_ADRES2 = x_SWIFI_ADRES2;
		this.X_SWIFI_INSTL_FLOOR = x_SWIFI_INSTL_FLOOR;
		this.X_SWIFI_INSTL_TY = x_SWIFI_INSTL_TY;
		this.X_SWIFI_INSTL_MBY = x_SWIFI_INSTL_MBY;
		this.X_SWIFI_SVC_SE = x_SWIFI_SVC_SE;
		this.X_SWIFI_CMCWR = x_SWIFI_CMCWR;
		this.X_SWIFI_CNSTC_YEAR = x_SWIFI_CNSTC_YEAR;
		this.X_SWIFI_INOUT_DOOR = x_SWIFI_INOUT_DOOR;
		this.X_SWIFI_REMARS3 = x_SWIFI_REMARS3;
		this.LAT = lAT;
		this.LNT = lNT;
		this.WORK_DTTM = wORK_DTTM;
	}
    
    
    private Connection connect() {
    	// SQLite connection string
    	String dbFileUrl = "jdbc:sqlite:Mission1.db";
    	Connection conn = null;
    	try {
    		Class.forName("org.sqlite.JDBC");
    		conn = DriverManager.getConnection(dbFileUrl);
    	} catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return conn;
    }
    
    
    public void printWifiInfo() {
		System.out.println("관리번호" + ":" + this.X_SWIFI_MGR_NO);
		System.out.println("자치구" + ":" + this.X_SWIFI_WRDOFC);
		System.out.println("와이파이명" + ":" + this.X_SWIFI_MAIN_NM);
		System.out.println("도로명주소" + ":" + this.X_SWIFI_ADRES1);
		System.out.println("상세주소" + ":" + this.X_SWIFI_ADRES2);
		System.out.println("설치위치(층)" + ":" + this.X_SWIFI_INSTL_FLOOR);
		System.out.println("설치유형" + ":" + this.X_SWIFI_INSTL_TY);
		System.out.println("설치기관" + ":" + this.X_SWIFI_INSTL_MBY);
		System.out.println("서비스구분" + ":" + this.X_SWIFI_SVC_SE);
		System.out.println("망종류" + ":" + this.X_SWIFI_CMCWR);
		System.out.println("설치년도" + ":" + this.X_SWIFI_CNSTC_YEAR);
		System.out.println("실내외구분" + ":" + this.X_SWIFI_INOUT_DOOR);
		System.out.println("wifi접속환경" + ":" + this.X_SWIFI_REMARS3);
		System.out.println("Y좌표" + ":" + this.LAT);
		System.out.println("X좌표" + ":" + this.LNT);
		System.out.println("작업일자" + ":" + this.WORK_DTTM);
    }
          
    
    public void getInfo() {
    	
    	printWifiInfo();
    	
        Connection conn = null;
        PreparedStatement stmt = null;
        Statement viewSql = null;
        ResultSet rs = null;
		
		String insertSql = "INSERT INTO SEOUL_WIFI(MGR_NO, WRDOFC, MAIN_NM, ADRES1,"
				+ "ADRES2, INSTL_FLOOR, INSTL_TY, INSTL_MBY, SVC_SE, CMCWR,"
				+ "CNSTC_YEAR, INOUT_DOOR, REMARS3, LNT, LAT, WORK_DTTM) VALUES(?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?);";
		
		try {
	        conn = this.connect();
	        viewSql = conn.createStatement();
	        
			String viewQuery = String.format("SELECT MGR_NO FROM SEOUL_WIFI WHERE MGR_NO = '%s'", this.X_SWIFI_MGR_NO);
			rs = viewSql.executeQuery(viewQuery);
			
			while(rs.next()) {
				String manageNum = rs.getString(1);
				if(manageNum != null) {
					Exception e = new Exception("이미 등록된 관리번호: " + manageNum);			
					throw e;	 // 예외를 발생시킴
				}
			}

			stmt = conn.prepareStatement(insertSql);
			
			conn.setAutoCommit(false);
			System.out.println("SQLite DB connected");
			
			stmt.setString(1, this.X_SWIFI_MGR_NO);
			stmt.setString(2, this.X_SWIFI_WRDOFC);
			stmt.setString(3, this.X_SWIFI_MAIN_NM);
			stmt.setString(4, this.X_SWIFI_ADRES1);
			stmt.setString(5, this.X_SWIFI_ADRES2);
			stmt.setString(6, this.X_SWIFI_INSTL_FLOOR);
			stmt.setString(7, this.X_SWIFI_INSTL_TY);
			stmt.setString(8, this.X_SWIFI_INSTL_MBY);
			stmt.setString(9, this.X_SWIFI_SVC_SE);
			stmt.setString(10, this.X_SWIFI_CMCWR);
			stmt.setString(11, this.X_SWIFI_CNSTC_YEAR);
			stmt.setString(12, this.X_SWIFI_INOUT_DOOR);
			stmt.setString(13, this.X_SWIFI_REMARS3);
			stmt.setString(14, this.LNT);
			stmt.setString(15, this.LAT);
			stmt.setString(16, this.WORK_DTTM);
			
			stmt.executeUpdate();
			
            stmt.close();
            
            conn.commit();
            conn.close();
            
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		} finally {
			try {
				conn.setAutoCommit(false);
	            int totalCnt = getTotalDataCnt(conn);
	            System.out.println("저장된 총 데이터 개수 : " + totalCnt);
	            conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
          if (rs != null) try { rs.close(); } catch(Exception e) {}
          if (stmt != null) try { stmt.close(); } catch(Exception e) {}
          if (conn != null) try { conn.close(); } catch(Exception e) {}
          if (viewSql != null) try { viewSql.close(); } catch(Exception e) {}
          System.out.println("Successful Insert query!!");
		}
		
    }
    
    private int getTotalDataCnt(Connection conn) {
    	int totalCnt = 0;
    	String countQuery = "SELECT COUNT(*) FROM SEOUL_WIFI;";
    	
    	ResultSet rs = null;
		try {
			Statement countSql = conn.createStatement();
			rs = countSql.executeQuery(countQuery);
			while(rs.next())
				totalCnt = Integer.parseInt(rs.getString(1));
			countSql.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    	return totalCnt;
    }
}
