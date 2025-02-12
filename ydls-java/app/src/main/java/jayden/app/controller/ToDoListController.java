package jayden.app.controller;

import jayden.app.view.ToDoListGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Controller
public class ToDoListController {
    private ToDoListGUI view;

    public ToDoListController(ToDoListGUI view) {
        this.view = view;
    }

    public void setView(ToDoListGUI view) {
        this.view = view;
    }

    public void addTask(String task) {
        if (!task.isEmpty()) {
            view.addTaskToList(task);
        }
    }

    public void removeTask(int index) {
        view.removeTaskFromList(index);
    }
}