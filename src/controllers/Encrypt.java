package controllers;

import java.io.*;
import java.util.Scanner;

public class Encrypt {

    public static void encrypt() throws IOException {
        System.out.println("");
        System.out.println("");
        System.out.println("------------------------------------------------------");
        System.out.println("Reading Data From File");
        System.out.println("------------------------------------------------------");
        System.out.println("");
        readfile();
        System.out.println("------------------------------------------------------");
        System.out.println("File Read Successfully");
        System.out.println("------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("------------------------------------------------------");
        System.out.println("Encrypting Data");
        System.out.println("Processing...");
        System.out.println("------------------------------------------------------");
        System.out.println("");
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("src/processedTextFiles/EncryptedText.csv"), "utf-8"))) {
            Scanner read = null;

            try {
                read = new Scanner(new File("src/textFiles/plaintext.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            assert read != null;
            read.useDelimiter(",");
            String theKey;
            String password;
            String plainText;

            while (read.hasNext()) {
                theKey = read.next();
                password = read.next();
                plainText = read.next();

                String[] temp;
                String plainTextFinal = "";

                for (int i = 0, j = 0; i < plainText.length(); i++) {
                    char cha = plainText.charAt(i);
                    if (cha < 'A' || cha > 'Z') {
                        continue;
                    }
                    plainTextFinal += (char) ((cha + password.charAt(j) - 26) % 26 + 'A');
                    j = ++j % password.length();
                }

                System.out.println(theKey + "," + password + "," + plainTextFinal);//just for debugging
                writer.write(theKey + "," + password + "," + plainTextFinal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");
        System.out.println("------------------------------------------------------");
        System.out.println("Encrypting Complete");
        System.out.println("------------------------------------------------------");
        Sort.sortEncrypt();

    }


    public static void readfile() {
        try(BufferedReader br = new BufferedReader(new FileReader("src/textFiles/plainText.txt"))) {
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

    public static void  filenotfound() {
        System.out.println("Error File empty or not found!");
        System.out.println("Please Re-Run Program!");
        System.exit(0);
    }

}
