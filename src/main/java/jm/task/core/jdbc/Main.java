package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        UserServiceImpl srv = new UserServiceImpl();
        srv.createUsersTable();

        srv.saveUser("Steve", "Jobs",(byte) 43);
        srv.saveUser("John", "Smith",(byte) 34);
        srv.saveUser("Michel", "Scot",(byte) 34);
        srv.saveUser("Adam", "Pots",(byte) 34);

        System.out.println(srv.getAllUsers().toString());
        srv.cleanUsersTable();
        srv.dropUsersTable();

    }
}
