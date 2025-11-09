package backend;
import java.util.ArrayList;
import java.util.LinkedList;// import Calculations;




public class Planets{
    //planet attributes
    
    public String planetName;
    public float planetMass;
    float userWeight;
    public float planetRadius;
    public float planetGravity;//planets gravitational pull

    //variables for user made planets
    String color;
    boolean water = false;
    boolean terrain = false;
    boolean tree = false;

    //Solar System Array List
    private static LinkedList<Planets> solarSystem = new LinkedList<>();
    

    // Basic Constructor
    public Planets(String name,float mass, float radius){
        this.planetName = name;
        this.planetRadius = radius;
        this.planetMass = mass;
        this.planetGravity = (float)Calculations.gravity(mass, radius);//rams gravity calculator 

    }

    //getter Method to return useres weight on new planet
    public float getNewUserWeight(float userEarthWeight){
        userWeight = (float)Calculations.new_weight((float)Calculations.mass_p(userEarthWeight), this.planetGravity);
        return userWeight;
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
    public String getName(){
        return this.planetName;
    }

    //adding Planet to Solar System
    public void addToSolarSystem(){
        solarSystem.add(this);
    }

    //method to delete planet -> remove from solar system
    public static boolean deletePlanet(String planetName){
        for(Planets p: solarSystem){
            if(p.getName().equals(planetName)){
                solarSystem.remove(p);
                return true;
            }
        }
        return false;
    }

    public static LinkedList<Planets> getSolarSystem(){
        return solarSystem;
    }
    

    
}