
package fi.daniela.logics;

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
        //running = true;
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
        //running = true;
        if (this.paddleX - 20 <= 3) {
            this.paddleX = 3; 
        } else {
            this.paddleX -= 20;
        }    
    }
    
//    public Rectangle createRectangle() { //RAMI AUTTAA
//        Rectangle paddleRect = new Rectangle(Play.getPaddle().paddleX, Play.getPaddle().paddleY, Play.getPaddle().paddleWidth, Play.getPaddle().paddleHeight);
//        //Rectangle paddleRect = new Rectangle(paddle.getPaddleX(), paddle.getPaddleY(), paddle.getPaddleWidth(), paddle.getPaddleHeight());
//        return paddleRect;
//    }
    
    //getterit ja setterit
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
