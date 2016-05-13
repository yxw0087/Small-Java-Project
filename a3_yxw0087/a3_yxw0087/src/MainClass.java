/**
 * Author: Yee H. Wong   
 *CLID: yxw0087   
 *Class: CMPS 360   
 *Assignment: 3
 * Due Date: 9/23/14   
 *Description: Read text from a URL and copy the content to a local file, and 
 *             then output specific information to user.
 */

import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.text.DecimalFormat;
public class MainClass {

    public static void main(String[] args) {
        new MainClass();
    }
    
    /**
     * Constructor of MainClass
     */
    public MainClass() {
        String position;
        double salary, assistSalary, assoSalary, fullSalary, maxAssist, minAssist, maxAsso, minAsso, maxFull, minFull;
        int numAssist, numAsso, numFull;
        numAssist = numAsso = numFull = 0;
        assistSalary = assoSalary = fullSalary = maxAssist = maxAsso = maxFull = 0;
        minAssist = minAsso = minFull = 1000000.0;
        
        try {
            URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
            Scanner scanner = new Scanner(url.openStream());
            PrintWriter writer = new PrintWriter("mycopy.txt");

            while (scanner.hasNext()) {
                writer.print(scanner.next() + " ");
                writer.print(scanner.next() + " ");
                position = scanner.next();
                if (position.equalsIgnoreCase("assistant")) {
                    numAssist++;
                    writer.print(position + " ");
                    salary = scanner.nextDouble();
                    assistSalary += salary;
                    if(salary >= maxAssist)
                        maxAssist = salary;
                    else if(salary < minAssist)
                        minAssist = salary;
                    writer.println(salary);
                } else if (position.equalsIgnoreCase("associate")) {
                    numAsso++;
                    writer.print(position + " ");
                    salary = scanner.nextDouble();
                    assoSalary += salary;
                    if(salary >= maxAsso)
                        maxAsso = salary;
                    else if(salary < minAsso)
                        minAsso = salary;
                    writer.println(salary);
                } else {
                    numFull++;
                    writer.print(position + " ");
                    salary = scanner.nextDouble();
                    fullSalary += salary;
                    if(salary >= maxFull)
                        maxFull = salary;
                    else if(salary < minFull)
                        minFull = salary;
                    writer.println(salary);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error writing/reading file.");
        }
        
        System.out.println("Number of assistant professors: " + numAssist);
        System.out.println("The average, high, and low salaries of assistant professors: " + new DecimalFormat("0.00").format(assistSalary/numAssist) + ", " + maxAssist + " and " + minAssist);
        System.out.println("Number of associate professors: " + numAsso);
        System.out.println("The average, high, and low salaries of associate professors: " + new DecimalFormat("0.00").format(assoSalary/numAsso) + ", " + maxAsso + " and " + minAsso);
        System.out.println("Number of full professors: " + numFull);
        System.out.println("The average, high, and low salaries of full professors: " + new DecimalFormat("0.00").format(fullSalary/numFull) + ", " + maxFull + " and " + minFull);      
    }
}
