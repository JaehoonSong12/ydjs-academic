/**
 * FileIOPractice.java
 * 
 * This is a Java Swing application that 
 * 
 * MVC Design Principle:
 * - ...
 *
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile: 
 *      `javac async-anderson-app/*.java`
 * 3. Run: 
 *      `java -cp async-anderson-app FileIOPractice`
 * 4. Clean: 
 *      `rm -rf async-anderson-app/*.class`
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;






public class FileIOPractice {
    public static void main(String[] args) {
        String filePath = "async-anderson-app/example.txt";
        
        // FileIOManager();


        // Set up a file manager with a specified root path
        FileIOManager fileManager = new FileIOManager("C:/repo");

        // Define a relative file path
        String relativePath = "anderson/output.txt";
        // // Write content to the file
        // String input = "Hi, my name is anderson. \n I am a software engineer. \n I love programming.";
        // fileManager.write(input, relativePath);

        // Read the file content and print it
        String fileContent = fileManager.read(relativePath);
        System.out.println("File content:\n" + fileContent);

        
        
        // // Writing to a file
        // try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        //     writer.write("Hello, File I/O in Java!");
        //     writer.newLine();
        //     writer.write("This is an example of writing to a file.");
        //     System.out.println("File written successfully.");
        // } catch (IOException e) {
        //     System.err.println("Error writing to file: " + e.getMessage());
        // }

        // // Reading from a file
        // try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        //     String line;
        //     System.out.println("Reading from file:");
        //     while ((line = reader.readLine()) != null) {
        //         System.out.println(line);
        //     }
        // } catch (IOException e) {
        //     System.err.println("Error reading from file: " + e.getMessage());
        // }
    }
}





class FileIOManager {
    // Root directory from where relative paths will be calculated
    private String rootPath;

    /**
     * Constructor which sets the root directory.
     * @param rootPath The base directory for file operations.
     */
    public FileIOManager(String rootPath) {
        this.rootPath = rootPath;
    }

    /**
     * Writes the given content to a file at the specified relative path.
     * If the required directories do not exist, it will create them.
     *
     * @param content The text content to write into the file.
     * @param relativePath The file path relative to the root directory.
     */
    public void write(String content, String relativePath) {
        // Create a new File object that represents the complete file path
        File file = new File(rootPath, relativePath);
        // Ensure the parent directories exist
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            // Recursively create directories if needed
            if (!parentDir.mkdirs()) {
                System.err.println("Failed to create directory: " + parentDir.getAbsolutePath());
            }
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("Successfully wrote to file: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to file: " + file.getAbsolutePath());
        }
    }

    /**
     * Reads the content from a file at the specified relative path.
     *
     * @param relativePath The file path relative to the root directory.
     * @return The content of the file as a String, or an empty string if an error occurs.
     */
    public String read(String relativePath) {
        File file = new File(rootPath, relativePath);
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // Read each line from the file and append it to the string builder
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
            System.out.println("Successfully read from file: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading from file: " + file.getAbsolutePath());
        }

        return contentBuilder.toString();
    }

    // Main method for demonstration purposes.
    public static void main(String[] args) {
        // Set up a file manager with a specified root path
        FileIOManager fileManager = new FileIOManager("C:/example/root");

        // Define a relative file path
        String relativePath = "data/output.txt";
        // Write content to the file
        fileManager.write("Hello, world!", relativePath);

        // Read the file content and print it
        String fileContent = fileManager.read(relativePath);
        System.out.println("File content:\n" + fileContent);
    }
}





// class FileIOManager {
//     private String filePath;

//     public FileIOManager(String filePath) {
//         this.filePath = filePath;
//     }

//     public void writeToFile(String content) {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//             writer.write(content);
//             System.out.println("File written successfully.");
//         } catch (IOException e) {
//             System.err.println("Error writing to file: " + e.getMessage());
//         }
//     }

//     public void readFromFile() {
//         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//             String line;
//             System.out.println("Reading from file:");
//             while ((line = reader.readLine()) != null) {
//                 System.out.println(line);
//             }
//         } catch (IOException e) {
//             System.err.println("Error reading from file: " + e.getMessage());
//         }
//     }
// }