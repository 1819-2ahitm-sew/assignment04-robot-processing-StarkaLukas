/*
    Von: Lukas Starka
 */
package at.htl.robot.gui;
import at.htl.robot.model.Robot;
import processing.core.PApplet;

public class Main extends PApplet {


    private int width = 800;
    private int height = 800;
    private int marginTop = 100;
    private int marginLeft = 100;
    private int fieldHeight = 0;
    private int fieldWidth = 0;
    private float fieldBoxWidth = 0f;
    private float fieldBoxHeight = 0f;
    public static int[][] fieldBox = new int[8][8];
    private Robot robot = new Robot();
    private char stepForward = 'F';
    private char stepForward2 = 'f';
    private char rotateLeft = 'L';
    private char rotateLeft2 = 'l';
    private int xText = 10;
    private int yText = 0;
    private float textSize = 0f;
    private int robotRadius = 0;
    private int x = 0;
    private int y = 0;
    private char lastKey = '0';

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(width, height);
    }

    public void setup() {
        background(0);
    }

    public void draw() {

        keyPressed();
        drawText();
        drawField();
        drawFieldBox();
        drawRobot();
        drawView();
    }

    private void drawView() {
        x = robot.getX();
        y = robot.getY();

        switch (robot.getDirection()) {
            case NORTH:
                    y--;
                break;
            case EAST:
                    x++;
                break;
            case SOUTH:
                    y++;
                break;
            case WEST:
                    x--;
                break;
        }
        if (x < 0) {
            x = fieldBox[0].length - 1;
        } else if (x == fieldBox.length) {
            x = 0;
        }
        if (y < 0) {
            y = fieldBox.length - 1;
        } else if (y == fieldBox.length) {
            y = 0;
        }
        fill(255, 224, 0);
        rect(marginLeft + (x * fieldBoxWidth),marginTop + (y * fieldBoxHeight), fieldBoxWidth, fieldBoxHeight);

        x = 0;
        y = 0;
    }

    private void drawText() {

        yText = marginTop / 2;
        textSize = Math.min(marginTop, marginLeft) / 4f;

        fill(255);
        textSize(textSize);

        text("Omicron - the little Robot", xText, yText);
        text("<" + stepForward + "> ... 1 Schritt vorwärts, <" + rotateLeft + "> ... Drehe nach links", xText, yText + textSize);

    }

    private void drawFieldBox() {
        for (int i = 0; i < fieldBox.length; i++) {
            for (int j = 0; j < fieldBox[i].length; j++) {

                rect(marginLeft + (j * fieldBoxWidth),marginTop + (i * fieldBoxHeight),fieldBoxWidth,fieldBoxHeight);
            }
        }
    }

    private void drawField() {
        fieldHeight = height - (2 * marginTop);
        fieldWidth = width - (2 * marginLeft);

        fill(163, 102, 56);
        rect(marginLeft, marginTop, fieldWidth, fieldHeight);

        fieldBoxHeight =(float) fieldHeight / fieldBox[0].length;
        fieldBoxWidth = (float) fieldWidth / fieldBox.length;
    }

    public void drawRobot() {

        robotRadius = (int) (Math.min(fieldBoxWidth, fieldBoxHeight) / 2);

        fill(191, 186, 171);
        ellipse(marginLeft + (robot.getX() * fieldBoxWidth) + (fieldBoxWidth / 2), marginTop + (robot.getY() * fieldBoxHeight) + (fieldBoxHeight / 2), robotRadius, robotRadius);
    }
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if((key == stepForward) && (lastKey == stepForward)) {
        }
        else if ((key == stepForward2) && (lastKey == stepForward2)) {
        } else if ((key == rotateLeft) && (lastKey == rotateLeft)) {

        } else if ((key == rotateLeft2) && (lastKey == rotateLeft2)) {

        }
        else {
            if ((key == stepForward || key == stepForward2) && (keyPressed)) {
                robot.stepForward(fieldBox);
            } else if ((key == rotateLeft || key == rotateLeft2) && (keyPressed)) {
                robot.rotateLeft();
            }
        }
        lastKey = key;
        key = '%';
    }
}
