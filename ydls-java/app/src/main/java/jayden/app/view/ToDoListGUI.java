package jayden.app.view;

import jayden.app.controller.ToDoListController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// View
public class ToDoListGUI {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private ToDoListController controller;

    public ToDoListGUI(ToDoListController controller) {
        this.controller = controller;
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

        addButton.addActionListener(e -> controller.addTask(taskInput.getText().trim()));
        removeButton.addActionListener(e -> controller.removeTask(taskList.getSelectedIndex()));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(taskInput, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(removeButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void addTaskToList(String task) {
        taskListModel.addElement(task);
        taskInput.setText("");
    }

    public void removeTaskFromList(int index) {
        if (index != -1) {
            taskListModel.remove(index);
        }
    }
}

