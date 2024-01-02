<%@ page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
        
<!DOCTYPE html>
<%@ page import="sample.ApiExplorer" %>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>와이파이 정보 구하기</title>

</head>
<body>
    <h1>와이파이 정보 구하기</h1>
      <nav id="nav1">
		<span><a href="#">홈</a></span> |
		<span><a href="#">위치 히스토리 목록</a></span> |
		<span><a href="#">Open API 와이파이 정보 가져오기</a></span>
	  </nav>
	 <p></p>
	
    <span>LAT：<%=request.getAttribute("result") %></span>,<span><input type="text"></span>
    <span>LNT：<%=request.getAttribute("result") %></span><span><input type="text"></span>
    <span><input type="button" value="내 위치 가져오기"></span>
    <span><input type="button" value="근처 WIFI 정보 보기"></span>
    
    <hr> <!-- 밑줄 -->
    
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
	    	<tr height= "70">
	    		<th scope="row" colspan="100%">위치 정보를 입력한 후에 조회해 주세요.</th>
	    	</tr>
	    </tbody>
    </table>
    <p id="msg">정수 입력：</p>
    <form method="post" action="/mygaeapp">
    <table>
        <tr>
            <td>입력</td>
            <td><input type="text" id="input" name="text1" value="<%=request.getAttribute("input") %>"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="전송"></td>
        </tr>
    </table>
    </form>
</body>
</html>




        
<%--
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sample JSP</title>
<style>
h1{
    font-size: 16pt;
    background: #AAFFAA;
    padding: 5px;
}
</style>
</head>
<body>
    <h1>JSP Page</h1>
    <p>Result：<%=request.getAttribute("result") %></p>
    <hr>
    <p id="msg">정수 입력：</p>
    <form method="post" action="/mygaeapp">
    <table>
        <tr>
            <td>입력</td>
            <td><input type="text" id="input" name="text1" value="<%=request.getAttribute("input") %>"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="전송"></td>
        </tr>
    </table>
    </form>
</body>
</html>
--%>