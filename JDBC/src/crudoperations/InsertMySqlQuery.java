package crudoperations;
import java.io.IOException;
import java.sql.*;
import in.JDBCUTIL.*;

public class InsertMySqlQuery {
    public static void main(String args[]) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = jdbcutil.getJdbcConnection();

            if (connection != null) {
                statement = connection.createStatement();
                String myinsertQuery = "INSERT INTO student(name, rollNum, result) VALUES('Pushpak', 124, 'PASS')";

                int rowsAffected = statement.executeUpdate(myinsertQuery);

                if (rowsAffected > 0) {
                    System.out.println("Row Inserted");
                } else {
                    System.out.println("Row Not Inserted");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                jdbcutil.closeResource(connection, statement,null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
