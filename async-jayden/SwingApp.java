/**
 * SwingApp.java
 * 
 * This is a Java Swing application that 
 * 
 * MVC Design Principle:
 * - ...
 *
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile: 
 *      `javac async-jayden/*.java`
 * 3. Run: 
 *      `java -cp async-jayden SwingApp`
 */

import java.util.Random;

import javax.swing.*;
import java.awt.*;




// -------------------------------
// App: holds a single standalone-instance like 
// 1. "window" in OS, 
// 2. "browser" in Web, 
// 3. "stage" in Other Frameworks like "JavaFX"
// -------------------------------
public class SwingApp {
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










////////////////////// Backend

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













////////////////////// Frontend

// -------------------------------
// View: Menu Panel
// -------------------------------
class MenuView extends JPanel {
    private JTextField usernameField;
    private JButton game1Button, game2Button, game3Button, randomGameButton ; // jayden addition

    public MenuView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Enter Username:"));
        usernameField = new JTextField(20);
        add(usernameField);
        add(Box.createRigidArea(new Dimension(0, 10)));

        game1Button = new JButton("TicTacToe");
        game2Button = new JButton("Game 2");
        game3Button = new JButton("Game 3");
        randomGameButton = new JButton("Random"); // jayden addition

        add(game1Button);
        add(game2Button);
        add(game3Button);
        add(randomGameButton); // jayden addition
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

    public JButton getRandomGameButton() { // jayden addition
        return randomGameButton;
    }
}

// -------------------------------
// Controller: Menu
// -------------------------------
class MenuController {
    private MenuView view;

    public MenuController(MenuView view) {
        this.view = view;
        view.getGame1Button().addActionListener(e -> launchGame("TicTacTeo"));
        view.getGame2Button().addActionListener(e -> launchGame("Game 2"));
        view.getGame3Button().addActionListener(e -> launchGame("Game 3"));
        view.getRandomGameButton().addActionListener(e -> RandomPick());
    }

    private void RandomPick() {
        String[] games = { "TicTacTeo", "Game 2", "Game 3" };
        Random random = new Random();
        String randomGame = games[random.nextInt(games.length)]; // Pick random game
        launchGame(randomGame);
    }


    private void launchGame(String gameName) {
        String username = view.getUsername();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter a username.");
            return;
        }
        User user = new User(username);

        switch (gameName) {
            case "TicTacTeo": SwingApp.setView(new Game1Controller(user).getView()); break;
            case "Game 2": SwingApp.setView(new Game2Controller(user).getView()); break;
            case "Game 3": SwingApp.setView(new Game3Controller(user).getView()); break;
        }
    }

    

    public MenuView getView() {
        return view;
    }
}

























// -------------------------------
// View: TicTacTeo Panel
// -------------------------------
class Game1View extends JPanel {
    private JLabel welcomeLabel, gameName;
    private JButton backButton, easyBtn, mediumBtn, hardBtn;

    public Game1View() {
        setLayout(new GridLayout(6, 1, 10, 10));
        setBackground(Color.DARK_GRAY);
        // Layout (HTML like) Operation
        welcomeLabel = new JLabel("", SwingConstants.CENTER);
        gameName = new JLabel("Tic-Tac-Toe", SwingConstants.CENTER);
        gameName.setForeground(Color.WHITE);
        gameName.setFont(new Font("Arial", Font.BOLD, 36));
        easyBtn = new JButton("Easy AI");
        mediumBtn = new JButton("Medium AI");
        hardBtn = new JButton("Hard AI");
        backButton = new JButton("Back to Menu");
        add(welcomeLabel);
        add(gameName);
        add(easyBtn);
        add(mediumBtn);
        add(hardBtn);
        add(backButton);

        // Styling (CSS like) Operation
        styleButton(easyBtn);
        styleButton(mediumBtn);
        styleButton(hardBtn);
    }

    public void setWelcomeLabel(String message) {
        welcomeLabel.setText(message);
        welcomeLabel.setForeground(Color.WHITE);

    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getEasyBtn() {
        return easyBtn;
    }
    public JButton getMediumBtn() {
        return mediumBtn;
    }
    public JButton getHardBtn() {
        return hardBtn;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
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
        view.setWelcomeLabel("Welcome to Game 1, " + user.getUsername() + "!");
        initController();
    }

    private void initController() {
        view.getBackButton().addActionListener(e -> SwingApp.setView(new MenuController(new MenuView()).getView()));
        view.getEasyBtn().addActionListener(e -> {
            System.out.println("Easy mode start");
            // frame.startGame("Easy");
        });
        view.getMediumBtn().addActionListener(e -> {
            System.out.println("Medium mode start");
            // frame.startGame("Medium");
        });
        view.getHardBtn().addActionListener(e -> {
            System.out.println("Hard mode start");
            // frame.startGame("Hard");
        });
    }


    public Game1View getView() {
        return view;
    }
}
    //Game started




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

    public void setWelcomeLabel(String message) {
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
        view.setWelcomeLabel("Welcome to Game 2, " + user.getUsername() + "!");
        initController();
    }

    private void initController() {
        view.getBackButton().addActionListener(e -> SwingApp.setView(new MenuController(new MenuView()).getView()));
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

    public void setWelcomeLabel(String message) {
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
        view.setWelcomeLabel("Welcome to Game 3, " + user.getUsername() + "!");
        initController();
    }

    private void initController() {
        view.getBackButton().addActionListener(e -> SwingApp.setView(new MenuController(new MenuView()).getView()));
    }

    public Game3View getView() {
        return view;
    }
}
