import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import backend.Planet;

public class PresetPlanetScreen extends Application {

    private Planet[] presetPlanets;
    private double userWeight = 150.0;//Defualt-> change later to be what the user enters
    
    //constructor for making planet here:
    public PresetPlanetScreen(){
        initializePlanets();
    }

    private void initializePlanets(){
        //initializing real planets with their data
        solarSystem = new Planet[]{
            new Planet("Mars", 0.642f,3389.5f),
            new Planet("Earth", 5.97f, 6371.0f)
        };
        
        //adding preset planets to the solarSystem list
        for(Planet p: presetPlanets){
            p.addToSolarSystem();
        }
    }

    public void start(Stage stage) {
        
        Label title = new Label("PRESET PLANETS");
        title.setStyle("-fx-font-size: 32px; -fx-text-fill: #00FFFF;");
        //solar System list of all planets
        LinkedList<Planet> solarSystem = Planet.getSolarSystem();
        
        // TODO: Use Planet class to show preset planets
        // TODO: Display Earth, Mars, Jupiter, etc.
        // TODO: Show gravity calculations
        
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(title);

        //creating planet buttons
        for (Planet planet : solarSystem) {
            Button planetButton = createPlanetButton(planet);
            layout.getChildren().add(planetButton);
        }
        
        Scene scene = new Scene(layout, 900, 700);
        stage.setTitle("Preset Planets");
        stage.setScene(scene);
        stage.show();
    }

    //method to create planet Buttons
    private Button createPlanetButton(Planet planet) {
        // Load the image (updated path: planet_builder_images/[name].deploy.png)
        ImageView imageView = null;
        try {
            Image image = new Image("planet_builder_images/" + planet.getName().toLowerCase() + ".deploy.png");
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

    //showing planet details in another window when button is pressed:
        // Load the planet image (updated path)
    private void showPlanetDetails(Planet planet) {
        Stage detailStage = new Stage();
        detailStage.setTitle(planet.getName() + " Details");
        ImageView imageView = null;
        try {
            Image image = new Image("planet_builder_images/" + planet.getName().toLowerCase() + ".deploy.png");
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