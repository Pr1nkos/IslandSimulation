package utils;

import java.io.IOException;

public class ConsoleHelper {
    private ConsoleHelper() {
    }

    public static void clearConsole() throws IOException, InterruptedException {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
