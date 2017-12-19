/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materii;

import clase.Clasa;
import clase.Materia;
import db.DbMaterii;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yo5bdm
 */
public class ModelMaterii extends AbstractTableModel {
    private Clasa clasa_curenta;
    private DbMaterii dbMaterii;
    private ArrayList<Materia> listaMaterii;
    
    private String[] coloane = {"Materia"};
    private final Class[] columnClass = new Class[] {
        String.class
    };
    ModelMaterii(Clasa first) {
        dbMaterii = new DbMaterii();
        clasa_curenta = first;
        refresh();
    }
    public void reincarca(Clasa c) {
        clasa_curenta = c;
        refresh();
    }
    @Override
    public int getRowCount() {
        return listaMaterii.size();
    }
    @Override
    public int getColumnCount() {
       return coloane.length; 
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return listaMaterii.get(rowIndex).nume_materie;
    }
    @Override
    public String getColumnName(int nr) {
        return coloane[nr];
    }
    private void refresh() {
        listaMaterii = dbMaterii.cauta(clasa_curenta.clasa);
        this.fireTableDataChanged();
    }
}
