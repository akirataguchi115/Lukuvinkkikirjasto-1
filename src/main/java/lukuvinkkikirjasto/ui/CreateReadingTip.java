package lukuvinkkikirjasto.ui;

import lukuvinkkikirjasto.domain.ReadingTip;
import lukuvinkkikirjasto.domain.ReadingTipService;

public class CreateReadingTip extends Command {
	public CreateReadingTip(IO io, ReadingTipService rtService) {
		super(io, rtService);
	}

	public void execute() {
		io.output("Header: ");
        String header = io.input();
        io.output("Description: ");
        String description = io.input();
        rtService.add(new ReadingTip(header, description));
	}
}
