/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medii;

import db.*;
import clase.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import static medii.ListaMediiElev.eu;


/**
 * Clasa ce face legatura intre lista de medii si tabelul aferent din UX
 * @author yo5bdm
 */
public class ModelListaMaterii extends AbstractTableModel {
    public Semestru semestrul;
        
    private ArrayList<Media> lista_note = new ArrayList();
    
    
    private String tabel_note="medii_semestriales"; //$tabel_note
    private String tabel_materii = "materiis"; //$tabel_materii
    private DbMedii db;
    
    protected String[] coloane = {"Materia","Media"};
    private final Class[] columnClass = new Class[] { String.class, Double.class };
    //constructor
    public ModelListaMaterii(Semestru semestrul) {
        //if(semestrul != null) setSemestrul(semestrul);
        db = new DbMedii();
    }

    public void setSemestrul(Semestru semestrul) {
        this.semestrul = semestrul;
        refresh();
    }
    
    
    private void refresh() {
        try {
            lista_note.clear();
            Media m = new Media(0,0);
            String q = ""
            + "SELECT * "
            + "FROM "+Setari.MEDII+" JOIN "+Setari.SEMESTRE+" "
            + "ON "+Setari.MEDII+".elev_clasa_id = "+Setari.SEMESTRE+".id "
            + "JOIN "+Setari.NUME_MATERII+" ON "+Setari.NUME_MATERII+".id = "
                    +Setari.MEDII+".materia_id "
            + "WHERE "+Setari.SEMESTRE+".id = $ID";
            q = q.replace("$ID",semestrul.id+"");
            ResultSet rs = db.query(q);
            while(rs.next()) {
                lista_note.add(
                        new Media(
                                rs.getInt(Setari.MEDII+".id"),
                                rs.getInt(Setari.SEMESTRE+".id"),
                                rs.getInt(Setari.SEMESTRE+".elev_id"), 
                                rs.getString(Setari.NUME_MATERII+".Nume_materie"),
                                rs.getDouble("media")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelListaSemestre.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return lista_note.size();
    }

    @Override
    public int getColumnCount() {
        return coloane.length;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 1) return true;
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Media n = lista_note.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return n.materia;
            default:
                return n.media;
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
    
    public void completeaza(Semestru s) {
        ArrayList<Materia> lista_materii;
        DbMaterii mat = new DbMaterii();
        lista_materii = mat.cauta(s.clasa_id);
        for(int i=0;i<lista_materii.size();i++) {
            db.salveaza(new Media(s.id,lista_materii.get(i).materia_id));
        }
        refresh();
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        int index = eu.conversie(rowIndex);
        db.update(lista_note.get(index),(double) aValue);
        refresh();
    }
}
