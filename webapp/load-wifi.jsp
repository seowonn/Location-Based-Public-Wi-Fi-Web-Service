<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
%>
<%-- MEMBMER 테이블의 내용
<table width="100%" border="1">
<tr>
	<td>이름</td><td>아이디</td><td>이메일</td>
</tr>
<%
	Class.forName("org.sqlite.JDBC");       
	
	Connection conn = null;    
	Statement stmt = null;
	ResultSet rs = null;
	
	String countQuery = "SELECT COUNT(*) FROM SEOUL_WIFI;";
	
	try {
		String dbFileUrl = "jdbc:sqlite:C:/java/eclipse-workspace/Mission1Project/Mission1.db";
		conn = DriverManager.getConnection(dbFileUrl);
		%>out.println(conn);<%
		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(countQuery);
  		
  		while(rs.next()) {
  		%>
  			<b><%=Integer.parseInt(rs.getString(1))%>개의 WIFI 정보를 정상적으로 저장하였습니다.</b><br/>
  		 <%
  		}
	} catch(SQLException ex) {
		out.println(ex.getMessage());
  		ex.printStackTrace();
  	} finally {
  		rs.close();
		stmt.clos();
		conn.close();
  	}
%>
</table> --%>
  
<%@ page import="sample.PublicWifiInfo" %>
<%
	String cnt = "14497"; 
    PublicWifiInfo api = new PublicWifiInfo();
	
	int totalCount = api.getUploadedDataCnt();

 %>
	<b><%=totalCount%>개의 WIFI 정보를 정상적으로 저장하였습니다.</b><br/>
 <%
%>
    

</body>
</html>