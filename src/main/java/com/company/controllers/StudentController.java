package com.company.controllers;

import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class StudentController {

    //Initialize the scanner

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    // Add student controller
    public static boolean addStudent() {
        // prompting the user for data

        System.out.print("Enter the name of the student: ");
        String name = scanner.next();

        System.out.println("Enter the age of the student: ");
        int age = scanner.nextInt();

        try {
            // INSERT INTO student(name, age) VALUES('name', age);
            ps = getConnection().prepareStatement("INSERT INTO student(name, age) VALUES('" + name + "', " + age + ")");

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database error");
            return false;
        }
    }

        // get student by Id controller

        public static Student getStudentById(){
            // Prompt the user to enter the id of the student they want to receive

            System.out.println("Enter the Id of the student: ");
            int id = scanner.nextInt();

            try{
                ps = getConnection().prepareStatement("SELECT * FROM students WHERE id=" + id);
                rs = ps.executeQuery();

                // define variables to temporarily hold
                // each field in the result set

                int studentId, age;
                String name;

                // Instantiate the student object to return at the end of the method execution
                Student student = new Student();

                //loop through the result set and add the necessary values to the student object

                while(rs.next()){
                    studentId = rs.getInt("id");
                    name = rs.getString("name");
                    age = rs.getInt("age");
                    student.setName(name);
                    student.setId(studentId);
                    student.setAge(age);
                }
                return student;


            } catch (SQLException e){
                e.printStackTrace();
                return null;
            }

        }

        public static void editStudent() {
            System.out.println("Enter id you want to edit: ");
            int id = scanner.nextInt();

            System.out.println("What field you want to edit? name/age ");
            String fieldToEdit = scanner.next();
            System.out.println("What value do you want to edit it to?  ");
            String update = scanner.next();

            try {
                ps = getConnection().prepareStatement("UPDATE student SET" + fieldToEdit + "= '" + update + "' WHERE id=" + id);
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    //    Add an overloaded deleteScore() method that takes id(int) as a parameter to you allow you
    //    delete a student’s score when a student is deleted from the database.
        public static boolean deleteStudentAndScores() {
            System.out.println("Enter id of the student: ");
            int id = scanner.nextInt();

            // delete student
            // delete student's scores after student's info is deleted

            if(deleteScore(id) && deleteStudent(id)) {
                return true;
            } else {
                return false;
            }
        }

        public static boolean deleteStudent(int id) {

            try {
                // DELETE FROM table_name WHERE condition;;
                ps = getConnection().prepareStatement("DELETE FROM student WHERE id=" + id);
                ps.execute();
                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }

    public static boolean addStudentScores() {
        System.out.println("Enter id of the student: ");
        int id = scanner.nextInt();

        System.out.println("Enter the score in mathematics ");
        int math = scanner.nextInt();

        System.out.println("Enter the score in english ");
        int english = scanner.nextInt();

        System.out.println("Enter the score in physics ");
        int physics = scanner.nextInt();

        System.out.println("Enter the score in chemistry");
        int chemistry = scanner.nextInt();

        try {

            // INSERT INTO scores (studentid, mathematics, english, physics, chemistry) VALUES(id, math, english, physics, chemistry);
            ps = getConnection().prepareStatement("INSERT INTO scores(studentid, mathematics, english, physics, chemistry) VALUES("
                    + id + ", " + math + ", " + english +  ", " + physics + ", " + chemistry + ")");

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteScore() {
        System.out.println("Enter the id of the student whose scores you want to delete: ");
        int id = scanner.nextInt();

        try {
            // DELETE FROM table_name WHERE condition;;
            ps = getConnection().prepareStatement("DELETE FROM scores WHERE studentid=" + id);

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean deleteScore(int id) {

        try {
            // DELETE FROM table_name WHERE condition;;
            ps = getConnection().prepareStatement("DELETE FROM scores WHERE studentid=" + id);

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


    //    Add an editScore method, to edit a particular student’s score for a subject of choice
    public static boolean editScores() {

        System.out.print("Enter the id of the student: ");
        int id = scanner.nextInt();

        System.out.print("Enter new score: ");
        int score = scanner.nextInt();

        System.out.print("Enter the subject: ");
        String subject = scanner.next();

        try {
            // UPDATE books SET name = ' ' WHERE id;
            ps = getConnection().prepareStatement("UPDATE scores SET " + subject + "=" + score + " WHERE studentid=" + id);

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}




