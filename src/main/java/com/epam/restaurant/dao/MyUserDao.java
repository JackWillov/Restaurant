package com.epam.restaurant.dao;

import com.epam.restaurant.dao.entity.User;
import com.epam.restaurant.exeption.UserCheckExeption;


import java.sql.*;

public class MyUserDao {


    public static User findUserByLogPass(String login, String password) throws UserCheckExeption {
        User user = new User();

        String sql = "SELECT * FROM user WHERE user_login = '" + login + "' and user_password='" + password + "'";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("user_login"));
                user.setPassword(rs.getString("user_password"));
                user.setRoleId(rs.getInt("role_id"));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new UserCheckExeption(throwables);
        }
        return user;
    }


    public static User findUserByLog(String login) throws UserCheckExeption {
        User user = new User();
        String sql = "SELECT * FROM user WHERE user_login = '" + login + "'";


        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("user_login"));
                user.setRoleId(rs.getInt("role_id"));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new UserCheckExeption(throwables);
        }
        return user;
    }

    public static boolean isLoginUnique(String login) throws UserCheckExeption {
        User us = new User();
        us = findUserByLog(login);
        if (us.getLogin() == null) {
            return true;
        }
        return false;
    }

    public static boolean addUser(String login, String password) throws UserCheckExeption {

        String sql = "INSERT INTO user (user_login, user_password, role_id) VALUE ('" + login + "', '" + password + "', 1)";


        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);

        } catch (SQLException | ClassNotFoundException throwables) {
            throw new UserCheckExeption(throwables);
        }


        return !isLoginUnique(login);
    }


    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "root");
        return con;
    }

}
