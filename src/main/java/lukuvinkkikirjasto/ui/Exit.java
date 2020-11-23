package lukuvinkkikirjasto.ui;

import java.util.Scanner;

public class Exit extends Command {

    public Exit(Scanner reader) {
        super(reader);
    }

    public void execute() {
        System.exit(0);
    }
}
