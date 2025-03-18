import javax.swing.*;
import java.awt.*;


public class SwingTemplateApp {
    private static JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Swing Template App");
            


            // Create initial MenuView and attach controller.
            setView(new MenuController(new MenuView()).getView());
            



            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    
    // Method to transition views.
    public static void setView(JPanel view) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(view);
        frame.revalidate();
        frame.repaint();
    }
}






// -------------------------------
// Model: Represents User Data
// -------------------------------
class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
















// -------------------------------
// View: Menu Panel
// -------------------------------
class MenuView extends JPanel {
    private JTextField usernameField;
    private JButton game1Button, game2Button, game3Button;

    public MenuView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Enter Username:"));
        usernameField = new JTextField(20);
        add(usernameField);
        add(Box.createRigidArea(new Dimension(0, 10)));

        game1Button = new JButton("Game 1");
        game2Button = new JButton("Game 2");
        game3Button = new JButton("Game 3");

        add(game1Button);
        add(game2Button);
        add(game3Button);
    }

    // Getters for the components
    public String getUsername() {
        return usernameField.getText().trim();
    }

    public JButton getGame1Button() {
        return game1Button;
    }

    public JButton getGame2Button() {
        return game2Button;
    }

    public JButton getGame3Button() {
        return game3Button;
    }
}

// -------------------------------
// Controller: Menu
// -------------------------------

class MenuController {
    private MenuView view;

    public MenuController(MenuView view) {
        this.view = view;
        view.getGame1Button().addActionListener(e -> launchGame("Game 1"));
        view.getGame2Button().addActionListener(e -> launchGame("Game 2"));
        view.getGame3Button().addActionListener(e -> launchGame("Game 3"));
    }

    private void launchGame(String gameName) {
        String username = view.getUsername();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter a username.");
            return;
        }
        User user = new User(username);

        switch (gameName) {
            case "Game 1": SwingTemplateApp.setView(new Game1Controller(user).getView()); break;
            case "Game 2": SwingTemplateApp.setView(new Game2Controller(user).getView()); break;
            case "Game 3": SwingTemplateApp.setView(new Game3Controller(user).getView()); break;
        }
    }

    public MenuView getView() {
        return view;
    }
}

























// -------------------------------
// View: Game 1 Panel
// -------------------------------
class Game1View extends JPanel {
    private JLabel welcomeLabel;
    private JButton backButton;

    public Game1View() {
        setLayout(new BorderLayout());
        welcomeLabel = new JLabel("", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);
        
        backButton = new JButton("Back to Menu");
        add(backButton, BorderLayout.SOUTH);
    }

    public void setWelcomeMessage(String message) {
        welcomeLabel.setText(message);
    }

    public JButton getBackButton() {
        return backButton;
    }
}

// -------------------------------
// Controller: Game 1
// -------------------------------
class Game1Controller {
    private Game1View view;
    private User user;

    public Game1Controller(User user) {
        this.user = user;
        view = new Game1View();
        view.setWelcomeMessage("Welcome to Game 1, " + user.getUsername() + "!");
        initController();
    }

    private void initController() {
        view.getBackButton().addActionListener(e -> SwingTemplateApp.setView(new MenuController(new MenuView()).getView()));
    }

    public Game1View getView() {
        return view;
    }
}























// -------------------------------
// View: Game 2 Panel
// -------------------------------
class Game2View extends JPanel {
    private JLabel welcomeLabel;
    private JButton backButton;

    public Game2View() {
        setLayout(new BorderLayout());
        welcomeLabel = new JLabel("", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);
        
        backButton = new JButton("Back to Menu");
        add(backButton, BorderLayout.SOUTH);
    }

    public void setWelcomeMessage(String message) {
        welcomeLabel.setText(message);
    }

    public JButton getBackButton() {
        return backButton;
    }
}



// -------------------------------
// Controller: Game 2
// -------------------------------
class Game2Controller {
    private Game2View view;
    private User user;

    public Game2Controller(User user) {
        this.user = user;
        view = new Game2View();
        view.setWelcomeMessage("Welcome to Game 2, " + user.getUsername() + "!");
        initController();
    }

    private void initController() {
        view.getBackButton().addActionListener(e -> SwingTemplateApp.setView(new MenuController(new MenuView()).getView()));
    }

    public Game2View getView() {
        return view;
    }
}





















// -------------------------------
// View: Game 3 Panel
// -------------------------------
class Game3View extends JPanel {
    private JLabel welcomeLabel;
    private JButton backButton;

    public Game3View() {
        setLayout(new BorderLayout());
        welcomeLabel = new JLabel("", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);
        
        backButton = new JButton("Back to Menu");
        add(backButton, BorderLayout.SOUTH);
    }

    public void setWelcomeMessage(String message) {
        welcomeLabel.setText(message);
    }

    public JButton getBackButton() {
        return backButton;
    }
}






// -------------------------------
// Controller: Game 3
// -------------------------------

class Game3Controller {
    private Game3View view;
    private User user;

    public Game3Controller(User user) {
        this.user = user;
        view = new Game3View();
        view.setWelcomeMessage("Welcome to Game 3, " + user.getUsername() + "!");
        initController();
    }

    private void initController() {
        view.getBackButton().addActionListener(e -> SwingTemplateApp.setView(new MenuController(new MenuView()).getView()));
    }

    public Game3View getView() {
        return view;
    }
}
