
package fi.daniela.logics;

import static fi.daniela.logics.Play.ballIntersectsBrick;
import java.awt.Rectangle;

/**
 * Class maintains information about the ball and offers methods related to it.
 * @author Daniela
 */
public class Ball {
    private int ballX;
    private int ballY;
    private int ballXdir;
    private int ballYdir;
    private final int ballDiameter;
    
    private static Paddle paddle; 
    
    public Ball() {
        this.ballX = 350; 
        this.ballY = 300;
        this.ballXdir = 1; 
        this.ballYdir = -2; 
        this.ballDiameter = 15;
    }
    
    /**
     * Method moves ball by changing its x- and y-coordinates.
     * 
     */
    public void move() {
        ballX += ballXdir;
        ballY += ballYdir;
    }
    
    /**
     * Method changes the ball's x-coordinate's direction.
     */
    public void changeDirectionX() {
        this.ballXdir = -ballXdir;
    }
    
    /**
     * Method changes  the ball's y-coordinate's direction.
     */
    public void changeDirectionY() {
        this.ballYdir = -ballYdir;
    }
    
    /**
     * Method creates a rectangle around the ball. 
     * @return rectangle created around the ball
     */
    public Rectangle createRectangle() {
        Rectangle ballRect = new Rectangle(this.ballX, this.ballY, this.ballDiameter, this.ballDiameter);
        return ballRect;
    }
    
    /**
     * Method checks if the ball intersects with the borders.
     */
    public void checkForBorders() {
        if (this.ballX < 3) {
            changeDirectionX();
        }
        if (this.ballX > 690 - this.ballDiameter) {
            changeDirectionX(); 
        }
        if (this.ballY < 3) {
            changeDirectionY();
        }
    }
    
    /**
     * Method checks if the ball intersects with the paddle.
     */
    public void checkForPaddle() { 
        Rectangle ballRect = createRectangle();
        Rectangle paddleRect = paddle.createRectangle();
        if (ballRect.intersects(paddleRect)) {
            changeDirectionY();
        }
    }
    
    public void checkForBricks() {
        outerloop:
            for (int i = 0; i < Play.getBrickwall().getVisible().length; i++) {
                for (int j = 0; j < Play.getBrickwall().getVisible()[0].length; j++) {
                    if (Play.getBrickwall().getVisible()[i][j] == 1) {
                       
                        Rectangle ballRect = createRectangle();
                        Rectangle brickRect = Brickwall.createRectangle(i, j);
                        
                        if (ballRect.intersects(brickRect)) {
                            ballIntersectsBrick(brickRect, i, j);
                            break outerloop;
                        }
                    }
                }
            }
    }
    
    /**
     * Method resets all the changed ball-values back to starting point.
     */
    public void resetStartingValues() {
        this.ballX = 350;
        this.ballY = 300;
        this.ballXdir = 1;
        this.ballYdir = -2; 
    }
    
    //getterit ja setterit
    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public int getBallXdir() {
        return ballXdir;
    }

    public int getBallYdir() {
        return ballYdir;
    }

    public int getBallDiameter() {
        return ballDiameter;
    }

    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public void setBallY(int ballY) {
        this.ballY = ballY;
    }

    public void setBallXdir(int ballXdir) {
        this.ballXdir = ballXdir;
    }

    public void setBallYdir(int ballYdir) {
        this.ballYdir = ballYdir;
    }

    public static void setPaddle(Paddle paddle) {
        Ball.paddle = paddle;
    }   
}
