package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Util.getConnection();

        UserDao user = new UserDaoHibernateImpl();

        user.createUsersTable();

        user.saveUser("John", "Wik", (byte) 39);
        user.saveUser("Zaur", "Tregulov", (byte) 32);
        user.saveUser("Sergey", "Briliov", (byte) 41);
        user.saveUser("Mason", "Capefell", (byte) 42);

        user.removeUserById(4);

        System.out.println(user.getAllUsers());

        user.cleanUsersTable();

        user.dropUsersTable();

        Util.getConnection().close();// реализуйте алгоритм здесь
    }
}
