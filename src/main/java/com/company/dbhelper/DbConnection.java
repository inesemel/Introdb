package com.company.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // create one static method to return the connection to the database
    // via the jdbc. It is  as static method because we do not need multiple connections
    // or instances to the database

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/students", "postgres", "67942057");
//            if(connection != null) System.out.println("The connection is created");
        } catch (SQLException e){
            System.out.println("There was a problem connecting to the database");

        }
        return connection;
    }

}
