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
    private final Timer timer;
    private final int delay; 
    
    private Brickwall brickwall;
    private final Ball ball;
    private final Paddle paddle;
    private final Score score;
    
    public GamePanel() { 
        brickwall = new Brickwall(4, 8);
        this.ball = new Ball();
        this.paddle = new Paddle();
        this.score = new Score();
        this.delay = 8;
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
       
        timer = new Timer(delay, this);
        timer.start();
       
        Play.setBall(this.ball);
        Play.setPaddle(this.paddle);
        Play.setScore(this.score);
        Play.setBrickwall(this.brickwall);   
    }
     
    @Override
    public void paint(Graphics g) {     
        paintBackground(g);
        paintBrickwall(g);
        paintBorders(g);
        paintPaddle(g);
        paintBall(g);
        paintScore(g);
        paintHighScore(g);
        
        paintGameOver(g);
        paintWin(g);
        
        g.dispose();    
    }
    public void restartTheGame() {
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
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (Play.isRunning() == true) {
               Play.pause();
            } else {
                Play.unpause();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(Play.isGameOver() == true) {
                if (Play.isRunning() == false) {
                    restartTheGame();
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
    
    public void paintBackground(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
    }
    
    public void paintBrickwall(Graphics g) {
        brickwall.draw((Graphics2D) g);
    }
    
    public void paintBorders(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
    }
    
    public void paintPaddle(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(paddle.getPaddleX(), paddle.getPaddleY(), paddle.getPaddleWidth(), paddle.getPaddleHeight());
    }
    
    public void paintBall(Graphics g) {
        g.setColor(Color.pink);
        g.fillOval(ball.getBallX(), ball.getBallY(), ball.getBallDiameter(), ball.getBallDiameter());
    }
    
    public void paintScore(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("sans serif", Font.BOLD, 30));
        g.drawString(Integer.toString(score.getScore()), score.getScoreX(), score.getScoreY());
    }
    
    public void paintHighScore(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("sans serif", Font.BOLD, 20));
        String highscore = "";
        try {
            highscore = String.valueOf(Play.getHighscore());
        } catch(Exception e){}
        g.drawString("Highscore: " + highscore, 10, score.getScoreY());
    }
    
    public void paintGameOver(Graphics g) {
        if (ball.getBallY() > 570) {
            Play.setGameOver(true);
            Play.setRunning(false);
            Play.updateHighscore();
            
            g.setColor(Color.red);
            String highscore = "";
            g.drawString("GAME OVER", 200, 300);
            try {
                highscore = String.valueOf(Play.getHighscore());
            } catch(Exception e){}
            g.drawString("HIGHSCORE: " + highscore, 200, 350); 
            g.drawString("Press enter to play again", 200, 400);
        }
    }
    
    public void paintWin(Graphics g) {
        if (brickwall.getNumberOfBricks() <= 0) {
            Play.setGameOver(true);
            Play.setRunning(false);
            Play.updateHighscore();
            
            g.setColor(Color.green);
            g.drawString("YOU WON", 270, 250);
            g.setFont(new Font("sans serif", Font.BOLD, 20));
            g.drawString("Press enter to play again", 225, 300);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}   
}
