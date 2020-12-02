package lukuvinkkikirjasto.ui;

import java.sql.SQLException;
import org.junit.*;

import lukuvinkkikirjasto.domain.ReadingTip;
import lukuvinkkikirjasto.domain.ReadingTipService;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class ListReadingTipsTest {

    IO io;
    ReadingTipService rtService;
    ListReadingTips listReadingTips;
    ArrayList<ReadingTip> startingTips;

    @Before
    public void setUp() throws SQLException {
        io = mock(IO.class);
        rtService = mock(ReadingTipService.class);
        startingTips = new ArrayList<>();
        startingTips.add(new ReadingTip(1, "title", "description"));
        startingTips.add(new ReadingTip(2, "a", "b"));
        when(rtService.getTips()).thenReturn(startingTips);
        listReadingTips = new ListReadingTips(io, rtService);
    }
    
    @Test
    public void listReadingTipsGivesData() {
        when(io.input()).thenReturn("all");
        listReadingTips.execute();
        verify(io).output(new ReadingTip(1, "title", "description").toString() + "\n");
        verify(io).output(new ReadingTip(2, "a", "b").toString() + "\n");
    }
    
    @Test
    public void listReadingTipsPrintsRightMessageWhenNoTips() throws SQLException {
        when(rtService.getTips()).thenReturn(new ArrayList<>());
        when(io.input()).thenReturn("all");
        listReadingTips.execute();
        verify(io).output("No tips\n");
    }
}
