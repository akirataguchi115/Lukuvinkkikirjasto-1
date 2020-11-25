package lukuvinkkikirjasto.ui;

import java.util.ArrayList;

import lukuvinkkikirjasto.domain.ReadingTip;
import lukuvinkkikirjasto.domain.ReadingTipService;

public class ListReadingTips extends Command {
    public ListReadingTips(IO io, ReadingTipService rtService) {
        super(io, rtService);
    }

    public void execute() {
        ArrayList<ReadingTip> tips = rtService.getTips();
        if (tips.isEmpty()) {
            io.output("No tips\n");
        }
        for (ReadingTip tip : tips) {
            io.output(tip.toString() + "\n");
        }
    }
}
