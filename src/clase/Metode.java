/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import javax.swing.JOptionPane;

/**
 *
 * @author yo5bdm
 */
public class Metode {

    /**
     * Afisare mesaj eroare.
     * Metoda statica pentru afisare mesaj de eroare de oriunde
     * @param msg String cu mesajul dorit
     */
    public static void mesajEroare(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Eroare!", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Afisare mesaj de atentionare.
     * Metoda statica pentru afisare mesaj de atentionare
     * @param msg String cu mesajul dorit
     */
    public static void mesajAtentie(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Atentie!", JOptionPane.WARNING_MESSAGE);
    }
    
}
