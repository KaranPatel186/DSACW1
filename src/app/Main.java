package app;

import controllers.Controller;

import java.io.IOException;

public class Main {

    private static void run() throws IOException {
    final Controller controller = new Controller();
        controller.run();
    }

    public static void main(final String[] args) throws IOException {
        Main.run();
    }

}

