package project;

import project.Student;

import java.sql.*;
import java.sql.Connection;
import java.util.HashMap;

public enum DatabaseStuff {

    INSTANCE;

    /**
     * Query the employee table and print the first and
     * last names.
     */

    private String url = "jdbc:mysql://localhost:3306/c3909";
    private String driver = "com.mysql.jdbc.Driver";
    private String username = "c3909u";
    private String password = "!*c3909*!";


    public HashMap<String, Student> getALlStudents() {


        HashMap<String, Student> map = new HashMap<>();

        try {
            // Load database driver if it's not already loaded.
            Class.forName(driver);
            // Establish network connection to database.
            Connection connection =
                    DriverManager.getConnection(url, username, password);
            // Create a statement for executing queries.
            Statement statement = connection.createStatement();
            String query = "SELECT * from students";
            // Send query to database and store results.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                map.put(resultSet.getString("id"), new Student(resultSet.getString("name"), resultSet.getString("id"), resultSet.getString("selected")));
            }
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Error loading driver: " + cnfe);
        } catch (SQLException sqle) {
            System.err.println("Error with connection: " + sqle);
        }

        return map;
    }

    public void updateStudent(Student stu) {

        String template =
                "UPDATE students SET selected = ? WHERE id = ?";


        try {

            Connection connection =
                    DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(template);

            statement.setString(1, stu.getSelected());
            statement.setString(2, stu.getStudentID());
            statement.execute();
            Class.forName(driver);

//            connection.close();
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Error loading driver: " + cnfe);
        } catch (SQLException sqle) {
            System.err.println("Error with connection: " + sqle);
        }
    }
}

