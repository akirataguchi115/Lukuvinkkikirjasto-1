package lukuvinkkikirjasto.ui;

public class Exit extends Command {

    public Exit(IO io) {
        super(io);
    }

    public void execute() {
        System.exit(0);
    }
}
