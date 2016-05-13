/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Assignment: 2
   *Due Date: 9/16/14
  *Description: These codes demonstrate the use of Galton Boxes with different
   *             numbers of bins and balls. 
*/ 

package a2_yxw0087;
import java.util.Scanner;
import java.util.Random;

public class MainClass {
    private GaltonBox[] box = new GaltonBox[5]; 

    public static void main(String[] args) {
        new MainClass();
    }
    
    /**
     * Constructor of MainClass
     */
    public MainClass(){          
        for(int i=0; i<5; i++)
        {
            box[i] = new GaltonBox(6+i);
            
            Random randomBalls = new Random();
            int balls = randomBalls.nextInt(81) + 20;  //Generates [20, 100] balls
            
            System.out.println("Test for Galton Box with " + (i+6) + " bins and " + balls + " balls:");
            
            for(int j=0; j<balls; j++)  //Loop for dropping the generated balls
            {
                System.out.print("Path of ball " + (j+1) + " in box " + (i+1) + " :");
                
                int count = 0;
                
                for(int k=0; k<(i+5); k++)  //Loop for the ball to reach bottom of the box
                {                    
                    if(box[i].ballPath() == 'R')
                    {
                        System.out.print("R");
                        count++; 
                    }
                    else
                        System.out.print("L");                                ;
                }   
                System.out.println();                
                box[i].putBall(count);
            }
            System.out.println("Total number of balls in each bin at the end:");
            box[i].binsCount();
            System.out.println();
        }         
    }
}
