package fi.daniela.main;

import fi.daniela.gui.GamePanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) throws Exception {
        JFrame jframe = new JFrame();
        GamePanel gamePanel = new GamePanel();
        jframe.add(gamePanel);
        jframe.setBounds(5, 5, 700, 600);
        jframe.setTitle("Brick Breaker Game");
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Connection connection = DriverManager.getConnection("jdbc:sqlite:score.db");
        connection.close();
        
    }
}
