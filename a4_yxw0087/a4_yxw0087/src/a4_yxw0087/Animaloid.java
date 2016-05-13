/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Assignment: 4
   *Due Date: 9/25/14
  *Description: A child class of class Alien. Also implements interface Status.
*/ 

package a4_yxw0087;

public class Animaloid extends Alien implements Status{
    
    public int arms, legs, eyes, heads, ears;
    
    /**
     * Default constructor of Animaloid class.
     */
    public Animaloid(){
        super();
        arms = 0;
        legs = 0;
        eyes = 1;
        heads = 1;
        ears = 1;
    }
    
    /**
     * Parametrized constructor of Animaloid class.
     * @param arms number of arms of this alien.
     *              Can be 0 or more.
     * @param legs number of legs of this alien.
     *              Can be 0 or more.
     * @param eyes number of eyes of this alien.
     *              Must be 1 or more.
     * @param heads number of heads of this alien.
     *              Must be 1 or more.
     * @param ears number of ears of this alien.
     *              Must be 1 or more.
     * @param home A name for the home of this alien.
     * @param food A name for the food of this alien.
     * @param breath A name for the breath of this alien.
     */
    public Animaloid(int arms, int legs, int eyes, int heads, int ears, String home, String food, String breath){
        super(home, food, breath);
        this.arms = arms;
        this.legs = legs;
        this.eyes = eyes;
        this.heads = heads;
        this.ears = ears;
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
        return arms+legs;
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
        return String.format("\nThis is an Animaloid alien with " + arms + " arms, " + legs + " legs, "+ eyes + " eyes, " + heads + " heads, and " + ears + " ears. It lives in " + home + ", eats " + food + " and breathes " + breath + "." );
    }
    
}
