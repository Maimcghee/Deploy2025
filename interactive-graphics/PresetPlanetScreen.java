import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.util.LinkedList;
import backend.Planets;

public class PresetPlanetScreen extends Application {

    private Planets[] presetPlanets;
    private double userWeight = 150.0;//Defualt-> change later to be what the user enters
    
    //constructor for making planet here:
    public PresetPlanetScreen(){
        initializePlanets();
    }

    private void initializePlanets(){
        //initializing real planets with their data
        presetPlanets = new Planets[]{

            new Planets("Mars", 0.642f, 3389500f),
            new Planets("Earth", 5.97e24f, 6371000f),
            new Planets("Jupiter", 1.898e27f, 69911000f)

        };
        
        //adding preset planets to the solarSystem list
        for(Planets p: presetPlanets){
            p.addToSolarSystem();
        }
    }

    public void start(Stage stage) {
        
        Label title = new Label("PRESET PLANETS");
        title.setStyle("-fx-font-size: 32px; -fx-text-fill: #00FFFF;");
        //solar System list of all planets
        LinkedList<Planets> solarSystem = Planets.getSolarSystem();
        
        // TODO: Use Planet class to show preset planets
        // TODO: Display Earth, Mars, Jupiter, etc.
        // TODO: Show gravity calculations
        
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(title);

        //creating planet buttons
        for (Planets planet : solarSystem) {
            Button planetButton = createPlanetButton(planet);
            layout.getChildren().add(planetButton);
        }
        
        Scene scene = new Scene(layout, 900, 700);
        stage.setTitle("Preset Planets");
        stage.setScene(scene);
        stage.show();
    }

    //method to create planet Buttons
    private Button createPlanetButton(Planets planet) {
        // Load the image (updated path: planet_builder_images/[name].deploy.png)
        ImageView imageView = null;
        try {
            Image image = new Image("file:planet_builder_images/" + planet.getName().toLowerCase() + ".deploy.png");
            imageView = new ImageView(image);
            imageView.setFitWidth(100);  // Adjust size as needed
            imageView.setFitHeight(100);
        } catch (Exception e) {
            System.out.println("Image not found for " + planet.getName() + ": " + e.getMessage());
            // Fallback: Use a text-only button if image fails
        }
        Button button = new Button(planet.getName());
        if (imageView != null) {
            button.setGraphic(imageView);
        }
        button.setStyle("-fx-font-size: 18px;");
        // Set action to show details
        button.setOnAction(e -> showPlanetDetails(planet));
        return button;
    }

    private void showPlanetDetails(Planets planet) {
        Stage detailStage = new Stage();
        detailStage.setTitle(planet.getName() + " Details");
        ImageView imageView = null;
        try {
            Image image = new Image("file:planet_builder_images/" + planet.getName().toLowerCase() + ".deploy.png");
            imageView = new ImageView(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
        } catch (Exception e) {
            System.out.println("Image not found for " + planet.getName() + ": " + e.getMessage());
        }
        // Labels for planet data
        Label nameLabel = new Label("Name: " + planet.getName());
        Label massLabel = new Label("Mass: " + planet.planetMass + " x 10^24 kg");  // Adjust units as needed
        Label radiusLabel = new Label("Radius: " + planet.planetRadius + " km");
        Label gravityLabel = new Label("Gravity: " + planet.planetGravity + " m/s²");
        Label weightLabel = new Label("Your Weight: " + String.format("%.2f", planet.getNewUserWeight((float) userWeight)) + " lbs");
        // Layout: Image on left, details on right
        VBox detailsBox = new VBox(10, nameLabel, massLabel, radiusLabel, gravityLabel, weightLabel);
        detailsBox.setAlignment(Pos.CENTER_LEFT);
        HBox layout = new HBox(20);
        if (imageView != null) {
            layout.getChildren().add(imageView);
        }
        layout.getChildren().add(detailsBox);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 600, 400);
        detailStage.setScene(scene);
        detailStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
