package lukuvinkkikirjasto.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.List;
import lukuvinkkikirjasto.domain.ReadingTip;
import lukuvinkkikirjasto.domain.ReadingTipService;
import org.junit.Test;
import static org.junit.Assert.*;

public class Stepdefs {
    
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    IO io = new SystemIO();
    ReadingTipService rtService = new ReadingTipService();
    UserInterface ui = new UserInterface(io, rtService);
    
    @Given("command {string} is selected")
    public void commandIsSelected(String string) {
        
    }

    @Then("{string} message is shown")
    public void messageIsShown(String message) {
        
    }
    
    @When("Header {string} and description {string} are given.")
    public void headerAndDescriptionAreGiven(String header, String description) {
        rtService.add(new ReadingTip(header, description));
    }

    @Then("The book {string} is added.")
    public void theBookIsAdded(String header) {
        List<ReadingTip> tipList = rtService.getTips();
        assertTrue(tipList.get(0).getTitle().equals(header));
    }
}
