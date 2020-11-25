package lukuvinkkikirjasto.ui;

import java.util.HashMap;
import lukuvinkkikirjasto.domain.ReadingTipService;

public class UserInterface {
    private String[] commandDescriptions = {
        "exit - closes the application",
        "new  - add a new reading tip",
        "list - lists all reading tips"
    };
    private IO io;
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private Command unknown;
    private ReadingTipService rtService;

    public UserInterface(IO io, ReadingTipService rtService) {
        this.rtService = rtService;
        this.io = io;
        commands.put("exit", new Exit(io, rtService));
        commands.put("new", new CreateReadingTip(io, rtService));
        commands.put("list", new ListReadingTips(io, rtService));
        unknown = new Unknown(io, rtService);
    }

    public void start() {
        while (true) {
            printCommands();
            String input = io.input();
            chooseCommand(input).execute();
        }
    }
    
    private void printCommands() {
        io.output("Here are the available commands:");
        for (String command : commandDescriptions) {
            io.output(command);
        }
    }
    
    private Command chooseCommand(String input) {
        return commands.getOrDefault(input, unknown);
    }
}
