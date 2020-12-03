package lukuvinkkikirjasto.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import lukuvinkkikirjasto.domain.ReadingTip;
import lukuvinkkikirjasto.domain.ReadingTipService;

public class Filter extends Command {
    public Filter(IO io, ReadingTipService rtService) {
        super(io, rtService);
    }

    public void execute() {
        try {

            io.output("Enter search term: ");
            String input = io.input();
            ArrayList<ReadingTip> tips = rtService.searchReadingTips(input);
            if (tips.isEmpty()) {
                io.output("No tips");
            }
            for (ReadingTip tip : tips) {
                io.output(tip.toString() + "\n");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ListReadingTips.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}