
package fi.daniela.logics;

/**
 * Class maintains information about the score and offers methods related to it.
 * @author Daniela
 */
public class Score {

    private int score;
    private int scoreX;
    private int scoreY;
    
    public Score() {
        this.score = 0;
        this.scoreX = 635;
        this.scoreY = 30;
    }
    
    /**
     * Method raises total score by 5 points.
     */
    public void raiseScore() {
        this.score += 5;
    }
    
    /**
     * Method resets total score back to zero.
     */
    public void reset() {
        this.score = 0;
    }
    
    public int getScore() {
        return score;
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreY() {
        return scoreY;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScoreX(int scoreX) {
        this.scoreX = scoreX;
    }

    public void setScoreY(int scoreY) {
        this.scoreY = scoreY;
    }       
}
