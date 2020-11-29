package lukuvinkkikirjasto.ui;

import java.sql.SQLException;

import lukuvinkkikirjasto.domain.ReadingTipService;

public class EditHeader extends Command {
    public EditHeader(IO io, ReadingTipService rtService) {
        super(io, rtService);
    }

    public void execute() {
        io.output("Give tip id:");
        String input = io.input();
        int id;
        try {
            id = Integer.valueOf(input);
            if (!rtService.tipExists(id)) {
                io.output("Could not find responding tip.");
                return;
            }
        } catch (Exception e) {
            io.output("Id must be a number.");
            return;
        }
        io.output("New Header:");
        String newHeader = io.input();
        try {
            rtService.editHeader(id, newHeader);
        } catch (SQLException e) {
            io.output("Could not find tip in database.");
        }
    }
}
