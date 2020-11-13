package edu.gd.mvndemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        String name = req.getParameter("name");


        req.getRemoteAddr();

        System.out.println(name);
        System.out.println("-----------");
        System.out.println(req.getContextPath());

        // 设置cookie
        Cookie cookie = new Cookie("name", name);
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        // 可以添加多个cookie
//        resp.addCookie();

        // 获取cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie item : cookies)
        {
            String j = item.getValue();

        }

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>Hello, "+ name +"!</h1>");
        writer.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req, resp);
    }
}
