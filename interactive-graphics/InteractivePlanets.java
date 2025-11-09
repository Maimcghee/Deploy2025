package backend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import backend.Planets;


public class InteractivePlanets extends Application {
    
    private double userWeight;
    private ImageView planetView;
    private StackPane planetDisplay;
    
    private boolean hasWater = false;
    private boolean hasTerrain = false;
    private boolean hasTrees = false;
    private String planetColor = "blue";
    
    private TextField planetNameField;
    private TextField massField;
    private TextField radiusField;
    
    private Label weightOnPlanetLabel;
    
    public InteractivePlanets(double userWeight) {
        this.userWeight = userWeight;
    }
    
    public void start(Stage stage) {
        
        Label title = new Label("CREATE YOUR PLANET");
        title.setStyle("-fx-font-size: 32px; -fx-text-fill: #00FFFF; -fx-font-weight: bold;");
        
        Label weightLabel = new Label("Your Earth weight: " + userWeight + " lbs");
        weightLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 18px;");
        
        weightOnPlanetLabel = new Label("");
        weightOnPlanetLabel.setStyle("-fx-text-fill: #00FF00; -fx-font-size: 16px; -fx-font-weight: bold;");
        
        Label nameLabel = new Label("Planets Name:");
        nameLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 14px;");
        planetNameField = new TextField();
        planetNameField.setPromptText("Enter planet name");
        planetNameField.setMaxWidth(200);
        
        Label massLabel = new Label("Mass (kg):");
        massLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 14px;");
        massField = new TextField();
        massField.setPromptText("e.g., 5.97e24");
        massField.setMaxWidth(200);
        
        Label radiusLabel = new Label("Radius (m):");
        radiusLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 14px;");
        radiusField = new TextField();
        radiusField.setPromptText("e.g., 6371000");
        radiusField.setMaxWidth(200);
        
        HBox nameBox = new HBox(10, nameLabel, planetNameField);
        nameBox.setAlignment(Pos.CENTER);
        HBox massBox = new HBox(10, massLabel, massField);
        massBox.setAlignment(Pos.CENTER);
        HBox radiusBox = new HBox(10, radiusLabel, radiusField);
        radiusBox.setAlignment(Pos.CENTER);
        
        planetDisplay = new StackPane();
        planetDisplay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5); -fx-border-color: #00FFFF; " +
                              "-fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        planetDisplay.setPrefSize(300, 300);
        
        planetView = new ImageView(new Image("file:basePlanet.deploy.png"));
        planetView.setFitWidth(250);
        planetView.setFitHeight(250);
        planetView.setPreserveRatio(true);
        planetDisplay.getChildren().add(planetView);
        
        Label optionsLabel = new Label("Customize Your Planet:");
        optionsLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 18px; -fx-font-weight: bold;");
        
        Button waterButton = new Button("💧 Add Water");
        waterButton.setStyle("-fx-background-color: #4A90E2; -fx-text-fill: white; -fx-font-size: 14px; " +
                            "-fx-padding: 10px 20px; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        waterButton.setOnAction(e -> addWater());
        
        Button terrainButton = new Button("⛰️ Add Terrain");
        terrainButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-font-size: 14px; " +
                              "-fx-padding: 10px 20px; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        terrainButton.setOnAction(e -> addTerrain());
        
        Button treesButton = new Button("🌳 Add Trees");
        treesButton.setStyle("-fx-background-color: #228B22; -fx-text-fill: white; -fx-font-size: 14px; " +
                            "-fx-padding: 10px 20px; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        treesButton.setOnAction(e -> addTrees());
        
        Button ringsButton = new Button("💍 Add Rings");
        ringsButton.setStyle("-fx-background-color: #DAA520; -fx-text-fill: white; -fx-font-size: 14px; " +
                            "-fx-padding: 10px 20px; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        ringsButton.setOnAction(e -> addRings());
        
        HBox buttonRow1 = new HBox(15);
        buttonRow1.setAlignment(Pos.CENTER);
        buttonRow1.getChildren().addAll(waterButton, terrainButton);
        
        HBox buttonRow2 = new HBox(15);
        buttonRow2.setAlignment(Pos.CENTER);
        buttonRow2.getChildren().addAll(treesButton, ringsButton);
        
        Button calculateButton = new Button("⚖️ Calculate My Weight");
        calculateButton.setStyle("-fx-background-color: #FF6B6B; -fx-text-fill: white; -fx-font-size: 14px; " +
                                "-fx-padding: 10px 20px; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        calculateButton.setOnAction(e -> calculateWeight());
        
        Button saveButton = new Button("💾 Save Planet");
        saveButton.setStyle("-fx-background-color: linear-gradient(to bottom, #6B46C1, #2D1B69); " +
                           "-fx-text-fill: #FFFFFF; -fx-font-size: 16px; -fx-font-weight: bold; " +
                           "-fx-padding: 12px 30px; -fx-border-color: #00FFFF; -fx-border-width: 2px; " +
                           "-fx-border-radius: 15px; -fx-background-radius: 15px;");
        saveButton.setOnAction(e -> savePlanet(stage));
        
        Button viewPlanetsButton = new Button("🌍 View All Planets");
        viewPlanetsButton.setStyle("-fx-background-color: #4ECDC4; -fx-text-fill: white; -fx-font-size: 14px; " +
                                  "-fx-padding: 10px 20px; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        viewPlanetsButton.setOnAction(e -> viewAllPlanets());
        
        HBox actionButtons = new HBox(15);
        actionButtons.setAlignment(Pos.CENTER);
        actionButtons.getChildren().addAll(calculateButton, saveButton, viewPlanetsButton);
        
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.getChildren().addAll(title, weightLabel, weightOnPlanetLabel, nameBox, massBox, radiusBox, 
                                     planetDisplay, optionsLabel, buttonRow1, buttonRow2, actionButtons);
        
        Scene scene = new Scene(layout, 900, 800);
        scene.setFill(Color.rgb(10, 10, 30));
        stage.setTitle("Create Planet");
        stage.setScene(scene);
        stage.show();
    }
    
    private void addWater() {
        hasWater = true;
        updatePlanet();
    }
    
    private void addTerrain() {
        hasTerrain = true;
        updatePlanet();
    }
    
    private void addTrees() {
        hasTrees = true;
        updatePlanet();
    }
    
    private void addRings() {
        updatePlanet();
    }
    
    private void updatePlanet() {
        planetDisplay.getChildren().clear();
        
        planetView = new ImageView(new Image("file:basePlanet.deploy.png"));
        planetView.setFitWidth(250);
        planetView.setFitHeight(250);
        planetDisplay.getChildren().add(planetView);
        
        if (hasWater) {
            ImageView water = new ImageView(new Image("file:river.deploy.png"));
            water.setFitWidth(250);
            water.setFitHeight(250);
            planetDisplay.getChildren().add(water);
        }
        
        if (hasTerrain) {
            ImageView terrain = new ImageView(new Image("file:mountains.deploy.png"));
            terrain.setFitWidth(250);
            terrain.setFitHeight(250);
            planetDisplay.getChildren().add(terrain);
        }
        
        if (hasTrees) {
            ImageView trees = new ImageView(new Image("file:trees.deploy.png"));
            trees.setFitWidth(250);
            trees.setFitHeight(250);
            planetDisplay.getChildren().add(trees);
        }
    }
    
    private void calculateWeight() {
        try {
            String name = planetNameField.getText();
            float mass = Float.parseFloat(massField.getText());
            float radius = Float.parseFloat(radiusField.getText());
            
            Planets tempPlanets = new Planet(name, mass, radius);
            float newWeight = tempPlanet.getNewUserWeight((float)userWeight);
            
            weightOnPlanetLabel.setText("Your weight on " + name + ": " + newWeight + " lbs");
            
        } catch (Exception e) {
            weightOnPlanetLabel.setText("Error: Fill in all fields correctly");
            weightOnPlanetLabel.setStyle("-fx-text-fill: #FF0000; -fx-font-size: 16px;");
        }
    }
    
    private void savePlanet(Stage stage) {
        try {
            String name = planetNameField.getText();
            float mass = Float.parseFloat(massField.getText());
            float radius = Float.parseFloat(radiusField.getText());
            
            Planets newPlanets = new Planet(name, mass, radius);
            newPlanet.setColor(planetColor);
            newPlanet.setWater(hasWater);
            newPlanet.setTerrain(hasTerrain);
            newPlanet.setTree(hasTrees);
            newPlanet.addToSolarSystem();
            
            System.out.println("Planets saved!");
            System.out.println("Name: " + newPlanet.getName());
            System.out.println("Color: " + newPlanet.getColor());
            System.out.println("Water: " + newPlanet.getWater());
            System.out.println("Terrain: " + newPlanet.getTerrain());
            System.out.println("Trees: " + newPlanet.getTree());
            
            stage.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void viewAllPlanets() {
        System.out.println("=== ALL PLANETS IN SOLAR SYSTEM ===");
        
        for (Planets p : Planet.getSolarSystem()) {
            System.out.println("Planet: " + p.getName());
            System.out.println("  Mass: " + p.planetMass);
            System.out.println("  Radius: " + p.planetRadius);
            System.out.println("  Gravity: " + p.planetGravity);
            System.out.println("  Water: " + p.getWater());
            System.out.println("  Terrain: " + p.getTerrain());
            System.out.println("  Trees: " + p.getTree());
            System.out.println("  Color: " + p.getColor());
            System.out.println("---");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}