package lukuvinkkikirjasto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// https://tikape-k20.mooc.fi/sqlite-java
public class Database {
    Connection db;
    Statement s;
    
    public Database() throws SQLException {
        db = DriverManager.getConnection("jdbc:sqlite:database.db");
    }
}
