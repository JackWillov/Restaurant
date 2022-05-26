package com.epam.restaurant.Servlet;

import com.epam.restaurant.dao.MyUserDao;
import com.epam.restaurant.dao.entity.User;
import com.epam.restaurant.exeption.UserCheckExeption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String action = req.getParameter("action");

        if ("registration".equals(action)) {
            resp.sendRedirect("registration.jsp");
        }
        MyUserDao md = new MyUserDao();
        User user = new User();
        try {
            user = md.findUserByLogPass(login, password);
        } catch (UserCheckExeption e) {
            e.printStackTrace();
        }


        if (user.getLogin() == null || user.getPassword() == null) {
            out.println("wrong login or password");
        } else {

            req.getSession().setAttribute("userId", user.getId());
            req.getSession().setAttribute("userLogin", user.getLogin());
            req.getSession().setAttribute("userRoleID", user.getRoleId());
            resp.sendRedirect("catalog.jsp");
        }
    }
}
