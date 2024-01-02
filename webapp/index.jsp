<%@ page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
        
<!DOCTYPE html>
<%@ page import="sample.ApiExplorer" %>
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