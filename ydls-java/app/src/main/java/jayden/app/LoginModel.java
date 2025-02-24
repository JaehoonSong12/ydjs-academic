package jayden.app;

import java.io.*;
import java.util.Properties;

public class LoginModel {
    private static final String FILE_PATH = "credentials.properties";
    private Properties properties;

    public LoginModel() {
        properties = new Properties();
        loadCredentials();
    }

    private void loadCredentials() {
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("No existing credentials found.");
        }
    }

    public boolean authenticate(String username, String password) {
        return password.equals(properties.getProperty(username));
    }

    public void registerUser(String username, String password) {
        properties.setProperty(username, password);
        saveCredentials();
    }

    private void saveCredentials() {
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            properties.store(fos, "Stored Credentials");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}