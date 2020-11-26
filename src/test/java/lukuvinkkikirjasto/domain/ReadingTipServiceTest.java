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
        this.fakeDatabase = new FakeDatabase();
        rtService = new ReadingTipService(fakeDatabase);
    }
    
    @Test
    public void addingReadingTipTest() throws SQLException {
        ReadingTip rt = new ReadingTip("test", "asd");
        rtService.add(rt);
        assertEquals(rtService.getTips().size(), 1);
        assertEquals(rtService.getTips().get(0), rt);
    }
}
