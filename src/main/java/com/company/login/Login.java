package com.company.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class Login {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean logIn() {
        System.out.println("Enter the username: ");
        String username = scanner.next();

        System.out.println("Enter the password: ");
        String password = scanner.next();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM users WHERE username='" + username +
                    "' AND password='" + password + "')");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
