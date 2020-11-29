/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukuvinkkikirjasto.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import lukuvinkkikirjasto.domain.ReadingTip;

/**
 *
 * @author tulijoki
 */
public interface Database {

    void create(String title, String description) throws SQLException;

    ArrayList<ReadingTip> getTips() throws SQLException;
    
    void editHeader(int id, String header) throws SQLException;

    void editDescription(int id, String description) throws SQLException;

    Boolean containsId(int id) throws SQLException;
}
