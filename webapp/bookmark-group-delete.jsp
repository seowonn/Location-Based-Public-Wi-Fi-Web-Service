<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%@ page import="Database.BookMarkedGroups" %>
<%@ page import="DTO.BookMarkGroupDto" %>

<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">
	<title>와이파이 정보 구하기</title>
</head>

<body>
	<h1>북마크 그룹 삭제</h1>
	<nav id="nav1">
		<span><a href="index.jsp">홈</a></span> |
		<span><a href="history.jsp">위치 히스토리 목록</a></span> |
		<span><a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a></span> |
		<span><a href="#">북마크 보기</a></span> |
		<span><a href="bookmark-group.jsp">북마크 그룹 관리</a></span>
	 </nav>
	 <p></p>
	 북마크 그룹 이름을 삭제하시겠습니까?
	 <p></p>
		 
	<%    
	    request.setCharacterEncoding("UTF-8");
	    String id = request.getParameter("id");
	    
	    BookMarkedGroups bmg = new BookMarkedGroups();
	    BookMarkGroupDto bmd = bmg.selectOneBookMarkGroup(id);
	    
	    String deleteBookMark = bmd.getBookmarkName();
	    String deleteOrder = bmd.getOrder();
	%>
		
	<div>
	 	<table>
		 	<colgroup>
		 		<col class="col">
			</colgroup>

	 		<tr>
		 		<td class="label" height="45">북마크 이름</td>
				<td height="45"><input name="bookmarkName" type="text" value="<%=deleteBookMark%>"></td>
			</tr>
			
			<tr>
				<td class="label" height="45">순서</td>
				<td height="45"><input name="order" type="text" value="<%=deleteOrder%>"></td>
			</tr>
	 	</table>
	 </div>
	 <p></p>
		 
	<form action="bookmark-group-delete-submit.jsp" method="post">
		 <div class="btn">	 
		 	<span><a href="bookmark-group.jsp">돌아가기</a></span> |
		 	<button type="submit" name="id" value="<%=id%>" >삭제</button>
		 </div>
	 </form>

</body>
</html>