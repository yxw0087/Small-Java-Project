/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Assignment: 4
   *Due Date: 9/25/14
  *Description: A child class of class Alien. Also implements interface Status.
*/ 

package a4_yxw0087;

public class Bloboid extends Alien implements Status {
    
    public String goo;
    public int tentacles;
    
    /**
     * Default constructor of Bloboid class.
     */
    public Bloboid(){
        super();
        goo = "some type";
        tentacles = 0;
    }
    
    /**
     * Parametrized constructor of Bloboid class.
     * @param goo A type of goo for this alien.
     * @param tentacles Number of tentacles of this alien.
     *                   Can be 0 or more.
     * @param home A name for the home of this alien.
     * @param food A name for the food of this alien.
     * @param breath A name for the breath of this alien.
     */
    public Bloboid(String goo, int tentacles, String home, String food, String breath){
        super(home, food, breath);
        this.goo = goo;
        this.tentacles = tentacles;
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
     * @return amount of tentacles.
     */
    public int GrasperCount(){
        return tentacles;
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
        return String.format("\nThis is a Bloboid alien with " + goo + " goo and " + tentacles + " tentacles. It lives in " + home + ", eats " + food + " and breathes " + breath + "." );
    }
}
