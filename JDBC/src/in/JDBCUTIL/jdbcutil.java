package in.JDBCUTIL;

import java.io.*;
import java.sql.*;
import java.util.*;

public class jdbcutil {
    public static Connection getJdbcConnection() throws IOException, SQLException {
        FileInputStream fis = new FileInputStream("Application.properties");

        Properties p = new Properties();
        p.load(fis);

        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String password = p.getProperty("password");

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(url);
        System.out.println(user);
        System.out.println(password);


        return connection;
    }

    public static void closeResource(Connection connection, Statement statement, ResultSet resultset) throws SQLException {
        if (connection != null)
            connection.close();
        if (statement != null)
            statement.close();
        if (resultset !=null)
            resultset.close();
    }
}
