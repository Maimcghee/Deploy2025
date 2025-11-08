import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreen extends Application {
    
    TextField weightInput;
    Button makePlanetButton;
    
    @Override
    public void start(Stage stage) {
        
        // Weight
        weightInput = new TextField();
        
        // Make button
        makePlanetButton = new Button("Make Planet");
        
        // Button actions
        makePlanetButton.setOnAction(event -> {
            // Get weight
            String weight = weightInput.getText();
            System.out.println("Weight: " + weight);
            
            // TODO: Switch to MakePlanetScreen
        });
        
        // HS layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(weightInput, makePlanetButton);
        
        // Scene layout
        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}