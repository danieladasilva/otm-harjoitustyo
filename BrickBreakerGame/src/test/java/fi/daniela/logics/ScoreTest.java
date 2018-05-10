
package fi.daniela.logics;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ScoreTest {
    
    Score score;
    
    public ScoreTest() {
        this.score = new Score();
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void raiseScoreFunctionsCorrectly() {
        assertEquals(0, score.getScore());
        score.raiseScore();
        score.raiseScore();
        assertEquals(10, score.getScore());
    }
    
    @Test
    public void resetScoreFunctionsCorrectly() {
        score.setScore(90);
        score.reset();
        assertEquals(0, score.getScore());
    }
    
    @Test
    public void getScoreXFunctionsCorrectly() {
        score.setScoreX(90);
        assertEquals(90, score.getScoreX());
    }
    
    @Test
    public void getScoreYFunctionsCorrectly() {
        score.setScoreY(90);
        assertEquals(90, score.getScoreY());
    }
    
}
