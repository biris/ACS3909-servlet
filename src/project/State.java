package project;

import java.util.Collection;

/**
 * Created by owner_ on 2016-02-24.
 */
public class State {


    String studentID;

    String message;

    String selectedStudents;

    Collection<Student>  filteredStudents;
    private String selctedStudents;
    private Collection<Student> whoSelected;
    private String name;

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Collection<Student> getFilteredStudents() {
        return filteredStudents;
    }

    public State() {

    }


    public void setFilteredStudents(Collection<Student> filteredStudents) {

        this.filteredStudents = filteredStudents;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void setSelctedStudents(String selctedStudents) {
        this.selctedStudents = selctedStudents;
    }

    public String getSelctedStudents() {
        return selctedStudents;
    }

    public void setWhoSelected(Collection<Student> whoSelected) {
        this.whoSelected = whoSelected;
    }

    public Collection<Student> getWhoSelected() {
        return whoSelected;
    }
}
