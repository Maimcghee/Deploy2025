import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.shape.Circle;

public class HomeScreen extends Application {
    
    TextField weightInput;
    Button makePlanetButton;
    double userWeight;
    
    public void start(Stage stage) {
        
        // Background 
        // Temp image
        Image bg = new Image("file:star_bg.png");

        BackgroundImage bgImg = new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, 
            new BackgroundSize(100, 100, true, true, false, true));
        
        // Title
        Label title = new Label("PLANET SIMULATOR");
        title.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #00FFFF; " +
                      "-fx-effect: dropshadow(gaussian, #0088FF, 15, 0.7, 0, 0);");
        
        // Weight label
        Label weightLabel = new Label("Enter Your Weight (lbs):");
        weightLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 18px; -fx-font-weight: bold;");
        
        // Text input
        weightInput = new TextField();
        weightInput.setPromptText("example: 150");
        weightInput.setMaxWidth(250);
        weightInput.setStyle("-fx-background-color: rgba(20, 20, 60, 0.8); -fx-text-fill: #FFFFFF; " +
                            "-fx-font-size: 16px; -fx-border-color: #00FFFF; -fx-border-width: 2px; " +
                            "-fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 10px;");
        
        // Create planet button
        makePlanetButton = new Button("🪐 CREATE PLANET 🪐");
        makePlanetButton.setStyle("-fx-background-color: linear-gradient(to bottom, #6B46C1, #2D1B69); " +
                                 "-fx-text-fill: #FFFFFF; -fx-font-size: 18px; -fx-font-weight: bold; " +
                                 "-fx-padding: 15px 40px; -fx-border-color: #00FFFF; -fx-border-width: 2px; " +
                                 "-fx-border-radius: 20px; -fx-background-radius: 20px; -fx-cursor: hand;");
        
        // Button effect
        makePlanetButton.setOnMouseEntered(e -> {
            makePlanetButton.setStyle("-fx-background-color: linear-gradient(to bottom, #8B66E1, #4D3B89); " +
                                "-fx-text-fill: #FFFFFF; -fx-font-size: 18px; -fx-font-weight: bold; " +
                                "-fx-padding: 15px 40px; -fx-border-color: #00FFFF; -fx-border-width: 3px; " +
                                "-fx-border-radius: 20px; -fx-background-radius: 20px; -fx-cursor: hand; " +
                                "-fx-effect: dropshadow(gaussian, #00FFFF, 20, 0.8, 0, 0);");
        });
        
        makePlanetButton.setOnMouseExited(e -> {
            makePlanetButton.setStyle("-fx-background-color: linear-gradient(to bottom, #6B46C1, #2D1B69); " +
                                 "-fx-text-fill: #FFFFFF; -fx-font-size: 18px; -fx-font-weight: bold; " +
                                 "-fx-padding: 15px 40px; -fx-border-color: #00FFFF; -fx-border-width: 2px; " +
                                 "-fx-border-radius: 20px; -fx-background-radius: 20px; -fx-cursor: hand;");
        });
        
        // Go to InteractivePlanets
        makePlanetButton.setOnAction(event -> {
            try {
                userWeight = Double.parseDouble(weightInput.getText());
                
                if (userWeight > 0) {
                    weightInput.setStyle("-fx-background-color: rgba(20, 20, 60, 0.8); -fx-text-fill: #FFFFFF; " +
                                 "-fx-font-size: 16px; -fx-border-color: #00FF00; -fx-border-width: 2px; " +
                                 "-fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 10px;");
                    
                    InteractivePlanets customScreen = new InteractivePlanets(userWeight);
                    customScreen.start(new Stage());
                    stage.close();
                    
                } else {
                    weightInput.setStyle("-fx-background-color: rgba(60, 20, 20, 0.8); -fx-text-fill: #FFFFFF; " +
                               "-fx-font-size: 16px; -fx-border-color: #FF0000; -fx-border-width: 3px; " +
                               "-fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 10px;");
                }
                
            } catch (Exception e) {
                weightInput.setStyle("-fx-background-color: rgba(60, 20, 20, 0.8); -fx-text-fill: #FFFFFF; " +
                           "-fx-font-size: 16px; -fx-border-color: #FF0000; -fx-border-width: 3px; " +
                           "-fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 10px;");
            }
        });
        
        // Planet Images (circles at bottom)
        // Temp images
        ImageView planet1 = createPlanetImage("file:mars.deploy.png", 90);
        ImageView planet2 = createPlanetImage("file:earth.deploy.png", 90);
        
        // Go to PresetPlanetScreen
        planet1.setOnMouseClicked(e -> {
            PresetPlanetScreen presetScreen = new PresetPlanetScreen();
            presetScreen.start(new Stage());
            stage.close();
        });
        
        planet2.setOnMouseClicked(e -> {
            PresetPlanetScreen presetScreen = new PresetPlanetScreen();
            presetScreen.start(new Stage());
            stage.close();
        });
        planet1.setOnMouseEntered(e -> planet1.setStyle("-fx-effect: dropshadow(gaussian, #00FFFF, 20, 0.8, 0, 0);"));
        planet1.setOnMouseExited(e -> planet1.setStyle(""));
        planet2.setOnMouseEntered(e -> planet2.setStyle("-fx-effect: dropshadow(gaussian, #FF6B6B, 20, 0.8, 0, 0);"));
        planet2.setOnMouseExited(e -> planet2.setStyle(""));
        
        // Label for planets section
        Label exampleLabel = new Label("Or choose a preset planet:");
        exampleLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 16px;");
        
        // Planet images container
        HBox planetBox = new HBox(30);
        planetBox.setAlignment(Pos.CENTER);
        planetBox.getChildren().addAll(planet1, planet2);
        
                
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.setStyle("-fx-background-color: rgba(10, 10, 40, 0.3); -fx-border-color: #00FFFF; " +
               "-fx-border-width: 2px; -fx-border-radius: 25px; -fx-background-radius: 25px; " +
               "-fx-effect: dropshadow(gaussian, #000000, 20, 0.5, 0, 0);");

        layout.setMaxWidth(450);
        layout.getChildren().addAll(title, weightLabel, weightInput, makePlanetButton, exampleLabel, planetBox);
        
        StackPane root = new StackPane(layout);
        root.setBackground(new Background(bgImg));
        
        Scene scene = new Scene(root, 900, 700);
        stage.setTitle("Planet Simulator");
        stage.setScene(scene);
        stage.show();
    }
    
    //  Circular planet images
    private ImageView createPlanetImage(String imagePath, double size) {
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        imageView.setPreserveRatio(true);
        
        Circle clip = new Circle(size/2, size/2, size/2);
        imageView.setClip(clip);
        imageView.setStyle("-fx-cursor: hand;");
        
        return imageView;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}