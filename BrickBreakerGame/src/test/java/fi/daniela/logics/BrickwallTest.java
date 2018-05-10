
package fi.daniela.logics;

import java.awt.Rectangle;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BrickwallTest {
    
    Brickwall brickwall;
    
    public BrickwallTest() {
        this.brickwall = new Brickwall(4, 8);
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void brickwallConstructorTest() {
        brickwall = new Brickwall(1, 2);
        assertEquals(270, brickwall.getBrickWidth());
        assertEquals(150, brickwall.getBrickHeight());
        assertEquals(2, brickwall.getNumberOfBricks());
        
    }
    
    @Test
    public void getBrickWidthFunctionsCorrectly() {
        brickwall.setBrickWidth(400);
        assertEquals(400, brickwall.getBrickWidth());
    } 
    
    @Test
    public void getBrickHeightFunctionsCorrectly() {
        brickwall.setBrickHeight(400);
        assertEquals(400, brickwall.getBrickHeight());
    }
    
    @Test
    public void getNumberOfBricksFunctionsCorrectly() {
        brickwall.setNumberOfBricks(12);
        assertEquals(12, brickwall.getNumberOfBricks());
    }
    
    @Test
    public void getBrickValueFunctionsCorrectly() {
        brickwall.setBrickValue(3, 2, 2);
        assertEquals(3, brickwall.getBrickValue(2, 2));
    }
    
    @Test
    public void setBrickValueFunctionsCorrectly() {
        assertEquals(1, brickwall.getVisible()[0][0]);
        brickwall.setBrickValue(0, 0, 0);
        assertEquals(0, brickwall.getVisible()[0][0]);
    }

    @Test
    public void createRectangleFunctionsCorrectly() {
        int brickX = 2 * brickwall.getBrickWidth() + 80;
        int brickY = 2 * brickwall.getBrickHeight() + 50;
        int brickWidth = brickwall.getBrickWidth();
        int brickHeight = brickwall.getBrickHeight();
                        
        Rectangle brickRect1 = new Rectangle(brickX, brickY, brickWidth, brickHeight);
        Rectangle brickRect2 = Brickwall.createRectangle(2, 2);
        assertEquals(brickRect1, brickRect2);
    }
    
}
