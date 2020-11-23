package lukuvinkkikirjasto.ui;

import java.util.Scanner;

public abstract class Command {
    protected Scanner reader;
    
    public Command(Scanner reader) {
        this.reader = reader;
    }

    public abstract void execute();
}
