package lukuvinkkikirjasto.ui;

import java.util.HashMap;

public class UserInterface {
    private String[] commandDescriptions = {
        "exit - closes the application"
    };
    private IO io;
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private Command unknown;

    public UserInterface(IO io) {
        this.io = io;
        commands.put("exit", new Exit(io));
        unknown = new Unknown(io);
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
