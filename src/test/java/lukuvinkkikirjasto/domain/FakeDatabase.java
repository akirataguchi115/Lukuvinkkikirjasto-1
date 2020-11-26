/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukuvinkkikirjasto.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import lukuvinkkikirjasto.dao.Database;

/**
 *
 * @author tulijoki
 */
public class FakeDatabase implements Database {

    ArrayList<ReadingTip> tipList;
    
    public FakeDatabase() {
        this.tipList = new ArrayList<>();
    }
    
    @Override
    public void create(String title, String description) throws SQLException {
        tipList.add(new ReadingTip(title, description));
    }

    @Override
    public ArrayList<ReadingTip> getTips() throws SQLException {
        return tipList;
    }
    
}
