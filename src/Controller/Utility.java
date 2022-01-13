/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author asus
 */
public class Utility {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int checkInterger(String mess) {
        int output = 0;
        do {
            try {
                System.out.print(mess);
                output = Integer.parseInt(in.readLine());
                break;
            } catch (Exception e) {
                System.err.println("Please Enter Interger");
            }

        } while (true);

        return output;
    }

    public int checkChoice(String mess) {
        int output = 0;
        try {
            do {
                System.out.print(mess);
                output = Integer.parseInt(in.readLine());
                if (output > 0 && output <= 8) {
                    break;
                }
                System.err.println("Please enter 1-8 !!");

            } while (true);
        } catch (Exception e) {
            System.err.println("Please enter integer !!!");
        }

        return output;
    }

    public String checkString(String mess) throws IOException {
        String out = "";
        try {
            do {
                System.out.print(mess);
                out = in.readLine();
                if (out.isEmpty()) {
                    System.err.println("Please Enter String");
                } else {
                    break;
                }
            } while (true);
        } catch (Exception e) {
        }

        return out.trim();

    }

    protected String standardlizeString(String s) {
        String strOut = "";
        String st = "";
        st = s.trim().toLowerCase().replaceAll("\\s+", " ");

        String[] temp = new String[100];
        temp = st.split(" ");
        for (int i = 0; i <= temp.length - 1; i++) {
            strOut += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                strOut += " ";
            }
        }
        return strOut;
    }

    Reader search_reader_byID(Reader[] readers) { //Hàm tìm thông tin reader theo id nhập vào
        int id;
        do {
            id = checkInterger("Enter your id in list: ");

            if (id != 0) {
                for (int i = 0; i < readers.length; i++) {
                    if (id == readers[i].getReader_id()) {
                        return readers[i];
                    }
                }
                System.err.println("Your ID is not exist in system !!!");
            } else {
                System.err.println("Your id can't be 0 !");
            }

        } while (true);
    }

}
