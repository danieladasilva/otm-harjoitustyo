
package fi.daniela.logics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brickwall {
    //oliomuuttujat
    public int brickWidth;
    public int brickHeight;
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
    public void setBrickValue(int value, int row, int column) {
        visible[row][column] = value;
    }
    
    public void draw(Graphics2D g) {
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
    
    
    
        
    
        
    
}
