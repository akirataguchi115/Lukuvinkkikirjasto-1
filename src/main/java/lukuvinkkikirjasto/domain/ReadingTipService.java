package lukuvinkkikirjasto.domain;

import java.util.ArrayList;

public class ReadingTipService {
    private ArrayList<ReadingTip> readingtips;
    
    public ReadingTipService() {
        this.readingtips = new ArrayList<>();
    }
    
    public void add(ReadingTip tip) {
        readingtips.add(tip);
    }
    
    public ArrayList<ReadingTip> getTips() {
        return this.readingtips;
    }
}
