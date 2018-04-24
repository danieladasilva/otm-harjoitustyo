
package fi.daniela.logics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
    @BeforeClass
    public static void setUpClass() {}
    @AfterClass
    public static void tearDownClass() {}
    @After
    public void tearDown() {}


}
