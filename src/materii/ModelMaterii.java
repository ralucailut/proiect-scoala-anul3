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
    private DbMaterii dbMaterii;
    private ArrayList<Materia> listaMaterii;
    
    private String[] coloane = {"Clasa"};
    private final Class[] columnClass = new Class[] {
        Integer.class
    };
    
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
}
