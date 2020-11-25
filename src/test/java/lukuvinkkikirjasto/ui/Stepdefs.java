package lukuvinkkikirjasto.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.HashMap;
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
    
}
