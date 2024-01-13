<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ page import="dao.BookMarkDao" %>
<%@ page import="dto.BookMarkDto" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>와이파이 정보 구하기</title>
</head>

<body>

	<%
		request.setCharacterEncoding("UTF-8");
    
    	String mgrNo = request.getParameter("mgrNo");
		String bmGroup = request.getParameter("bmGroup");
	
		if(mgrNo != null && bmGroup != null) {
			BookMarkDao bookmarkDao = new BookMarkDao();
			boolean isInserted = bookmarkDao.insertBookMark(mgrNo, bmGroup);
			
			if(isInserted){
	%>			
			<script>
				alert("북마크 정보를 추가하였습니다.");
				location.href = "bookmark-list.jsp";
			</script>
			
	<%		} else {%>
			<script>
				alert("북마크 정보를 추가하지 못하였습니다.");
				location.href = "bookmark-list.jsp";
			</script>	
			
	<%		}
		} else {
	%>		
		<script>
			alert("북마크 정보를 받아오지 못했습니다.");
			location.href = "detail.jsp";
		</script>
	<%	}%>

</body>
</html>