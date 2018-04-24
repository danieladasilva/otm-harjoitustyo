
package fi.daniela.logics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayTest {
    
    private static Ball ball;
    private static Paddle paddle;
    
    public PlayTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void setBallFunctionsCorrectly() {
        Play.setBall(ball);
        assertEquals(ball, Play.getBall());
    }
    
    @Test
    public void setPaddleFunctionsCorrectly() {
        Play.setPaddle(paddle);
        assertEquals(paddle, Play.getPaddle());
    }
    
    
    @BeforeClass
    public static void setUpClass() {}
    @AfterClass
    public static void tearDownClass() {}
    @After
    public void tearDown() {}

}
