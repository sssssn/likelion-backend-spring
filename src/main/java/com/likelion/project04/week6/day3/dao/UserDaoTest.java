package com.likelion.project04.week6.day3.dao;

import com.likelion.project04.week6.day3.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        User user = new User();
        user.setId("6");
        user.setName("end");
        user.setPassword("0000");
        userDao.add(user);

        User selectedUser = userDao.get("6");
        System.out.println(selectedUser.getId());
        System.out.println(selectedUser.getName());
        System.out.println(selectedUser.getPassword());
    }
}