
package fi.daniela.logics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BallTest {
    
    private Ball ball;
    
    public BallTest() {
        this.ball = new Ball();
    }
    
    @Before
    public void setUp() {
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
    
    
    
    
    
    
    
    
    
    
    
    @BeforeClass
    public static void setUpClass() {}
    @AfterClass
    public static void tearDownClass() {}
    @After
    public void tearDown() {}

}
