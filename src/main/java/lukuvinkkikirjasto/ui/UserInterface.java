package lukuvinkkikirjasto.ui;

import java.util.ArrayList;
import java.util.HashMap;
import lukuvinkkikirjasto.domain.ReadingTip;
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
        commands.put("exit", new Exit(io));
        unknown = new Unknown(io);
    }
    
    public void start() {
        while (true) {
            printCommands();
            String input = io.input();
            chooseCommand(input);
        }
    }
    
    private void printCommands() {
        io.output("Here are the available commands:");
        for (String command : commandDescriptions) {
            io.output(command);
        }
    }
    
    private void chooseCommand(String input) {
        switch (input) {
            case "exit":
                System.exit(0);
                break;
            case "new":
                createReadingTip();
                break;
            case "list":
                listReadingTips();
                break;
            default:
                io.output("Unknown command");
        }
    }
    
    
    public void createReadingTip() {
        io.output("Header: ");
        String header = io.input();
        io.output("Description: ");
        String description = io.input();
        rtService.add(new ReadingTip(header, description));
    }
    
    private void listReadingTips() {
        printTips(rtService.getTips());
    }

    private void printTips(ArrayList<ReadingTip> tips) {
        if (tips.isEmpty()) {
            io.output("No tips\n");
        }
        for (ReadingTip tip : tips) {
            io.output(tip.toString() + "\n");
        }
    }
}
