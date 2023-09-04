package service;

import implementations.Student;
import repositories.StudentRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    StudentRepository studentRepository = new StudentRepository();
    public void readFile() {
        String line = "";
        String splitBy = ";";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("CsvReader/Student.CSV"));

            while((line = reader.readLine()) != null) {
                String[] student = line.split(splitBy);
                studentRepository.addStudent
                        (
                                new Student
                                        (
                                                student[0],
                                                Integer.parseInt(student[1]),
                                                Integer.parseInt(student[2])
                                        )
                        );
            }
            System.out.println("FILE READ SUCCESSFULLY!");

        } catch (IOException i) {
            System.err.println("Error reading the file");
            i.printStackTrace();
        }
    }


}
