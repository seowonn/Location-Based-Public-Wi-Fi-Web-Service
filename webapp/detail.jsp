<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="dao.WIfiInfosDao" %>
<%@ page import="dto.WIfiInfosDto" %>
<%@ page import="dao.BookMarkGroupDao" %>
<%@ page import="dto.BookMarkGroupDto" %>

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
	 
	 
	<form action="#">
	  <select name="languages" id="lang">
	    <option value="javascript">북마크 그룹 이름 선택</option>
		 <%
		 	BookMarkGroupDao bookMarkGroupDao = new BookMarkGroupDao();
		 	List<String> list = bookMarkGroupDao.getBookMarkGroup();
		 	
		 	if(list != null) {
		 		for(String group : list){
		 			
		 %>
		    <option><%=group %></option>		
	    	<%} %>
		<%} %>
	  </select>
	  <input type="submit" value="북마크 추가하기" />
	</form>
	

	
	<div>
	 	<table>
		 	<colgroup>
		 		<col class="col">
			</colgroup>
			<%
			    request.setCharacterEncoding("UTF-8");
			    String mgrNo = request.getParameter("mgrNo");
			    int num = 0;
			
				if(!mgrNo.equals("")) {
					WIfiInfosDao wifiDao = new WIfiInfosDao();
					WIfiInfosDto wifiInfo = wifiDao.getWifiInfo(mgrNo);
					if(wifiInfo != null){
				
			%>
	 		<tr class="info">
		 		<td class="label" height="45">거리(km)</td>
				<td class="info" height="45">0.0000</td>
			</tr>
			
			<tr class="info">
				<td class="label" height="45">관리번호</td>
				<td class="info" height="45"><%=wifiInfo.getMgr_no()%></td>
			</tr>
			
			<tr class="info">
				<td class="label" height="45">자치구</td>
				<td class="info" height="45"><%=wifiInfo.getWrdofc()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">와이파이명</td>
				<td class="info" height="45"><a href="detail.jsp?mgrNo=<%=wifiInfo.getMgr_no()%>"><%=wifiInfo.getMain_nm()%></a></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">도로명주소</td>
				<td class="info" height="45"><%=wifiInfo.getAdres1()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">상세주소</td>
				<td class="info" height="45"><%=wifiInfo.getAdres2()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">설치위치(층)</td>
				<td class="info" height="45"><%=wifiInfo.getInstl_floor()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">설치유형</td>
				<td class="info" height="45"><%=wifiInfo.getInstl_ty()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">설치기관</td>
				<td class="info" height="45"><%=wifiInfo.getInstl_mby()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">서비스구분</td>
				<td class="info" height="45"><%=wifiInfo.getSvc_se()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">망종류</td>
				<td class="info" height="45"><%=wifiInfo.getCmcwr()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">설치년도</td>
				<td class="info" height="45"><%=wifiInfo.getCnstc_year()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">실내외구분</td>
				<td class="info" height="45"><%=wifiInfo.getInout_door()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">WIFI접속환경</td>
				<td class="info" height="45"><%=wifiInfo.getRemars3()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">X좌표</td>
				<td class="info" height="45"><%=wifiInfo.getLat()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">Y좌표</td>
				<td class="info" height="45"><%=wifiInfo.getLnt()%></td>
			</tr>
			<tr class="info">
				<td class="label" height="45">작업일자</td>
				<td class="info" height="45"><%=wifiInfo.getWork_dttm()%></td>
			</tr>
			
				<%}%>
			<%} else {%>
		   	<tr height= "70">
		   		<th scope="row" colspan="100%">위치 정보를 불러오지 못하였습니다.</th>
		   	</tr>
			<%}%>
	 	</table>
	 </div>
	 <p></p>
</body>
</html>