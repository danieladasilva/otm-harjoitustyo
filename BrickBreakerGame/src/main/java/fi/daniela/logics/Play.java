
package fi.daniela.logics;

import fi.daniela.dao.Database;
import fi.daniela.dao.ScoreDao;
import fi.daniela.main.Main;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private static boolean gameOver = false;
    
    /**
     * Method activates the game if the variable 'running' equals true.
     */
    public static void play() {
        if (running) {
            ball.checkForPaddle();
            ball.checkForBricks();               
            ball.checkForBorders();
            ball.move();
        }
    }
    
    /**
     * Method restarts the game and all of its changed values back to starting point.
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
        play();
    }
    
    /**
     * Method updates highscore in the database score.db
     */
    public static void updateHighscore() {
        try {
            Database scoredb = new Database("jdbc:sqlite:score.db");
            ScoreDao scoreDao = new ScoreDao(scoredb);
            scoreDao.save(score);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /**
     * Method finds the highscore from the database score.db
     * @return highscore
     * @throws Exception 
     */
    public static int getHighscore() throws Exception {
        Database scoredb = new Database("jdbc:sqlite:score.db");
        ScoreDao scoreDao = new ScoreDao(scoredb);
        return scoreDao.maxScore();
    }
    
    /**
     * Method for when ball intersects with a brick (raises score, sets brick invisible etc.)
     * @param brickRect rectangle created around the brick
     * @param i row
     * @param j column
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
    
    public static boolean isRunning() {
        return running;
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setBall(Ball ball) {
        Play.ball = ball;
    }

    public static void setPaddle(Paddle paddle) {
        Play.paddle = paddle;
        Ball.setPaddle(paddle);
    }

    public static void setScore(Score score) {
        Play.score = score;
    }

    public static void setBrickwall(Brickwall brickwall) {
        Play.brickwall = brickwall;
    }
    
    public static void setRunning(boolean running) {
        Play.running = running;
    }

    public static void setGameOver(boolean gameOver) {
        Play.gameOver = gameOver;
    }   
}
