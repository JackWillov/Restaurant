package com.epam.restaurant.dao;

import com.epam.restaurant.dao.entity.Dish;
import com.epam.restaurant.dao.entity.User;
import com.epam.restaurant.exeption.UserCheckExeption;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDao {


    public List<Dish> getAllDish() throws UserCheckExeption {


        List<Dish> list = new ArrayList<>();
        String sql = "SELECT * FROM dish";
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setId(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setPrice(rs.getDouble("price"));
                dish.setDescription(rs.getString("description"));
                dish.setCategoryId(rs.getInt("category_id"));
                list.add(dish);
            }
            return list;
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new UserCheckExeption(throwables);
        }


    }

    public static Dish findDishById(int id) throws UserCheckExeption {
        Dish dish = new Dish();
        String sql = "SELECT * FROM dish WHERE id = '" + id + "'";


        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                dish.setId(rs.getInt("id"));
                dish.setDescription(rs.getString("description"));
                dish.setPrice(rs.getDouble("price"));
                dish.setCategoryId(rs.getInt("category_id"));
                dish.setName(rs.getString("name"));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new UserCheckExeption(throwables);
        }
        return dish;
    }


    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "root");
        return con;
    }
}