
package fi.daniela.logics;

import java.awt.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BallTest {
    
    private Ball ball;
    private Paddle paddle;
    
    public BallTest() {
        this.ball = new Ball();
        this.paddle = new Paddle();
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void moveFunctionsCorrectly() {
        ball.move();
        assertEquals(351, ball.getBallX());
        assertEquals(298, ball.getBallY());
    }
    
    @Test
    public void changeDirectionXFunctionsCorrectly() {
        ball.changeDirectionX();
        assertEquals(-1, ball.getBallXdir());
    }
    
    @Test
    public void changeDirectionYFunctionsCorrectly() {
        ball.changeDirectionY();
        assertEquals(2, ball.getBallYdir());
    }
    
    @Test
    public void createRectangleFunctionsCorrectly() {
        Rectangle ballRect1 = new Rectangle(ball.getBallX(), ball.getBallY(), ball.getBallDiameter(), ball.getBallDiameter());
        Rectangle ballRect2 = ball.createRectangle();
        assertEquals(ballRect1, ballRect2);
    }
    
    @Test
    public void checkForBordersLeftFunctionsCorrectly() {
        ball.setBallX(2);
        ball.checkForBorders();
        assertEquals(-1, ball.getBallXdir());
    }
    
    @Test
    public void checkForBordersRightFunctionsCorrectly() {
        ball.setBallX(691);
        ball.checkForBorders();
        assertEquals(-1, ball.getBallXdir());
    }
    
    @Test
    public void checkForBordersTopFunctionsCorrectly() {
        ball.setBallY(2);
        ball.checkForBorders();
        assertEquals(2, ball.getBallYdir());
    }
    
    @Test
    public void ballDoesNotChangeDirectionWithoutIntersectingWithBorders() {
        for (int i = 3; i <= 690 - ball.getBallDiameter(); i++) {
            ball.setBallX(i);
            ball.checkForBorders();
            assertEquals(1, ball.getBallXdir());
        }
        for (int i = 3; i <= paddle.getPaddleY(); i++) {
            ball.setBallY(i);
            ball.checkForBorders();
            assertEquals(-2, ball.getBallYdir());
        }   
    }
    
    @Test
    public void resetStartingValuesFunctionsCorrectly() {
        ball.setBallX(22);
        ball.setBallY(33);
        ball.setBallXdir(44);
        ball.setBallYdir(55);
        ball.resetStartingValues();
        assertEquals(350, ball.getBallX());
        assertEquals(300, ball.getBallY());
        assertEquals(1, ball.getBallXdir());
        assertEquals(-2, ball.getBallYdir());
    }

}
