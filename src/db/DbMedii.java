/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import clase.*;
import java.sql.PreparedStatement;

/**
 *
 * @author yo5bdm
 */
public class DbMedii extends DbCon { 
    private Elev e;

    public DbMedii(Elev e) {
        this.e = e;
    }

    public DbMedii() {}
    
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
        try {
            Media m = (Media) o;
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE "+Setari.MEDII+" "
                    + "SET media = ? "
                    + "materia_id = ? "
                    + "elev_clasa_id = ? "
                    + "WHERE id = ? "
            );
            int i=1; //indexul pentru stabilirea pozitiei
            stmt.setDouble(i++, m.media);
            stmt.setInt(i++,m.materia_id);
            stmt.setInt(i++,m.semestrul_id);
            stmt.setInt(i++,m.id);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DbMedii.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public Object get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Metoda de salvare a unei medii noi.
     * Introduce o materie noua pentru un semestru anume
     * @param med Obiectul care se salveaza
     * @return 
     */
    public int salveaza(Media med) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO "+Setari.MEDII+" (elev_clasa_id, materia_id, media) values (?, ?, 0.0)");
            stmt.setInt(1, med.semestrul_id);
            stmt.setInt(2, med.materia_id);

            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Metode.mesajEroare("Eroare la inserarea in baza de date");
            Logger.getLogger(DbMedii.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    /**
     * Actualizeaza media in baza de date
     * @param m Obiectul care trebuie editat (id-ul din obiect corespunde id-ului din tabelul db)
     * @param media Noua medie pentru acest obiect
     * @return -1 la eroare, 0 daca nu a facut nimic, >0 nr de randuri modificate
     */
    public int update(Media m, double media) {
        try {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE "+Setari.MEDII+" "
                    + "SET media = ? WHERE id = ?"
            );
            stmt.setDouble(1, media);
            stmt.setInt(2,m.id);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DbMedii.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    
}
