/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Project: 4
  *Due Date: 12/6/14
  *Description: Creation of client software for a socket accessible database
   *            server. 
 */

/** To delete all tables, recreate all tables and populate all tables 
 * with testing data, run MakeDB.java
 */

/**
 * To create a database in Linux/OSX: run Project4/socketdb/linuxcreate
   To create a database in Windows: run Project4\socketdb\windowscreate.bat
   To start the socket server in Linux/OSX: run Project4/socketdb/linuxstart
   To start the socket server in Windows: run Project4\socketdb\windowstart.bat
   To stop the socket server in Linux/OSX: CTRL C
   To stop the socket server in Windows: close the window
 */

package socketmckoidb;

import java.sql.*;

public class myDB {

    String[] list = new String[20];
    public Connection connection;
    String password;
    
    public static void main(String[] args) {

    }

    /**
     * Default constructor for myDB.
     * Checks if client is connected to the database
     */
    public myDB() {
        
        password = "12345";

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
    public String[] showStudents() {

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
            list[0] = "Student ID and Names:";
            int index = 1;
            while (result.next()) {
                list[index++] = result.getString(1) + " " + result.getString(2);     
            }
            return list;

        } catch (SQLException e) {
            list[0] = "Error querying database: " + e;
            return list;
        }
    }

    /**
     * List all available courses in the database.
     */
    public String[] showCourses() {

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
            list[0] = "Courses available:";
            int index = 1;
            while (result.next()) {
                list[index++] = result.getString(1) + " " + result.getString(2);              
            }
            return list;

        } catch (SQLException e) {
            list[0] = "Error querying database: " + e;
            return list;
        }
    }

    /**
     * List all available majors in the database.
     */
    public String[] showMajors() {

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
            list[0] = "Majors available:";
            int index = 1;
            while (result.next()) {
                list[index++] = result.getString(1) + " " + result.getString(2);               
            }
            return list;

        } catch (SQLException e) {
            list[0] = "Error querying database: " + e;
            return list;
        }
    }    

    /**
     * List all students in the given major.
     * @param majorID ID of the given major
     */
    public String[] showMajorStudents(int majorID) {

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
                list[0] = "Major doesn't exist.";
            } else {

                result = statement.executeQuery(
                        "SELECT Student.name FROM Student, Major WHERE Student.majorId="
                        + majorID);

                // display result of query
                list[0] = "Students in this major:";
                int index = 1;
                while (result.next()) {
                    if (!result.getString(1).equals(name)) {
                        name = result.getString(1);
                        list[index++] = name;
                    }
                }
            }
            return list;
        } catch (SQLException e) {
            list[0] = "Error querying database: " + e;
            return list;
        }
    }

    /**
     * List all students currently enrolled in the given course.
     * @param courseID ID of the given course
     */
    public String[] showCourseStudents(int courseID) {

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
                list[0] = "Course doesn't exist.";
            } else {

                result = statement.executeQuery(
                        "SELECT Student.name FROM Student, Enrolled WHERE Student.id=Enrolled.id "
                        + "AND Enrolled.courseId =" + courseID);

                // display result of query
                list[0] = "Students in this course:";
                int index = 1;
                while (result.next()) {
                    if (!result.getString(1).equals(name)) {
                        name = result.getString(1);
                        list[index++] = name;
                    }
                }
            }
            return list;
        } catch (SQLException e) {
            list[0] = "Error querying database: " + e;
            return list;
        }
    }

    /**
     * Show schedule of the given student.
     * @param majorID ID of the given student
     */
    public String[] showSchedule(int studentID) {

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
                list[0] = "Student doesn't exist.";
            } else {

                result = statement.executeQuery(
                        "SELECT Course.courseDesc FROM Course, Enrolled WHERE "
                        + studentID + "=Enrolled.id "
                        + "AND Enrolled.courseId=Course.courseId");

                // display result of query
                list[0] = "Schedule of this student:";
                int index = 1;
                while (result.next()) {
                    list[index++] = result.getString(1);
                }
            }
            return list;
        } catch (SQLException e) {
            list[0] = "Error querying database: " + e;
            return list;
        }
    }

    /**
     * List the name, address and major of the given student.
     * @param majorID ID of the given student
     */
    public String[] showStudentInfo(int studentID) {

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
                list[0] = "Student doesn't exist.";
            } else {

                result = statement.executeQuery(
                        "SELECT Student.name, Major.majorDesc,Address.street, Address.city, Address.state, Address.zip "
                        + "FROM Student, Major, Address WHERE Student.id="
                        + studentID + "AND Student.id=Address.id AND Student.majorId=Major.majorId");

                // display result of query
                list[0] = "Name, major and address of this student:";
                while (result.next()) {
                    list[1] = result.getString(1);
                    list[2] = result.getString(2);
                    list[3] = result.getString(3);
                    list[4] = result.getString(4) + ", "
                            + result.getString(5) + "  "
                            + result.getString(6);
                }
            }
            return list;
        } catch (SQLException e) {
            list[0] = "Error querying database: " + e;
            return list;
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
    public String addStudent(int studentID, String studentName, int majorID, String Street, String City, String State, String Zip) {

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
                return "Major doesn't exist.";
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
                return "A new student has been added.";
            }
        } catch (SQLException e) {
            return "Insertion failed: " + e;
        }
    }

    /**
     * Adds a new course to the database.
     * @param courseID ID of the new course
     * @param description Description of the new course
     */
    public String addCourse(int courseID, String description) {

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
            return "A new course has been added.";

        } catch (SQLException e) {
            return "Insertion failed: " + e;
            
        }
    }

    /**
     * Adds a new major to the database.
     * @param majorID ID of the new major
     * @param description Description of the new major
     */
    public String addMajor(int majorID, String description) {

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
            return "A new major has been added.";

        } catch (SQLException e) {
            return "Insertion failed: " + e;
        }
    }

    /**
     * Enrolls a student in a course
     * @param studentID ID of the student
     * @param courseID ID of the course
     */
    public String enroll(int studentID, int courseID) {

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
                return "Student doesn't exist.";
            } else {
                result = statement.executeQuery(
                        "SELECT Course.courseId FROM Course WHERE Course.courseId=" + courseID
                );
                if (!result.next()) {
                    return "Course doesn't exist.";
                } else {

                    // query to get addresses of students
                    result = statement.executeQuery(
                            "INSERT INTO Enrolled(id, courseId) VALUES (" + studentID
                            + ", " + courseID + ")");

                    // display result of query
                    return "Student has been enrolled in this course.";
                }
            }
        } catch (SQLException e) {
            return "Enroll failed: " + e;
        }
    }
    
    /**
     * Checks if the entered password is correct.
     * @param pass User entered password
     * @return True if password is correct, false otherwise.
     */
    public Boolean checkPass(String pass) {
        return password.equals(pass);
    }
}