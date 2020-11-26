package lukuvinkkikirjasto.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import lukuvinkkikirjasto.dao.Database;
import lukuvinkkikirjasto.dao.SQLDatabase;

public class ReadingTipService {
    private ArrayList<ReadingTip> readingtips;
    Database database;
    
    public ReadingTipService(Database database) throws SQLException {
        this.database = database;
        this.readingtips = new ArrayList<>();
    }
    
    public void add(ReadingTip tip) throws SQLException {
        database.create(tip.getTitle(), tip.getDescription());
    }
    
    public ArrayList<ReadingTip> getTips() throws SQLException {
        return database.getTips();
    }
}
