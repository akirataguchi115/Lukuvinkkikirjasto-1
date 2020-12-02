package lukuvinkkikirjasto;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lukuvinkkikirjasto.dao.Database;
import lukuvinkkikirjasto.domain.ReadingTip;
import lukuvinkkikirjasto.domain.ReadingTipService;
import lukuvinkkikirjasto.ui.SystemIO;
import lukuvinkkikirjasto.ui.UserInterface;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Stepdefs {

    SystemIO io;
    Database fakeDatabase;
    ReadingTipService rtService;
    UserInterface ui;
    ArrayList<ReadingTip> list;

    public Stepdefs() throws SQLException {
        io = mock(SystemIO.class);
        fakeDatabase = mock(Database.class);
        rtService = new ReadingTipService(fakeDatabase);
        ui = new UserInterface(io, rtService);
        list = new ArrayList<>();
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
        rtService.add(header, description);
    }

    @Then("The book {string} is added.")
    public void theBookIsAdded(String header) throws SQLException {
        List<ReadingTip> tipList = rtService.getTips();
        verify(fakeDatabase).create(eq(header), anyString());
    }

    @Given("tip with header {string} and description {string} is added")
    public void tipWithHeaderAndDescriptionIsAdded(String string, String string2) throws SQLException {
        rtService.add(string, string2);
        verify(fakeDatabase).create(string, string2);
        list.add(new ReadingTip(list.size()+1, string, string2));
        when(fakeDatabase.getTips()).thenReturn(list);
    }

    @Then("tip with id, header {string} and description {string} is listed")
    public void tipWithIdAndHeaderAndDescriptionIsListed(String string, String string2) throws SQLException {
        verify(io).output("ID: " + anyString() + "\n" + "Header: " + string + "\n" + "Description: " + string2 + "\n");
    }
}
