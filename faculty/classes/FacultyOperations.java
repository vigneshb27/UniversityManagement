package faculty.classes;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.FileReadWriteException;
import exceptions.InvalidInputException;
import interfaces.GeneralOperations;

public class FacultyOperations implements GeneralOperations {
    FacultyIO facultyIO;
    Scanner sc;

    public FacultyOperations() {
        facultyIO = new FacultyIO();
        sc = new Scanner(System.in);
    }

    @Override
    public void add() throws Exception {
        try {
            System.out.println("\n---- Enter Faculty Information ----");
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Gender(Male/Female): ");
            sc.nextLine();
            String gender = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Faculty newFaculty = new Faculty(id, name, age, gender, department, salary);
            facultyIO.writeIntoFile(newFaculty);
            System.out.println("\n-----///----- New faculty added -----///-----");
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
            System.out.print("\nEnter faculty ID to search: ");
            String facultyId = sc.nextLine();
            Faculty faculty = facultyIO.searchFromFile(facultyId);
            if (faculty.getId() == null) {
                System.out.println("///=== No faculty found with this ID ===///");
            } else {
                faculty.showDetails();
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
            System.out.print("\nEnter faculty ID to update: ");
            String facultyId = sc.nextLine();
            Faculty faculty = facultyIO.searchFromFile(facultyId);
            if (faculty.getId() == null) {
                System.out.println("No faculty found with this ID");
            } else {
                String facultyStr = faculty.facultyToStr();
                System.out.println("\n---- Edit Faculty Information ----");

                System.out.print("Name (" + faculty.getName() + "): ");
                String name = sc.nextLine();

                System.out.print("Age (" + faculty.getAge() + "): ");
                String age = sc.nextLine();

                System.out.print("Gender (" + faculty.getGender() + "): ");
                String gender = sc.nextLine();

                System.out.print("Department (" + faculty.getDepartment() + "): ");
                String department = sc.nextLine();

                System.out.print("Salary (" + faculty.getSalary() + "): ");
                String salary = sc.nextLine();

                Faculty updatedFaculty = new Faculty(
                        faculty.getId(),
                        name == "" ? faculty.getName() : name,
                        age == "" ? faculty.getAge() : Integer.parseInt(age),
                        gender == "" ? faculty.getGender() : gender,
                        department == "" ? faculty.getDepartment() : department,
                        salary == "" ? faculty.getSalary() : Double.parseDouble(salary));
                String updatedFacultyStr = updatedFaculty.facultyToStr();
                facultyIO.updateData(facultyStr, updatedFacultyStr);
                System.out.println("\n-----///----- Faculty data updated -----///-----");
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
            System.out.print("\nEnter faculty ID to delete: ");
            String facultyId = sc.nextLine();
            Faculty faculty = facultyIO.searchFromFile(facultyId);
            if (faculty.getId() == null) {
                System.out.println("///=== No faculty found with this ID ===///");
            } else {
                String facultyStr = faculty.facultyToStr() + "\r\n\r\n";
                facultyIO.updateData(facultyStr, "");
                System.out.println("\n-----///----- Faculty deleted -----///-----");
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

            Faculty[] facultyList = facultyIO.getAllFaculty();

            for (Faculty faculty : facultyList) {
                faculty.showDetails();
            }

        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }
}
