package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*public class UserDaoJDBCImpl implements UserDao {
    Statement statement = null;
    Util u = new Util();

    public void createUsersTable() {

        try {
            statement = u.getConnection().createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users" +
                    "(id INTEGER not null AUTO_INCREMENT, " +
                    " name VARCHAR(50), " +
                    " lastName VARCHAR (50), " +
                    " age INTEGER," +
                    "PRIMARY KEY (id));");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try {
            statement = u.getConnection().createStatement();
            statement.execute("DROP TABLE IF EXISTS users;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        try {
            PreparedStatement preparedStatement = u.getConnection().prepareStatement("INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            PreparedStatement preparedStatement = u.getConnection().prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM users;";
        try {
            statement = u.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                Byte age = rs.getByte("age");
                list.add(new User(name, lastName, age));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void cleanUsersTable() {
        try {
            statement = u.getConnection().createStatement();
            statement.executeUpdate("TRUNCATE table users;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}*/
