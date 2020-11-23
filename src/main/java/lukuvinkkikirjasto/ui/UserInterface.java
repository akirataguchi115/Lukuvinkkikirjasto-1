package lukuvinkkikirjasto.ui;

import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {
    private String[] commandDescriptions = {
        "exit"
    };
    private Scanner reader;
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private Command unknown;

    public UserInterface(Scanner reader) {
        this.reader = reader;
        commands.put("exit", new Exit(reader));
        unknown = new Unknown(reader);
    }

    public void start() {
        while (true) {
            System.out.println("Here are the available commands:");
            printCommands();
            String input = reader.nextLine();
            chooseCommand(input).execute();
        }
    }

    private void printCommands() {
        for (String command : commandDescriptions) {
            System.out.println(command);
        }
    }

    private Command chooseCommand(String input) {
        return commands.getOrDefault(input, unknown);
    }
}
