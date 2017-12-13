/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import clase.Clasa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yo5bdm
 */
public class DbClase extends DbCon {

    @Override
    public ArrayList list() {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM "+Setari.NUME_CLASA);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Clasa> clase = new ArrayList();
            while(rs.next()) {
                Clasa e = new Clasa(
                        rs.getInt("ID"),
                        rs.getInt("Clasa")
                );
                clase.add(e);
            }
            return clase;
        } catch (SQLException ex) {
            Logger.getLogger(DbClase.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean insert(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
