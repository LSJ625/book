<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bean.Book" %>
<%@ page import="java.util.List" %>
<html>
<head>
        <meta charset="UTF-8">
        <title>图书管理</title>
        <style>
            body{text-align:center;}
            table{margin: 10px auto;border-collapse: collapse;width: 700px;}
            th,td{border:1px solid #999;padding:6px;}
            th{background-color:lightblue;}
        </style>
</head>
<body>
<h3>图书管理列表</h3>

<form action="${pageContext.request.contextPath}/book/list" method="get">
    <input type="text" name="searchName" placeholder="输入书名搜索">
    <input type="submit" value="搜索">
</form>

<br>

<a href="${pageContext.request.contextPath}/addBook.html">新增图书</a>

<table border="1" cellpadding="5">
    <tr>
        <th>编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>借阅状态</th>
        <th>操作</th>
    </tr>

    <%
        List<Book> bookList = (List<Book>) request.getAttribute("bookList");
        if (bookList != null) {
            for (Book b : bookList) {
    %>
    <tr>
        <td><%= b.getId() %></td>
        <td><%= b.getBookname() %></td>
        <td><%= b.getAuthor() %></td>
        <td>
            <%= "0".equals(b.getStatus()) ? "可借阅" : "已借出" %>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/bookToUpdate?id=<%= b.getId() %>">修改</a>
            <a href="${pageContext.request.contextPath}/bookDelete?id=<%= b.getId() %>">删除</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
