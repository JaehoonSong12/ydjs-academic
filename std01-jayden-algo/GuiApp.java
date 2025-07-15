/**
INSTRUCTIONS: 
    Running this JavaFX GuiApp (GuiApp.java)




COMPILE & EXECUTE & CLEANUP (Java):

     javac  --module-path libs --add-modules javafx.controls,javafx.fxml -d out          GuiApp*.java
     java   --module-path libs --add-modules javafx.controls,javafx.fxml         -cp out GuiApp
     rm -rf out/








     

     


 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class GuiApp extends Application {
    @Override
    public void start(Stage stage) {
        // 1) title property → setTitle(...)
        stage.setTitle("Kotlin JavaFX");

        // 2) Button + anonymous inner-class for the lambda
        Button btn = new Button("Click me!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button clicked!");
            }
        });

        // 3) Scene creation and assignment via setter
        Scene scene = new Scene(btn, 300.0, 200.0);
        stage.setScene(scene);

        stage.show();
    }

    //  Kotlin companion object’s @JvmStatic main() → static main in Java
    public static void main(String[] args) {
        Application.launch(GuiApp.class, args);
    }
}
