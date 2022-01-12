/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import Model.Reader;
import java.io.IOException;

/**
 *
 * @author asus
 */
public class Management {

    Utility util = new Utility();

    Book input_Book(int book_id) throws IOException {
        int id = book_id + 1;
        String name = util.checkString("Enter book's name: ");
        String author = util.checkString("Enter book's author: ");

        System.out.println("Book's type: \n1-Natural Sciences");
        System.out.println("2-Information Technology");
        System.out.println("3-Literature");
        System.out.println("4-Electronics & Telecommunication");
        int type;
        do {
            type = util.checkInterger("Enter book's type: ");
            if (type > 0 && type <= 4) {
                break;
            }
            System.err.println("Please enter 1-4 !");
        } while (true);

        int year;

        do {
            year = util.checkInterger("Enter pulished year (2000-2022): ");
            if (year >= 2000 && year <= 2022) {
                break;
            }
            System.err.println("Please enter year between 2000-2022 !");
        } while (true);

        int quantity;
        do {
            quantity = util.checkInterger("Enter book's quantity: ");
            if (quantity > 0) {
                break;
            }
            System.err.println("Quantity must be >0 !");
        } while (true);

        Book b = new Book(id, name, author, type, year, quantity);
        return b;
    }

    Reader input_Reader(int reader_id) throws IOException {
        int id = reader_id + 1;
        String name = util.checkString("Enter reader's name: ");
        String address = util.checkString("Enter reader's address: ");
        String phone = "";

        do {
            phone = util.checkString("Enter reader's phone number: ");
            if (phone.matches("[1234567890]+") && phone.length() >= 5 && phone.length() <= 10) {
                break;
            } else {
                System.err.println("Phone number can't has a letter and must has the length is 5 ! Please re-enter !");
            }
        } while (true);

        System.out.println("Reader's type: \n1-Student");
        System.out.println("2-Teacher");
        System.out.println("3-Staff");
        int type;
        do {
            type = util.checkInterger("Enter reader's type: ");
            if (type > 0 && type <= 3) {
                break;
            }
            System.err.println("Please enter 1-3 !");
        } while (true);

        Reader r = new Reader(id, type, name, address, phone);
        return r;
    }

    void print_BookArray(Book[] books) {
        System.out.printf("%-5s| %-30s| %-15s| %-15s| %-10s| %-5s|\n","ID","Book Name","Author","Type","Published Year","Quantity");        
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBook_id() == 0) {
                for (int j = 0; j <= i; j++) {
                    print_Book(books[j]);
                    System.out.println("");
                }
            }
        }
    }

    void print_Book(Book book) {
        String name = util.standardlizeString(book.getBook_Name());
        String author = util.standardlizeString(book.getBook_author());

        String type = "";
        switch (book.getType()) {
            case (1):
                type = "Sciences";
                break;
            case (2):
                type = "Technology";
                break;
            case (3):
                type = "Literature";
                break;
            case (4):
                type = "Electronics";
                break;
            default:
                break;
        }

        System.out.printf("%-5d| %-30s| %-15s| %-15s| %-14d| %-8d|", book.getBook_id(), name, author,
                 type, book.getPublished_year(), book.getQuantity());
    }

}
