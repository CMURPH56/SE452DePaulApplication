package edu.depaul.cdm.se.SpaceApplication;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLHandler {

    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/SPACEUSERS";
        String username = "root";
        String password = "password*1";


        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            Statement statement = connection.createStatement();
            ResultSet getAllData = statement.executeQuery(
                    "SELECT * FROM members"
            );
            while( getAllData.next()){
                String s = getAllData.getString("email");
                System.out.println(s);
            }



        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }




        System.out.println("What is the next step");
    }
}
