package lukuvinkkikirjasto.ui;

import org.junit.*;

import lukuvinkkikirjasto.domain.ReadingTip;
import lukuvinkkikirjasto.domain.ReadingTipService;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class CreateReadingTipTest {
    
    IO io;
    ReadingTipService rtService;
    CreateReadingTip createReadingTip;

    @Before
    public void setUp() {
        io = mock(IO.class);
        rtService = mock(ReadingTipService.class);
        createReadingTip = new CreateReadingTip(io, rtService);
        when(io.input()).thenReturn("value");
        when(io.input()).thenReturn("value2");
    }

    @Test
    public void createReadingTipAsksForHeaderAndDescription() {
        createReadingTip.execute();
        verify(io).output("Header: ");
        verify(io).output("Description: ");
    }
}
