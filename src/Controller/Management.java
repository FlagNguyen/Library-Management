/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Book;
import Model.Borrow;
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
    
    protected void print_BookArray(Book[] books) {
        System.out.printf("%-5s| %-30s| %-15s| %-15s| %-10s| %-5s|\n", "ID", "Book Name", "Author", "Type", "Published Year", "Quantity");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBook_id() != 0) {
                
                print_Book(books[i]);
                System.out.println("");
                
            }
        }
    }
    
    protected void print_Book(Book book) {
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
    
    protected void print_ReaderArray(Reader[] readers) {
        System.out.printf("%-5s| %-20s| %-10s| %-15s| %-10s|\n", "ID", "Reader Name", "Address", "Phone", "Job");
        for (int i = 0; i < readers.length; i++) {
            if (readers[i].getReader_id() != 0) {
                print_Reader(readers[i]);
                System.out.println("");
            }
        }
    }
    
    protected void print_Reader(Reader reader) {
        
        String name = util.standardlizeString(reader.getName());
        String address = util.standardlizeString(reader.getAddress());
        
        String type = "";
        switch (reader.getType()) {
            case 1:
                type = "Student";
                break;
            case 2:
                type = "Teacher";
                break;
            case 3:
                type = "Staff";
                break;
        }
        
        System.out.printf("%-5d| %-20s| %-10s| %-15s| %-10s|",
                reader.getReader_id(), name,
                address, reader.getPhone(), type);
    }
    
    protected void borrow(Book[] books, Reader[] readers, Borrow[] borrows) {

        //S1. Enter reader id and search in Reader[]
        Reader borrower = util.search_reader_byID(readers);
        System.out.println("This's your information: ");
        print_Reader(borrower);
        Borrow b = new Borrow();

        //S1.2 Search positive of the reader in Borrow[]
        int pos = 0; //Position of reader in Borrows[]
        for (int i = 0; i < borrows.length; i++) {
            if (borrows[i].getReader().equals(borrower)) {
                pos = i;
                
            } else if (borrows[i].getReader().getReader_id() == 0) {
                pos = i;
            }
        }

        //S2. Input book id
        System.out.println("List available book: ");
        print_BookArray(books);
        Book borrow_book = util.search_Book_byId(books);
        int quantity_borrow = 0;
        if (borrow_book.getQuantity() == 0) {
            System.out.println("This book is over !");
            borrow_book = util.search_Book_byId(books);
        } else {
            
            for (int i = 0; i < borrows[pos].getBooks().length; i++) {

                //S2.1 Enter chosen book into array Book in Borrow
                if (borrows[pos].getBooks()[i].getBook_id() == 0) {
                    borrows[pos].getBooks()[i] = borrow_book;                    
                }
                //S2.2 Enter quantity borrowed
                if (borrows[pos].getQuantities()[i] == 0) {
                    borrows[pos].getQuantities()[i] = input_Quantity(borrow_book.getQuantity());
                    quantity_borrow = borrows[pos].getQuantities()[i];
                } else if (borrows[pos].getQuantities()[i] < 3 || borrows[pos].getQuantities()[i] > 0) {
                    borrows[pos].getQuantities()[i] = input_Quantity2(borrow_book.getQuantity(), borrows[pos].getQuantities()[i]);
                    quantity_borrow = borrows[pos].getQuantities()[i];
                }
            }
        }
        
        update_Quantity_Book(books, borrow_book.getBook_id(), quantity_borrow);
        
    }
    
    private int input_Quantity(int quantity) {
        int out = 0;
        int temp = 0;
        if (quantity <= 3) {
            temp = quantity;
        } else {
            temp = 3;
        }
        out = util.checkChoice("Enter quantity you want to borrow: ", 1, temp);
        return out;
    }
    
    private int input_Quantity2(int quantity_now, int quantity_borrowed) {
        int out = 0;
        System.out.printf("You have borrowed %d item", quantity_borrowed);
        int to = 3 - quantity_borrowed;
        
        out = util.checkChoice("Enter quatity you want to borrow: ", 1, to);
        if (out > quantity_now) {
            out = util.checkChoice("Don't enough book in stock", 1, quantity_now);
        }
        return out;
    }
    
    private void update_Quantity_Book(Book[] books, int book_id, int quantity_borrow) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBook_id() == book_id) {
                books[i].setQuantity(books[i].getQuantity() - quantity_borrow);
            }
        }
    }
    
}
