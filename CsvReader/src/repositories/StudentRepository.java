package repositories;

import implementations.Student;

import java.util.ArrayList;

public class StudentRepository {
    static ArrayList<Student> students = new ArrayList<>();

    public StudentRepository() {

    };

    public StudentRepository(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listStudents() {
        for (Student student : students) {
            student.showStudent();
        }
    }


}
