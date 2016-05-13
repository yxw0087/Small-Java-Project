/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Assignment: 2
   *Due Date: 9/16/14
  *Description: These codes simulates Galton Box.
 */
package a2_yxw0087;
import java.util.Random;
public class GaltonBox {
    private int[] bin;  //Creates an array of Galton Box bins
    private final int maxSize = 20;  //Maximum number of Galton Box bins
    
    /**
     * Default constructor of GaltonBox.
     * Creates a Galton Box of 10 bins
     */
    public GaltonBox() {
        bin = new int[10];        
    }
    
    /**
     * Parametrized constructor of GaltonBox.
     * @param size number of bins specified
     */
    public GaltonBox(int size) {
        if(size <= maxSize)
            bin = new int[size];
        else
            bin = new int[maxSize];
    }
    
    /**
     * Returns the path of the ball.
     * @return R if ball falls right of the pin, L if falls to the left
     */
    public char ballPath(){
        Random r = new Random();
        if(r.nextBoolean())                    
            return 'R';        
        else
            return 'L';
    }
    
    /**
     * Outputs the final total of balls in each bin of Galton Box.
     */
    public void binsCount(){
        for(int i=0; i<bin.length; i++)
            System.out.println("Bin " + (i+1) + " has " + bin[i] + " balls.");
    }
    
    /**
     * To put a ball in the corresponding bin
     * @param index Index of the bin in the array
     */
    public void putBall(int index){
        bin[index]++;
    }
}
