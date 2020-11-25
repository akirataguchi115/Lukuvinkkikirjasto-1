package lukuvinkkikirjasto.ui;

import lukuvinkkikirjasto.domain.ReadingTipService;

public class Unknown extends Command {
    
    public Unknown(IO io, ReadingTipService rtService) {
        super(io, rtService);
    }

    public void execute() {
        io.output("Command not found");
    }
}
