
package lukuvinkkikirjasto.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lukuvinkkikirjasto.domain.ReadingTip;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SQLDatabaseTest {
    
    SQLDatabase database;
    

    @Before
    public void setUp() throws SQLException, Exception {
        database = new SQLDatabase("testdatabase.db");
    } 
    
    @After
    public void tearDown() {
        File dbFile = new File("testdatabase.db");
        dbFile.delete();
    }

    @Test
    public void readingTipIsCreatedAndIsIncludedInTheList() throws SQLException {
        database.create("Test Item", "Test description");
        assertEquals(database.getTips().get(0).getTitle(), "Test Item");
        assertEquals(database.getTips().get(0).getDescription(), "Test description");
    }
    
    @Test
    public void readingIsDeletedFromDatabase() throws SQLException {
        database.create("Test Item", "Test description");
        ArrayList<ReadingTip> tipList = database.getTips();
        assertEquals(1, tipList.size());
        database.delete(1);
        tipList = database.getTips();
        assertEquals(0, tipList.size());
    }
}
