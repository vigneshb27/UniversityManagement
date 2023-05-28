package stuff.classes;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.FileReadWriteException;
import exceptions.InvalidInputException;
import interfaces.GeneralOperations;

public class StuffOperations implements GeneralOperations {
    StuffIO stuffIO;
    Scanner sc;

    public StuffOperations() {
        stuffIO = new StuffIO();
        sc = new Scanner(System.in);
    }

    @Override
    public void add() throws Exception {
        try {
            System.out.println("\n---- Enter stuff Information ----");
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Gender(Male/Female): ");
            sc.nextLine();
            String gender = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Stuff newstuff = new Stuff(id, name, age, gender, salary);
            stuffIO.writeIntoFile(newstuff);
            System.out.println("\n-----///----- New stuff added -----///-----");
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
            System.out.print("\nEnter stuff ID to search: ");
            String stuffId = sc.nextLine();
            Stuff stuff = stuffIO.searchFromFile(stuffId);
            if (stuff.getId() == null) {
                System.out.println("///=== No stuff found with this ID ===///");
            } else {
                stuff.showDetails();
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
            System.out.print("\nEnter stuff ID to update: ");
            String stuffId = sc.nextLine();
            Stuff stuff = stuffIO.searchFromFile(stuffId);
            if (stuff.getId() == null) {
                System.out.println("No stuff found with this ID");
            } else {
                String stuffStr = stuff.stuffToStr();
                System.out.println("\n---- Edit stuff Information ----");

                System.out.print("Name (" + stuff.getName() + "): ");
                String name = sc.nextLine();

                System.out.print("Age (" + stuff.getAge() + "): ");
                String age = sc.nextLine();

                System.out.print("Gender (" + stuff.getGender() + "): ");
                String gender = sc.nextLine();

                System.out.print("Salary (" + stuff.getSalary() + "): ");
                String salary = sc.nextLine();

                Stuff updatedstuff = new Stuff(
                        stuff.getId(),
                        name == "" ? stuff.getName() : name,
                        age == "" ? stuff.getAge() : Integer.parseInt(age),
                        gender == "" ? stuff.getGender() : gender,
                        salary == "" ? stuff.getSalary() : Double.parseDouble(salary));
                String updatedstuffStr = updatedstuff.stuffToStr();
                stuffIO.updateData(stuffStr, updatedstuffStr);
                System.out.println("\n-----///----- Stuff data updated -----///-----");
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
            System.out.print("\nEnter stuff ID to delete: ");
            String stuffId = sc.nextLine();
            Stuff stuff = stuffIO.searchFromFile(stuffId);
            if (stuff.getId() == null) {
                System.out.println("///=== No stuff found with this ID ===///");
            } else {
                String stuffStr = stuff.stuffToStr() + "\r\n\r\n";
                stuffIO.updateData(stuffStr, "");
                System.out.println("\n-----///----- Stuff deleted -----///-----");
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

            Stuff[] stuffs = stuffIO.getAllStuff();

            for (Stuff stuff : stuffs) {
                stuff.showDetails();
            }

        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        }
    }
}
