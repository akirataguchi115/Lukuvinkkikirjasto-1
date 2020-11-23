package lukuvinkkikirjasto.ui;

public class Unknown extends Command {
    
    public Unknown(IO io) {
        super(io);
    }

    public void execute() {
        io.output("Command not found");
    }
}
