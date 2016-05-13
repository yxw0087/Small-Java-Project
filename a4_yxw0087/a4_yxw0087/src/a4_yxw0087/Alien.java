/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Assignment: 4
   *Due Date: 9/25/14
  *Description: An abstract parent class to be inherited.
*/ 

package a4_yxw0087;

public abstract class Alien {
    
    public String home, food, breath;
    public double fraction;
    /**
     * Default constructor of Alien class.
     */
    public Alien(){
        home = "something";
        food = "something";
        breath = "something";
    }
    
    /**
     * Parametrized constructor of Alien Class.
     * @param home A name for the home of this alien.
     * @param food A name for the food of this alien.
     * @param breath A name for the breath of this alien.
     */
    public Alien(String home, String food, String breath){
        this.home = home;
        this.food = food;
        this.breath = breath;
    }
    
    /**
     * Set the length of Alien year in fraction of 1 Earth year.
     * @param fraction Fraction of Alien year in terms of Earth year.
     */
    public void setLength(int fraction){
        this.fraction = 1.0/fraction;
    }
    
    /*
    Abstract method to be inherited.
    */
    public abstract int getGraspers();     

    /*
    Abstract method to be inherited.
    */
    public abstract double earthYear(int alienYear);   
    
}
