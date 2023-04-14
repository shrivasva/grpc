package com.shopping.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {
    private static final Logger logger = Logger.getLogger(UserDao.class.getName());
    User user = new User();

    public User getUserDetail(String username) {
        try {
            Connection connection = H2DatabaseConnection.getConnectionToDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username =?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId((resultSet.getInt("id")));
                user.setUsername((resultSet.getString("username")));
                user.setName((resultSet.getString("name")));
                user.setGender((resultSet.getString("gender")));
                user.setAge((resultSet.getInt("age")));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getSQLState());
        }
        return user;

    }
}
