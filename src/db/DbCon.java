/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import clase.Metode;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yo5bdm
 */
public abstract class DbCon {
    //stringurile pentru operatiunile cu baza de date:
    // setInt() si setString cu prepared statements
    
    //protected String slist = "SELECT * FROM $tabel ";
    //protected String sget = "SELECT * FROM $tabel WHERE id = ?";
    //protected String sdelete = "DELETE FROM $tabel WHERE id = ?";
    //conexiunea la baza de date
    protected Connection con;
    
    public DbCon() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://"
                    +Setari.HOST+":"
                    +Setari.PORT+"/"
                    +Setari.DB,
                    Setari.USER,
                    Setari.PASS);
        } catch (SQLException ex) {
            Metode.mesajEroare("Nu s-a putut face conexiunea la baza de date!");
        }
    }
    /**
     * Ruleaza un query customizat. 
     * @param sql Nu este verificat sa fie fara erori!
     * @return ResultSet - se proceseaza la apelare
     */
    public ResultSet query(String sql) {
        try {
            Statement stmt = con.createStatement(); 
            return stmt.executeQuery( sql );
        } catch (SQLException ex) {
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Returneaza o lista cu elementele din clasa care o extinde.
     * @return ArrayList
     */
    abstract public ArrayList list(); 
    
    /**
     * Insereaza un element in baza de date
     * @param o obiectul de inserat in db
     * @return returneaza codul de eroare
     */
    abstract public boolean insert(Object o); 
    
    /**
     * Sterge un obiect din baza de date
     * @param o Obiectul de inserat
     * @return returneaza codul de eroare
     */
    abstract public int delete(Object o); 
    
    /**
     * Actualizeaza un obiect din baza de date
     * @param o Obiectul de sters
     * @return returneaza codul de eroare
     */
    abstract public int update(Object o); 
    
    /**
     * Returneaza un obiect din baza de date dupa id
     * @param id ID-ul de returnat
     * @return Object - obiectul returnat
     */
    abstract public Object get(Integer id); 
}       
