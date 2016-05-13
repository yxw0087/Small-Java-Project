/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Assignment: 4
   *Due Date: 9/25/14
  *Description: A child class of class Animaloid.
*/ 

package a4_yxw0087;

public class Humanoid extends Animaloid{
    
    /**
     * Default constructor of Humanoid class.
     */
    public Humanoid(){
        super();     
        arms = 2;
        legs = 2;
        eyes = 2;
        heads = 1;
        ears = 2;
    }
    
    /**
     * Parametrized constructor of Humanoid class.
     * @param home A name for the home of this alien.
     * @param food A name for the food of this alien.
     * @param breath A name for the breath of this alien.
     */
    public Humanoid(String home, String food, String breath){
        super(2, 2, 2, 1, 2, home, food, breath);        
    }
    
    /**
     * Returns the Earth year equivalence of the Alien year.
     * @param alienYear Integer year of the aliens.
     * @return alienYear multiplied by fraction.
     */
    public double earthYear(int alienYear){        
        return alienYear*fraction;
    }    
    
    /**
     * Counts the amount of graspers this alien has.
     * @return amount of arms and legs.
     */
    public int GrasperCount(){
        return 4;
    } 
    
    /**
     * To access GrasperCount() method.
     * @return amount of graspers return from GrasperCount().
     */
    public int getGraspers(){
        return GrasperCount();
    }
    
    /**
     * Overrode method toString().
     * @return String summary of the features of this alien.
     */
    public String toString() {
        return String.format("\nThis is a Humanoid alien with " + arms + " arms, " + legs + " legs, "+ eyes + " eyes, " + heads + " heads, and " + ears + " ears. It lives in " + home + ", eats " + food + " and breathes " + breath + "." );
    }
}
