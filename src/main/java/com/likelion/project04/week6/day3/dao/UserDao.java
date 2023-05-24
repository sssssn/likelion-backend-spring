package com.likelion.project04.week6.day3.dao;

import com.likelion.project04.week6.day3.domain.User;

import java.sql.*;

public abstract class UserDao {
    public abstract Connection getConnection() throws SQLException, ClassNotFoundException;

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());

        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public User get(String id) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select id, name, password from users where id = ?");
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        pstmt.close();
        conn.close();

        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new NUserDao();
        User user = new User();
        user.setId("3");
        user.setName("pang");
        user.setPassword("4321");
        userDao.add(user);

        User selectedUser = userDao.get("3");
        System.out.println(selectedUser.getId());
        System.out.println(selectedUser.getName());
        System.out.println(selectedUser.getPassword());
    }
}