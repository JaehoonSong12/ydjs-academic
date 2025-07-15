/**
INSTRUCTIONS: 
    Running this JavaFX GuiApp (GuiApp.kt) with Kotlin




COMPILE & EXECUTE & CLEANUP (Kotlin):

     kotlinc    -d out  -cp "$(echo libs/javafx*.jar | tr ' ' ';')"             GuiApp*.kt
     kotlin             -cp "out;$(echo libs/javafx*.jar | tr ' ' ';')"         GuiApp
     rm -rf out/

COMPILE & EXECUTE & CLEANUP (Java x Kotlin):

     kotlinc    -d out  -cp "$(echo libs/javafx*.jar | tr ' ' ';')"             GuiApp*.kt
     java       --module-path libs --add-modules javafx.controls,javafx.fxml \
                        -cp "./out:$KOTLIN_HOME/lib/kotlin-stdlib.jar"          GuiApp
     rm -rf out/

TIP:
     - On Windows, use ';' as the classpath separator
     - On Mac/Linux, use ':' as the classpath separator
     - java   `-cp` (Mac/Linux) flag must sepcify absolute paths.
     - kotlin `-cp` (Windows) flag accepts relative paths.
 */

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage

class GuiApp : Application() {
    override fun start(stage: Stage) {
        // 1) Property setter syntax:
        stage.title = "Kotlin JavaFX"
        
        // 2) Lambda event handler:
        val btn = Button("Click me!")
        btn.setOnAction { _: ActionEvent ->
            println("Button clicked!")
        }

        // 3) Build scene graph:
        val scene = Scene(btn, 300.0, 200.0)
        stage.scene = scene

        stage.show()
    }
    
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(GuiApp::class.java, *args)
        }
    }
}
