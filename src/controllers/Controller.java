package controllers;
import helpers.InputHelper;

import java.io.IOException;

public class Controller {

    public void run() throws IOException {
        boolean finished = false;
        InputHelper inputHelper = new InputHelper();
        do {
            System.out.print("\nA. Encrypt File");
            System.out.print("\tB. Decrypt File");
            System.out.print("\tQ. Quit\n");
            char choice = inputHelper.readCharacter("Enter choice", "A, B, Q");
            switch (choice) {
                case 'A' -> Encrypt.encrypt();
                case 'B' -> Decrypt.decrypt();
                case 'Q' -> finished = true;
            }
        } while (!finished);
    }








}
