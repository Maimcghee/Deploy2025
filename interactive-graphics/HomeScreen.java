import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class HomeScreen extends Application {
    
    TextField weightInput;
    Button makePlanetButton;
    
    public void start(Stage stage) {
        
        // Background
        Image backgroundImage = new Image("file:blue.png");
        BackgroundImage bgImage = new BackgroundImage(
            backgroundImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(100, 100, true, true, false, true)
        );
        Background background = new Background(bgImage);
        
        // Title
        Label titleLabel = new Label("PLANET SIMULATOR ");
        titleLabel.setStyle(
            "-fx-font-size: 32px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #00FFFF;" +
            "-fx-effect: dropshadow(gaussian, #0088FF, 15, 0.7, 0, 0);"
        );
        
        // Weight 
        Label weightLabel = new Label("Enter Your Weight (lbs):");
        weightLabel.setStyle(
            "-fx-text-fill: #FFFFFF;" +
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;"
        );
        
        // Weight Input
        weightInput = new TextField();
        weightInput.setPromptText("example:, 2");
        weightInput.setMaxWidth(250);
        weightInput.setStyle(
            "-fx-background-color: rgba(20, 20, 60, 0.8);" +
            "-fx-text-fill: #FFFFFF;" +
            "-fx-font-size: 16px;" +
            "-fx-border-color: #00FFFF;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;" +
            "-fx-padding: 10px;"
        );
        
        // Make Planet Button
        makePlanetButton = new Button("🪐 CREATE PLANET 🪐");
        makePlanetButton.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #6B46C1, #2D1B69);" +
            "-fx-text-fill: #FFFFFF;" +
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 15px 40px;" +
            "-fx-border-color: #00FFFF;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 20px;" +
            "-fx-background-radius: 20px;" +
            "-fx-cursor: hand;"
        );
        
        // Button Effects
        makePlanetButton.setOnMouseEntered(e -> 
            makePlanetButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #8B66E1, #4D3B89);" +
                "-fx-text-fill: #FFFFFF;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 15px 40px;" +
                "-fx-border-color: #00FFFF;" +
                "-fx-border-width: 3px;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 20px;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, #00FFFF, 20, 0.8, 0, 0);"
            )
        );
        
        makePlanetButton.setOnMouseExited(e -> 
            makePlanetButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #6B46C1, #2D1B69);" +
                "-fx-text-fill: #FFFFFF;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 15px 40px;" +
                "-fx-border-color: #00FFFF;" +
                "-fx-border-width: 2px;" +
                "-fx-border-radius: 20px;" +
                "-fx-background-radius: 20px;" +
                "-fx-cursor: hand;"
            )
        );
        
        makePlanetButton.setOnAction(event -> {
            String weight = weightInput.getText();
            
            try {
                double weightValue = Double.parseDouble(weight);
                
                if (weightValue <= 0) {
                    weightInput.setStyle(
                        "-fx-background-color: rgba(60, 20, 20, 0.8);" +
                        "-fx-text-fill: #FFFFFF;" +
                        "-fx-font-size: 16px;" +
                        "-fx-border-color: #FF0000;" +
                        "-fx-border-width: 3px;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-padding: 10px;"
                    );
                    return;
                }
                
                weightInput.setStyle(
                    "-fx-background-color: rgba(20, 20, 60, 0.8);" +
                    "-fx-text-fill: #FFFFFF;" +
                    "-fx-font-size: 16px;" +
                    "-fx-border-color: #00FF00;" +
                    "-fx-border-width: 2px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-padding: 10px;"
                );
                System.out.println("Weight: " + weightValue + " lbs");
                
            } catch (NumberFormatException e) {
                weightInput.setStyle(
                    "-fx-background-color: rgba(60, 20, 20, 0.8);" +
                    "-fx-text-fill: #FFFFFF;" +
                    "-fx-font-size: 16px;" +
                    "-fx-border-color: #FF0000;" +
                    "-fx-border-width: 3px;" +
                    "-fx-border-radius: 10px;" +
                    "-fx-background-radius: 10px;" +
                    "-fx-padding: 10px;"
                );
            }
        });
        
        VBox inputLayout = new VBox(20);
        inputLayout.setAlignment(Pos.CENTER);
        inputLayout.setPadding(new Insets(40));
        inputLayout.setStyle(
            "-fx-background-color: rgba(10, 10, 40, 0.75);" +
            "-fx-border-color: #00FFFF;" +
            "-fx-border-width: 3px;" +
            "-fx-border-radius: 25px;" +
            "-fx-background-radius: 25px;" +
            "-fx-effect: dropshadow(gaussian, #000000, 30, 0.7, 0, 0);"
        );
        inputLayout.setMaxWidth(400);
        inputLayout.getChildren().addAll(titleLabel, weightLabel, weightInput, makePlanetButton);
        
        StackPane root = new StackPane();
        root.setBackground(background);
        root.getChildren().add(inputLayout);
        Scene scene = new Scene(root, 900, 700);
        stage.setTitle("Planet Simulator");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}