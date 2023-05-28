package stuff;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.FileReadWriteException;
import exceptions.InvalidInputException;
import stuff.classes.StuffOperations;

public class StuffManagement {
    public static void runStuffOperation() throws Exception {
        StuffOperations stuffOps = new StuffOperations();
        Scanner sc = new Scanner(System.in);
        int option = 0;

        try {
            while (option != 6) {
                System.out.println("\n----- Manage Stuffs -----");
                System.out.println("1. Add Stuff");
                System.out.println("2. Update Stuff");
                System.out.println("3. Search Stuff");
                System.out.println("4. Delete Stuff");
                System.out.println("5. Show All Stuffs");
                System.out.println("6. Exit");
                System.out.print("\nSelect Option: ");

                option = sc.nextInt();

                switch (option) {
                    case 1:
                        stuffOps.add();
                        break;
                    case 2:
                        stuffOps.update();
                        break;
                    case 3:
                        stuffOps.search();
                        break;
                    case 4:
                        stuffOps.delete();
                        break;
                    case 5:
                        stuffOps.showAll();
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
