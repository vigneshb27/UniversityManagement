package student.classes;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.FileReadWriteException;
import exceptions.InvalidInputException;
import interfaces.GeneralOperations;

public class StudentOperations implements GeneralOperations {
    StudentIO studentIO;
    Scanner sc;

    public StudentOperations() {
        studentIO = new StudentIO();
        sc = new Scanner(System.in);
    }

    @Override
    public void add() throws Exception {
        try {
            System.out.println("\n---- Enter Student Information ----");
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Gender(Male/Female): ");
            sc.nextLine();
            String gender = sc.nextLine();

            System.out.print("Cgpa: ");
            double cgpa = sc.nextDouble();

            System.out.print("Credit Passed: ");
            int creditPassed = sc.nextInt();

            Student newStudent = new Student(id, name, age, gender, cgpa, creditPassed);
            studentIO.writeIntoFile(newStudent);
            System.out.println("\n-----///----- New student added -----///-----");
            sc.nextLine();

        } catch (InputMismatchException error) {
            throw new InvalidInputException("Invalid input given");
        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public void search() throws Exception {
        try {
            System.out.print("\nEnter student ID to search: ");
            String studentId = sc.nextLine();
            Student student = studentIO.searchFromFile(studentId);
            if (student.getId() == null) {
                System.out.println("///=== No student found with this ID ===///");
            } else {
                student.showDetails();
            }
        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public void update() throws Exception {
        try {
            System.out.print("\nEnter student ID to update: ");
            String studentId = sc.nextLine();
            Student student = studentIO.searchFromFile(studentId);
            if (student.getId() == null) {
                System.out.println("No student found with this ID");
            } else {
                String studentStr = student.studentToStr();
                System.out.println("\n---- Edit Student Information ----");

                System.out.print("Name (" + student.getName() + "): ");
                String name = sc.nextLine();

                System.out.print("Age (" + student.getAge() + "): ");
                String age = sc.nextLine();

                System.out.print("Gender (" + student.getGender() + "): ");
                String gender = sc.nextLine();

                System.out.print("Cgpa (" + student.getCGPA() + "): ");
                String cgpa = sc.nextLine();

                System.out.print("Credit Passed (" + student.getCreditPassed() + "): ");
                String creditPassed = sc.nextLine();

                Student updatedStudent = new Student(
                        student.getId(),
                        name == "" ? student.getName() : name,
                        age == "" ? student.getAge() : Integer.parseInt(age),
                        gender == "" ? student.getGender() : gender,
                        cgpa == "" ? student.getCGPA() : Double.parseDouble(cgpa),
                        creditPassed == "" ? student.getCreditPassed() : Integer.parseInt(creditPassed));
                String updatedStudentStr = updatedStudent.studentToStr();
                studentIO.updateData(studentStr, updatedStudentStr);
                System.out.println("\n-----///----- Student data updated -----///-----");
            }
        } catch (InputMismatchException error) {
            throw new InvalidInputException("Invalid input given");
        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public void delete() throws Exception {
        try {
            System.out.print("\nEnter student ID to delete: ");
            String studentId = sc.nextLine();
            Student student = studentIO.searchFromFile(studentId);
            if (student.getId() == null) {
                System.out.println("///=== No student found with this ID ===///");
            } else {
                String studentStr = student.studentToStr() + "\r\n\r\n";
                studentIO.updateData(studentStr, "");
                System.out.println("\n-----///----- Student deleted -----///-----");
            }
        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public void showAll() throws Exception {
        try {

            Student[] students = studentIO.getAllStudent();

            for (Student student : students) {
                student.showDetails();
            }

        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }
}
