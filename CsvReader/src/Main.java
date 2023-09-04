import repositories.StudentRepository;
import service.Reader;
import service.Writter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader();
        StudentRepository studentRepository = new StudentRepository();
        Writter writter = new Writter();

        Scanner scanner = new Scanner(System.in);
        int option;

        do{
            System.out.println("0 - EXIT");
            System.out.println("1 - READ FILE");
            System.out.println("2 - LIST STUDENTS");
            System.out.println("3 - ADD STUDENT");
            option = scanner.nextInt();

            switch (option) {
                case 1 : reader.readFile(); break;
                case 2 : studentRepository.listStudents(); break;
                case 3 : writter.studentInfo();break;
            }

        }while(option != 0);


    }

}