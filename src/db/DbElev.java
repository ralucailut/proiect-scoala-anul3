/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import clase.Elev;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.ModelElevi;

/**
 *
 * @author yo5bdm
 */
public class DbElev extends DbCon {
    
    @Override
    public boolean insert(Object o) {
        Elev e = (Elev) o;
        try {    
            PreparedStatement stmt = con.prepareStatement("INSERT INTO "+Setari.ELEVI+" (nume, prenume, initiala_tatalui, CNP, volum_matricol, pagina_matricol, adresa_elev, adresa_parinti, locul_nasterii, nationalitate, nume_tata, nume_mama, inmatriculat, transferat, observatii) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            int n=1;
            stmt.setString(n++, e.Nume);
            stmt.setString(n++, e.Prenume);
            stmt.setString(n++, e.Initiala_tatalui);
            stmt.setString(n++, e.CNP);
            stmt.setString(n++, e.Volum_matricol);
            stmt.setString(n++, e.Pagina_matricol);
            stmt.setString(n++, e.adresa_elev);
            stmt.setString(n++, e.adresa_parinti);
            stmt.setString(n++, e.locul_nasterii);
            stmt.setString(n++, e.nationalitate);
            stmt.setString(n++, e.nume_tata);
            stmt.setString(n++, e.nume_mama);
            stmt.setBoolean(n++,e.inmatriculat);
            stmt.setBoolean(n++,e.transferat);
            stmt.setString(n++,e.observatii);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public int delete(Object o) {
        Elev e = (Elev) o;
        if(e==null) return -1;
        try {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM "+Setari.ELEVI+" WHERE id = ?");
            stmt.setString(1, e.id.toString());
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int update(Object o) {
        Elev e = (Elev) o;
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE "+Setari.ELEVI+" SET Nume = ?, Prenume = ?, Initiala_tatalui = ?, CNP = ?, Volum_matricol = ?, Pagina_matricol = ?, Adresa_elev = ?, Adresa_parinti = ?, Locul_nasterii = ?, Nationalitate = ?, Nume_tata = ?, Nume_mama = ?, inmatriculat = ?, transferat = ?, observatii = ? WHERE id = ?");
            int n=1;
            stmt.setString(n++, e.Nume);
            stmt.setString(n++, e.Prenume);
            stmt.setString(n++, e.Initiala_tatalui);
            stmt.setString(n++, e.CNP);
            stmt.setString(n++, e.Volum_matricol);
            stmt.setString(n++, e.Pagina_matricol);
            stmt.setString(n++, e.adresa_elev);
            stmt.setString(n++, e.adresa_parinti);
            stmt.setString(n++, e.locul_nasterii);
            stmt.setString(n++, e.nationalitate);
            stmt.setString(n++, e.nume_tata);
            stmt.setString(n++, e.nume_mama);
            stmt.setBoolean(n++,e.inmatriculat);
            stmt.setBoolean(n++,e.transferat);
            stmt.setString(n++, e.observatii);
            stmt.setString(n++, e.id.toString());
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public ArrayList list() {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM "+Setari.ELEVI);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Elev> lista_elevi = new ArrayList();
            while(rs.next()) {
                Elev e = new Elev(
                        rs.getInt("ID"),
                        rs.getString("Nume"),
                        rs.getString("prenume"),
                        rs.getString("Initiala_tatalui"),
                        rs.getString("CNP"),
                        rs.getString("volum_matricol"),
                        rs.getString("pagina_matricol"),
                        rs.getString("adresa_elev"),
                        rs.getString("adresa_parinti"),
                        rs.getString("Locul_nasterii"),
                        rs.getString("Nationalitate"),
                        rs.getString("Nume_tata"),
                        rs.getString("Nume_mama"), 
                        rs.getBoolean("inmatriculat"), 
                        rs.getBoolean("transferat"), 
                        rs.getString("observatii")
                );
                lista_elevi.add(e);
            }
            return lista_elevi;
        } catch (SQLException ex) {
            Logger.getLogger(ModelElevi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Object get(Integer id) {
        if(id!=0) {
            try {
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM "+Setari.ELEVI+" WHERE id = ?");
                stmt.setString(1, id.toString());
                ResultSet rs = stmt.executeQuery();
                rs.next();
                return new Elev(rs.getInt("ID"),
                        rs.getString("Nume"),
                        rs.getString("prenume"),
                        rs.getString("Initiala_tatalui"),
                        rs.getString("CNP"),
                        rs.getString("volum_matricol"),
                        rs.getString("pagina_matricol"),
                        rs.getString("adresa_elev"),
                        rs.getString("adresa_parinti"),
                        rs.getString("Locul_nasterii"),
                        rs.getString("Nationalitate"),
                        rs.getString("Nume_tata"),
                        rs.getString("Nume_mama"), 
                        rs.getBoolean("inmatriculat"), 
                        rs.getBoolean("transferat"), 
                        rs.getString("observatii")
                );
                
            } catch (SQLException ex) {
                Logger.getLogger(DbElev.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } else return null;
    }
}
