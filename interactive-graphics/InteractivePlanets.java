import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
 // TODO: Add  Planet class 

public class InteractivePlanets extends Application {
    
    private double userWeight;
    
    public InteractivePlanets(double userWeight) {
        this.userWeight = userWeight;
    }
    
    public void start(Stage stage) {
        
        Label title = new Label("CREATE YOUR PLANET");
        title.setStyle("-fx-font-size: 32px; -fx-text-fill: #00FFFF;");
        
        Label weightLabel = new Label("Your weight: " + userWeight + " lbs");
        weightLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 18px;");
        
        // TODO: Use Planet:
        // TODO: setColor() , setWater() , setTerrain() -, setTree() , addToSolarSystem() 
        
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(title, weightLabel);
        
        Scene scene = new Scene(layout, 900, 700);
        stage.setTitle("Create Planet");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}