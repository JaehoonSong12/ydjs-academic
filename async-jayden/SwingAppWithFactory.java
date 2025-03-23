/**
 * SwingAppWithFactory.java
 * 
 * This is a Java Swing application that demonstrates the Factory Design 
 * Pattern within an MVC architecture.
 * The application provides a simple UI where users can switch between 
 * different views (List View, Detail View, Form View).
 * The Factory Pattern is used to instantiate the view objects, ensuring 
 * separation of concerns and flexibility.
 *
 * Factory Design Principle:
 * - Encapsulates object creation, providing a centralized method to 
 * create and manage View instances.
 * - Improves maintainability by decoupling object instantiation 
 * from client classes (Controller).
 * - Enhances scalability, making it easy to add new views without 
 * modifying the existing code structure.
 *
 * How to compile and run the application:
 * 1. Open a terminal or command prompt.
 * 2. Compile: 
 *      `javac async-jayden/*.java`
 * 3. Run: 
 *      `java -cp async-jayden SwingAppWithFactory`
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;













// View interface representing different UI components
interface View {
    JPanel getRoot(); // Returns the root JPanel containing UI elements
}
/**
 * `interface`: weak relationship or inheritance, just for common behavior to `implements`.
 * `class`: strong relationship or inheritance, for blueprinting most of the parts to `extends`.
 */
// ViewList class implementing View
class ViewList implements View {
    private JPanel rootPanel;
    @Override
    public JPanel getRoot() {
        return rootPanel;
    }

    public ViewList() {
        // Layout (HTML like) Operation
        String[] data = {"Item 1", "Item 2", "Item 3"};
        JList<String> list = new JList<>(data);

        // Styling (CSS like) Operation
        // ....
        // ....

        // root components for Controller Logic (like system-objects in JavaScript)
        rootPanel = new JPanel(new BorderLayout());
        rootPanel.add(new JScrollPane(list), BorderLayout.CENTER);
    }

}
// ViewDetail class implementing View
class ViewDetail implements View {
    private JPanel rootPanel;
    @Override
    public JPanel getRoot() {
        return rootPanel;
    }

    public ViewDetail() {
        // Layout (HTML like) Operation
        // ....
        // ....

        // Styling (CSS like) Operation
        // ....
        // ....

        // root components for Controller Logic (like system-objects in JavaScript)
        rootPanel = new JPanel(new FlowLayout());
        rootPanel.add(new JLabel("This is the Detail View"));
    }
}
// ViewForm class implementing View
class ViewForm implements View {
    private JPanel rootPanel;
    @Override
    public JPanel getRoot() {
        return rootPanel;
    }

    public ViewForm() {
        // Layout (HTML like) Operation
        // ....
        // ....

        // Styling (CSS like) Operation
        // ....
        // ....

        // root components for Controller Logic (like system-objects in JavaScript)
        rootPanel = new JPanel(new GridLayout(2, 2));
        rootPanel.add(new JLabel("Name:"));
        rootPanel.add(new JTextField(10));
        rootPanel.add(new JLabel("Email:"));
        rootPanel.add(new JTextField(10));
    }
}












// ViewFactory class for creating view objects
class ViewFactory {
    public static View getView(String viewType) {
        switch (viewType.toUpperCase()) {
            case "LIST": return new ViewList();
            case "DETAIL": return new ViewDetail();
            case "FORM": return new ViewForm();
            default: throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
    }
}












// Main application entry point
public class SwingAppWithFactory {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingAppWithFactory::start);
    }

    private static JFrame frame;
    private static JPanel mainPanel;

    public static void start() {
        frame = new JFrame("Swing MVC with Factory Pattern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Navigation Panel
        JPanel navPanel = new JPanel();
        JButton viewListButton = new JButton("List View");
        JButton viewDetailButton = new JButton("Detail View");
        JButton viewFormButton = new JButton("Form View");

        navPanel.add(viewListButton);
        navPanel.add(viewDetailButton);
        navPanel.add(viewFormButton);

        // Main content panel
        mainPanel = new JPanel(new BorderLayout());

        // Button event handlers (Controller)
        viewListButton.addActionListener(e -> switchView("LIST"));
        viewDetailButton.addActionListener(e -> switchView("DETAIL"));
        viewFormButton.addActionListener(e -> switchView("FORM"));

        // Add panels to frame
        frame.add(navPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        switchView("LIST"); // Default view
        frame.setVisible(true);
    }

    private static void switchView(String viewType) {
        mainPanel.removeAll();
        View view = ViewFactory.getView(viewType);
        mainPanel.add(view.getRoot(), BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
