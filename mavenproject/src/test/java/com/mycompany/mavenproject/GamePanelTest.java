package com.mycompany.mavenproject;


import com.mycompany.mavenproject.GamePanel;
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
    
    @Test
    public void moveRightFunctionsCorrectly() {
        gp.moveRight();
        assertEquals(360, gp.getPaddleX());
        gp.setPaddleX(595);
        gp.moveRight();
        assertEquals(600, gp.getPaddleX());
    }
    
    @Test
    public void moveLeftFunctionsCorrectly() {
        gp.moveLeft();
        assertEquals(340, gp.getPaddleX());
        gp.setPaddleX(5);
        gp.moveLeft();
        assertEquals(0, gp.getPaddleX());
    }
    
    
    
    
    
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
}
