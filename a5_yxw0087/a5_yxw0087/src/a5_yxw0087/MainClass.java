/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Assignment: 5
   *Due Date: 10/2/14
  *Description: To read a file containing state and capital names from a URL,
   *             map state to capital in one tree map object and map capital to
   *             state in another tree map object.
 */

package a5_yxw0087;

import java.util.*;
import java.net.*;

public class MainClass {

    public static void main(String[] args) {
        new MainClass();
    }

    /**
     * Constructor of MainClass
     */
    public MainClass() {
        String State, Capital;        
        int input;
        int count_state = 0;
        int count_capital = 0;
        TreeMap tm1 = new TreeMap();
        TreeMap tm2 = new TreeMap();
        try {
            URL url = new URL("http://fidelio.cacs.louisiana.edu/360/statecapitals.txt");
            Scanner scanner = new Scanner(url.openStream());
            Scanner reader = new Scanner(System.in);
             while (scanner.hasNext())
             {
             State = scanner.next();
             Capital = scanner.next();
             tm1.put(State,Capital);
             tm2.put(Capital,State);
             }
            
            do {
                System.out.print("To spell the state, enter 1. \n\nTo spell the capital, enter 2. \n\nTo exit, enter 0: ");
                input = reader.nextInt();
                System.out.println();
                if (input == 1) {
                    System.out.print("Spell the State:");
                    State = reader.next();
                    System.out.println("Capital of " + State + " is " + tm1.get(State) + ".");
                    count_state++;
                } else if (input == 2) {
                    System.out.print("Spell the Capital:");
                    Capital = reader.next();
                    System.out.println(Capital + " is in " + tm2.get(Capital) + ".");
                    count_capital++;
                } else {
                    System.out.println("Correctly spelled State names: " + count_state);
                    System.out.println("Correctly spelled Capital names: " + count_capital);                    
                }
                System.out.println();
            } while (input != 0);

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
}
