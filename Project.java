/*
 * Caleb May
 * Mr.Eng
 * AT Java
 */

import java.util.Scanner;

import mow.Yard;
import mow.Mower;

public class Project {

    // method to clear screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // method to delay showing yard
    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

    public static void main(String[] args) {
        clearScreen(); // Clear the screen

        // Initalize Scanner
        Scanner in = new Scanner(System.in);

        // Prompt user for dimensions of the lawn
        System.out.print("Enter the height of the yard: ");
        int height = in.nextInt();

        System.out.print("Enter the width of the yard: ");
        int width = in.nextInt();

        // Create Yard object
        Yard yard = new Yard(height, width);

        // Print Yard without mower
        yard.printYard();
        System.out.println();

        // Get row
        System.out.print("Enter a starting row in your yard between 0 and " + (height - 1) + ": ");
        int mrow = in.nextInt();

        // Get column
        System.out.print("Enter a starting column in your yard between 0 and " + (width - 1) + ": ");
        int mcolumn = in.nextInt();

        // Get direction
        System.out.print("Enter a starting direction for your mower. 0 is up, 1 is right, 2 is down, 3 is left: ");
        int mdirection = in.nextInt();

        // Print yard with mower
        Mower mower = new Mower(mrow, mcolumn, mdirection);
        clearScreen();
        yard.printYard(mower);

        // Choose cut
        System.out.print("Do you want a spiral cut (1) or line by line cut (2): ");
        int cut = in.nextInt();
        if (cut == 1) {
            // cut spiral
            while (true) {
                mower.cutGrass(yard);
                if (mower.checkGrass(yard) == false) {
                    // check right
                    mower.turnRight();
                    if (mower.checkGrass(yard) == true) {
                        mower.moveForward();
                    } else {
                        mower.turnLeft();
                        mower.turnLeft();
                        if (mower.checkGrass(yard) == true) {
                            mower.moveForward();
                        } else {
                            break;
                        }

                    }
                } else {
                    mower.moveForward();
                }
                clearScreen();

                // Print yard with mower
                yard.printYard(mower);

                System.out.println();
                delay(500);
            }
        } else if (cut == 2) {
            // cut line by line
            while (true) {
                if (mower.checkGrass(yard) == false) {
                    mower.turnRight();
                }
                if (mower.checkGrass(yard) == false) {
                    mower.turnRight();
                }
                while (mower.checkGrass(yard) == true) {
                    mower.cutGrass(yard);
                    mower.updateMower(yard);
                    clearScreen();
                    yard.printYard(mower);
                    System.out.println();
                    delay(500);
                }
                mower.turnRight();
                if (mower.checkGrass(yard) == false) {
                    mower.turnLeft();
                    mower.turnLeft();
                    mower.cutGrass(yard);
                    mower.updateMower(yard);
                    clearScreen();
                    yard.printYard(mower);
                    System.out.println();
                    delay(500);
                    mower.turnLeft();
                } else if (mower.checkGrass(yard) == true) {
                    mower.cutGrass(yard);
                    mower.updateMower(yard);
                    clearScreen();
                    yard.printYard(mower);
                    System.out.println();
                    delay(500);
                    mower.turnRight();
                }
                while (mower.checkGrass(yard) == true) {
                    mower.cutGrass(yard);
                    mower.updateMower(yard);
                    clearScreen();
                    yard.printYard(mower);
                    System.out.println();
                    delay(500);
                }
            }
        }
        in.close();
    }
}