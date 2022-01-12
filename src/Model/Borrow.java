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

    private int order_id;
    private Book[] books;
    private Reader reader;
    private int[] quantities;

    public Borrow() {
    }

    public Borrow(int order_id, Book[] books, Reader reader, int[] quantities) {
        this.order_id = order_id;
        this.books = books;
        this.reader = reader;
        this.quantities = quantities;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

}
