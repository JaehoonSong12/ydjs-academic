/**
 * SwingAppWithFactory.java
 * 
 * This is a Java Swing application that demonstrates the Factory Design Pattern within an MVC architecture.
 * The application provides a simple UI where users can switch between different views (List View, Detail View, Form View).
 * The Factory Pattern is used to instantiate the view objects, ensuring separation of concerns and flexibility.
 *
 * Factory Design Principle:
 * - Encapsulates object creation, providing a centralized method to create and manage View instances.
 * - Improves maintainability by decoupling object instantiation from client classes (Controller).
 * - Enhances scalability, making it easy to add new views without modifying the existing code structure.
 *
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Ensure you are in the root directory containing `SwingAppWithFactory.java`.
 * 3. Compile: javac SwingAppWithFactory.java
 * 4. Run: java SwingAppWithFactory
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// View interface representing different UI components
interface View {
    JPanel getRoot(); // Returns the root JPanel containing UI elements
}

// ListView class implementing View
class ListView implements View {
    private JPanel rootPanel;

    public ListView() {
        rootPanel = new JPanel(new BorderLayout());
        String[] data = {"Item 1", "Item 2", "Item 3"};
        JList<String> list = new JList<>(data);
        rootPanel.add(new JScrollPane(list), BorderLayout.CENTER);
    }

    @Override
    public JPanel getRoot() {
        return rootPanel;
    }
}

// DetailView class implementing View
class DetailView implements View {
    private JPanel rootPanel;

    public DetailView() {
        rootPanel = new JPanel(new FlowLayout());
        rootPanel.add(new JLabel("This is the Detail View"));
    }

    @Override
    public JPanel getRoot() {
        return rootPanel;
    }
}

// FormView class implementing View
class FormView implements View {
    private JPanel rootPanel;

    public FormView() {
        rootPanel = new JPanel(new GridLayout(2, 2));
        rootPanel.add(new JLabel("Name:"));
        rootPanel.add(new JTextField(10));
        rootPanel.add(new JLabel("Email:"));
        rootPanel.add(new JTextField(10));
    }

    @Override
    public JPanel getRoot() {
        return rootPanel;
    }
}

// ViewFactory class for creating view objects
class ViewFactory {
    public static View createView(String viewType) {
        switch (viewType.toUpperCase()) {
            case "LIST": return new ListView();
            case "DETAIL": return new DetailView();
            case "FORM": return new FormView();
            default: throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
    }
}

// Application manager for handling UI operations
class ApplicationManager {
    private static JFrame frame;
    private static JPanel mainPanel;

    public static void initialize() {
        frame = new JFrame("Swing MVC with Factory Pattern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Navigation Panel
        JPanel navPanel = new JPanel();
        JButton listViewButton = new JButton("List View");
        JButton detailViewButton = new JButton("Detail View");
        JButton formViewButton = new JButton("Form View");

        navPanel.add(listViewButton);
        navPanel.add(detailViewButton);
        navPanel.add(formViewButton);

        // Main content panel
        mainPanel = new JPanel(new BorderLayout());

        // Button event handlers
        listViewButton.addActionListener(e -> switchView("LIST"));
        detailViewButton.addActionListener(e -> switchView("DETAIL"));
        formViewButton.addActionListener(e -> switchView("FORM"));

        // Add panels to frame
        frame.add(navPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        switchView("LIST"); // Default view
        frame.setVisible(true);
    }

    private static void switchView(String viewType) {
        mainPanel.removeAll();
        View view = ViewFactory.createView(viewType);
        mainPanel.add(view.getRoot(), BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}

// Main application entry point
public class SwingAppWithFactory {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ApplicationManager::initialize);
    }
}
