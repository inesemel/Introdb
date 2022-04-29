package com.company.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class Auth {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;
    //Authentication
    // Create a table called users which has the following fields with the following properties
    // id serial, primary key
    // username varchar(255), unique
    // password varchar(255)
    // role varchar(255)

    //Write a method to sign up users on this student management platform,
    //that allows them to have a username and password and role.
    // The role is to be one of two items, (user and admin) (validate it such that anything else that
    // is entered is not passed to the db.
    //  Make the username unique as well (you can choose to make the username an email instead)


    public static boolean signUpUser() {
        System.out.println("Create a username: ");
        String username = scanner.next();

        System.out.println("Create a password: ");
        String password = scanner.next();

        System.out.println("Specify your role (user or admin): ");
        String role = scanner.next();

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        boolean matcher = emailRegex.matches(username);
        if(matcher) {
            if(role.equalsIgnoreCase("user") || role.equalsIgnoreCase("admin")) {

                try {
                    // INSERT INTO student(name, age) VALUES('name', age);
                    ps = getConnection().prepareStatement("INSERT INTO users(username, password, role) " +
                            "VALUES('" + username + "', '" + password + "', '" + role + "')");
                    ps.execute();
                    return true;

                } catch (SQLException e) {
                    System.out.println("Username is probably used already.");
                    System.out.println(e.getMessage());
                    return false;
                }
            } else {
                System.out.println("The " + role + " is invalid.");
                return false;
            }
        } else {
            System.out.println("Email is not correct");
            return false;
        }
    }

}
