package lukuvinkkikirjasto.ui;

import java.util.Scanner;

public class Unknown extends Command {
    
    public Unknown(Scanner reader) {
        super(reader);
    }

    public void execute() {
        System.out.println("Command not found");
    }
}
