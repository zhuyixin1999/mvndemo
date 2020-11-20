<%@ page import="edu.gd.mvndemo.dao.StudentDao" %>
<%@ page import="edu.gd.mvndemo.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: thyme
  Date: 2020/10/31
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<div class="layui-container">
    <blockquote class="layui-elem-quote layui-text">
        Student数据渲染：
    </blockquote>

    <%
        String id = request.getParameter("id");
        Student student = StudentDao.getStuById(id);
    %>

    <form class="layui-form" action="" >

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <label>
                        <input type="tel" name="tel" class="layui-input" value="<%=student == null ? "null" : student.getName()%>" >
                    </label>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                    <label>
                        <input type="text" name="email"  class="layui-input" value="<%=student == null ? "null" : student.getEmail()%>" >
                    </label>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" >立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

    </form>

</div>
<script src="layui/layui.all.js"></script>
</body>
</html>
