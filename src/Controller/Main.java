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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Management mn = new Management();
        Utility util = new Utility();
        Book[] books = new Book[100];
        Reader[] readers = new Reader[100];
        Borrow[] borrows = new Borrow[100];

        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(0, "", "", 0, 0, 0);
        }

        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Reader(0, 0, "", "", "");
        }

        for (int i = 0; i < borrows.length; i++) {
            Book[] temp = new Book[1];
            Reader temp1 = new Reader();
            int[] temp2 = new int[1];
            borrows[i] = new Borrow(0, temp, temp1, temp2);
        }

        while (true) {
            System.out.println("1.  Enter new book");
            System.out.println("2.  Enter new reader");
            System.out.println("3.  Borrow book");
            System.out.println("4.  Sort");
            System.out.println("5.  Find Reader");

            int choice = util.checkInterger("Enter your choice: ");
            switch (choice) {
                case 1:
                    for (int i = 0; i < books.length; i++) {
                        if (i == 0) {
                            if (books[i].getBook_id() == 0) {
                                books[0] = mn.input_Book(10000);
                                break;
                            }
                        }else{
                            if (books[i].getBook_id() == 0) {
                                books[i] = mn.input_Book(books[i-1].getBook_id());
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }
    }

}