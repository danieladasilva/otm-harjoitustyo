
package fi.daniela.logics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaddleTest {
    
    private Paddle paddle;
    
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
    
//    @Test
//    public void moveRightRunningValueChanges() {
//        paddle.moveRight();
//        assertEquals(true, paddle.getRunning());
//    }
//    
//    @Test
//    public void moveLeftRunningValueChanges() {
//        paddle.moveLeft();
//        assertEquals(true, paddle.getRunning());
//    }
    
    
    @BeforeClass
    public static void setUpClass() {}
    @AfterClass
    public static void tearDownClass() {}
    @After
    public void tearDown() {}

}
