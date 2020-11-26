package lukuvinkkikirjasto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lukuvinkkikirjasto.domain.ReadingTip;

// https://tikape-k20.mooc.fi/sqlite-java
public class SQLDatabase implements Database {
    Connection db;
    Statement s;
    
    public SQLDatabase(String databaseName) throws SQLException {
        db = DriverManager.getConnection("jdbc:sqlite:"+databaseName);
        Statement s = db.createStatement();
        s.execute("CREATE TABLE IF NOT EXISTS Tips (id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR NOT NULL, description VARCHAR)");
    }
    
    @Override
    public void create(String title, String description) throws SQLException {
        PreparedStatement p = db.prepareStatement("INSERT INTO Tips(title, description) VALUES (?, ?)");
        p.setString(1, title);
        p.setString(2, description);
        p.executeUpdate();
        p.close();
    }
    
    @Override
    public ArrayList<ReadingTip> getTips() throws SQLException {
        ArrayList<ReadingTip> tipList = new ArrayList<>();
        PreparedStatement p = db.prepareStatement("SELECT * FROM Tips");
        ResultSet r = p.executeQuery();
        while (r.next()) {
            tipList.add(new ReadingTip(r.getString("title"), r.getString("description")));
        }
        return tipList;
    }
    
}