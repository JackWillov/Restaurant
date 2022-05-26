package com.epam.restaurant.Filter;

import com.epam.restaurant.dao.BillDao;
import com.epam.restaurant.dao.DishDao;
import com.epam.restaurant.dao.entity.Bill;
import com.epam.restaurant.dao.entity.CountedDish;
import com.epam.restaurant.dao.entity.Dish;
import com.epam.restaurant.exeption.UserCheckExeption;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/CatalogFilter")
public class CatalogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        DishDao dishDao = new DishDao();
        List<Dish> list = null;
        try {
            list = dishDao.getAllDish();
        } catch (UserCheckExeption e) {
            e.printStackTrace();
        }

        List<CountedDish> orderList = new ArrayList<>();

        List<Bill> bills = new ArrayList<>();
        BillDao dao = new BillDao();
        try {
            bills = dao.getAllBills();
        } catch (UserCheckExeption e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("bills", bills);

        request.getSession().setAttribute("orderList", orderList);

        request.getSession().setAttribute("dishList", list);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
