package crudoperations;

import in.JDBCUTIL.jdbcutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class updateQuery {
    public static void main(String args[]) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = jdbcutil.getJdbcConnection();

            if (connection != null) {
                String mySqlQuery = "";

                statement = connection.prepareStatement(mySqlQuery);

                if (statement != null) {
                    int roweffected = statement.executeUpdate();

                    if (roweffected == 1) {
                        System.out.println("Row operation done");

                    } else {
                        System.out.println("Row operation not done");
                    }

                }
            }
        }catch (IOException e) {
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
}
