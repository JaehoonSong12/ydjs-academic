/*


INSTRUCTIONS: 
    This is a java practice space for Eloise..!

COMPILE & EXECUTE & CLEANUP (Java):

     javac  -d out              JMain*.java
     java           -cp out     JMain*
     rm -rf out/
     
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <h1>JavaFX-like MVC Wizard Implementation</h1>
 * This class serves as the entry point for a wizard-style application, mimicking 
 * the structure of JavaFX using standard Swing components.
 * 
 * <h2>Design Patterns Used:</h2>
 * <ul>
 * <li><b>Template Method Pattern:</b> The {@link Application} base class dictates the lifecycle 
 *     (init, start, stop) and defers the specific implementation of {@code start} to subclasses.</li>
 * <li><b>Model-View-Controller (MVC):</b> Data (Model), UI (View), and logic (Controller) are separated.</li>
 * <li><b>Mediator Pattern:</b> {@link WizardController} manages communication between {@link WizardModel} and {@link WizardView}.</li>
 * <li><b>Strategy Pattern:</b> {@link java.awt.CardLayout} uses cards as interchangeable strategies for displaying views.</li>
 * <li><b>Composition:</b> Wrapping {@link JFrame} within {@link Stage}, and {@link JComponent} within {@link Scene}, 
 *     prioritizing object composition over inheritance.</li>
 * </ul>
 */
public class JMain extends Application {
    
    /**
     * Entry point for the application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Initializes the UI for the wizard, mapping the root view to a Scene, 
     * and setting it on the primary Stage.
     * 
     * @param primaryStage the primary window for this application.
     * @throws Exception if any error occurs during application startup.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        WizardModel model = new WizardModel();
        WizardView view = new WizardView();

        new WizardController(model, view);

        Scene scene = new Scene(view.getRoot());

        primaryStage.setTitle("MVC Wizard with Method References");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

// =============================================================================
// JavaFX-like API (Swing Implementation)
// =============================================================================

/**
 * Represents the visual contents of a {@link Stage}.
 * It acts as a container wrapper for a root {@link JComponent}, applying the 
 * <b>Adapter Pattern</b> to mimic JavaFX's Scene API using Swing.
 */
class Scene {
    private final JComponent root;

    /**
     * Creates a Scene for a specific root component.
     * @param root the root UI component of the scene.
     */
    public Scene(JComponent root) {
        this.root = root;
    }

    /**
     * Creates a Scene for a specific root component with a specific size.
     * @param root the root UI component of the scene.
     * @param width the width of the scene.
     * @param height the height of the scene.
     */
    public Scene(JComponent root, double width, double height) {
        this.root = root;
        this.root.setPreferredSize(new Dimension((int) width, (int) height));
    }

    /**
     * Returns the root component of this scene.
     * @return the root {@link JComponent}.
     */
    public JComponent getRoot() {
        return root;
    }
}

/**
 * Represents the top-level container (window).
 * Uses the <b>Facade Pattern</b> to provide a simplified, JavaFX-style 
 * interface over the complex Swing {@link JFrame}.
 */
class Stage {
    private final JFrame frame;
    private Scene scene;

    /**
     * Initializes a new Stage wrapping a JFrame.
     */
    public Stage() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Sets the title of the window.
     * @param title the title string.
     */
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    /**
     * Specifies the scene to be used on this stage.
     * @param scene the Scene to display.
     */
    public void setScene(Scene scene) {
        this.scene = scene;
        frame.setContentPane(scene.getRoot());
        frame.pack();
        frame.setLocationRelativeTo(null); // Recenter after pack
    }

    /**
     * Makes the stage visible.
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * Specifies whether the stage can be resized by the user.
     * @param value true to allow resizing, false otherwise.
     */
    public final void setResizable(boolean value) {
        frame.setResizable(value);
    }

    /**
     * Checks if the stage is resizable.
     * @return true if resizable, false otherwise.
     */
    public final boolean isResizable() {
        return frame.isResizable();
    }

    /**
     * Retrieves the underlying Swing frame.
     * @return the {@link JFrame} managed by this stage.
     */
    public JFrame getFrame() {
        return frame;
    }
}

// =============================================================================
// APPLICATION: Abstract base and launch entry point
// =============================================================================

/**
 * Abstract application base class that models the JavaFX Application lifecycle.
 * Utilizes the <b>Template Method Pattern</b> to define the skeleton of the 
 * application lifecycle ({@code init}, {@code start}, {@code stop}).
 */
abstract class Application {
    
    /**
     * The application initialization method. Called before {@code start}.
     * @throws Exception if initialization fails.
     */
    public void init() throws Exception {}

    /**
     * The main entry point for the application. Subclasses must implement this.
     * @param primaryStage the primary stage for this application.
     * @throws Exception if an error occurs.
     */
    public abstract void start(Stage primaryStage) throws Exception;

    /**
     * The application cleanup method. Called when the application should stop.
     * @throws Exception if cleanup fails.
     */
    public void stop() throws Exception {}

    /**
     * Launches the application by inferring the calling class using reflection.
     * Uses the <b>Factory Method Pattern</b> concept internally to instantiate the application.
     * @param args the command-line arguments.
     */
    public static void launch(String... args) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String callingClassName = null;
            for (int i = 1; i < stackTrace.length; i++) {
                if (stackTrace[i].getMethodName().equals("main")) {
                    callingClassName = stackTrace[i].getClassName();
                    break;
                }
            }
            if (callingClassName == null && stackTrace.length > 2) {
                callingClassName = stackTrace[2].getClassName();
            }
            if (callingClassName != null) {
                Class<?> clazz = Class.forName(callingClassName);
                if (Application.class.isAssignableFrom(clazz)) {
                    @SuppressWarnings("unchecked")
                    Class<? extends Application> appClass = (Class<? extends Application>) clazz;
                    launch(appClass, args);
                    return;
                }
            }
            throw new RuntimeException("Could not determine Application subclass from stack trace.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to launch application", e);
        }
    }

    /**
     * Launches the specific application class on the Swing Event Dispatch Thread (EDT).
     * @param appClass the application class to instantiate and run.
     * @param args the command-line arguments.
     */
    public static void launch(Class<? extends Application> appClass, String... args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Application app = appClass.getDeclaredConstructor().newInstance();
                app.init();
                Stage primaryStage = new Stage();
                
                primaryStage.getFrame().addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        try {
                            app.stop();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                app.start(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException("Failed to launch application", e);
            }
        });
    }
}



















// =============================================================================
// MODEL: Data and Business Logic
// =============================================================================

/**
 * Stores the state of the wizard application.
 * Represents the <b>Model</b> in the MVC pattern.
 */
class WizardModel {
    private String userName = "";

    /**
     * Sets the user's name.
     * @param name the name to set.
     */
    public void setUserName(String name) { this.userName = name; }
    
    /**
     * Gets the user's name.
     * @return the current user name.
     */
    public String getUserName() { return userName; }
}

// =============================================================================
// VIEW: UI Structure and Components
// =============================================================================

/**
 * A custom Swing panel that provides visual fade transitions between components.
 * Implements a custom rendering loop to fade out the previous view.
 */
class TransitionPanel extends JPanel {
    private final CardLayout cardLayout = new CardLayout();
    private float alpha = 1f;
    private Image oldImage;
    private Timer timer;

    /**
     * Constructs a TransitionPanel utilizing a CardLayout.
     */
    public TransitionPanel() {
        setLayout(cardLayout);
    }

    /**
     * Adds a component to the panel with the specified identifier.
     * @param comp the component to add.
     * @param name the identifier for the card layout.
     */
    public void addCard(Component comp, String name) {
        add(comp, name);
    }

    /**
     * Shows the specified card and triggers the fade transition animation.
     * @param name the identifier of the card to show.
     */
    public void showCard(String name) {
        if (getWidth() > 0 && getHeight() > 0) {
            oldImage = createImage(getWidth(), getHeight());
            if (oldImage != null) {
                Graphics g = oldImage.getGraphics();
                paint(g);
                g.dispose();
            }
        }
        
        cardLayout.show(this, name);
        
        if (oldImage != null) {
            alpha = 1f;
            if (timer != null && timer.isRunning()) timer.stop();
            timer = new Timer(15, e -> {
                alpha -= 0.08f;
                if (alpha <= 0) {
                    alpha = 0;
                    timer.stop();
                    oldImage = null;
                }
                repaint();
            });
            timer.start();
        }
    }

    /**
     * Paints the panel, blending the old image over the new one to create a fade effect.
     * @param g the Graphics context.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (oldImage != null && alpha > 0) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2d.drawImage(oldImage, 0, 0, null);
            g2d.dispose();
        }
    }
}

/**
 * Manages the visual elements and the layout for the wizard application.
 * Represents the <b>View</b> in the MVC pattern.
 */
class WizardView {
    private final TransitionPanel cardsPanel = new TransitionPanel();
    private final JPanel rootPanel = new JPanel(new BorderLayout());

    private final JButton btnBack = new JButton("< Back");
    private final JButton btnNext = new JButton("Next >");
    private final JTextField nameField = new JTextField(15);
    private final JLabel summaryLabel = new JLabel("Summary", SwingConstants.CENTER);

    /**
     * Constructs the View, initializing the wizard UI steps.
     */
    public WizardView() {
        // Setup Card 1
        JPanel step1 = new JPanel();
        step1.add(new JLabel("Enter Name:"));
        step1.add(nameField);

        // Setup Card 2
        JPanel step2 = new JPanel(new BorderLayout());
        step2.add(summaryLabel, BorderLayout.CENTER);

        cardsPanel.addCard(step1, "STEP_1");
        cardsPanel.addCard(step2, "STEP_2");

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        controls.add(btnBack);
        controls.add(btnNext);

        rootPanel.add(cardsPanel, BorderLayout.CENTER);
        rootPanel.add(controls, BorderLayout.SOUTH);
        rootPanel.setPreferredSize(new Dimension(400, 200));
    }

    /**
     * Retrieves the root component containing the entire view.
     * @return the root {@link JComponent}.
     */
    public JComponent getRoot() { return rootPanel; }

    // Navigation and Data Access
    
    /**
     * Commands the layout to display a specific card by its identifier.
     * @param id the string identifier of the card.
     */
    public void showCard(String id) { cardsPanel.showCard(id); }
    
    public JButton getBtnBack() { return btnBack; }
    public JButton getBtnNext() { return btnNext; }
    public String getInputText() { return nameField.getText(); }
    public void setSummaryText(String text) { summaryLabel.setText(text); }
}

// =============================================================================
// CONTROLLER: Coordination and Event Handling
// =============================================================================

/**
 * Coordinates user actions and manages data flow between the Model and View.
 * Represents the <b>Controller</b> in the MVC pattern, and acts as a <b>Mediator</b> 
 * by centralizing UI event logic.
 */
class WizardController {
    private final WizardModel model;
    private final WizardView view;
    private int step = 1;

    /**
     * Constructs the Controller, wiring up UI events to handler methods.
     * @param model the wizard data model.
     * @param view the wizard user interface.
     */
    public WizardController(WizardModel model, WizardView view) {
        this.model = model;
        this.view = view;

        /* * METHOD REFERENCES: 
         * view.getBtnNext().addActionListener(this::handleNext) 
         * is equivalent to 
         * (e) -> this.handleNext(e)
         */
        this.view.getBtnNext().addActionListener(this::handleNext);
        this.view.getBtnBack().addActionListener(this::handleBack);

        updateUI();
    }

    /**
     * Handles forward navigation through the wizard steps.
     * @param e the ActionEvent triggered by the 'Next' button.
     */
    private void handleNext(java.awt.event.ActionEvent e) {
        if (step == 1) {
            model.setUserName(view.getInputText());
            view.setSummaryText("Registered: " + model.getUserName());
            view.showCard("STEP_2");
            step = 2;
        } else {
            JOptionPane.showMessageDialog(null, "Process Finished!");
            System.exit(0);
        }
        updateUI();
    }

    /**
     * Handles backward navigation through the wizard steps.
     * @param e the ActionEvent triggered by the 'Back' button.
     */
    private void handleBack(java.awt.event.ActionEvent e) {
        if (step == 2) {
            view.showCard("STEP_1");
            step = 1;
        }
        updateUI();
    }

    /**
     * Updates the state of the UI controls based on the current wizard step.
     */
    private void updateUI() {
        view.getBtnBack().setEnabled(step > 1);
        view.getBtnNext().setText(step == 2 ? "Finish" : "Next >");
    }
}



/*


INSTRUCTIONS: 
    This is a java practice space for Eloise..!

COMPILE & EXECUTE & CLEANUP (Java):

     javac  -d out              JMain*.java
     java           -cp out     JMain*
     rm -rf out/
     
*/