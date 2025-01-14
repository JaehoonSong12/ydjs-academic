import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class FontSizeSelector extends Application
{
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      // Constants for the scene dimensions
      final double WIDTH = 300.0, HEIGHT = 200.0;
      
      // Create the sample text.
      Label sampleText = new Label("Sample Text");
      
      // Create the menu bar.
      MenuBar menuBar = new MenuBar();
 
      // Create the File menu.
      Menu fileMenu = new Menu("File");
      MenuItem exitItem = new MenuItem("Exit");
      fileMenu.getItems().add(exitItem);
      
      // Register an event handler for the exit item.
      exitItem.setOnAction(event ->
      {
         primaryStage.close();
      });

      // Add the menu to the menu bar.
      menuBar.getMenus().addAll(fileMenu);
         
      // Create a BorderPane with the sample text in the center.
      BorderPane borderPane = new BorderPane(sampleText);
      
      // Add the menu bar to the top region.
      borderPane.setTop(menuBar);
      
      // Create a Scene and display it.
      Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}