package repositories;

import implementations.Student;
import services.DbConnection;
import services.ReadTXT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public void insertStudent(int ra, String name) {

        try{
            Connection connection = new DbConnection().getConnection();
            String sqlQuery = "INSERT INTO fib.fiblioteca.student (ra, name) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, ra);
            preparedStatement.setString(2, name);
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Lines inserted successfully! ");
            } else {
                System.err.println("Line insertion failed!! ");
            }
        } catch (SQLException e) {
            System.out.println("Error on DataBase" + e.getMessage());

        }
    };

};
