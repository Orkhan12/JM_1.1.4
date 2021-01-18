package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

import jm.task.core.jdbc.util.Util;
import org.hibernate.*;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String CREATE_TABLE_SQL = "CREATE TABLE `mydbtest`.`users` ("
                + "`id` INT NOT NULL AUTO_INCREMENT,"
                + "`name` VARCHAR(45) NULL,"
                + "`lastName` VARCHAR(45) NULL,"
                + "`age` INT NULL,"
                + "PRIMARY KEY (`id`))"
                + "COMMENT = 'Java Mentor course';";
        Transaction transaction = null;
        Session session = null;
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query createQuery = session.createSQLQuery(CREATE_TABLE_SQL);
            int create = createQuery.executeUpdate();
            System.out.println(" delete   " + create);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        String DROP_TABLE = "DROP TABLE IF EXISTS users;";
        Session session = null;
        Transaction transaction = null;

        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query createQuery = session.createSQLQuery(DROP_TABLE);
            int create = createQuery.executeUpdate();
            System.out.println(" delete   " + create);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        User user = new User(name, lastName, age);
        try {
            Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            User u;
            u = (User) session.load(User.class, id);
            session.delete(u);
            session.flush();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = null;
        Transaction tx = null;
        String GET_ALL = "FROM users;";
        try {
            Session session = Util.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(GET_ALL);
            list = query.list();
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return list;
    }


    @Override
    public void cleanUsersTable() {
        String CLEAN_TABLE = String.format("delete from %s", "users");
        Session session = null;
        Transaction transaction = null;

        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query createQuery = session.createSQLQuery(CLEAN_TABLE);
            int create = createQuery.executeUpdate();
            System.out.println(" delete   " + create);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}
