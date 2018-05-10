
package fi.daniela.logics;

import java.awt.Rectangle;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class PaddleTest {
    
    private final Paddle paddle;
    
    public PaddleTest() {
        this.paddle = new Paddle();
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void moveRightFunctionsCorrectly() {
        paddle.moveRight();
        assertEquals(370, paddle.getPaddleX());
        paddle.setPaddleX(595);
        paddle.moveRight();
        assertEquals(600, paddle.getPaddleX());
    }
    
    @Test
    public void moveLeftFunctionsCorrectly() {
        paddle.moveLeft();
        assertEquals(330, paddle.getPaddleX());
        paddle.setPaddleX(5);
        paddle.moveLeft();
        assertEquals(3, paddle.getPaddleX());
    }
    
    @Test
    public void resetStartingValuesFunctionsCorrectly() {
        paddle.setPaddleX(33);
        paddle.setPaddleY(44);
        paddle.resetStartingValues();
        assertEquals(350, paddle.getPaddleX());
        assertEquals(550, paddle.getPaddleY());
    }
    
    @Test
    public void createRectangleFunctionsCorrectly() {
        Rectangle paddleRect1 = new Rectangle(paddle.getPaddleX(), paddle.getPaddleY(), paddle.getPaddleWidth(), paddle.getPaddleHeight());
        Rectangle paddleRect2 = paddle.createRectangle();
        assertEquals(paddleRect1, paddleRect2);
    }
    
    @Test
    public void getPaddleWidthFunctionsCorrectly() {
        paddle.setPaddleWidth(400);
        assertEquals(400, paddle.getPaddleWidth());
    } 
    
    @Test
    public void getPaddleHeightFunctionsCorrectly() {
        paddle.setPaddleHeight(400);
        assertEquals(400, paddle.getPaddleHeight());
    }

}
