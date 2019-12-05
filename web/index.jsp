<%--
  Created by IntelliJ IDEA.
  User: exia
  Date: 2019/12/5
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>

<html>
<head>
  <title>数据库连接JavaBean使用示例</title>
</head>
<body>
<jsp:useBean id="db" class="com.xxx.bean.BeanTest" scope="page">
</jsp:useBean>
<font size="2"><strong> 本页面利用JavaBean实现插入数据库的功能：</strong><br></font>
<form action="insert_done.jsp" method="post">
  id：<input type="text" name="id" size="10" /> <br/>
  书名：<input type="text" name="name" size="10" /> <br/>
  作者：<input type="text" name="author" size="10" /> <br/>
  价格：<input type="text" name="price" size="10" /> <br/>
  封面：<input type="text" name="image" size="10" /> <br/>
  描述：<input type="text" name="description" size="10" /> <br/>
  分类：<input type="text" name="category_id" size="10" /> <br/>
  <input type="submit" value="提交" />
</form>

</body>
</html>