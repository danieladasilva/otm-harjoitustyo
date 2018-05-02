
package fi.daniela.logics;

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
    private int ballDiameter;
    
    public static Paddle paddle; //NÄÄ PRIVATEIKS?
    public static Brickwall brickwall;
    public static Score score;
    
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
     * Method changes ball x-coordinate direction.
     */
    public void changeDirectionX() {
        this.ballXdir = -ballXdir;
    }
    
    
    /**
     * Method changes ball y-coordinate direction.
     */
    public void changeDirectionY() {
        this.ballYdir = -ballYdir;
    }
    
    /**
     * Method creates a rectangle around the ball and returns it. 
     * @return rectangle created around the ball
     */
    public Rectangle createRectangle() {
        Rectangle ballRect = new Rectangle(this.ballX, this.ballY, this.ballDiameter, this.ballDiameter);
        return ballRect;
    }
    
    /**
     * Method checks if ball intersects with the borders.
     */
    public void checkForBorders() {
        if (this.ballX < 3) { //left border
            changeDirectionX();
        }
        if (this.ballX > 690 - this.ballDiameter) { //right border 675 = 690 - 15
            changeDirectionX(); 
        }
        if (this.ballY < 3) { //top border
            changeDirectionY();
        }
    }
    
    /**
     * Method checks if ball intersects with the paddle.
     */
    public void checkForPaddle() { //RAMI AUTTAA? MITEN PADDLEN RECTANGLE LUODAAN PADDLEM OMASSA LUOKASSA
        Rectangle ballRect = createRectangle();
        //Rectangle paddleRect = createRectangle();
        Rectangle paddleRect = new Rectangle(paddle.getPaddleX(), paddle.getPaddleY(), paddle.getPaddleWidth(), paddle.getPaddleHeight());
        if (ballRect.intersects(paddleRect)) {
            changeDirectionY();
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



    
    
    
    
    
    
    

    
    
    
}
