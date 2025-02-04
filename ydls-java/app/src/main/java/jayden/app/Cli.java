package jayden.app;

import jayden.unit.a.Exercise;

import javax.swing.JOptionPane; // Needed for JOptionPane



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cli {
    public static void main(String[] args) { // executable main method 
        System.out.println("Hello, Cli!");
        System.out.println("This is just for testing!");

        // Exercise.main(args); // test homework! Unit A

        SwingUtilities.invokeLater(() -> new ToDoListGUI());

        // test();

        // jayden.usaco.Exercise01.main(args); /// This is for `./script/java02-build.sh`, not needed.
    }





    public static void test() {
        double score1; // To hold score #1
        double score2; // To hold score #2
        double score3; // To hold score #3
        double average; // To hold the average score
        String input; // To hold the user's input

        // Get the first test score.
        input = JOptionPane.showInputDialog("Enter score #1:");
        score1 = Double.parseDouble(input);

        // Get the second score.
        input = JOptionPane.showInputDialog("Enter score #2:");
        score2 = Double.parseDouble(input);

        // Get the third test score.
        input = JOptionPane.showInputDialog("Enter score #3:");
        score3 = Double.parseDouble(input);

        // Calculate the average score.
        average = (score1 + score2 + score3) / 3.0;

        // Display the average score.
        JOptionPane.showMessageDialog(null, "The average is " + average);

        // If the average was greater than 95, let the user know that's a great score.
        if (average > 95) {
            JOptionPane.showMessageDialog(null, "That's a great score!");
        }

        System.exit(0);
    }
}



// why not 'public class'
class ToDoListGUI {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public ToDoListGUI() {
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Selected");

        addButton.addActionListener(e -> addTask()); // lambda expression, what is this
        removeButton.addActionListener(e -> removeTask());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(taskInput, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(removeButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskInput.setText("");
        }
    }

    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        }
    }
}
