
package fi.daniela.logics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class maintains information about the brickwall and offers methods related to it.
 * @author Daniela
 */
public class Brickwall {
    //oliomuuttujat
    private int brickWidth;
    private int brickHeight;
    private int numberOfBricks;
    private int visible[][];
    
    //konstruktorit
    public Brickwall(int rows, int columns) {
        visible = new int[rows][columns];
        for (int i = 0; i < visible.length; i++) { //rivien määrä
            for (int j = 0; j < visible[0].length; j++) { //sarakkeiden määrä
                visible[i][j] = 1; //kun arvo on 1, niin tiili näkyvissä
            }
        }    
        this.brickWidth = 540 / columns;
        this.brickHeight = 150 / rows;
        this.numberOfBricks = rows * columns;
    }
    
    //metodit
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
    public void draw(Graphics2D g) { //KUULUUKO TÄNNE? VAI GAMEPANEL?
        for (int i = 0; i < visible.length; i++) {
            for (int j = 0; j < visible[0].length; j++) {
                if (visible[i][j] == 1) {
                    g.setColor(Color.cyan); //tiilien väri
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    
                    g.setStroke(new BasicStroke(1)); //välien paksuus
                    g.setColor(Color.black); //välien väri
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }    
    }
    
    //getterit ja setterit
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
        this.brickWidth = brickWidth;
    }

    public void setBrickHeight(int brickHeight) {
        this.brickHeight = brickHeight;
    }
    
    public void setNumberOfBricks(int numberOfBricks) {
        this.numberOfBricks = numberOfBricks;
    }
    
    public int getBrickValue(int row, int column) {
        return visible[row][column];
    }
    
    
    
        
    
        
    
}
