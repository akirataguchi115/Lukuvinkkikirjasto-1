package lukuvinkkikirjasto.domain;

import lukuvinkkikirjasto.ui.IO;
import lukuvinkkikirjasto.ui.Unknown;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ReadingTipServiceTest {
    ReadingTipService rtService;
    
    @Before
    public void setUp() {
        rtService = new ReadingTipService();
    }
    
    @Test
    public void addingReadingTipTest() {
        ReadingTip rt = new ReadingTip("test", "asd");
        rtService.add(rt);
        assertEquals(rtService.getTips().size(), 1);
        assertEquals(rtService.getTips().get(0), rt);
    }
}
