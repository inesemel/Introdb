package com.company.menu;

import com.company.controllers.StudentController;

import java.util.Scanner;

public class StudentMenu {
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Add a new student");
        System.out.println("2. Get a student by id");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println(StudentController.addStudent() ? "Successfully added a new student" : "Student not added ");
                break;
            case 2:
                System.out.println(StudentController.getStudentById().getName() );
                break;
            default:
                System.out.println("Invalid option, try again");
                menu();
        }
    }
}
