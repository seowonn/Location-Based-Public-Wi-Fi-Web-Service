<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="dao.WifiHistoryDao" %>
<%@ page import="dto.WifiHistoryDto" %>

<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">
	<title>와이파이 정보 구하기</title>
</head>
<body>
    <h1>위치 히스토리 목록</h1>
      <nav id="nav1">
		<span><a href="index.jsp">홈</a></span> |
		<span><a href="history.jsp">위치 히스토리 목록</a></span> |
		<span><a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a></span> |
		<span><a href="#">북마크 보기</a></span> |
		<span><a href="bookmark-group.jsp">북마크 그룹 관리</a></span>
	  </nav>
	 <p></p>
	 
	 <div>
	    <table id="infoTable">
	    	<thead>
		    <tr>
		    	<th>ID</th>
		    	<th>X좌표</th>
		    	<th>Y좌표</th>
		    	<th>조회일자</th>
		    	<th>비고</th>
		    </tr>
		    </thead>
		    <tbody>
		    	<%
		    	WifiHistoryDao swf = new WifiHistoryDao();
		    			    		    			List<WifiHistoryDto> results = swf.getSearchedWifis();
		    			    		    			
		    			    		    			if(results != null) {
		    			    		    				for(WifiHistoryDto serachedWifi : results) {
		    	%>
		    		<tr class="colored">
		    			<td><%=serachedWifi.getCol()%></td>
		    			<td><%=serachedWifi.getLat()%></td>
		    			<td><%=serachedWifi.getLnt()%></td>
		    			<td><%=serachedWifi.getView_date()%></td>
		    			<td>
		    			<form action="history-delete-submit.jsp" method="post">
		    				<button type="submit" name="id" value="<%=serachedWifi.getCol()%>">삭제</button>
		    			</form>
		    			</td>
		    		</tr>	
	    		<%}%>
	    		<%} else {%>
			    	<tr height= "70">
			    		<th scope="row" colspan="100%">검색 기록이 없습니다.</th>
			    	</tr>
				<%}%>
		    </tbody>
	    </table>
    </div>

</body>
</html>