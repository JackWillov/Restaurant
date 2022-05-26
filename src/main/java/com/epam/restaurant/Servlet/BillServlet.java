package com.epam.restaurant.Servlet;

import com.epam.restaurant.dao.BillDao;
import com.epam.restaurant.dao.entity.CountedDish;
import com.epam.restaurant.exeption.UserCheckExeption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/bill"})
public class BillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        List<CountedDish> list = (ArrayList<CountedDish>) req.getSession().getAttribute("orderList");
        String action = req.getParameter("action");

        long userId = (Long) req.getSession().getAttribute("userId");
        double totalPrice = (Double) req.getSession().getAttribute("totalPrice");

        if ("status".equals(action)) {
            BillDao dao = new BillDao();
            try {
                dao.createBill(userId, totalPrice);
            } catch (UserCheckExeption e) {
                e.printStackTrace();
            }
            resp.sendRedirect("status.jsp");
        } else {

            for (int i = 0; i < list.size(); i++) {
                String str = "delete" + i;
                if (str.equals(action)) {
                    list.remove(i);
                }
            }

            resp.sendRedirect("bill.jsp");
        }
    }
}
