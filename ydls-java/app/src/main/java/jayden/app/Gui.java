package jayden.app;


import jayden.app.controller.ToDoListController;
import jayden.app.view.ToDoListGUI;

import javax.swing.SwingUtilities;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class Gui {
    public static void main(String[] args) {
        
        // SwingUtilities.invokeLater(() -> {
        //     ToDoListController controller = new ToDoListController(null);
        //     ToDoListGUI view = new ToDoListGUI(controller);
        //     controller.setView(view);
        // });



        
        SwingUtilities.invokeLater(() -> {
            LoginModel model = new LoginModel();
            LoginView view = new LoginView();
            new LoginController(model, view);
            view.setVisible(true);
        });
    }
}


// Model: Handles user data and persistence
class LoginModel {
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

// View: Builds the UI
class LoginView extends JFrame {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, registerButton;
    JLabel messageLabel;

    public LoginView() {
        setTitle("Login App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        add(loginButton);
        add(registerButton);

        messageLabel = new JLabel("", SwingConstants.CENTER);
        add(messageLabel);
    }
}

// Controller: Handles user interactions
class LoginController {
    private LoginModel model;
    private LoginView view;

    public LoginController(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;

        view.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = view.usernameField.getText();
                String password = new String(view.passwordField.getPassword());
                if (model.authenticate(username, password)) {
                    view.messageLabel.setText("Login successful!");
                } else {
                    view.messageLabel.setText("Invalid credentials");
                }
            }
        });

        view.registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = view.usernameField.getText();
                String password = new String(view.passwordField.getPassword());
                model.registerUser(username, password);
                view.messageLabel.setText("User registered!");
            }
        });
    }
}
