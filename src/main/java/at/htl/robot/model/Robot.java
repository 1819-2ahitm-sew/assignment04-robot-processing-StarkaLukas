package at.htl.robot.model;

public class Robot {

    private int x = 0;
    private int y = 0;
    private Direction direction = Direction.SOUTH;

    //region Getter and Setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    //endregion

    public void stepForward(int[][] fieldBox){
        switch (direction) {
            case SOUTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
            case NORTH:
                y--;
                break;
        }
        if (x < 0) {
            x = fieldBox[0].length - 1;
        } else if(x == fieldBox[0].length){
            x = 0;
        }
        else if (y < 0) {
            y = fieldBox.length - 1;
        } else if (y == fieldBox.length) {
            y = 0;
        }
    }

    public void rotateLeft() {
        switch (direction) {
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case NORTH:
                direction = Direction.WEST;
                break;
        }
    }
}
