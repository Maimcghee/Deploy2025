package backend;
import java.util.ArrayList;
import Calculations;




public class Planets{
    //planet attributes
    
    String planetName;
    float planetMass;
    float userWeight;
    float planetRadius;
    float planetGravity;//planets gravitational pull

    //variables for user made planets
    String color;
    boolean water = false;
    boolean terrain = false;
    boolean tree = false;

    //Solar System Array List
    private static LinkedList<Planet> solarSystem = new LinkedList<>();
    

    // Basic Constructor
    public Planet(String name,float mass, float radius){
        this.planetName = name;
        this.planetRadius = radius;
        this.planetMass = mass;
        this.planetGravity = Calculations.gravity(mass, radius);//rams gravity calculator 

    }

    //for custom make planets 
    public void setColor(String planetColor){
        this.color = planetColor; 
    }
    public String getColor(){
        return this.color;
    }

    //setting Water Bool
    public void setWater(boolean containsWater){
        if(containsWater == true){
            water = true;
        }
    }

    public boolean getWater(){
        return this.water;
    }

    //setting Terrain Bool
    public void setTerrain(boolean containsTerrain){
        if(containsTerrain == true){
            terrain = true;
        }
    }

    public boolean getTerrain(){
        return this.terrain;
    }

    //setting Tree Bool
    public void setTree(boolean containsTree){
        if(containsTree == true){
            tree = true;
        }
    }

    public boolean getTree(){
        return this.tree;
    }

    //getting planet Name
    public void getName(){
        return this.name;
    }

    //adding Planet to Solar System
    public void addToSolarSystem(){
        solarSystem.add(this);
    }

    //method to delete planet -> remove from solar system
    public static boolean deletePlanet(String planetName){
        for(Planet p: solarSystem){
            if(p.getName().equals(planetName)){
                solarSystem.remove(p);
                return true;
            }
        }
        return false;
    }

    public static LinkedList<Planet> getSolarSystem(){
        return solarSystem;
    }
    

    
}