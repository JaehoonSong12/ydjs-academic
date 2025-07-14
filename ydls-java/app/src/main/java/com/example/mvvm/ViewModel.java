package com.example.mvvm;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ViewModel {
    private final Model model;
    private final ObservableList<String> items;
    private final StringProperty newItem;

    public ViewModel() {
        model = new Model();
        items = FXCollections.unmodifiableObservableList(model.getItems());
        newItem = new SimpleStringProperty();
    }

    public ObservableList<String> getItems() {
        return items;
    }

    public StringProperty newItemProperty() {
        return newItem;
    }

    public void addItem() {
        if (!newItem.get().isEmpty()) {
            model.addItem(newItem.get());
            newItem.set("");
        }
    }

    public void removeItem(String item) {
        model.removeItem(item);
    }
}
