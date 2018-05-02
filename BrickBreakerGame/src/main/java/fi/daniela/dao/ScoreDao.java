
package fi.daniela.dao;

import fi.daniela.logics.Score;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ScoreDao implements Dao<Score, Integer> {
    
    private Database database;

    public ScoreDao(Database database) {
        this.database = database;
    }

    @Override
    public Score findOne(Integer key) throws SQLException {
        
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Score WHERE score = ?");
        stmt.setInt(1, 10);
        
        ResultSet rs = stmt.executeQuery();
       
        while (rs.next()) {
            int tulos = rs.getInt("score");
            Score score = new Score();
        }
        
        stmt.close();
        rs.close();
        conn.close();
        return null;
        
    }

    @Override
    public List<Score> findAll() throws SQLException {
        return null;
    }

    @Override
    public Score saveOrUpdate(Score object) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:resourses:scores.db");
        
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Score score");
        stmt.setInt(1, 10);
        
        ResultSet rs = stmt.executeQuery();
        
        stmt.close();
        rs.close();
        conn.close();
        return null;
    }
    
//    @Override
//    public void delete(Integer key) throws SQLException {
//        
//    }
    
}
