
package fi.daniela.logics;

import java.awt.Rectangle;

/**
 * Class maintains information about the paddle and offers methods related to it.
 * @author Daniela
 */
public class Paddle {
    
    private int paddleX;
    private int paddleY;
    private int paddleWidth;
    private int paddleHeight;
    
    public Paddle() {
        this.paddleX = 350;
        this.paddleY = 550;
        this.paddleWidth = 100;
        this.paddleHeight = 15;
    }
    
    /**
     * Method resets all the changed paddle-values back to starting point.
     */
    public void resetStartingValues() {
        this.paddleX = 350;
        this.paddleY = 550;
    }
    
    /**
     * Method changes paddles position to the right by 20 steps.
     */
    public void moveRight() {
        if (this.paddleX + 20 >= 600) {
            this.paddleX = 600;
        } else {
            this.paddleX += 20;
        }    
    }
    
    /**
     * Method changes paddles position to the left by 20 steps.
     */
    public void moveLeft() {
        if (this.paddleX - 20 <= 3) {
            this.paddleX = 3; 
        } else {
            this.paddleX -= 20;
        }    
    }
    
    /**
     * Method creates a rectangle around the paddle.
     * @return created rectangle 
     */
    public Rectangle createRectangle() {
        Rectangle paddleRect = new Rectangle(this.paddleX, this.paddleY, this.paddleWidth, this.paddleHeight);
        return paddleRect;
    }
    
    public int getPaddleX() {
        return paddleX;
    }

    public int getPaddleY() {
        return paddleY;
    }

    public int getPaddleWidth() {
        return paddleWidth;
    }

    public int getPaddleHeight() {
        return paddleHeight;
    }

    public void setPaddleX(int paddleX) {
        this.paddleX = paddleX;
    }

    public void setPaddleY(int paddleY) {
        this.paddleY = paddleY;
    }

    public void setPaddleWidth(int paddleWidth) {
        this.paddleWidth = paddleWidth;
    }

    public void setPaddleHeight(int paddleHeight) {
        this.paddleHeight = paddleHeight;
    }   
}
