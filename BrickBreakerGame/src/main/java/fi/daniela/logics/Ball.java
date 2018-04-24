
package fi.daniela.logics;

public class Ball {
    //oliomuuttujat
    private int ballX;
    private int ballY;
    private int ballXdir;
    private int ballYdir;
    private int ballDiameter;
    
    //kosntruktorit
    public Ball() {
        this.ballX = 350; //350
        this.ballY = 300;
        this.ballXdir = 1; //-1
        this.ballYdir = -2; //.2
        this.ballDiameter = 15;
    }
    
    //metodit
    public void changeDirectionX() {
        this.ballXdir = -ballXdir;
    }
    
    public void changeDirectionY() {
        this.ballYdir = -ballYdir;
    }
    
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

    public void setBallDiameter(int ballDiameter) {
        this.ballDiameter = ballDiameter;
    }
    

    
    
    
}
