package com.epam.restaurant.Servlet;

import com.epam.restaurant.dao.BillDao;
import com.epam.restaurant.dao.entity.Bill;
import com.epam.restaurant.exeption.UserCheckExeption;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/manager"})
public class ManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        List<Bill> bills = (List<Bill>) req.getSession().getAttribute("bills");
        String action = req.getParameter("action");
        BillDao dao = new BillDao();

        for (int i = 0; i < bills.size(); i++) {
            String str = "delete" + i;

            String str1 = "upgrade" + i;
            if (str.equals(action)) {
                bills.remove(i);
                try {
                    dao.deleteFromBillsByUserId(bills.get(i).getUserId());
                } catch (UserCheckExeption e) {
                    e.printStackTrace();
                }
            } else if (str1.equals(action)) {
                bills.get(i).getStatus().setId(bills.get(i).getStatus().getId() + 1);
            }
        }

        resp.sendRedirect("manager_page.jsp");
    }
}
