package com.epam.restaurant.dao;

import com.epam.restaurant.dao.entity.Bill;
import com.epam.restaurant.dao.entity.Status;
import com.epam.restaurant.exeption.UserCheckExeption;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDao {


    public void createBill(long userId, double total) throws UserCheckExeption {
        String sql = "INSERT INTO bill (total, manager_id, status_id, users_id) VALUE ('" + total + "',1,1,'" + userId + "')";


        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);

        } catch (SQLException | ClassNotFoundException throwables) {
            throw new UserCheckExeption(throwables);
        }
    }


    public void deleteFromBillsByUserId(int userId) throws UserCheckExeption {
        String sql = "DELETE  FROM bill where users_id = " + userId;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);

        } catch (SQLException | ClassNotFoundException throwables) {
            throw new UserCheckExeption(throwables);
        }
    }

    public List<Bill> getAllBills() throws UserCheckExeption {


        List<Bill> list = new ArrayList<>();
        String sql = "SELECT * FROM bill";
        try {
            Connection con = getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setTotal(rs.getDouble("total"));
                bill.setManagerId(rs.getInt("manager_id"));
                bill.setStatus(getStatusById((rs.getInt("status_id"))));
                bill.setUserId(rs.getInt("users_id"));
                list.add(bill);
            }
            return list;
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new UserCheckExeption(throwables);
        }
    }


    public Bill getBillByUserId(long userId) throws UserCheckExeption {
        Bill bill = new Bill();
        String sql = "SELECT * FROM bill WHERE users_id = '" + userId + "'";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                bill.setId(rs.getInt("id"));
                bill.setTotal(rs.getDouble("total"));
                bill.setManagerId(rs.getInt("manager_id"));
                bill.setStatus(getStatusById(rs.getInt("id")));
                bill.setUserId(rs.getInt("users_id"));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new UserCheckExeption(throwables);
        }
        return bill;
    }

    public Status getStatusById(int id) {
        Status status = new Status();
        String sql = "SELECT * FROM status WHERE id = '" + id + "'";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                status.setId(id);
                status.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return status;
    }


    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "root");
        return con;
    }
}
