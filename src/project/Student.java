package project;

import java.util.ArrayList;

/**
 * Created by owner_ on 2016-01-26.
 */

//TODO:
// see what's who's gonna inherit from it
// limit the setters and getters!
    // choose wether to use array of strings of students for the selection


public class Student {

    private String studentID;
    private String name;
    private String email = null;
    private String selected;
    private String selectd;


    public Student(String studentID, String name, String selected, String email) {

        this(studentID, name, selected);
        setEmail(null);
    }


    public Student(String name,
                   String studentID, String selected) {

        this.studentID = studentID;
        this.name = name;
        this.selectd = selected;

    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String setStudentID(String id) {
        return this.studentID = id;
    }

    public void setSelected(String selectd) {
        this.selectd = selectd;
    }

    public String getSelected() {
        return selectd;
    }
}
