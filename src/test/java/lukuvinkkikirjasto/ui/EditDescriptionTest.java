package lukuvinkkikirjasto.ui;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.*;

import lukuvinkkikirjasto.domain.ReadingTipService;

public class EditDescriptionTest {

	private IO io;
	private ReadingTipService rtService;
	private EditDescription editDescription;

	@Before
	public void setUp() {
		io = mock(IO.class);
		rtService = mock(ReadingTipService.class);
		editDescription = new EditDescription(io, rtService);
	}

	@Test
	public void stopsExecutingIfIdNotFound() throws SQLException {
		when(io.input()).thenReturn("3");
		when(rtService.tipExists(3)).thenReturn(false);
		editDescription.execute();
		verify(io, times(0)).output("New Description:");
		verify(io, times(1)).input();
		verify(rtService, times(0)).editDescription(anyInt(), anyString());
	}

	@Test
	public void ifIdNotFoundInformsUser() throws SQLException {
		when(io.input()).thenReturn("3");
		when(rtService.tipExists(3)).thenReturn(false);
		editDescription.execute();
		verify(io, times(1)).output("Could not find responding tip.");
	}

	@Test
	public void stopsExecutingIfIdNotNumber() throws SQLException {
		when(io.input()).thenReturn("2D");
		when(rtService.tipExists(3)).thenReturn(true);
		editDescription.execute();
		verify(io, times(0)).output("New Description:");
		verify(io, times(1)).input();
		verify(rtService, times(0)).editDescription(anyInt(), anyString());
	}

	@Test
	public void ifIdNotNumberInformsUser() throws SQLException {
		when(io.input()).thenReturn("2D");
		when(rtService.tipExists(3)).thenReturn(true);
		editDescription.execute();
		verify(io, times(1)).output("Id must be a number.");
	}

	@Test
	public void callsReadingTipServiceWithRightParameter() throws SQLException {
		when(io.input()).thenReturn("1").thenReturn("desc");
		when(rtService.tipExists(1)).thenReturn(true);
		editDescription.execute();
		verify(rtService, times(1)).editDescription(1, "desc");
	}

	@Test
	public void infromsUserOnDatabaseException() throws SQLException {
		when(io.input()).thenReturn("1").thenReturn("desc");
		when(rtService.tipExists(1)).thenThrow(SQLException.class);
		editDescription.execute();
		verify(io, times(1)).output("Problem accessing database.");
	}
}
