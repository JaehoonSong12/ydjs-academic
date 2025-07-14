package com.example.mvvm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        ViewModel viewModel = new ViewModel();
        View view = new View(viewModel);

        primaryStage.setScene(new Scene(view.getRoot(), 600, 400));
        primaryStage.setTitle("MVVM Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
