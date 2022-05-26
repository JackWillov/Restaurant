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

@WebServlet(urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confPassword = req.getParameter("conf_password");

        MyUserDao md = new MyUserDao();
        boolean isLogUnique = false;
        boolean isAdded = false;
        if (!password.equals(confPassword)) {
            out.println("Password do not match");
        } else {

            try {
                isLogUnique = md.isLoginUnique(login);

            } catch (UserCheckExeption e) {
                e.printStackTrace();
            }

            if (isLogUnique) {
                try {
                    isAdded = md.addUser(login, password);

                } catch (UserCheckExeption userCheckExeption) {
                    userCheckExeption.printStackTrace();
                }
                resp.sendRedirect("login.jsp");
            }
        }
    }
}
