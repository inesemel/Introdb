package com.company.menu;

import com.company.controllers.StudentController;

import java.util.Scanner;

public class StudentMenu {
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1. Add a new student");
        System.out.println("2. Get a student by id");
        System.out.println("3. Edit students name or age");
        System.out.println("4. Delete student and student's scores");
        System.out.println("5. Add students scores");
        System.out.println("6. Delete student's scores");
        System.out.println("7. Edit student's scores");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println(StudentController.addStudent() ? "Successfully added a new student" : "Student not added ");
                break;
            case 2:
                System.out.println(StudentController.getStudentById().getName() );
                break;
            case 3:
                StudentController.editStudent();
                break;
            case 4:
                StudentController.deleteStudent();
                break;
            case 5:
                System.out.println(StudentController.addStudentScores() ? "Successfully added scores of the student" :
                        "Scores not added");
                break;
            case 6:
                System.out.println(StudentController.deleteScore() ? "Scores deleted" : "Scores not deleted");
                break;
            case 7:
                System.out.println(StudentController.editScores() ? "Scores edited" : "Scores not edited");
                break;
            default:
                System.out.println("Invalid option, try again");
                menu();
        }
    }
}
