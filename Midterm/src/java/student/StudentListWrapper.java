/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package student;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class StudentListWrapper {

    ArrayList<Student> students;
    int size;

    public StudentListWrapper(ArrayList<Student> students) {
        this.students = students;
        if(students != null)
            this.size = students.size();
        else
        {
            this.size = 0;
        }
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
        this.size = students.size();
    }
}
