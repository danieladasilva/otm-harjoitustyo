
package fi.daniela.logics;

import java.awt.Rectangle;

/**
 * Class maintains information about the game play and offers methods related to it.
 * @author Daniela
 */
public class Play {
    
    private static Brickwall brickwall;
    private static Ball ball;
    private static Paddle paddle;
    private static Score score;
    
    private static boolean running = false;
    private static boolean gameOver;
    
    /**
     * Method to restart the game. Resets all changed values back to starting point.
     * @return new brickwall
     */
    public static Brickwall restartTheGame() {
        running = true;
        ball.resetStartingValues();
        paddle.resetStartingValues();
        score.reset();   
        brickwall = new Brickwall(4, 8);
        gameOver = false;
        return brickwall;
    }
    
    /**
     * Method pauses the game.
     */
    public static void pause() {
        running = false;
    }
    
    /**
     * Method unpauses the game.
     */
    public static void unpause() {
        running = true;
        //play();  ei toimi testien kanssa?? null pointer exception 
    }
 
    /**
     * Method activates the game if its running.
     */
    public static void play() {
        if (running) {

            ball.checkForPaddle(); //tarkista osuminen lautaan
            //ball.checkForBricks();
            //osuminen tiileihin
            outerloop:
            for (int i = 0; i < brickwall.getVisible().length; i++) {
                for (int j = 0; j < brickwall.getVisible()[0].length; j++) {
                    if (brickwall.getVisible()[i][j] == 1) { //jos tiili on näkyvissä
                       
                        Rectangle ballRect = ball.createRectangle();
                        Rectangle brickRect = createRectangleAroundTheBrick(i, j);
                        
                        if (ballRect.intersects(brickRect)) {
                            ballIntersectsBrick(brickRect, i, j);
                            break outerloop;
                        }
                    }
                }
            }                
            ball.move(); //liikuta palloa
            ball.checkForBorders(); //tarkista osuminen reunoihin
        }
    }
    
    /**
     * METHOD UNFINISHED!!
     * @param brickRect
     * @param i
     * @param j 
     */
    public static void ballIntersectsBrick(Rectangle brickRect, int i, int j) {
        brickwall.setBrickValue(0, i, j);
        score.raiseScore();
        brickwall.setNumberOfBricks(brickwall.getNumberOfBricks() - 1);
        if (ball.getBallX() + 19 <= brickRect.getX() || ball.getBallX() + 1 >= brickRect.getX() + brickwall.getBrickWidth()) {
            ball.changeDirectionX();
        } else {
            ball.changeDirectionY();
        }
    }
    
    /**
     * Method creates a rectangle around a brick/brickwall.
     * @param i row (visible[][])
     * @param j column (visible[][])
     * @return rectangle created around a brick/brickwall
     */
    public static Rectangle createRectangleAroundTheBrick(int i, int j) {
        int brickX = j * brickwall.getBrickWidth() + 80;
        int brickY = i * brickwall.getBrickHeight() + 50;
        int brickWidth = brickwall.getBrickWidth();
        int brickHeight = brickwall.getBrickHeight();
                        
        Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
        
        return brickRect;
        
    }
    
    //getters and setters
    public static Ball getBall() {
        return ball;
    }

    public static Paddle getPaddle() {
        return paddle;
    }
    
    public static Score getScore() {
        return score;
    }
    
    public static Brickwall getBrickwall() {
        return brickwall;
    }

    public static void setBall(Ball ball) {
        Play.ball = ball;
    }

    public static void setPaddle(Paddle paddle) {
        Play.paddle = paddle;
        Ball.paddle = paddle;
    }

    public static void setScore(Score score) {
        Play.score = score;
        Ball.score = score;
    }

    public static void setBrickwall(Brickwall brickwall) {
        Play.brickwall = brickwall;
        Ball.brickwall = brickwall;
    }

    public static boolean isRunning() {
        return running;
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setRunning(boolean running) {
        Play.running = running;
    }

    public static void setGameOver(boolean gameOver) {
        Play.gameOver = gameOver;
    }
    
    
    
}
