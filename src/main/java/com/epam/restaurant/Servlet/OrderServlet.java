package com.epam.restaurant.Servlet;

import com.epam.restaurant.dao.DishDao;
import com.epam.restaurant.dao.entity.CountedDish;
import com.epam.restaurant.dao.entity.Dish;
import com.epam.restaurant.exeption.UserCheckExeption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        int dishCount = Integer.parseInt(req.getParameter("dishCount"));
        int categoryId = Integer.parseInt(req.getParameter("sell"));
        Dish dish = new Dish();
        try {
            dish = DishDao.findDishById(categoryId);
        } catch (UserCheckExeption e) {
            e.printStackTrace();
        }
        CountedDish countedDish = new CountedDish();
        countedDish.setDish(dish);
        countedDish.setCount(dishCount);


        List<CountedDish> orderList;
        orderList = (ArrayList<CountedDish>) req.getSession().getAttribute("orderList");
        orderList.add(countedDish);
        req.getSession().setAttribute("orderList", orderList);
        resp.sendRedirect("bill.jsp");
    }
}
