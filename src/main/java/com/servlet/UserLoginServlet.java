package com.servlet;

import com.bean.User;
import com.dao.UserDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.login(username, password);
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            // 登录成功 欢迎弹窗，之后跳转图书列表
            out.write("<script>");
            out.write("alert('欢迎您，"+user.getUsername()+"！登录成功！');");
            out.write("location.href='/book/list';");
            out.write("</script>");
        }else{
            out.write("<script>");
            out.write("alert('账号或密码错误！');");
            out.write("location.href='/login.html';");
            out.write("</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
