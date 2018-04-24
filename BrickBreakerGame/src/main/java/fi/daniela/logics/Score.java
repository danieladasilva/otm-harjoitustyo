
package fi.daniela.logics;

public class Score {
    //oliomuuttujat
    private int score;
    private int scoreX;
    private int scoreY;
    
    //konstruktorit
    public Score() {
        this.score = 0;
        this.scoreX = 650;
        this.scoreY = 30;
    }
    
    //metodit
    public void raiseScore() {
        this.score += 5;
    }
    
    public void reset() {
        this.score = 0;
    }
    
    //getterit ja setterit
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
