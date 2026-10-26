<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bean.Book" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改图书</title>
</head>
<body>
<h3>修改图书信息</h3>
<%
    Book book = (Book) request.getAttribute("book");
%>
<form action="${pageContext.request.contextPath}/bookUpdate" method="post">
    <input type="hidden" name="id" value="<%=book.getId()%>">
    书名：<input type="text" name="bookname" value="<%=book.getBookname()%>"><br>
    作者：<input type="text" name="author" value="<%=book.getAuthor()%>"><br>
    借阅状态：
    <select name="status">
        <option value="0" <%="0".equals(book.getStatus())?"selected":""%>>可借阅</option>
        <option value="1" <%="1".equals(book.getStatus())?"selected":""%>>已借出</option>
    </select>
    <br>
    <input type="submit" value="提交修改">
</form>
<a href="${pageContext.request.contextPath}/book/list">返回列表</a>
</body>
</html>
