package lukuvinkkikirjasto.ui;

import static org.mockito.Mockito.*;
import java.sql.SQLException;
import org.junit.*;
import lukuvinkkikirjasto.domain.ReadingTipService;

public class EditHeaderTest {
    private IO io;
	private ReadingTipService rtService;
	private EditHeader editHeader;

	@Before
	public void setUp() {
		io = mock(IO.class);
		rtService = mock(ReadingTipService.class);
		editHeader = new EditHeader(io, rtService);
    }
    
    @Test
	public void stopsExecutingIfIdNotFound() throws SQLException {
		when(io.input()).thenReturn("3");
		when(rtService.tipExists(3)).thenReturn(false);
		editHeader.execute();
		verify(io, times(0)).output("New Header:");
		verify(io, times(1)).input();
		verify(rtService, times(0)).editHeader(anyInt(), anyString());
	}

	@Test
	public void ifIdNotFoundInformsUser() throws SQLException {
		when(io.input()).thenReturn("3");
		when(rtService.tipExists(3)).thenReturn(false);
		editHeader.execute();
		verify(io, times(1)).output("Could not find responding tip.");
	}

	@Test
	public void stopsExecutingIfIdNotNumber() throws SQLException {
		when(io.input()).thenReturn("2D");
		when(rtService.tipExists(3)).thenReturn(true);
		editHeader.execute();
		verify(io, times(0)).output("New Header:");
		verify(io, times(1)).input();
		verify(rtService, times(0)).editHeader(anyInt(), anyString());
	}

	@Test
	public void ifIdNotNumberInformsUser() throws SQLException {
		when(io.input()).thenReturn("2D");
		when(rtService.tipExists(3)).thenReturn(true);
		editHeader.execute();
		verify(io, times(1)).output("Id must be a number.");
	}

	@Test
	public void callsReadingTipServiceWithRightParameter() throws SQLException {
		when(io.input()).thenReturn("1").thenReturn("header");
		when(rtService.tipExists(1)).thenReturn(true);
		editHeader.execute();
		verify(rtService, times(1)).editHeader(1, "header");
	}

	@Test
	public void infromsUserOnDatabaseException() throws SQLException {
		when(io.input()).thenReturn("1").thenReturn("header");
		when(rtService.tipExists(1)).thenThrow(SQLException.class);
		editHeader.execute();
		verify(io, times(1)).output("Problem accessing database.");
	}
}
