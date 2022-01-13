/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author asus
 */
public class Borrow {

//    private int borrow_id;
    private Reader reader;
    private Book[] books;
    private int[] quantities;

    public Borrow() {
    }

    public Borrow(Reader reader, Book[] books, int[] quantities) {
        this.reader = reader;
        this.books = books;
        this.quantities = quantities;
    }    

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public void setQuantities(int[] quantities) {
        this.quantities = quantities;
    }

//    public int getBorrow_id() {
//        return borrow_id;
//    }
//
//    public void setBorrow_id(int borrow_id) {
//        this.borrow_id = borrow_id;
//    }

}
