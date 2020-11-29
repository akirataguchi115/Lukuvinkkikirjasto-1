package lukuvinkkikirjasto.domain;

import java.sql.SQLException;
import lukuvinkkikirjasto.dao.Database;
import lukuvinkkikirjasto.ui.IO;
import lukuvinkkikirjasto.ui.Unknown;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ReadingTipServiceTest {
    ReadingTipService rtService;
    Database fakeDatabase;
    
    @Before
    public void setUp() throws SQLException {
        this.fakeDatabase = mock(Database.class);
        rtService = new ReadingTipService(fakeDatabase);
    }

    @Test
    public void addAddsReadingTipToDatabase() throws SQLException {
        rtService.add("test", "asd");
        verify(fakeDatabase).create("test", "asd");
    }
}
