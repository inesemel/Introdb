package com.company;

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

        List<Book> myBooks = new ArrayList<>();
        myBooks.add(new Book(1, "The Complete Tales of Winnie-The-Pooh", 26.5f));
        myBooks.add(new Book(2, "Where Is Spot?", 4.98f));
        myBooks.add(new Book(3, "The Giving Tree", 9.05f));


        String bookList = "";
        for (Book currentBook: myBooks) {
            if(currentBook.getPrice() > 5){
                bookList = bookList + currentBook.getName() + ",  ";
            }

        }
        System.out.println(bookList);

    }






}
