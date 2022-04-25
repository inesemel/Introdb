package com.company.controllers;

import com.company.books.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class BookController {

    //Initialize the scanner

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    // Add book controller
    public static boolean addBook() {
        // prompting the user for data

        System.out.println("Enter the name of the book: ");
        String name = scanner.nextLine();

        System.out.print("Enter the price of the book: ");
        float price = scanner.nextFloat();

        try {
            // INSERT INTO books(name, price) VALUES('name', price);
            ps = getConnection().prepareStatement("INSERT INTO books(name, price) VALUES('" + name + "', " + price + ")");

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }


    // get student by Id controller

    public static Book getBookById(){
        // Prompt the user to enter the id of the student they want to receive

        System.out.println("Enter the Id of the book: ");
        int id = scanner.nextInt();

        try{
            ps = getConnection().prepareStatement("SELECT * FROM books WHERE id=" + id);
            rs = ps.executeQuery();

            // define variables to temporarily hold
            // each field in the result set

            int bookId;
            float price;
            String name;

            // Instantiate the student object to return at the end of the method execution
            Book book = new Book();

            //loop through the result set and add the necessary values to the student object

            while(rs.next()){
                bookId = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getFloat("price");
                book.setName(name);
                book.setId(bookId);
                book.setPrice(price);
            }
            return book;


        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }



}
