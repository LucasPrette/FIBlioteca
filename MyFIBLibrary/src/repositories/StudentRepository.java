package repositories;

import implementations.Student;
import services.ReadTXT;

import java.util.ArrayList;
public class StudentRepository {
    private ArrayList<Student> students;

    public StudentRepository() {
        ReadTXT reader = new ReadTXT();

        students = reader.readStudents();
    };

    public ArrayList<Student> getStudents() {
        return this.students;
    };

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    };

    public void listStudent() {
        for(Student student : students) {
            student.showStudent();
        }
    };

    public Student searchStudent(int ra) {
        for(Student student : students) {
            if (ra == student.getRa()) {
                return student;
            }
        }
        return null;
    };

    public boolean isStudentRegistered (int ra) {
        for(Student student : students) {
            if (ra == student.getRa()) {
                return true;
            }
        }
        return false;
    };

};
