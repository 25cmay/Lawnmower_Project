package mow;

public class Mower {
    private int row;
    private int column;
    private int direction;
    // 0 up, 1 right, 2 down, 3 left

    // Create Mower
    public Mower(int row, int column, int direction) {
        this.row = row + 1;
        this.column = column + 1;
        this.direction = direction;
    }

    public boolean updateMower(Yard yard) {
        if (yard.hasUnmowedGrass() == true) {
            moveForward();
            return true;
        } else {
            return false;
        }
    }

    // Get Row
    public int getRow() {
        return row;
    }

    // Set Row
    public void setRow(int row) {
        this.row = row;
    }

    // Get Column
    public int getColumn() {
        return column;
    }

    // Set Column
    public void setColumn(int column) {
        this.column = column;
    }

    // Get Direction
    public int getDirection() {
        return direction;
    }

    // Set Direction
    public void setDirection(int direction) {
        this.direction = direction;
    }

    // Create Movements
    // Move Forwards
    public void moveForward() {
        switch (direction) {
            case 0: // up
                row--;
                break;
            case 1: // right
                column++;
                break;
            case 2: // down
                row++;
                break;
            case 3: // left
                column--;
                break;
        }
    }

    // Turn Left
    public void turnLeft() {
        direction = (direction + 3) % 4;
    }

    // Turn Right
    public void turnRight() {
        direction = (direction + 1) % 4;
    }

    // Look for grass
    public boolean checkGrass(Yard yard) {
        if (direction == 0) {
            boolean cell = yard.getStatus(row - 1, column) == '+';
            return cell;
        } else if  (direction == 1) {
            boolean cell = yard.getStatus(row, column + 1) == '+';
            return cell;
        } else if  (direction == 2) {
            boolean cell = yard.getStatus(row + 1, column) == '+';
            return cell;
        } else if  (direction == 3) {
            boolean cell = yard.getStatus(row, column - 1) == '+';
            return cell;
        }
        return false;
    }


    // Cut the grass 
    public void cutGrass(Yard yard) {
        yard.setCellValue(row, column, 'x');

    }
 
}