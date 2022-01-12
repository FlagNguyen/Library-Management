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
public class Reader extends Person{
    private int reader_id;
    private int type;

    public Reader() {
    }
    
    

    public Reader(int reader_id, int type) {
        this.reader_id = reader_id;
        this.type = type;
    }

    public Reader(int reader_id, int type, String name, String address, String phone) {
        super(name, address, phone);
        this.reader_id = reader_id;
        this.type = type;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
    
    
}
