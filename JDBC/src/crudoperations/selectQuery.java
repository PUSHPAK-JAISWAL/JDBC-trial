package crudoperations;

import in.JDBCUTIL.jdbcutil;

import java.io.IOException;
import java.util.Scanner;
import java.sql.*;

public class selectQuery {
    public static void main(String args[]) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Scanner scan = new Scanner(System.in);

        try {
            connection = jdbcutil.getJdbcConnection();
            if (connection != null) {
                String mysqlquery = "select * from student where id = ?";
                preparedStatement = connection.prepareStatement(mysqlquery);

                if (preparedStatement != null) {
                    System.out.println("Enter the id you want to fetch in database");
                    int id = scan.nextInt();
                    preparedStatement.setInt(1, id);

                    resultSet = preparedStatement.executeQuery();

                    if (resultSet != null) {
                        if (resultSet.next()) {
                            System.out.println("ID\tName\tRollNum\tResult");

                            System.out.print(resultSet.getInt(1) + "\t");
                            System.out.print(resultSet.getString(2) + "\t");
                            System.out.print(resultSet.getInt(3) + "\t");
                            System.out.print(resultSet.getString(4) + "\t");
                        } else {
                            System.out.println("No record found with ID: " + id);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            scan.close();
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
