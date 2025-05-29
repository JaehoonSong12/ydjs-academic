package anderson.app;

import java.net.URL;
import java.io.*;
import java.nio.file.*;

public class Cli {
    public static void main(String[] args) {
        System.out.println("Hello, Cli!");
        


        // Get resource as URL
        URL resourceUrl = Cli.class.getResource("/anderson/number_0.png");
        System.out.println(resourceUrl);

        if (resourceUrl != null) {
            System.out.println("Resource URL: " + resourceUrl);

            // Optionally, convert to File if it's a file URL (not inside a jar)
            if (resourceUrl.getProtocol().equals("file")) {
                try {
                    File file = new File(resourceUrl.toURI());
                    System.out.println("Resolved File Path: " + file.getAbsolutePath());
                    System.out.println("Exists on disk? " + file.exists());
                } catch (Exception e) {
                    System.out.println("Failed to resolve file: " + e.getMessage());
                }
            } else {
                System.out.println("Resource is not a direct file (maybe in a JAR).");
            }

        } else {
            System.out.println("Resource not found!");
        }


        // anderson.app.Codingbat.main(args);
        // anderson.app.cbstring01.Q01HelloName.main(args);
        anderson.app.lwjgl.Game.main(args);
    }
}