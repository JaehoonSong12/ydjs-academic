/*
----------------------------------------------------------------------------
Feature     |           AWT                 |             Swing
----------------------------------------------------------------------------
Weight      | Heavyweight (OS-dependent)    | Lightweight (OS-independent)
Package     | java.awt                      | javax.swing
Speed       | Faster (direct OS calls)      | Slower (rendered by Java)
Components  | Limited set                   | "Richer set (Trees, Tables, etc.)"
Naming      | "Button", "Label"             | "JButton", "JLabel"
----------------------------------------------------------------------------

< Naming Equivalent Table >

-------------------------------------------------------------------------------------------------
Feature     |           AWT                 |             Swing             |       OS-term
-------------------------------------------------------------------------------------------------
Frame       | java.awt.Frame                | javax.swing.JFrame            |       Window
Panel       | java.awt.Panel                | javax.swing.JPanel            |     Container
BoxLayout   | java.awt.BoxLayout            | javax.swing.BoxLayout         |     Dividers (box-style)
GridLayout  | java.awt.GridLayout           | javax.swing.GroupLayout       |     Dividers (grid-style)
BorderLayout| java.awt.BorderLayout         | javax.swing.BorderLayout      |     Dividers (border-style)
CardLayout  | java.awt.CardLayout           | javax.swing.CardLayout        |     *Dividers (card-style)
Button      | java.awt.Button               | javax.swing.JButton           |     Button UI
Label       | java.awt.Label                | javax.swing.JLabel            |      Label UI
-------------------------------------------------------------------------------------------------


INSTRUCTIONS: 
    This is a java practice space for Eloise..!

COMPILE & EXECUTE & CLEANUP (Java):

     javac  -d out              GuiMain*.java
     java           -cp out     GuiMain*
     rm -rf out/
     
*/

// Java Foundation Classes (JFC)
// AWT (Abstract Window Toolkit)
// Swing


// import java.awt.Frame;
// import java.awt.Panel;
// import java.awt.Button;
import java.awt.*;
import java.awt.event.ActionListener;

// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JButton;
import javax.swing.*;

public class GuiMain {
    public static void main(String[] args) {
        // // AWT Example
        // awtExample();

        // Swing Example
        swingExample();
    }

    public static void awtExample() {
        // add a button to the panel
        Button button = new Button("Click Me");
        button.addActionListener(e -> System.out.println("Hi!")); // say hi when the button is clicked
        

        // AWT panel
        Panel panel = new Panel();
        panel.add(button);

        
        // AWT Example
        Frame awtFrame = new Frame("AWT Frame");
        awtFrame.add(panel); // Add panel to frame
        // basic frame settings
        awtFrame.setSize(300, 200);
        awtFrame.setVisible(true);
    }










    public final static CardLayout cardLayout = new CardLayout();
    public final static JPanel panel = new JPanel();
    public static void swingExample() {
        // content 1
        JPanel boxPanel = getBoxPanel(); // Get the box panel with label and button
        // content 2
        JPanel gridPanel = getGridPanel(); // Get the grid panel with label and button



        // Swing panel with Cardlayout
        panel.setLayout(cardLayout);
        panel.add(boxPanel, "ex1"); // Add box panel to card layout with name "ex1"
        panel.add(gridPanel, "ex2"); // Add grid panel to card layout with name "ex2"
        // Swing Example
        JFrame swingFrame = new JFrame("Swing Frame");
        swingFrame.add(panel); // Add panel to frame
        // basic frame settings
        swingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        swingFrame.pack(); // Adjust frame size to fit content
        swingFrame.setVisible(true);
    }
    
    public static JPanel getBoxPanel() {
        // add a label to the panel
        JLabel label = new JLabel("Welcome to Swing!");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Center the label text
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Set font for the label
        label.setForeground(Color.BLUE); // Set text color for the label
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add padding around the label
        label.setOpaque(true); // Make the label background visible
        label.setBackground(Color.LIGHT_GRAY); // Set background color for the label
        label.setPreferredSize(new Dimension(200, 50)); // Set preferred size for the label
        
        // add a button to the panel
        JButton button = new JButton("Click Me 1");
        ActionListener buttonListener = e -> {
            label.setText("Button Clicked!"); // Update label text when button is clicked
            label.setForeground(Color.RED); // Change text color when button is clicked
            GuiMain.cardLayout.show(GuiMain.panel, "ex2"); // Show the box panel first
        }; // Create an ActionListener for the button
        button.addActionListener(buttonListener); // Add ActionListener to the button

        // Layout (Box)
        JPanel boxPanel = new JPanel();
        BoxLayout layout = new BoxLayout(boxPanel, BoxLayout.Y_AXIS);
        boxPanel.setLayout(layout);
        boxPanel.add(label); // Add label to box panel
        boxPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add horizontal spacing between label and button
        boxPanel.add(button); // Add button to box panel

        return boxPanel;
    }

    public static JPanel getGridPanel() {
        // add a label to the panel
        JLabel label = new JLabel("Welcome to Swing!");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Center the label text
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Set font for the label
        label.setForeground(Color.BLUE); // Set text color for the label
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add padding around the label
        label.setOpaque(true); // Make the label background visible
        label.setBackground(Color.LIGHT_GRAY); // Set background color for the label
        label.setPreferredSize(new Dimension(200, 50)); // Set preferred size for the label
        
        // add a button to the panel
        JButton button = new JButton("Click Me 2");
        ActionListener buttonListener = e -> {
            label.setText("Button Clicked!"); // Update label text when button is clicked
            label.setForeground(Color.RED); // Change text color when button is clicked
            GuiMain.cardLayout.show(GuiMain.panel, "ex1"); // Show the box panel first
        }; // Create an ActionListener for the button
        button.addActionListener(buttonListener); // Add ActionListener to the button

        // Layout (Grid)
        JPanel gridPanel = new JPanel();
        GridLayout layout = new GridLayout(2, 1);
        gridPanel.setLayout(layout);
        gridPanel.add(label); // Add label to grid panel
        gridPanel.add(button); // Add button to grid panel

        return gridPanel;
    }
}