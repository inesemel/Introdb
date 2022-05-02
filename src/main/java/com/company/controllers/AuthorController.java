package com.company.controllers;

import com.company.books.Authors;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class AuthorController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addAuthor() {
        System.out.println("Enter the name of the author: ");
        String name = scanner.next();

        System.out.println("Enter the age of the author: ");
        int age = scanner.nextInt();

        try {
            // INSERT INTO authors(name, age) VALUES('name', age);
            ps = getConnection().prepareStatement("INSERT INTO authors(name, age) VALUES('" + name + "', " + age + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Authors getAuthorById() {
        System.out.println("Enter the Id of the author: ");
        int id = scanner.nextInt();

        try{
            ps = getConnection().prepareStatement("SELECT * FROM authors WHERE id=" + id);
            rs = ps.executeQuery();

            // define variables to temporarily hold
            // each field in the result set

            int authorId;
            String name;
            int age;

            Authors author = new Authors();

            while(rs.next()){
                authorId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                author.setName(name);
                author.setId(authorId);
                author.setAge(age);
            }
            return author;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

        public static boolean deleteAuthor() {
            // prompting the user for data

            System.out.print("Enter the id of the author: ");
            int id = scanner.nextInt();

            try {
                // DELETE FROM table_name WHERE condition;;
                ps = getConnection().prepareStatement("DELETE FROM authors WHERE id=" + id);
                ps.execute();
                return true;
            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }
        }


}
