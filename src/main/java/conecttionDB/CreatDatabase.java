package conecttionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreatDatabase {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/thithuchanhmd3?useUnicode=yes&characterEncoding=UTF-8";
    private static final String userName = "root";
    private static final String pass = "10061995";

    public static Connection getConnection() {
        Connection connection = null;
        try { Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, userName, pass);
            System.out.println("connection successfully");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}
