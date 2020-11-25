package lukuvinkkikirjasto.ui;

import org.junit.*;

import lukuvinkkikirjasto.domain.ReadingTip;
import lukuvinkkikirjasto.domain.ReadingTipService;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class ListReadingTipsTest {

	IO io;
	ReadingTipService rtService;
	CreateReadingTip createReadingTip;
	ArrayList<ReadingTip> startingTips;

	@Before
	public void setUp() {
		io = mock(IO.class);
		rtService = mock(ReadingTipService.class);
		startingTips = new ArrayList<>();
		startingTips.add(new ReadingTip("title", "description"));
		startingTips.add(new ReadingTip("a", "b"));
		when(rtService.getTips()).thenReturn(startingTips);
		createReadingTip = new CreateReadingTip(io, rtService);
	}
}
