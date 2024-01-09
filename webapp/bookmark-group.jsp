<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="Database.SearchedWifis" %>
<%@ page import="DTO.SearchedWifiDto" %>
<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">
	<title>와이파이 정보 구하기</title>
</head>
<body>
	<h1>북마크 그룹</h1>
	<nav id="nav1">
		<span><a href="index.jsp">홈</a></span> |
		<span><a href="history.jsp">위치 히스토리 목록</a></span> |
		<span><a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a></span> |
		<span><a href="#">북마크 보기</a></span> |
		<span><a href="bookmark-group.jsp">북마크 그룹 관리</a></span>
	 </nav>
	 <p></p>
	 
	 <button onclick="location.href='bookmark-group-add.jsp'">북마크 그룹 이름 추가</button>
	 <p></p>
	 
	 <div>
	    <table id="infoTable">
	    	<thead>
		    <tr>
		    	<th>ID</th>
		    	<th>북마크 이름</th>
		    	<th>순서</th>
		    	<th>등록일자</th>
		    	<th>수정일자</th>
		    	<th>비고</th>
		    </tr>
		    </thead>
		    <tbody>
		    	<%
		    		SearchedWifis swf = new SearchedWifis();
	    			List<SearchedWifiDto> results = swf.getSearchedWifis();
	    			
	    			if(results != null) {
	    				for(SearchedWifiDto serachedWifi : results) {		    					
		    				
		    	%>
		    		<tr class="colored">
		    			<td><%=serachedWifi.getCol()%></td>
		    			<td><%=serachedWifi.getLat()%></td>
		    			<td><%=serachedWifi.getLnt()%></td>
		    			<td><%=serachedWifi.getView_date()%></td>
		    			<td><%=serachedWifi.getView_date()%></td>
		    			<td><input type="button" onclick="getCurrentPositionLatLng()" value="삭제"/></td>
		    		</tr>			
	    		<%}%>
	    		<%} else {%>
			    	<tr height= "70">
			    		<th scope="row" colspan="100%">정보가 존재하지 않습니다.</th>
			    	</tr>
				<%}%>
		    </tbody>
	    </table>
    </div>

</body>
</html>