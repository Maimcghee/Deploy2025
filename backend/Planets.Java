package backend;
import java.ArrayList;

public class Planets{
    //Instance variables 
    private Calculations calculator = new Calculations();
    String planetName;
    float planetMass;
    float planetGravity;

    //variables for user made planets
    String color;
    String water;
    String terrain;

    //Constructors 
    public Planets makePlanet(String name,float mass, float gravity){
        this.planetName = name;
        this.planetGravity = gravity;
        this.planetMass = mass;
    }

    //for custom make planets 
    public Planets makePlanet(String name,float mass, float gravity, String planetColor, String planetWater, String planetTerrain){
        this.planetName = name;
        this.planetGravity = gravity;
        this.planetMass = mass;
        this.color = planetColor;
        this.water = planetWater;
        this.terrain = planetTerrain;
    }


    

    
}