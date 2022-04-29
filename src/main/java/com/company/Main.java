package com.company;

import com.company.books.Book;
import com.company.dbhelper.DbConnection;
import com.company.login.Auth;
import com.company.menu.BookMenu;
import com.company.menu.StudentMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        try{
//            scanner.nextInt();
//        } catch (Exception e){
//            System.out.println("The value entered is not valid");
//        }
//

        //Create the same class in your code and add the following fields:
        // id(int), name(String), price(float).
        // In your main method, create a List of books and return books that are more expensive than $5.
//        List<Book> myBooks = new ArrayList<>();
//        myBooks.add(new Book(1, "The Complete Tales of Winnie-The-Pooh", 26.5f));
//        myBooks.add(new Book(2, "Where Is Spot?", 4.98f));
//        myBooks.add(new Book(3, "The Giving Tree", 9.05f));


//        DbConnection.getConnection();

//        String bookList = "";
//        for (Book currentBook: myBooks) {
//            if(currentBook.getPrice() > 5){
//                bookList = bookList + currentBook.getName() + ",  ";
//            }
//
//        }
//        System.out.println(bookList);

        // CRUD - Create, Read, Update and Delete
//        StudentMenu.menu();

        if (Auth.signUpUser()) {
            StudentMenu.menu();
        } else {
            System.out.println("Invalid login credentials");
        }
//        BookMenu.menu();

        // create a book controller and a book menu
        // using the templates shown, and we'll demo them

        // attempt to add 3 student's scores into the scores table
        // Create a method called addStudentsScores() and use that to perform the task
        // use the id of an existing student


    }

//    public static List<Book> filterLessThanFive(List<Book> myBook){
//        myBook.removeIf(book -> book.getPrice() < 5);
//        return myBook;
//    }






}
