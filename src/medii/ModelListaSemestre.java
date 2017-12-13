/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medii;

import db.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import clase.*;

public class ModelListaSemestre extends AbstractTableModel {
    public Elev e;
    
    protected String[] coloane = {"Clasa","Semestrul"};
        
    
    private String tabel_elev_clasa = "elev_clasa";
    private String tabel_clase = "clases";
    
    private DbMedii db;
    private final Class[] columnClass = new Class[] { String.class, Integer.class };
    private ArrayList<Semestru> lista_medii = new ArrayList();
    
    ModelListaSemestre(int id_elev) {
        DbElev me = new DbElev();
        e = (Elev) me.get(id_elev);
        me = null;
        db = new DbMedii(e);
        refresh();
    }
    
    protected void refresh() {
        try {
            String q = ""
            + "SELECT * "
            + "FROM "+Setari.SEMESTRE+" JOIN "+Setari.NUME_CLASA+" "
            + "ON "+Setari.SEMESTRE+".clasa_id = "+Setari.NUME_CLASA+".id "
            + "WHERE elev_id = $ID "
            + "ORDER BY clasa, semestrul";  
            lista_medii.clear();
            q = q.replace("$ID",e.id+"");
            ResultSet rs = db.query(q);
            while(rs.next()) {
                lista_medii.add(
                        new Semestru(
                                rs.getInt(Setari.SEMESTRE+".id"), //Integer id, 
                                rs.getInt(Setari.SEMESTRE+".elev_id"), //Integer elev_id, 
                                rs.getInt(Setari.SEMESTRE+".clasa_id"), //Integer clasa_id, 
                                rs.getString(Setari.SEMESTRE+".litera_clasa"),//String litera, 
                                rs.getInt(Setari.SEMESTRE+".semestrul"), //Integer nr_semestru, 
                                rs.getString(Setari.SEMESTRE+".an_scolar"),//String an_scolar, 
                                rs.getString(Setari.NUME_CLASA+".clasa") //String clasa
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelListaSemestre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        return lista_medii.size();
    }

    @Override
    public int getColumnCount() {
        return coloane.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Semestru s = lista_medii.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return s.clasa;
            default:
                return s.nr_semestru;
        }
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }
    
    @Override
    public String getColumnName(int nr) {
        return coloane[nr];
    }

    public Semestru primul() {
        if(lista_medii.size()>0) return lista_medii.get(0);
        return null;
    }
    
    public Semestru get(int i) {
        return lista_medii.get(i);
    }
    
}
