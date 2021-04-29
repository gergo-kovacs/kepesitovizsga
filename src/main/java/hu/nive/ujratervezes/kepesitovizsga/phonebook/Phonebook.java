package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.*;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output){
        if(contacts == null || output == null){
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        File file = new File(output);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contacts);
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException ie) {
            throw new IllegalArgumentException("Not found this file");
        }
    }

}
