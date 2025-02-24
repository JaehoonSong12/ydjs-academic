package jayden.app.login_controller;

import jayden.app.LoginModel;
import jayden.app.login_view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginModel model;
    private LoginView view;

    public LoginController(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;

        view.getLoginButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsernameField().getText();
                String password = new String(view.getPasswordField().getPassword());
                if (model.authenticate(username, password)) {
                    view.getMessageLabel().setText("Login successful!");
                } else {
                    view.getMessageLabel().setText("Invalid credentials");
                }
            }
        });

        view.getRegisterButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = view.getUsernameField().getText();
                String password = new String(view.getPasswordField().getPassword());
                model.registerUser(username, password);
                view.getMessageLabel().setText("User registered!");
            }
        });
    }
}