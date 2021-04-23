package controllers;

import java.io.*;
import java.util.Scanner;

public class Decrypt {

    //method for decrypting data
    public static void decrypt() throws IOException {
        //prints messages to console for menu layout
        System.out.println("");
        System.out.println("");

        System.out.println("------------------------------------------------------");
        System.out.println("Reading Data From File");
        System.out.println("------------------------------------------------------");

        System.out.println("");
        //calls function to read file in line by line - method was used initally for testing but has been left in to print data to console before decrypting
        readfile();

        System.out.println("------------------------------------------------------");
        System.out.println("File Read Successfully");
        System.out.println("------------------------------------------------------");

        System.out.println("");
        System.out.println("");

        System.out.println("------------------------------------------------------");
        System.out.println("Decrypting Data");
        System.out.println("Processing...");
        System.out.println("------------------------------------------------------");

        System.out.println("");
        //gets csv file for new data to be written to
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("src/processedTextFiles/DecryptedText.csv"), "utf-8"))) {
        Scanner read = null;
            //reads test data in from the text file
            try {
                read = new Scanner(new File("src/textFiles/cipherText.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        assert read != null;
        read.useDelimiter(",");
        //declares temp variables for incoming data to be stored
        String theKey;
        String password;
        String cipherText;
        //reads each line of the file and stores data from each line into temp variables - "," delimiter is used to split each line up into 3 different values
        while (read.hasNext()) {
            theKey = read.next();
            password = read.next();
            cipherText = read.next();

            String[] temp;
            String cipherTextFinal = "";

            for (int i = 0, j = 0; i < cipherText.length(); i++) {
                char cha = cipherText.charAt(i);
                if (cha < 'A' || cha > 'Z') {
                    continue;
                }
                //equation for encrypting the text:
                cipherTextFinal += (char) ((cha - password.charAt(j) + 26) % 26 + 'A');
                j = ++j % password.length();
            }
            //prints decrypted data to the console
            System.out.println(theKey + "," + password + "," + cipherTextFinal);//just for debugging
            //writes decrypted data to the csv file
            writer.write(theKey + "," + password + "," + cipherTextFinal);
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
        //prints message to console
        System.out.println("");
        System.out.println("------------------------------------------------------");
        System.out.println("Decryption Complete");
        System.out.println("------------------------------------------------------");
        //calls method for sorting the newly decrypted data
        Sort.sortDecrypt();
    }


    //method for reading in data from text file
    public static void readfile() {

        try(BufferedReader br = new BufferedReader(new FileReader("src/textFiles/cipherText.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();

            }
            String everything = sb.toString();
            if (everything.equals("")) {
                filenotfound();
            }
            System.out.println(everything);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method for displaying an error message if the file cannot be found or is empty
    public static void  filenotfound() {
        System.out.println("Error: File empty or not found!!!");
        System.out.println("Please Re-Run Program!!");
        System.exit(0);
    }
}
