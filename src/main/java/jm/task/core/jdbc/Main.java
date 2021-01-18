package jm.task.core.jdbc;

//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl srv = new UserServiceImpl();
        srv.createUsersTable();

        srv.saveUser("Steve", "Jobs", (byte) 43);
        srv.saveUser("John", "Smith", (byte) 34);
        srv.saveUser("Michel", "Scot", (byte) 34);
        srv.saveUser("Adam", "Pots", (byte) 34);

        List<User> list = srv.getAllUsers(); //ñäåëàíî
        System.out.println(Arrays.deepToString(list.toArray()));
        srv.cleanUsersTable();
        srv.dropUsersTable();
        srv.removeUserById(3);
        Util.getSessionFactory().close();
    }
}
