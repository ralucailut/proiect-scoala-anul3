/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import clase.Semestru;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yo5bdm
 */
public class DbSemestre extends DbCon {

    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Object o) {
        Semestru s = (Semestru) o;
        try {    
            PreparedStatement stmt = con.prepareStatement("INSERT INTO "+Setari.SEMESTRE+" (elev_id, clasa_id, litera_clasa, semestrul, an_scolar ) values (?, ?, ?, ?, ?)");
            int n=1;
            stmt.setInt(n++, s.elev_id);
            stmt.setInt(n++, s.clasa_id);
            stmt.setString(n++, s.litera);
            stmt.setInt(n++, s.nr_semestru);
            stmt.setString(n++, s.an_scolar);
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
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
