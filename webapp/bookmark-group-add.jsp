<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css">
	<meta charset="UTF-8">
	<title>와이파이 정보 구하기</title>
	
	<style>
		col#newBookMark {
			width: 20%;
			background: #04B45F;
			color: white;
		}
	</style>
</head>
<body>
	<h1>북마크 그룹 추가</h1>
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
    
    	String bookmarkName = "";
    	String order = "";
    %>
	 
	 <form action="bookmark-group-add-submit.jsp" method="post">
	 <div>
	 	<table>
	 	
		 	<colgroup>
				<col id='newBookMark' />
			</colgroup>
		
	 		<tr>
		 		<td height="45">북마크 이름</td>
				<td height="45"><input name="bookmarkName" type="text"></td>
			</tr>
			
			<tr>
				<td height="45">순서</td>
				<td height="45"><input name="order" type="text"></td>
			</tr>
	 	</table>
	 </div>
	 
	 <div class="btn">	 
	 	<button type="submit" >추가</button>
	 </div>
	</form>

</body>
</html>