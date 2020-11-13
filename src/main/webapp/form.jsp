<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<div class="layui-container">
    <blockquote class="layui-elem-quote layui-text">
        表单提交：
    </blockquote>

    <form class="layui-form" action="">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">手机</label>
                <div class="layui-input-inline">
                    <input type="tel" name="phone" readonly class="layui-input"
                           value="<%=request.getParameter("tel")%>" >
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                    <input type="text" name="email" readonly class="layui-input"
                    value="<%=request.getParameter("email")%>">
                </div>
            </div>
        </div>

    </form>

    </div>
    <script src="layui/layui.all.js"></script>
</body>
</html>
