package fi.daniela.gui;


import fi.daniela.gui.GamePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GamePanelTest {
    
    GamePanel gp;
    
    @Before
    public void setUp() {
        gp = new GamePanel();
    }
    
//    @Test
//    public void actionPerformedChangesBallXAndBallYCorrectly() {
//        ActionEvent e = mock(ActionEvent.class);
//        gp.setRunning(true);
//        gp.actionPerformed(e);
//        assertEquals(351, gp.getBallX());
//        assertEquals(298, gp.getBallY());      
//    }
    
    
    
    
//    public GamePanelTest() {
//    }
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    @After
//    public void tearDown() {
//    }
//
//    private ActionEvent mock(Class<ActionEvent> aClass) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
