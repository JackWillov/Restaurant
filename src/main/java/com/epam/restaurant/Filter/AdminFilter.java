package com.epam.restaurant.Filter;

import com.epam.restaurant.dao.BillDao;
import com.epam.restaurant.dao.entity.Bill;
import com.epam.restaurant.dao.entity.User;
import com.epam.restaurant.exeption.UserCheckExeption;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        long roleID = (Long) request.getSession().getAttribute("userRoleID");

        List<Bill> bills = new ArrayList<>();
        BillDao dao = new BillDao();
        try {
            bills = dao.getAllBills();
        } catch (UserCheckExeption e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("bills", bills);


        if (roleID == 2) {
            response.sendRedirect("manager_page.jsp");
        } else if (roleID == 1) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
