/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

/**
 *
 * @author yo5bdm
 */
public class Semestru {
    //medii semestriale
    public Integer id;
    public Integer elev_id;
    public Integer clasa_id;
    public String litera;
    public Integer nr_semestru;
    public String an_scolar;
    public String clasa;
    //public String semestrul;

    /*public Semestru(Integer id, String clasa, Integer semestrul) {
        this.id = id;
        this.clasa = clasa;
        this.nr_semestru = semestrul;
    }*/
    /**
     * Constructor de salvare
     * @param elev_id
     * @param clasa_id
     * @param litera
     * @param nr_semestru
     * @param an_scolar 
     */
    public Semestru(Integer elev_id, Integer clasa_id, String litera, Integer nr_semestru, String an_scolar)    {
        this.elev_id = elev_id;
        this.clasa_id = clasa_id;
        this.litera = litera;
        this.nr_semestru = nr_semestru;
        this.an_scolar = an_scolar;
        this.clasa = clasa;
    }
    /**
     * Constructor de afisare si generare lista
     * @param id
     * @param elev_id
     * @param clasa_id
     * @param litera
     * @param nr_semestru
     * @param an_scolar
     * @param clasa 
     */
    public Semestru(Integer id, Integer elev_id, Integer clasa_id, String litera, Integer nr_semestru, String an_scolar, String clasa) {
        this.id = id;
        this.elev_id = elev_id;
        this.clasa_id = clasa_id;
        this.litera = litera;
        this.nr_semestru = nr_semestru;
        this.an_scolar = an_scolar;
        this.clasa = clasa;
    }
    
    
    

    @Override
    public String toString() {
        return "Semestru{" + "id=" + id + ", clasa_id=" + clasa_id + ", litera=" + litera + ", nr_semestru=" + nr_semestru + ", an_scolar=" + an_scolar + ", clasa=" + clasa + '}';
    }
    
    
}