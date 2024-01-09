<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="Database.NearWifis" %>
<%@ page import="DTO.NearWifiDto" %>

<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">
	<title>와이파이 정보 구하기</title>
</head>

<body>
    <h1>와이파이 정보 구하기</h1>
      <nav id="nav1">
		<span><a href="index.jsp">홈</a></span> |
		<span><a href="history.jsp">위치 히스토리 목록</a></span> |
		<span><a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a></span> |
		<span><a href="#">북마크 보기</a></span> |
		<span><a href="bookmark-group.jsp">북마크 그룹 관리</a></span>		
	  </nav>
	 <p></p>
	 
	<%
    	request.setCharacterEncoding("UTF-8");
    
    	String lat = request.getParameter("lat");
    	String lnt = request.getParameter("lnt");
    %>
	 
	<script src="test.js"></script>
	
	<form action="aroundWifiInfo.jsp" method="get">
		<div class="input">
			<span>LAT: <input id="currentLat" name="lat" type="text" value=<%=lat%>> ,</span>
			<span> LNT: <input id="currentLnt" name="lnt" type="text" value=<%=lnt%>></span>
			
			<span><input type="button" onclick="getCurrentPositionLatLng()" value="내 위치 가져오기"/></span>
		    <span><input type="submit" value="근처 WIFI 정보 보기"></span>
	    </div>
    </form>
    <p></p>
    
    
    <div>
	    <table id="infoTable">
	    	<thead>
		    <tr>
		    	<th>거리{km)</th>
		    	<th>관리번호</th>
		    	<th>자치구</th>
		    	<th>와이파이명</th>
		    	<th>도로명주소</th>
		    	<th>상세주소</th>
		    	<th>설치위치(층)</th>
		    	<th>설치유형</th>
		    	<th>설치기관</th>
		    	<th>서비스구분</th>
		    	<th>망종류</th>
		    	<th>설치년도</th>
		    	<th>실내외구분</th>
		    	<th>WIFI접속환경</th>
		    	<th>X좌표</th>
		    	<th>Y좌표</th>
		    	<th>작업일자</th>
		    </tr>
		    </thead>
		    <tbody>
		    	<%
		    		if(!("0.0").equals(lat) && !("0.0").equals(lnt)) {
		    			NearWifis nwf = new NearWifis();
		    			List<NearWifiDto> results = nwf.getNearWifis(lat, lnt);
		    			
		    			if(results != null) {
		    				for(NearWifiDto nearWifi : results) {		    					
		    				
		    	%>
		    		<tr class="colored">
		    			<td><%=nearWifi.getDistance()%></td>
		    			<td><%=nearWifi.getMgr_no()%></td>
		    			<td><%=nearWifi.getWrdofc()%></td>
		    			<td><%=nearWifi.getMain_nm()%></td>
		    			<td><%=nearWifi.getAdres1()%></td>
		    			<td><%=nearWifi.getAdres2()%></td>
		    			<td><%=nearWifi.getInstl_floor()%></td>
		    			<td><%=nearWifi.getInstl_ty()%></td>
		    			<td><%=nearWifi.getInstl_mby()%></td>
		    			<td><%=nearWifi.getSvc_se()%></td>
		    			<td><%=nearWifi.getCmcwr()%></td>
		    			<td><%=nearWifi.getCnstc_year()%></td>
		    			<td><%=nearWifi.getInout_door()%></td>
		    			<td><%=nearWifi.getRemars3()%></td>
		    			<td><%=nearWifi.getLat()%></td>
		    			<td><%=nearWifi.getLnt()%></td>
		    			<td><%=nearWifi.getWork_dttm()%></td>
		    		</tr>			
	    		<%}%>
	    		<%}%>
	    		<%} else {%>
			    	<tr height= "70">
			    		<th scope="row" colspan="100%">위치 정보를 입력한 후에 조회해 주세요.</th>
			    	</tr>
			   <%}%>
		    </tbody>
	    </table>
    </div>

</body>
</html>