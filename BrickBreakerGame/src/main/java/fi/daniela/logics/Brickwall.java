
package fi.daniela.logics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Class maintains information about the brickwall and offers methods related to it.
 * @author Daniela
 */
public class Brickwall {
    private static int brickWidth;
    private static int brickHeight;
    private int numberOfBricks;
    private final int visible[][];
    
    public Brickwall(int rows, int columns) {
        visible = new int[rows][columns];
        for (int[] visible1 : visible) {
            for (int j = 0; j < visible[0].length; j++) {
                visible1[j] = 1;
            }
        }    
        Brickwall.brickWidth = 540 / columns;
        Brickwall.brickHeight = 150 / rows;
        this.numberOfBricks = rows * columns;
    }
    
    /**
     * Method sets the brick value (1 = visible, 0 = not visible).
     * @param value 1 = visible, 0 = not visible
     * @param row row
     * @param column column
     */
    public void setBrickValue(int value, int row, int column) {
        visible[row][column] = value;
    }
    
    /**
     * Method draws the brickwall.
     * @param g Graphics2D g
     */
    public void draw(Graphics2D g) {
        for (int i = 0; i < visible.length; i++) {
            for (int j = 0; j < visible[0].length; j++) {
                if (visible[i][j] == 1) {
                    g.setColor(Color.cyan);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    
                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }    
    }
    
    /**
     * Method creates a rectangle around a brick/brickwall.
     * @param i row (visible[][])
     * @param j column (visible[][])
     * @return rectangle created around a brick/brickwall
     */
    public static Rectangle createRectangle(int i, int j) {
        int brickX = j * Brickwall.brickWidth + 80;
        int brickY = i * Brickwall.brickHeight + 50;
        int width = Brickwall.brickWidth;
        int height = Brickwall.brickHeight;
        Rectangle brickRect = new Rectangle(brickX, brickY, width, height);
        return brickRect;
    }
    
    public int getBrickWidth() {
        return brickWidth;
    }

    public int getBrickHeight() {
        return brickHeight;
    }

    public int[][] getVisible() {
        return visible;
    }

    public int getNumberOfBricks() {
        return numberOfBricks;
    }

    public void setBrickWidth(int brickWidth) {
        Brickwall.brickWidth = brickWidth;
    }

    public void setBrickHeight(int brickHeight) {
        Brickwall.brickHeight = brickHeight;
    }
    
    public void setNumberOfBricks(int numberOfBricks) {
        this.numberOfBricks = numberOfBricks;
    }
    
    public int getBrickValue(int row, int column) {
        return visible[row][column];
    }  
}
