package com.mycompany.mavenproject;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements KeyListener, ActionListener {
    
    //class variables
    
    private boolean running = false;
    
    private int ballX = 350; //350
    private int ballY = 300;
    private int ballXdir = 1; //-1
    private int ballYdir = -2; //-2
    private int ballDiameter = 15;
    
    private int paddleX = 350;
    private int paddleY = 550;
    private int paddleWidth = 100;
    private int paddleHeight = 15;
    
    private Timer timer;
    private int delay = 8;
    
    private Rectangle ball = new Rectangle(ballX, ballY, ballDiameter, ballDiameter);
    private Rectangle paddle = new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);
    
    //private int score;
    //private int numberOfBricks = 21;
    
    //constuctor(s)
    
    public GamePanel() { 
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(8, this);
        timer.start();
    }
    
    
    //methods 
    
    public void paint(Graphics g) {
        //background
        g.setColor(Color.black);
        //g.fillRect(1, 1, 700, 600);
        g.fillRect(1, 1, 692, 592);
       
        //borders
        g.setColor(Color.pink);
        //x, y, leveys=700,korkeus=600
        g.fillRect(0, 0, 3, 592); //left 592
        g.fillRect(0, 0, 692, 3); //top
        g.fillRect(691, 0, 3, 592); //right
        
        //paddle
        g.setColor(Color.white);
        g.fillRect(paddleX, 550, 100, 15);
        
        //ball
        g.setColor(Color.pink);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
        
        g.dispose();
        
    }
    
    public void moveRight() {
        running = true;
        if (paddleX + 20 >= 600) {
                paddleX = 600;
        } else {
            paddleX = paddleX + 20;
        }    
    }
    public void moveLeft() {
        running = true;
        if (paddleX - 20 <= 3) {
                paddleX = 3; 
        } else {
            paddleX = paddleX - 20;
        }    
    }

    @Override
    public void keyPressed(KeyEvent e){
        //running = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        }    
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        }    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (running) {
            if (new Rectangle(ballX, ballY, ballDiameter, ballDiameter).intersects
        (new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight))) {
                ballYdir = -ballYdir;
                
            }
            ballX = ballX + ballXdir;
            ballY = ballY + ballYdir;
            if (ballX < 3) { //left border
                ballXdir = -ballXdir; 
            }
            if (ballX > 690 - ballDiameter) { //right border 675 = 690 - 15
                ballXdir = -ballXdir; 
            }
            if (ballY < 3) { //top border
                ballYdir = -ballYdir;
            }
        }
        repaint();
    }

    //getterit ja setterit
    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public int getPaddleX() {
        return paddleX;
    }

    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public void setPaddleX(int paddleX) {
        this.paddleX = paddleX;
    }
    
    
    
    
    
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    
}
