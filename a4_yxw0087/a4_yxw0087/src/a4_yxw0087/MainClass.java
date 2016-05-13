/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Assignment: 4
   *Due Date: 9/25/14
  *Description: Demonstrates the use of inheritance, abstract and interface
   *             in Java.   
*/ 
package a4_yxw0087;

public class MainClass {
    
    private Alien[] aliens = new Alien[3];

    public static void main(String[] args) {
        new MainClass();
    }
    
    /**
     * Constructor of MainClass.
     */
    public MainClass() {
        
        Bloboid b = new Bloboid();
        System.out.println("Testing default constructor and members of Bloboid.");
        System.out.println("Goo: " + b.goo);
        System.out.println("Tentacles: " + b.tentacles);
        System.out.println("Home: " + b.home);
        System.out.println("Food: " + b.food);
        System.out.println("Breath: " + b.breath);
        Animaloid a = new Animaloid();
        System.out.println("Testing default constructor and members of Animaloid.");
        System.out.println("Arms: " + a.arms);
        System.out.println("Legs: " + a.legs);
        System.out.println("Eyes: " + a.eyes);
        System.out.println("Heads: " + a.heads);
        System.out.println("Ears: " + a.ears);
        System.out.println("Home: " + a.home);
        System.out.println("Food: " + a.food);
        System.out.println("Breath: " + a.breath);
        Humanoid h = new Humanoid();
        System.out.println("Testing default constructor and members of Humanoid.");
        System.out.println("Arms: " + h.arms);
        System.out.println("Legs: " + h.legs);
        System.out.println("Eyes: " + h.eyes);
        System.out.println("Heads: " + h.heads);
        System.out.println("Ears: " + h.ears);
        System.out.println("Home: " + h.home);
        System.out.println("Food: " + h.food);
        System.out.println("Breath: " + h.breath);
        
        System.out.println("\nTesting parametrized constructors and methods.");
               
        aliens[0] = new Bloboid("red", 100, "swamp", "fish", "nitrogen");
        aliens[1] = new Animaloid(6, 6, 8, 3, 2, "forest", "birds", "hydrogen");
        aliens[2] = new Humanoid("mountains", "bears", "oxygen");
        
        for(int j=0; j<aliens.length; j++){
            System.out.println(aliens[j]);
            aliens[j].setLength(j+2);
            System.out.println("This alien has length of alien year equals to " + aliens[j].earthYear(50) + " earth years.");     
            System.out.println("It has " + aliens[j].getGraspers() + " graspers.");
        }    
    }  
}
