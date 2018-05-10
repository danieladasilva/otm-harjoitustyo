
package fi.daniela.dao;

import fi.daniela.logics.Score;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreDao implements Dao<Score, Integer> {
    
    private Database database;

    public ScoreDao(Database database) {
        this.database = database;
    }
    
    public int maxScore() throws SQLException{
        Connection conn = database.getConnection();
        
        PreparedStatement statement2 = conn.prepareStatement("SELECT MAX(score) FROM Score");
        
        ResultSet rs = statement2.executeQuery();
        String number = rs.getString(1);
        
        rs.close();
        return Integer.parseInt(number);  
    }

    @Override
    public Score save(Score score) throws SQLException {
        Connection conn = database.getConnection();
        
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Score (score) VALUES (?)");
        stmt.setInt(1, score.getScore());
        stmt.executeUpdate();
        
        stmt.close();
        conn.close();
        return null;
    }    
}
