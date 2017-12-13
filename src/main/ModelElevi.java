/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import db.DbElev;
import clase.Elev;
import clase.Metode;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author yo5bdm
 */
public class ModelElevi extends AbstractTableModel {
    private final DbElev db;
    ArrayList<Elev> lista_elevi = new ArrayList();
    
    String[] coloane = {"Nume complet","CNP","Numar matricol","Nationalitate","Inmatriculat"};
    private final Class[] columnClass = new Class[] {
        String.class, String.class, String.class, String.class, Boolean.class
    };
    
    ModelElevi() {
        this.db = new DbElev();
        refresh();
    }
    
    private void refresh () {
        lista_elevi = db.list();
    }

    @Override
    public int getRowCount() {
        return lista_elevi.size();
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return coloane.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lista_elevi.get(rowIndex).NumeComplet();
            case 1:
                return lista_elevi.get(rowIndex).CNP;
            case 2:
                return lista_elevi.get(rowIndex).NrMatricol();
            case 3:
                return lista_elevi.get(rowIndex).nationalitate;
            default:
                return lista_elevi.get(rowIndex).inmatriculat;
        }
    }
    
    @Override
    public String getColumnName(int nr) {
        return coloane[nr];
    }

    void adauga(Elev e) {
        db.insert(e);
        refresh();
        this.fireTableDataChanged();
    }

    void sterge(int[] selection) {
        for(int i:selection) {
            String cnp = getValueAt(i,1).toString();
            if(db.delete(findCnp(cnp))<1) Metode.mesajEroare("Eroare la stergere!");
        }
        refresh();
        this.fireTableDataChanged();
    }
    Elev findCnp(String cnp) {
        for(int i=0;i<lista_elevi.size();i++){
            Elev e = lista_elevi.get(i);
            if(cnp.equalsIgnoreCase(e.CNP)) return e;
        }
        return null;
    }

    Elev getElev(int id) {
        return lista_elevi.get(id);
    }

    void update(Elev n) {
        db.update(n);
        refresh();
        this.fireTableDataChanged();
    }

    int getElevId(int i) {
        return lista_elevi.get(i).id;
    }
}
