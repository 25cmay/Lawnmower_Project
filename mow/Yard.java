package mow;

public class Yard {
    // Create the yard
    public char yard[][];

    // Constructor
    public Yard(int height, int width) {
        // Create array with the dimensions and room for boundarries
        yard = new char[height + 2][width + 2];

        // Fill the array with initial values
        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[0].length; j++) {
                // Boundary
                if (i == 0 || i == yard.length - 1 || j == 0 || j == yard[0].length - 1) {
                    yard[i][j] = '0';
                    // Unmowed grass
                } else {
                    yard[i][j] = '+';
                }
            }
        }
    }

    // give status
    public char getStatus(int row, int col) {
        return yard[row][col];
    }

    // set value
    public void setCellValue(int row, int col, char value) {
        yard[row][col] = value;
    }

    // return height
    public int returnHeight() {
        return yard.length - 2;
    }

    // return width
    public int returnWidth() {
        return yard[0].length - 2;
    }

    // print lawn
    public void printYard() {
        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[0].length; j++) {
                System.out.print(yard[i][j]);
            }
            System.out.println();
        }
    }

    //

    // print lawn with mower
    public void printYard(Mower mower) {
        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[0].length; j++) {
                if (mower.getRow() == i && mower.getColumn() == j) { // mower print mower;
                    if (mower.getDirection() == 0) {
                        System.out.print("^");
                    } else if (mower.getDirection() == 1) {
                        System.out.print(">");
                    } else if (mower.getDirection() == 2) {
                        System.out.print("v");
                    } else if (mower.getDirection() == 3) {
                        System.out.print("<");
                    }
                } else {
                    System.out.print(yard[i][j]);
                }
                
            }
            System.out.println();
        }
    }

    public boolean hasUnmowedGrass() {
        for (int i = 1; i < yard.length - 1; i++) {
            for (int j = 1; j < yard[0].length - 1; j++) {
                if (yard[i][j] == '+') {
                    return true;
                }
            }
        }
        return false;
    }
}