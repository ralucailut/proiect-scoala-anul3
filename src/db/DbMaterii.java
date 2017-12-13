/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import clase.*;
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
public class DbMaterii extends DbCon {
    
    
    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public ArrayList cauta(Integer clasa_id) {
        try {
            //throw new UnsupportedOperationException("Not supported yet.");
            String sql = "SELECT "+Setari.NUME_MATERII+".id FROM "+Setari.NUME_MATERII+" JOIN "+Setari.MATERII+" ON "+Setari.NUME_MATERII+".id = "+Setari.MATERII+".materii_id JOIN "+Setari.NUME_CLASA+" ON "+Setari.MATERII+".clasa_id = clases.id WHERE "+Setari.NUME_CLASA+".id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, clasa_id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Materia> materii = new ArrayList();
            while(rs.next()) {
                materii.add(new Materia(rs.getInt(Setari.NUME_MATERII+".id")));
            }
            return materii;
        } catch (SQLException ex) {
            Logger.getLogger(DbMaterii.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
