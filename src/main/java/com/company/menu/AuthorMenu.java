package com.company.menu;

import com.company.controllers.AuthorController;
import com.company.controllers.StudentController;

import java.util.Scanner;

public class AuthorMenu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Add a new author");
        System.out.println("2. Get an author by id");
        System.out.println("3. Delete an author by id");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println(AuthorController.addAuthor() ? "Successfully added a new author" :
                        "Author not added ");
                break;
            case 2:
                System.out.println(AuthorController.getAuthorById().getName());
                break;
            case 3:
                System.out.println(AuthorController.deleteAuthor() ? "An author is successfully deleted" :
                        "Author not deleted");
                break;
            default:
                System.out.println("Invalid option, try again");
                menu();
        }

    }
}
