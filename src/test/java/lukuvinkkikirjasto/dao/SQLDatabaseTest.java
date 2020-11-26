
package lukuvinkkikirjasto.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import lukuvinkkikirjasto.domain.ReadingTip;
import org.junit.*;
import static org.junit.Assert.assertEquals;


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
        assertEquals(database.getTips().get(0), new ReadingTip("Test Item", "Test description"));
        
    }


}
