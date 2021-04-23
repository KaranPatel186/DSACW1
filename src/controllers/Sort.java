package controllers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Sort {
    //Method to sort the newly encrypted data using the packet ID
    public static void sortEncrypt() throws IOException {
        //reads data in from the csv file to be sorted
        BufferedReader reader = new BufferedReader(new FileReader("src/processedTextFiles/EncryptedText.csv"));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        while((line=reader.readLine())!=null){
            str.add(line);
        }
        reader.close();
        //bug: double digit numbers are not sorted correctly, method is only taking into account the first number (i.e. only the 1 from and ID of 10)
        System.out.println(str);
        Collections.sort(str);
        //writes the sorted data back into the csv file
        FileWriter writer = new FileWriter("src/processedTextFiles/EncryptedText.csv");
        for(String s: str){
            writer.write(s);
            writer.write("\r\n");
        }
        writer.close();
    }


    //Method to sort the newly encrypted data using the packet ID
    public static void sortDecrypt() throws IOException {
        //reads data in from the csv file to be sorted
        BufferedReader reader = new BufferedReader(new FileReader("src/processedTextFiles/DecryptedText.csv"));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        while((line=reader.readLine())!=null){
            str.add(line);
        }
        reader.close();
        //bug: double digit numbers are not sorted correctly, method is only taking into account the first number (i.e. only the 1 from and ID of 10)
        System.out.println(str);
        Collections.sort(str);
        //writes the sorted data back into the csv file
        FileWriter writer = new FileWriter("src/processedTextFiles/DecryptedText.csv");
        for(String s: str){
            writer.write(s);
            writer.write("\r\n");
        }
        writer.close();
    }


}


