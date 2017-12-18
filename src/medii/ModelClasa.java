/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medii;

import clase.Clasa;
import db.DbClase;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author yo5bdm
 */
public class ModelClasa extends AbstractListModel {
    ArrayList<Clasa> clase = new ArrayList();
    DbClase db = new DbClase();

    public ModelClasa() {
        clase = db.list();
    }
    
    
    @Override
    public int getSize() {
        return clase.size();
    }

    @Override
    public Object getElementAt(int index) {
        return clase.get(index).clasa;
    }    
    
}
