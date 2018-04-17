
package fi.daniela.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class BrickwallGenerator {
    
    private int array[][];
    private int brickWidth;
    private int brickHeight;
    //private int rows;
    //private int columns;
    
    public BrickwallGenerator(int rows, int columns) {
        //this.rows = rows;
        //this.columns = columns;
        array = new int[rows][columns];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 1;
            }
        }
        this.brickWidth = 540 / columns;
        this.brickHeight = 150 / rows;
    }
    
    public void draw(Graphics2D g) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > 0) {
                    g.setColor(Color.cyan); //tiilien väri
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    
                    g.setStroke(new BasicStroke(1)); //välien paksuus
                    g.setColor(Color.black); //välien väri
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }    
    }
    
}
