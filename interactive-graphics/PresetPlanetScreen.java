import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
//   // TODO: Add when Planet class is fixed

public class PresetPlanetScreen extends Application {
    
    public void start(Stage stage) {
        
        Label title = new Label("PRESET PLANETS");
        title.setStyle("-fx-font-size: 32px; -fx-text-fill: #00FFFF;");
        
        // TODO: Use Planet class to show preset planets
        // TODO: Display Earth, Mars, Jupiter, etc.
        // TODO: Show gravity calculations
        
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(title);
        
        Scene scene = new Scene(layout, 900, 700);
        stage.setTitle("Preset Planets");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}