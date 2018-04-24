
package fi.daniela.logics;

public class Paddle {
    //oliomuuttujat
    private int paddleX;
    private int paddleY;
    private int paddleWidth;
    private int paddleHeight;
    
    //konstruktorit
    public Paddle() {
        this.paddleX = 350;
        this.paddleY = 550;
        this.paddleWidth = 100;
        this.paddleHeight = 15;
    }
    
    //metodit
    public void resetStartingValues() {
        this.paddleX = 350;
        this.paddleY = 550;
    }
    
    public void moveRight() {
        //running = true;
        if (this.paddleX + 20 >= 600) {
            this.paddleX = 600;
        } else {
            this.paddleX += 20;
        }    
    }
    
    public void moveLeft() {
        //running = true;
        if (this.paddleX - 20 <= 3) {
            this.paddleX = 3; 
        } else {
            this.paddleX -= 20;
        }    
    }
    
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
