package com.example.mvvm;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class View {
    private final VBox root;
    private final ListView<String> listView;
    private final TextField inputField;
    private final Button addButton;

    public View(ViewModel viewModel) {
        listView = new ListView<>(viewModel.getItems());
        inputField = new TextField();
        inputField.textProperty().bindBidirectional(viewModel.newItemProperty());
        addButton = new Button("Add Item");
        addButton.setOnAction(e -> viewModel.addItem());
        root = new VBox(10, listView, inputField, addButton);
    }

    public VBox getRoot() {
        return root;
    }
}
