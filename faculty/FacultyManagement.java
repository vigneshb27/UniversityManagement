package faculty;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.FileReadWriteException;
import exceptions.InvalidInputException;
import faculty.classes.FacultyOperations;

public class FacultyManagement {
    public static void runFacultyOperation() throws Exception {
        FacultyOperations facultyOps = new FacultyOperations();
        Scanner sc = new Scanner(System.in);
        int option = 0;

        try {
            while (option != 6) {
                System.out.println("\n----- Manage Faculty -----");
                System.out.println("1. Add Faculty");
                System.out.println("2. Update Faculty");
                System.out.println("3. Search Faculty");
                System.out.println("4. Delete Faculty");
                System.out.println("5. Show All Faculty");
                System.out.println("6. Exit");
                System.out.print("\nSelect Option: ");

                option = sc.nextInt();

                switch (option) {
                    case 1:
                        facultyOps.add();
                        break;
                    case 2:
                        facultyOps.update();
                        break;
                    case 3:
                        facultyOps.search();
                        break;
                    case 4:
                        facultyOps.delete();
                        break;
                    case 5:
                        facultyOps.showAll();
                        break;
                    case 6:
                        System.out.println("Program Exited");
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }
        } catch (InputMismatchException error) {
            throw new InvalidInputException("Invalid input given");
        } catch (InvalidInputException error) {
            throw error;
        } catch (FileReadWriteException error) {
            throw error;
        } catch (Exception error) {
            throw error;
        } finally {
            sc.close();
        }
    }
}
