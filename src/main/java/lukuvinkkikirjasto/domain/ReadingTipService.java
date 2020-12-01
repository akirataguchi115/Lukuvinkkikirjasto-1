package lukuvinkkikirjasto.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import lukuvinkkikirjasto.dao.Database;

public class ReadingTipService {
    Database database;

    public ReadingTipService(Database database) throws SQLException {
        this.database = database;
    }

    public void add(String header, String description) throws SQLException {
        database.create(header, description);
    }

    public void editHeader(int id, String header) throws SQLException {
        database.editHeader(id, header);
    }

    public void editDescription(int id, String description) throws SQLException {
        database.editDescription(id, description);
    }

    public Boolean tipExists(int id) throws SQLException {
        return database.containsId(id);
    }

    public ArrayList<ReadingTip> getTips() throws SQLException {
        return database.getTips();
    }
    
    public void delete(int id) throws SQLException {
        database.delete(id);
    }
}
