/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medii;

import clase.Clasa;
import clase.Semestru;
import db.DbClase;
import db.DbSemestre;
import java.util.ArrayList;

/**
 *
 * @author yo5bdm
 */
public class InscrieInClasa extends javax.swing.JFrame {
    private int id_elev;
    ModelClasa m = new ModelClasa();
    /**
     * Creates new form InscrieInClasa
     * @param id_elev
     */
    public InscrieInClasa(int id_elev) {
        initComponents();
        setLocationRelativeTo(null); //center
        this.id_elev = id_elev;
        //selecteaza clasele din baza de date si pune-le in tabel
        jList1.setModel(m);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Inscrie = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LiteraClasa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        AnScolar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        Inscrie.setText("Inscrie");
        Inscrie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscrieActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecteaza clasa:");

        jLabel2.setText("Litera clasei (optional):");

        LiteraClasa.setToolTipText("");

        jLabel3.setText("An scolar:");

        AnScolar.setText("2k-de-modificat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel2)
                    .addComponent(LiteraClasa)
                    .addComponent(Inscrie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(AnScolar, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LiteraClasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnScolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Inscrie)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InscrieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscrieActionPerformed
        //datele din formular
        int[] sel = jList1.getSelectedIndices();
        String litera = LiteraClasa.getText();
        String an_scolar = AnScolar.getText();
        //genereaza semestrele
        Semestru unu = new Semestru(id_elev,m.clase.get(sel[0]).id,litera,1,an_scolar);
        Semestru doi = new Semestru(id_elev,m.clase.get(sel[0]).id,litera,2,an_scolar);
        //insereaza clasa in baza de date
        DbSemestre salvare = new DbSemestre();
        salvare.insert(unu);
        salvare.insert(doi);
        //inchide fereastra
    }//GEN-LAST:event_InscrieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnScolar;
    private javax.swing.JButton Inscrie;
    private javax.swing.JTextField LiteraClasa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}