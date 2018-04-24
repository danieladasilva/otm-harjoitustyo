
package fi.daniela.logics;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Play {
    
    private static Brickwall brickwall;
    private static Ball ball;
    private static Paddle paddle;
    private static Score score;
    private static boolean running = false;
    
    public static Brickwall restartTheGame() {
        running = true;
        ball.resetStartingValues();
        paddle.resetStartingValues();
        score.reset();   
        brickwall = new Brickwall(4, 8);
        return brickwall;
    } 
 
    public static void play() {
        if (running) { //osuminen lautaan
            if (new Rectangle(ball.getBallX(), ball.getBallY(), ball.getBallDiameter(), ball.getBallDiameter()).intersects(new Rectangle(paddle.getPaddleX(), paddle.getPaddleY(), paddle.getPaddleWidth(), paddle.getPaddleHeight()))) {
                ball.changeDirectionY();    
            }
            
            //osuminen tiileihin
            outerloop:
            for (int i = 0; i < brickwall.getVisible().length; i++) {
                for (int j = 0; j < brickwall.getVisible()[0].length; j++) {
                    if (brickwall.getVisible()[i][j] == 1) {
                        
                        int brickX = j * brickwall.brickWidth + 80;
                        int brickY = i * brickwall.brickHeight + 50;
                        int brickWidth = brickwall.brickWidth;
                        int brickHeight = brickwall.brickHeight;
                        
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ball.getBallX(), ball.getBallY(), ball.getBallDiameter(), ball.getBallDiameter());
                        Rectangle brickRect = rect;
                        
                        if (ballRect.intersects(brickRect)) {
                            brickwall.setBrickValue(0, i, j);
                            score.raiseScore();
                            brickwall.setNumberOfBricks(brickwall.getNumberOfBricks() - 1);
                            
                            if (ball.getBallX() + 19 <= brickRect.getX() || ball.getBallX() + 1 >= brickRect.getX() + brickwall.brickWidth) {
                                ball.changeDirectionX();
                            } else {
                                ball.changeDirectionY();
                            }
                            break outerloop;
                        }
                    }
                }
            }                
                
            ball.setBallX(ball.getBallX() + ball.getBallXdir());
            ball.setBallY(ball.getBallY() + ball.getBallYdir());
          
            if (ball.getBallX() < 3) { //left border
                ball.changeDirectionX();
            }
            if (ball.getBallX() > 690 - ball.getBallDiameter()) { //right border 675 = 690 - 15
                ball.changeDirectionX(); 
            }
            if (ball.getBallY() < 3) { //top border
                ball.changeDirectionY();
            }
        }
    }

    
    //getterit ja setterit
    
    public static Ball getBall() {
        return ball;
    }

    public static Paddle getPaddle() {
        return paddle;
    }

    public static void setBall(Ball ball) {
        Play.ball = ball;
    }

    public static void setPaddle(Paddle paddle) {
        Play.paddle = paddle;
    }

    public static void setScore(Score score) {
        Play.score = score;
    }

    public static void setBrickwall(Brickwall brickwall) {
        Play.brickwall = brickwall;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void setRunning(boolean running) {
        Play.running = running;
    }
    
}
