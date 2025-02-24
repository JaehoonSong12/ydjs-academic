package jayden.app;

import jayden.app.login_controller.LoginController;
import jayden.app.login_view.LoginView;

import javax.swing.SwingUtilities;

public class Gui {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginModel model = new LoginModel();
            LoginView view = new LoginView();
            new LoginController(model, view);
            view.setVisible(true);
        });
    }
}