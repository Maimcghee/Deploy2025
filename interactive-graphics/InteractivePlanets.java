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
import javafx.scene.layout.*;

// Import created class 
import backend.Planets;

public class InteractivePlanets extends Application {
    
    private double userWeight;
    private StackPane planetDisplay;
    private ImageView planetBase;
    private ImageView terrainLayer;
    private ImageView treesLayer;
    private ImageView waterLayer;
    
    private boolean hasPlanet = false;
    private boolean hasTerrain = false;
    private boolean hasTrees = false;
    private boolean hasWater = false;

    
    private String planetColor = "pink"; // Default color if none is selcted 
    private String selectedBasePlanet = ""; // Default empty so hardcoded image can be set when buttons are selected
    
    private TextField planetNameField;
    private TextField massField;
    private TextField radiusField;
    
    private Label weightOnPlanetLabel;
    private Label instructionLabel;
    
    private StackPane terrainButton;
    private StackPane treesButton;
    private StackPane waterButton;
    
    public InteractivePlanets(double userWeight) {
        this.userWeight = userWeight;
    }
    
    public void start(Stage stage) {
        
        Image bg = new Image("file:star_bg.png");
        BackgroundImage bgImg = new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, 
            new BackgroundSize(100, 100, true, true, false, true));
        
        Label title = new Label("CREATE YOUR PLANET");
        title.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #00FFFF; " +
                      "-fx-effect: dropshadow(gaussian, #0088FF, 15, 0.7, 0, 0);");
        
        Label weightLabel = new Label("Your Earth weight: " + userWeight + " lbs");
        weightLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 16px;");
        
        weightOnPlanetLabel = new Label("");
        weightOnPlanetLabel.setStyle("-fx-text-fill: #00FF00; -fx-font-size: 14px; -fx-font-weight: bold;");
        
        instructionLabel = new Label("Select a base planet to start →");
        instructionLabel.setStyle("-fx-text-fill: #FFD700; -fx-font-size: 14px; -fx-font-style: italic;");
        
        // Input fields - CENTERED
        VBox inputSection = new VBox(10);
        inputSection.setAlignment(Pos.CENTER);
        
        planetNameField = new TextField();
        planetNameField.setPromptText("Planet Name");
        planetNameField.setMaxWidth(250);
        planetNameField.setStyle("-fx-background-color: rgba(20, 20, 60, 0.8); -fx-text-fill: #FFFFFF; " +
                                "-fx-font-size: 14px; -fx-border-color: #00FFFF; -fx-border-width: 2px; " +
                                "-fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 10px;");
        
        massField = new TextField();
        massField.setPromptText("Mass (kg) - e.g., 5.97e24");
        massField.setMaxWidth(250);
        massField.setStyle("-fx-background-color: rgba(20, 20, 60, 0.8); -fx-text-fill: #FFFFFF; " +
                          "-fx-font-size: 14px; -fx-border-color: #00FFFF; -fx-border-width: 2px; " +
                          "-fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 10px;");
        
        radiusField = new TextField();
        radiusField.setPromptText("Radius (m) - e.g., 6371000");
        radiusField.setMaxWidth(250);
        radiusField.setStyle("-fx-background-color: rgba(20, 20, 60, 0.8); -fx-text-fill: #FFFFFF; " +
                            "-fx-font-size: 14px; -fx-border-color: #00FFFF; -fx-border-width: 2px; " +
                            "-fx-border-radius: 10px; -fx-background-radius: 10px; -fx-padding: 10px;");
        
        inputSection.getChildren().addAll(planetNameField, massField, radiusField);
        
        // Planet display
        planetDisplay = new StackPane();
        planetDisplay.setStyle("-fx-background-color: transparent;");
        planetDisplay.setPrefSize(400, 400);
        
        Label emptyLabel = new Label("No planet selected");
        emptyLabel.setStyle("-fx-text-fill: rgba(255, 255, 255, 0.3); -fx-font-size: 18px;");
        planetDisplay.getChildren().add(emptyLabel);
        
        // Center section - title, weight, instruction, inputs, planet
        VBox centerSection = new VBox(20);
        centerSection.setAlignment(Pos.CENTER);
        centerSection.getChildren().addAll(title, weightLabel, weightOnPlanetLabel, instructionLabel, 
                                            inputSection, planetDisplay);
        
        // Action buttons - LEFT SIDE positioned lower
        Region topSpacer = new Region();
        VBox.setVgrow(topSpacer, Priority.ALWAYS);
        
        Button calculateButton = new Button("⚖️ Calculate Weight");
        calculateButton.setStyle("-fx-background-color: rgba(255, 107, 107, 0.3); -fx-text-fill: white; " +
                                "-fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-color: #00FFFF; " +
                                "-fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        calculateButton.setOnAction(e -> calculateWeight());
        
        Button saveButton = new Button("💾 Save Planet");
        saveButton.setStyle("-fx-background-color: linear-gradient(to bottom, #6B46C1, #2D1B69); " +
                           "-fx-text-fill: #FFFFFF; -fx-font-size: 16px; -fx-font-weight: bold; " +
                           "-fx-padding: 12px 30px; -fx-border-color: #00FFFF; -fx-border-width: 2px; " +
                           "-fx-border-radius: 15px; -fx-background-radius: 15px;");
        saveButton.setOnAction(e -> savePlanet(stage));
        
        Button viewPlanetsButton = new Button("🌍 View All");
        viewPlanetsButton.setStyle("-fx-background-color: rgba(78, 205, 196, 0.3); -fx-text-fill: white; " +
                                  "-fx-font-size: 14px; -fx-padding: 10px 20px; -fx-border-color: #00FFFF; " +
                                  "-fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        viewPlanetsButton.setOnAction(e -> viewAllPlanets());
        
        Region bottomSpacer = new Region();
        VBox.setVgrow(bottomSpacer, Priority.ALWAYS);
        
        VBox leftButtons = new VBox(25);
        leftButtons.setAlignment(Pos.CENTER);
        leftButtons.setPadding(new Insets(0, 20, 0, 20));
        leftButtons.getChildren().addAll(topSpacer, calculateButton, saveButton, viewPlanetsButton, bottomSpacer);
        
        // Right side - feature buttons in rows instead of columns
        Label basePlanetLabel = new Label("Base Planets");
        basePlanetLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 16px; -fx-font-weight: bold;");
        
        StackPane bluePlanetButton = createImageButton("file:basePlanet.deploy.png", 60);
        bluePlanetButton.setOnMouseClicked(e -> selectBasePlanet("file:basePlanet.deploy.png", "blue"));
        
        StackPane orangePlanetButton = createImageButton("file:basePlanet_or.deploy.png", 60);
        orangePlanetButton.setOnMouseClicked(e -> selectBasePlanet("file:basePlanet_or.deploy.png", "orange"));
        
        StackPane blackPlanetButton = createImageButton("file:basePlanet_bl.deploy.png", 60);
        blackPlanetButton.setOnMouseClicked(e -> selectBasePlanet("file:basePlanet_bl.deploy.png", "black"));
        
        HBox basePlanetsRow = new HBox(10);
        basePlanetsRow.setAlignment(Pos.CENTER);
        basePlanetsRow.getChildren().addAll(bluePlanetButton, orangePlanetButton, blackPlanetButton);
        
        VBox basePlanetsBox = new VBox(10);
        basePlanetsBox.setAlignment(Pos.CENTER);
        basePlanetsBox.getChildren().addAll(basePlanetLabel, basePlanetsRow);
        
        Label featuresLabel = new Label("Add Features");
        featuresLabel.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 16px; -fx-font-weight: bold;");
        
        waterButton = createImageButton("file:river.deploy.png", 60);
        waterButton.setOnMouseClicked(e -> toggleWater());
        
        terrainButton = createImageButton("file:mountains.deploy.png", 60);
        terrainButton.setOnMouseClicked(e -> toggleTerrain());
        
        treesButton = createImageButton("file:trees.deploy.png", 60);
        treesButton.setOnMouseClicked(e -> toggleTrees());
        
        StackPane ringsButton = createImageButton("file:rings.deploy.png", 60);
        
        HBox featuresRow1 = new HBox(10);
        featuresRow1.setAlignment(Pos.CENTER);
        featuresRow1.getChildren().addAll(waterButton, terrainButton);
        
        HBox featuresRow2 = new HBox(10);
        featuresRow2.setAlignment(Pos.CENTER);
        featuresRow2.getChildren().addAll(treesButton, ringsButton);
        
        VBox featuresBox = new VBox(10);
        featuresBox.setAlignment(Pos.CENTER);
        featuresBox.getChildren().addAll(featuresLabel, featuresRow1, featuresRow2);
        
        VBox rightSide = new VBox(30);
        rightSide.setAlignment(Pos.CENTER);
        rightSide.setPadding(new Insets(20));
        rightSide.setStyle("-fx-background-color: rgba(10, 10, 40, 0.5); " +
                           "-fx-border-color: #00FFFF; -fx-border-width: 2px; " +
                           "-fx-border-radius: 15px; -fx-background-radius: 15px;");
        rightSide.getChildren().addAll(basePlanetsBox, featuresBox);
        
        // Three columns with set spacing
        HBox mainLayout = new HBox(60);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20, 50, 20, 50));
        mainLayout.getChildren().addAll(leftButtons, centerSection, rightSide);
        
        StackPane root = new StackPane(mainLayout);
        root.setBackground(new Background(bgImg));
        
        Scene scene = new Scene(root, 1300, 750);
        stage.setTitle("Create Planet");
        stage.setScene(scene);
        stage.show();
    }
    
    // When user selects one of three "base planet" options
    private void selectBasePlanet(String imagePath, String color) {
        hasPlanet = true;
        selectedBasePlanet = imagePath;
        planetColor = color;
        instructionLabel.setText("");
        
        planetDisplay.getChildren().clear();
        
        planetBase = new ImageView(new Image(imagePath));
        planetBase.setFitWidth(380);
        planetBase.setFitHeight(380);
        planetBase.setPreserveRatio(true);
        
        // Adds other features for the user to select
        waterLayer = new ImageView(new Image("file:river.deploy.png"));
        waterLayer.setFitWidth(380);
        waterLayer.setFitHeight(380);
        waterLayer.setPreserveRatio(true);
        waterLayer.setVisible(false);
        
        terrainLayer = new ImageView(new Image("file:mountains.deploy.png"));
        terrainLayer.setFitWidth(380);
        terrainLayer.setFitHeight(380);
        terrainLayer.setPreserveRatio(true);
        terrainLayer.setVisible(false);
        
        treesLayer = new ImageView(new Image("file:trees.deploy.png"));
        treesLayer.setFitWidth(380);
        treesLayer.setFitHeight(380);
        treesLayer.setPreserveRatio(true);
        treesLayer.setVisible(false);
        
        planetDisplay.getChildren().addAll(planetBase, waterLayer, terrainLayer, treesLayer);
    }
    

    // Createimage button allows users selection to be displayed 
    private StackPane createImageButton(String imagePath, double size) {
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        imageView.setPreserveRatio(true);
        
        StackPane button = new StackPane(imageView);
        button.setPrefSize(size + 20, size + 20);
        button.setStyle("-fx-background-color: rgba(20, 20, 60, 0.3); -fx-border-color: #00FFFF; " +
                       "-fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-radius: 10px; " +
                       "-fx-cursor: hand;");
        
        
        button.setOnMouseEntered(e -> {
            button.setStyle("-fx-background-color: rgba(20, 20, 60, 0.5); -fx-border-color: #00FFFF; " +
                           "-fx-border-width: 3px; -fx-border-radius: 10px; -fx-background-radius: 10px; " +
                           "-fx-cursor: hand; -fx-effect: dropshadow(gaussian, #00FFFF, 15, 0.7, 0, 0);");
        });
        
        button.setOnMouseExited(e -> {
            if (button != terrainButton || !hasTerrain) {
                if (button != treesButton || !hasTrees) {
                    if (button != waterButton || !hasWater) {
                        button.setStyle("-fx-background-color: rgba(20, 20, 60, 0.3); -fx-border-color: #00FFFF; " +
                                       "-fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-radius: 10px; " +
                                       "-fx-cursor: hand;");
                    }
                }
            }
        });
        
        return button;
    }
    
    private void toggleWater() {
        if (!hasPlanet) return;
        hasWater = !hasWater;
        waterLayer.setVisible(hasWater);
        
        if (hasWater) {
            waterButton.setStyle("-fx-background-color: rgba(74, 144, 226, 0.8); -fx-border-color: #00FFFF; " +
                                "-fx-border-width: 3px; -fx-border-radius: 10px; -fx-background-radius: 10px; " +
                                "-fx-cursor: hand; -fx-effect: dropshadow(gaussian, #4A90E2, 20, 0.9, 0, 0);");
        } else {
            waterButton.setStyle("-fx-background-color: rgba(20, 20, 60, 0.3); -fx-border-color: #00FFFF; " +
                                "-fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-radius: 10px; " +
                                "-fx-cursor: hand;");
        }
    }
    
    private void toggleTerrain() {
        if (!hasPlanet) return;
        hasTerrain = !hasTerrain;
        terrainLayer.setVisible(hasTerrain);
        
        if (hasTerrain) {
            terrainButton.setStyle("-fx-background-color: rgba(139, 69, 19, 0.8); -fx-border-color: #00FFFF; " +
                                  "-fx-border-width: 3px; -fx-border-radius: 10px; -fx-background-radius: 10px; " +
                                  "-fx-cursor: hand; -fx-effect: dropshadow(gaussian, #8B4513, 20, 0.9, 0, 0);");
        } else {
            terrainButton.setStyle("-fx-background-color: rgba(20, 20, 60, 0.3); -fx-border-color: #00FFFF; " +
                                  "-fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-radius: 10px; " +
                                  "-fx-cursor: hand;");
        }
    }
    
    private void toggleTrees() {
        if (!hasPlanet) return;
        hasTrees = !hasTrees;
        treesLayer.setVisible(hasTrees);
        
        if (hasTrees) {
            treesButton.setStyle("-fx-background-color: rgba(34, 139, 34, 0.8); -fx-border-color: #00FFFF; " +
                                "-fx-border-width: 3px; -fx-border-radius: 10px; -fx-background-radius: 10px; " +
                                "-fx-cursor: hand; -fx-effect: dropshadow(gaussian, #228B22, 20, 0.9, 0, 0);");
        } else {
            treesButton.setStyle("-fx-background-color: rgba(20, 20, 60, 0.3); -fx-border-color: #00FFFF; " +
                                "-fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-radius: 10px; " +
                                "-fx-cursor: hand;");
        }
    }
    
    private void calculateWeight() {
        try {
            String name = planetNameField.getText();
            float mass = Float.parseFloat(massField.getText());
            float radius = Float.parseFloat(radiusField.getText());
            
            Planets tempPlanets = new Planets(name, mass, radius);
            float newWeight = tempPlanets.getNewUserWeight((float)userWeight);
            
            weightOnPlanetLabel.setText("Your weight on " + name + ": " + String.format("%.2f", newWeight) + " lbs");
            weightOnPlanetLabel.setStyle("-fx-text-fill: #00FF00; -fx-font-size: 14px; -fx-font-weight: bold;");
            
        } catch (Exception e) {
            weightOnPlanetLabel.setText("Error: Must enter value");
            weightOnPlanetLabel.setStyle("-fx-text-fill: #FF0000; -fx-font-size: 14px;");
        }
    }
    
    private void savePlanet(Stage stage) {
        try {
            String name = planetNameField.getText();
            float mass = Float.parseFloat(massField.getText());
            float radius = Float.parseFloat(radiusField.getText());
            
            Planets newPlanets = new Planets(name, mass, radius);
            newPlanets.setColor(planetColor);
            newPlanets.setWater(hasWater);
            newPlanets.setTerrain(hasTerrain);
            newPlanets.setTree(hasTrees);
            newPlanets.addToSolarSystem();
            
            System.out.println("Planet saved!");
            System.out.println("Name: " + newPlanets.getName());
            System.out.println("Color: " + planetColor);
            System.out.println("Water: " + newPlanets.getWater());
            System.out.println("Terrain: " + newPlanets.getTerrain());
            System.out.println("Trees: " + newPlanets.getTree());
            

            // Close this window and return to home page when "saved planet" button is clicked
            stage.close();
            HomeScreen homeScreen = new HomeScreen();
            Stage homeStage = new Stage();
            homeScreen.start(homeStage);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void viewAllPlanets() {
        System.out.println("ALL PLANETS")
        
        for (Planets p : Planets.getSolarSystem()) {
            System.out.println("Planet: " + p.getName());
            System.out.println("  Mass: " + p.planetMass);
            System.out.println("  Radius: " + p.planetRadius);
            System.out.println("  Gravity: " + p.planetGravity);
            System.out.println("  Water: " + p.getWater());
            System.out.println("  Terrain: " + p.getTerrain());
            System.out.println("  Trees: " + p.getTree());
            System.out.println("---");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}