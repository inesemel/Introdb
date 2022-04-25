package com.company.menu;

import com.company.books.Book;
import com.company.controllers.BookController;
import com.company.controllers.StudentController;

import java.util.Scanner;

public class BookMenu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Add a new book");
        System.out.println("2. Get a book by id");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println(BookController.addBook() ? "Successfully added a new book" : "Book not added ");
                break;
            case 2:
                System.out.println(BookController.getBookById().getName());
                break;
            default:
                System.out.println("Invalid option, try again");
                menu();
        }
    }

}
