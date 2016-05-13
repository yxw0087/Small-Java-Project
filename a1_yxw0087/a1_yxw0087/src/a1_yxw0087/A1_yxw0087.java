/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Assignment: 1
   *Due Date: 9/14/14
  *Description: These codes are used to explore string class and math class in
   *             Java, as well as to practice using JOptionPane class and Scanner
   *             class.
 */

package a1_yxw0087;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class A1_yxw0087 {

    public static void main(String[] args) {
        A1_yxw0087 a1 = new A1_yxw0087();     
    }
    
    /**
     * Constructor of the main class.
     */
    public A1_yxw0087(){
        Scanner sc = new Scanner(System.in);   
        
        String double1 = JOptionPane.showInputDialog("Enter a double(type) number: ");
        String double2 = JOptionPane.showInputDialog("Enter a double(type) number: ");
        double d1 = Double.parseDouble(double1);
        double d2 = Double.parseDouble(double2);
    
        JOptionPane.showMessageDialog(null, "The result of " + d1 + " raised to the power of " + d2 + " is: " + powerOf(d1, d2));
        JOptionPane.showMessageDialog(null, "A random number in the range of [50, 100]: " + random());
        
        System.out.print("Enter a long string: ");
        String longS = sc.nextLine();
        System.out.print("Enter a short string: ");
        String shortS = sc.nextLine();
        System.out.print("Enter a character: ");
        char c = sc.next().charAt(0);        
        
        System.out.println("Length of the long string is: " + longLength(longS));
        
        if(isPalindrome(longS))
            System.out.println("This long string is a palindrome.");
        else
            System.out.println("This long string is not a palindrome.");
        
        System.out.println("Number of time '" + c + "' appears in \"" + longS + "\" is: " + charMatching(longS, c));
        
        if(suffixOf(longS, shortS))
            System.out.println("The short string is a suffix of the long string.");
        else
            System.out.println("The short string is not a suffix of the long string.");
        
        System.exit(0);        
    }
    
    /**
     * Returns the length of long string input by user.
     * s must be a valid string.
     * @param s A long string input by user.
     * @return The length of string s.
     */
    public int longLength(String s){        
        return s.length();
    }
    
    /**
     * Checks if the long string input by user is a palindrome.
     * s must be a valid string.
     * @param s A long string input by user.
     * @return True if s is a palindrome, false otherwise.
     */
    public boolean isPalindrome(String s){
        int n = s.length();
        for (int i=0; i<(n/2)+1; i++){
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;            
        }
        return true;
    }
    
    /**
     * Counts the number of occurrence of char c in long String s.
     * s must be a valid string and c must be char.
     * @param s A long string input by user.
     * @param c A char character input by user.
     * @return Number of occurrence of c in s.
     */
    public int charMatching(String s, char c){
        int count = 0;
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) == c)
                count++;
        }
        return count;
    }
    
    /**
     * Checks if the short string is a suffix of the long string.
     * @param longS A long string input by user.
     * @param shortS A short string input by user.
     * @return True if shortS is a suffix of longS, false otherwise.
     */
    public boolean suffixOf(String longS, String shortS){
        return longS.endsWith(shortS);
    }
    
    /**
     * Returns the value of d1 raised to the power of d2 rounded to integer.
     * @param d1 The first double.
     * @param d2 The second double.
     * @return Value of d1 raised to power of d2 in integer form.
     */
    public int powerOf(double d1, double d2){
        return (int)Math.round(Math.pow(d1, d2));
    }
    
    /**
     * Returns a random number in the range of [50, 100].
     * @return num, a random integer in the range of [50, 100].
     */
    public int random(){
        int num; 
        do{
            num = (int)(Math.random()*100);
        }while(num<50);
        return num;
    }
    
}
