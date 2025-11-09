package backend;


public class Calculations {
    float wei_e ;           // weight on earth (user input)
    float gnu ;             // new gravity value (calculated)
    float r ;               // planet radius (user selected)
    float person_m ;        // person mass (calculated)
    float planet_m ;        // planet mass (user input)
    float wei_nu ;          // weight on new planet (calculated)
    


    public static void main(String[ ] args){
  // find weight -> float wei = multiply(gnu, person_m);
  // return ;
    }
    public static double mass_p(float wei_e){
    double person_m = wei_e*.45359237/9.80665 ;
    return person_m;

    }


   public static double gravity(float planet_m, float r){
             // person weight on earth-> float person_m = wei_e/9.81 ;
            // find g  float gnu = multiply(6.67, planet_m, 1/r, 1/r) ;
        double gnu = 6.67e-11*planet_m/(r*r) ;
        return gnu;
        
    }
    
  public static double new_weight(float person_m, double gnu){
    double wei_nu = person_m*gnu;
    return wei_nu ;
  }
}

//*  from user input/ 
