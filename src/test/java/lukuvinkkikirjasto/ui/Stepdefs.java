package lukuvinkkikirjasto.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import lukuvinkkikirjasto.dao.Database;
import lukuvinkkikirjasto.domain.FakeDatabase;
import lukuvinkkikirjasto.domain.ReadingTip;
import lukuvinkkikirjasto.domain.ReadingTipService;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class Stepdefs {

    SystemIO io;
    Database fakeDatabase = new FakeDatabase();
    ReadingTipService rtService;
    UserInterface ui;

    public Stepdefs() throws SQLException {
        io = mock(SystemIO.class);
        rtService = new ReadingTipService(fakeDatabase);
        ui = new UserInterface(io, rtService);
    }

    @Given("command {string} is selected")
    public void commandIsSelected(String string) {
        ui.chooseCommand(string).execute();
    }

    @Then("{string} message is shown")
    public void messageIsShown(String message) {
        verify(io).output(message + "\n");
    }

    @When("Header {string} and description {string} are given.")
    public void headerAndDescriptionAreGiven(String header, String description) throws SQLException {
        rtService.add(new ReadingTip(header, description));
    }

    @Then("The book {string} is added.")
    public void theBookIsAdded(String header) throws SQLException {
        List<ReadingTip> tipList = rtService.getTips();
        assertTrue(tipList.get(0).getTitle().equals(header));
    }

    @Given("tip with header {string} and description {string} is added")
    public void tipWithHeaderAndDescriptionIsAdded(String string, String string2) throws SQLException {
        rtService.add(new ReadingTip(string, string2));
    }

    @Then("tip with header {string} and description {string} is listed")
    public void tipWithHeaderAndDescriptionIsListed(String string, String string2) {
        verify(io).output("Header: " + string + "\n" + "Description: " + string2 + "\n");
    }
}
