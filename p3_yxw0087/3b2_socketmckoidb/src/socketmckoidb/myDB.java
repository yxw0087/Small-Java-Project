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

import java.sql.*;

public class myDB {

    Connection connection;

    public static void main(String[] args) {

    }

    /**
     * Default constructor for myDB.
     * Checks if client is connected to the database
     */
    public myDB() {

        // ******************************************************
        // ****************  Connecting to datatbase  ***********
        // ******************************************************
        // Register Mckoi JDBC driver
        try {
            Class.forName("com.mckoi.JDBCDriver").newInstance();
        } catch (Exception e) {
            System.out.println("Cannot register driver: " + e);
            return;
        }

        // URL for local database with configuration file
        String url = "jdbc:mckoi://localhost:9157/BedrockU.conf?create=false";

        // create root user info
        String admin = "admin";
        String adminPw = "9999";

        // make a connection to the database
        try {
            connection = DriverManager.getConnection(url, admin, adminPw);
        } catch (SQLException e) {
            System.out.println("cannot connect to database: " + e);
            return;
        }
    }

    /**
     * List all students in the database.
     */
    public void showStudents() {

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            result = statement.executeQuery(
                    "SELECT Student.id, Student.name FROM Student"
            );

            // display result of query
            System.out.println("\nStudent ID and Names:");
            while (result.next()) {
                System.out.print(result.getString(1) + " ");
                System.out.println(result.getString(2));
            }

        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }

    /**
     * List all available courses in the database.
     */
    public void showCourses() {

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            result = statement.executeQuery(
                    "SELECT Course.courseId, Course.courseDesc FROM Course"
            );

            // display result of query
            System.out.println("\nCourses available:");
            while (result.next()) {
                System.out.print(result.getString(1) + " ");
                System.out.println(result.getString(2));
            }

        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }

    /**
     * List all available majors in the database.
     */
    public void showMajors() {

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            result = statement.executeQuery(
                    "SELECT Major.majorId, Major.majorDesc FROM Major"
            );

            // display result of query
            System.out.println("\nMajors available:");
            while (result.next()) {
                System.out.print(result.getString(1) + " ");
                System.out.println(result.getString(2));
            }

        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }    

    /**
     * List all students in the given major.
     * @param majorID ID of the given major
     */
    public void showMajorStudents(int majorID) {

        String name = "";

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            result = statement.executeQuery(
                    "SELECT Major.majorId FROM Major WHERE Major.majorId=" + majorID
            );
            if (!result.next()) {
                System.out.println("Major doesn't exist.");
            } else {

                result = statement.executeQuery(
                        "SELECT Student.name FROM Student, Major WHERE Student.majorId="
                        + majorID);

                // display result of query
                System.out.println("\nStudents in this major:");
                while (result.next()) {
                    if (!result.getString(1).equals(name)) {
                        name = result.getString(1);
                        System.out.println(name);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }

    /**
     * List all students currently enrolled in the given course.
     * @param courseID ID of the given course
     */
    public void showCourseStudents(int courseID) {

        String name = "";

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            result = statement.executeQuery(
                    "SELECT Course.courseId FROM Course WHERE Course.courseId=" + courseID
            );
            if (!result.next()) {
                System.out.println("Course doesn't exist.");
            } else {

                result = statement.executeQuery(
                        "SELECT Student.name FROM Student, Enrolled WHERE Student.id=Enrolled.id "
                        + "AND Enrolled.courseId =" + courseID);

                // display result of query
                System.out.println("\nStudents in this course:");
                while (result.next()) {
                    if (!result.getString(1).equals(name)) {
                        name = result.getString(1);
                        System.out.println(name);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }

    /**
     * Show schedule of the given student.
     * @param majorID ID of the given student
     */
    public void showSchedule(int studentID) {

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            result = statement.executeQuery(
                    "SELECT id FROM Student WHERE id=" + studentID
            );
            if (!result.next()) {
                System.out.println("Student doesn't exist.");
            } else {

                result = statement.executeQuery(
                        "SELECT Course.courseDesc FROM Course, Enrolled WHERE "
                        + studentID + "=Enrolled.id "
                        + "AND Enrolled.courseId=Course.courseId");

                // display result of query
                System.out.println("\nSchedule of this student:");
                while (result.next()) {
                    System.out.println(result.getString(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }

    /**
     * List the name, address and major of the given student.
     * @param majorID ID of the given student
     */
    public void showStudentInfo(int studentID) {

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            result = statement.executeQuery(
                    "SELECT id FROM Student WHERE id=" + studentID
            );
            if (!result.next()) {
                System.out.println("Student doesn't exist.");
            } else {

                result = statement.executeQuery(
                        "SELECT Student.name, Major.majorDesc,Address.street, Address.city, Address.state, Address.zip "
                        + "FROM Student, Major, Address WHERE Student.id="
                        + studentID + "AND Student.id=Address.id AND Student.majorId=Major.majorId");

                // display result of query
                System.out.println("\nName, major and address of this student:");
                while (result.next()) {
                    System.out.println(result.getString(1));
                    System.out.println(result.getString(2));
                    System.out.println(result.getString(3));
                    System.out.println(result.getString(4) + ", "
                            + result.getString(5) + "  "
                            + result.getString(6) + "\n");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }

    /**
     * Adds a new student to the database, with the given parameters.
     * @param studentID ID of the new student
     * @param studentName name of the new student
     * @param majorID Id of the major to be enrolled
     * @param Street Street name of the address of the new student
     * @param City City name of the address of the new student
     * @param State State name of the address of the new student
     * @param Zip Zip code of the address of the new student
     */
    public void addStudent(int studentID, String studentName, int majorID, String Street, String City, String State, String Zip) {

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            result = statement.executeQuery(
                    "SELECT Major.majorId FROM Major WHERE Major.majorId=" + majorID
            );

            if (!result.next()) {
                System.out.println("Major doesn't exist.");
            } else {
                // query to get addresses of students
                result = statement.executeQuery(
                        "INSERT INTO Student(id, name, majorId) VALUES (" + studentID
                        + ", " + "'" + studentName + "'" + ", " + majorID + ")");

                result = statement.executeQuery(
                        "INSERT INTO Address(id, street, city, state, zip) VALUES (" + studentID
                        + ", " + "'" + Street + "'" + ", " + "'" + City + "'"
                        + ", " + "'" + State + "'" + ", " + "'" + Zip + "'" + ")");

                // display result of query
                System.out.println("\nA new student has been added.");
            }
        } catch (SQLException e) {
            System.out.println("Insertion failed: " + e);
            return;
        }
    }

    /**
     * Adds a new course to the database.
     * @param courseID ID of the new course
     * @param description Description of the new course
     */
    public void addCourse(int courseID, String description) {

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            // query to get addresses of students
            result = statement.executeQuery(
                    "INSERT INTO Course(courseId, courseDesc) VALUES (" + courseID
                    + ", " + "'" + description + "')");

            // display result of query
            System.out.println("\nA new course has been added.");

        } catch (SQLException e) {
            System.out.println("Insertion failed: " + e);
            return;
        }
    }

    /**
     * Adds a new major to the database.
     * @param majorID ID of the new major
     * @param description Description of the new major
     */
    public void addMajor(int majorID, String description) {

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            // query to get addresses of students
            result = statement.executeQuery(
                    "INSERT INTO Major(majorId, majorDesc) VALUES (" + majorID
                    + ", " + "'" + description + "')");

            // display result of query
            System.out.println("\nA new major has been added.");

        } catch (SQLException e) {
            System.out.println("Insertion failed: " + e);
            return;
        }
    }

    /**
     * Enrolls a student in a course
     * @param studentID ID of the student
     * @param courseID ID of the course
     */
    public void enroll(int studentID, int courseID) {

        // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;

            result = statement.executeQuery(
                    "SELECT id FROM Student WHERE id=" + studentID
            );
            if (!result.next()) {
                System.out.println("Student doesn't exist.");
            } else {
                result = statement.executeQuery(
                        "SELECT Course.courseId FROM Course WHERE Course.courseId=" + courseID
                );
                if (!result.next()) {
                    System.out.println("Course doesn't exist.");
                } else {

                    // query to get addresses of students
                    result = statement.executeQuery(
                            "INSERT INTO Enrolled(id, courseId) VALUES (" + studentID
                            + ", " + courseID + ")");

                    // display result of query
                    System.out.println("\nStudent has been enrolled in this course.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Enroll failed: " + e);
            return;
        }
    }
}
