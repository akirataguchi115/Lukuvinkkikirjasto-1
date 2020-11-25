package lukuvinkkikirjasto.ui;

import lukuvinkkikirjasto.domain.ReadingTipService;

public abstract class Command {
    protected IO io;
    protected ReadingTipService rtService;
    
    public Command(IO io, ReadingTipService rtService) {
        this.io = io;
        this.rtService = rtService;
    }

    public abstract void execute();
}
