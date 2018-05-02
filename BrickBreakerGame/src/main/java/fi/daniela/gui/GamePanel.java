package fi.daniela.gui;

import fi.daniela.logics.Ball;
import fi.daniela.logics.Brickwall;
import fi.daniela.logics.Paddle;
import fi.daniela.logics.Play;
import fi.daniela.logics.Score;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //oliomuuttujat
    private Timer timer;
    private int delay = 8; 
    
    public Brickwall brickwall;
    public Ball ball;
    public Paddle paddle;
    public Score score;
    
    //konstruktorit
    public GamePanel() { 
        brickwall = new Brickwall(4, 8);
        this.ball = new Ball();
        this.paddle = new Paddle();
        this.score = new Score();
        timer = new Timer(8, this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer.start();
        //KOKEILUA
        Play.setBall(this.ball);
        Play.setPaddle(this.paddle);
        Play.setScore(score);
        Play.setBrickwall(brickwall);
    }
    
    //metodit 
    @Override
    public void paint(Graphics g) {     
        //background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
        
        //brickwall
        brickwall.draw((Graphics2D) g);
       
        //borders
        g.setColor(Color.pink);
        g.fillRect(0, 0, 3, 592); //left 592
        g.fillRect(0, 0, 692, 3); //top
        g.fillRect(691, 0, 3, 592); //right
        
        //paddle
        g.setColor(Color.white);
        g.fillRect(paddle.getPaddleX(), paddle.getPaddleY(), paddle.getPaddleWidth(), paddle.getPaddleHeight());
        
        //ball
        g.setColor(Color.pink);
        g.fillOval(ball.getBallX(), ball.getBallY(), ball.getBallDiameter(), ball.getBallDiameter());
        
        //score
        g.setColor(Color.white);
        g.setFont(new Font("sans serif", Font.BOLD, 30));
        g.drawString(Integer.toString(score.getScore()), score.getScoreX(), score.getScoreY());
        
        //game over
        if (ball.getBallY() > 570) {
            Play.setGameOver(true);
            Play.setRunning(false);
            g.setColor(Color.red);
            g.drawString("GAME OVER", 200, 300);
        }
        
        //you won
        if (brickwall.getNumberOfBricks() <= 0) {
            Play.setGameOver(true);
            Play.setRunning(false);
            g.setColor(Color.green);
            g.drawString("YOU WON", 270, 250);
            g.setFont(new Font("sans serif", Font.BOLD, 20));
            g.drawString("Press enter to play again", 225, 300);
        }
        
        g.dispose();    
    }
    
    public void restartTheGame() { //tää pois gamepanelista?????
          brickwall = Play.restartTheGame();
          repaint();
    }
    

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Play.setRunning(true);
            paddle.moveRight();
        }    
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Play.setRunning(true);
            paddle.moveLeft();
        } 
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Play.isGameOver()) { //jos peli on loppu
                if (Play.isRunning() == false) { //ja peli ei oo käynnissä
                restartTheGame();
                }
            } else { //jos peli ei oo loppu
                if (Play.isRunning() == false) {
                    Play.unpause();
                }
                if (Play.isRunning() == true) {
                    Play.pause(); //asettaa running = false
                }
                
            } 
        }    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        Play.play();
        repaint();
    }
    
    //turhia?
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    
}
