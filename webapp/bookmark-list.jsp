<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="dao.BookMarkDao" %>
<%@ page import="dto.BookMarkDto" %>

<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">
	<title>와이파이 정보 구하기</title>
</head>
<body>

    <h1>북마크 목록</h1>
      <nav id="nav1">
		<span><a href="index.jsp">홈</a></span> |
		<span><a href="history.jsp">위치 히스토리 목록</a></span> |
		<span><a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a></span> |
		<span><a href="bookmark-list.jsp">북마크 보기</a></span> |
		<span><a href="bookmark-group.jsp">북마크 그룹 관리</a></span>
	  </nav>
	 <p></p>
    
    <div>
	    <table id="infoTable">
	    	<thead>
		    <tr>
		    	<th>ID</th>
		    	<th>북마크 이름</th>
		    	<th>와이파이명</th>
		    	<th>등록일자</th>
		    	<th>비고</th>
		    </tr>
		    </thead>
		    <tbody>
		    	<%
		    		BookMarkDao bookmarkDao = new BookMarkDao();
		    		List<BookMarkDto> results = bookmarkDao.getEveryBookMarkWifi();
	    			
	    			if(results != null) {
	    				for(BookMarkDto bookmarkgroup : results) {	
		    	%>
		    		<tr class="colored">
		    			<td><%=bookmarkgroup.getId()%></td>
		    			<td><%=bookmarkgroup.getBookmarkName()%></td>
		    			<td><%=bookmarkgroup.getWifiName()%></td>
		    			<td><%=bookmarkgroup.getRegister_dttm()%></td>
		    			<td>
		    				<a href="bookmark-delete.jsp?id=<%=bookmarkgroup.getId()%>">삭제</a>
						</td>
		    		</tr>			
	    		<%}%>
	    		<%} else {%>
			    	<tr height= "70">
			    		<th scope="row" colspan="100%">등록된 북마크 정보가 없습니다.</th>
			    	</tr>
				<%}%>
		    </tbody>
	    </table>
    </div>

</body>
</html>