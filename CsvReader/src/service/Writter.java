package service;

import implementations.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Writter {
    public Writter() {

    }


    public void studentInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name => ");
        String name = scanner.nextLine();
        System.out.println("Age => ");
        String age = scanner.nextLine();
        System.out.println("RA => ");
        String ra = scanner.nextLine();

        String[] student = {name, age, ra};

        updateFile(student);
    }

    public void updateFile(String[] student) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("CsvReader/Student.CSV"))) {
            for(int i = 0; i < student.length; i++) {
                writer.write(student[i]);
                if(i < student.length - 1){
                    writer.write(";");
                }
                writer.newLine();
            }

        }catch (IOException e) {
            System.err.println("Error writing the csv");
            e.printStackTrace();
        }
    }

}
