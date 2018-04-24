
package fi.daniela.logics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BrickwallTest {
    
    Brickwall bw;
    
    public BrickwallTest() {
        this.bw = new Brickwall(4, 8);
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void setBrickValueFunctionsCorrectly() {
        assertEquals(1, bw.getVisible()[0][0]);
        bw.setBrickValue(0, 0, 0);
        assertEquals(0, bw.getVisible()[0][0]);
    }    
    
    
    
    
    
    @BeforeClass
    public static void setUpClass() {}
    @AfterClass
    public static void tearDownClass() {}
    @After
    public void tearDown() {}

}
