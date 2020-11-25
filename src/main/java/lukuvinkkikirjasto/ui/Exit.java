package lukuvinkkikirjasto.ui;

import lukuvinkkikirjasto.domain.ReadingTipService;

public class Exit extends Command {

    public Exit(IO io, ReadingTipService rtService) {
        super(io, rtService);
    }

    public void execute() {
        System.exit(0);
    }
}
