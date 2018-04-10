package com.mycompany.mavenproject;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements KeyListener, ActionListener {
    
    //class variables
    
    private boolean play = false;
    
    private int ballX = 350;
    private int ballY = 150;
    
    private int paddleX = 350;
    
    private Timer timer;
    private int delay = 8;
    
    
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
        g.fillRect(1, 1, 692, 592);
       
        //borders
        g.setColor(Color.red);
        //x, y, leveys=700,leveys=600
        g.fillRect(0, 0, 3, 592); //left
        g.fillRect(0, 0, 692, 3); //top
        g.fillRect(691, 0, 3, 592); //right
        
        //paddle
        g.setColor(Color.white);
        g.fillRoundRect(paddleX, 550, 100, 15, 3, 3);
        
        //ball
        g.setColor(Color.orange);
        g.fillOval(ballX, ballY, 15, 15);
        
    }
    
    public void moveRight() {
        if (paddleX + 10 >= 600) {
                paddleX = 600;
        } else {
            paddleX = paddleX + 10;
        }    
    }
    
    public void moveLeft() {
        if (paddleX - 10 <= 0) {
                paddleX = 0; 
        } else {
            paddleX = paddleX - 10;
        }    
    }

    @Override
    public void keyPressed(KeyEvent e){
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
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
