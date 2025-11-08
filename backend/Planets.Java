package backend;
import java.util.ArrayList;

public class Planets{
    //planet attributes
    private Calculations calculator = new Calculations();
    String planetName;
    float planetMass;
    float planetGravity;

    //variables for user made planets
    String color;
    boolean water = false;
    boolean terrain = false;
    boolean tree = false;
    

    //Constructors 
    public makePlanet(String name,float mass, float gravity){
        this.planetName = name;
        this.planetGravity = gravity;
        this.planetMass = mass;
        this.planetGravity
    }

    //for custom make planets 
    public void setColor(String planetColor){
        this.color = planetColor; 
    }

    //setting Water Bool
    public void hasWater(boolean containsWater){
        if(containsWater == true){
            water = true;
        }
    }

    //setting Terrain Bool
    public void hasTerrain(boolean containsTerrain){
        if(containsTerrain == true){
            terrain = true;
        }
    }

    //setting Tree Bool
    public void hasTree(boolean containsTree){
        if(containsTree == true){
            tree = true;
        }
    }
    

    
}