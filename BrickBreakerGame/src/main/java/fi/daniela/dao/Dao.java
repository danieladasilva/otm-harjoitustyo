
package fi.daniela.dao;

import java.sql.*;
    
public interface Dao<T, K> {
    T save(T object) throws SQLException;
    int maxScore() throws SQLException;
}
    

