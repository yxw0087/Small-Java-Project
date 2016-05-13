/**
   *Author: Yee H. Wong
? *CLID: yxw0087
? *Class: CMPS 360
? *Project: 3
   *Due Date: 11/23/14
? *Description: Creation of client software for a socket accessible database
   *             server. 
 */

/** To?delete?all?tables,?recreate?all?tables?and?populate?all?tables?
 * with?testing?data,?run?MakeDB.java
 */

/**
 * To create a database in Linux/OSX: run 3b2_socketmckoidb/socketdb/linuxcreate
   To create a database in Windows: run 3b2_socketmckoidb\socketdb\windowscreate.bat
   To start the socket server in Linux/OSX: run 3b2_socketmckoidb/socketdb/linuxstart
   To start the socket server in Windows: run 3b2_socketmckoidb\socketdb\windowstart.bat
   To stop the socket server in Linux/OSX: CTRL?C
   To stop the socket server in Windows: close the window?
 */

package socketmckoidb;

import java.util.Scanner;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char cont;
        boolean validCont;
        int response;
        int ID, ID2;
        String name, street, city, state, zip;

        myDB db = new myDB();

        if (db.connection != null) {
            do {
                System.out.println("To list all student ids and student names, enter 1.");
                System.out.println("To list all courses, enter 2.");
                System.out.println("To list all majors, enter 3.");
                System.out.println("To list all students in a particular major, enter 4.");
                System.out.println("To list all students in a particular course, enter 5.");

                System.out.println("To list the schedule of a particular student, enter 6.");
                System.out.println("To list the name, address and major of a particular student, enter 7.");

                System.out.println("To add a new student to database, enter 8.");
                System.out.println("To add a new course to database, enter 9.");
                System.out.println("To add a new major to database, enter 10.");

                System.out.println("To enroll a new student to a course in the database, enter 11.");

                System.out.println("To exit, enter 0.");

                System.out.print("\nYour response: ");

                response = sc.nextInt();

                switch (response) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        db.showStudents();
                        break;
                    case 2:
                        db.showCourses();
                        break;
                    case 3:
                        db.showMajors();
                        break;
                    case 4:
                        System.out.print("Enter a major id: ");
                        ID = sc.nextInt();
                        db.showMajorStudents(ID);
                        break;
                    case 5:
                        System.out.print("Enter a course id: ");
                        ID = sc.nextInt();
                        db.showCourseStudents(ID);
                        break;
                    case 6:
                        System.out.print("Enter a student id: ");
                        ID = sc.nextInt();
                        db.showSchedule(ID);
                        break;
                    case 7:
                        System.out.print("Enter a student id: ");
                        ID = sc.nextInt();
                        db.showStudentInfo(ID);
                        break;
                    case 8:
                        System.out.print("Enter a new student id: ");
                        ID = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter a new student name: ");
                        name = sc.nextLine();
                        System.out.print("Enter a major id for this student: ");
                        ID2 = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter a street name for the address of this student: ");
                        street = sc.nextLine();
                        System.out.print("Enter a city name for the address of this student: ");
                        city = sc.nextLine();
                        System.out.print("Enter a state name for the address of this student: ");
                        state = sc.nextLine();
                        System.out.print("Enter a zip for the address of this student: ");
                        zip = sc.nextLine();
                        db.addStudent(ID, name, ID2, street, city, state, zip);
                        break;
                    case 9:
                        System.out.print("Enter a new course id: ");
                        ID = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter a description for this course: ");
                        name = sc.nextLine();
                        db.addCourse(ID, name);
                        break;
                    case 10:
                        System.out.print("Enter a new major id: ");
                        ID = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter a description for this major: ");
                        name = sc.nextLine();
                        db.addMajor(ID, name);
                        break;
                    case 11:
                        System.out.print("Enter a student id: ");
                        ID = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter a course id to enroll: ");
                        ID2 = sc.nextInt();
                        db.enroll(ID, ID2);
                        break;
                    default:
                        System.out.println("Invalid response.");
                }

                do {
                    System.out.print("Continue? (y/n): ");
                    cont = sc.next().charAt(0);
                    if (cont == 'y' || cont == 'n') {
                        validCont = true;
                    } else {
                        validCont = false;
                        System.out.println("Please enter y for yes and n for no.");
                    }
                } while (!validCont);
            } while (cont != 'n');
        }
    }
}
