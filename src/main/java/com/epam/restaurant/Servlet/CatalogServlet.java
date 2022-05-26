package com.epam.restaurant.Servlet;

import com.epam.restaurant.dao.DishDao;
import com.epam.restaurant.dao.entity.Dish;
import com.epam.restaurant.exeption.UserCheckExeption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = {"/catalog"})
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        String action = (String) session.getAttribute("action");
        if ("logout".equals(action)) {
            session.invalidate();
            resp.sendRedirect("login.jsp");
        }
        super.doPost(req, resp);
    }

}
