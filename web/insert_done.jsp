<%--
  Created by IntelliJ IDEA.
  User: exia
  Date: 2019/12/5
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<jsp:useBean id="db" class="com.xxx.bean.BeanTest" scope="page">
</jsp:useBean>
<%
    String no= request.getParameter("id");
    String name=request.getParameter("name");
    String author=request.getParameter("author");
    double price = Double.parseDouble(request.getParameter("price"));
    String image=request.getParameter("image");
    String des=request.getParameter("description");
    int cid=Integer.parseInt(request.getParameter("category_id"));
    String sql_query="select * from book where id="+no;
    ResultSet rs = db.select(sql_query);
    if(!rs.next()){

        String sql_insert="insert book values ('" + no + "','" + name + "','" + author + "'," + price + ", '"+ image +"', '" + des +"', "+ cid +")";
        db.insert(sql_insert);
    }else
        out.print("<script>alert('添加失败！'); window.location='insert.jsp' </script>");
%>

<html>
<head>
    <title>数据库连接JavaBean使用示例</title>
</head>
<body>
<font size="2"><strong> 成功插入数据！<a href="index.jsp">返回继续</a></br>
    <a href="Query.jsp">查看当前数据库数据</a>
</strong><br> </font>

</body>
</html>
