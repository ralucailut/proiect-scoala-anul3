/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materii;

import clase.*;
import db.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yo5bdm
 */
public class ModelClase extends AbstractTableModel {
    private DbClase dbclase;
    private ArrayList<Clasa> listaClase;
    
    private String[] coloane = {"Clasa"};
    private final Class[] columnClass = new Class[] {
        Integer.class
    };
    
    public ModelClase() {
    dbclase = new DbClase();
    listaClase = dbclase.list();
    }
    @Override
    public int getRowCount() {
        return listaClase.size();
    }
    @Override
    public int getColumnCount() {
       return coloane.length; 
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return listaClase.get(rowIndex).clasa;
    }
    @Override
    public String getColumnName(int nr) {
        return coloane[nr];
    }
    public Clasa getFirst() {
        return listaClase.get(0);
    }
    Clasa get(int i) {
        return listaClase.get(i);
    }
}
