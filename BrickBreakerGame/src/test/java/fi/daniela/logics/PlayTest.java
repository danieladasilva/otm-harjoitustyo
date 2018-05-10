
package fi.daniela.logics;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class PlayTest {
    
    private final Play play;
    
    private static Ball ball;
    private static Paddle paddle;
    private static Brickwall brickwall;
    private static Score score;
    
    public PlayTest() {
        this.play = new Play();
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void pauseFunctionsCorrectly() {
        Play.pause();
        assertEquals(false, Play.isRunning());
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
    
    @Test
    public void setScoreFunctionsCorrectly() {
        Play.setScore(score);
        assertEquals(score, Play.getScore());
    }
    
    @Test
    public void setBrickwallFunctionsCorrectly() {
        Play.setBrickwall(brickwall);
        assertEquals(brickwall, Play.getBrickwall());
    }
    
    @Test
    public void setRunningFunctionsCorrectly() {
        Play.setRunning(true);
        assertEquals(true, Play.isRunning());
    }
    
    @Test
    public void setGameOverFunctionsCorrectly() {
        Play.setGameOver(true);
        assertEquals(true, Play.isGameOver());
    }

}
