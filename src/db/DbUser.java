/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import clase.User;
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
public class DbUser extends DbCon {

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
    
    public User verifica(User e) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM "+Setari.UTILIZATORI+" WHERE username = ? AND pass = ? LIMIT 1");
            int n=1;
            stmt.setString(n++, e.getUsername());
            stmt.setString(n++, e.getPassword());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                User db = new User(rs.getInt("id"),rs.getInt("clasa_user"),rs.getString("username"),rs.getString("pass"));
                if(db.equals(e)==true) return db;
                else return null;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbUser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
