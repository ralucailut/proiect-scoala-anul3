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
public class Media {
    public Integer id;
    public Integer materia_id;
    public Integer semestrul_id;
    public String materia;
    public Double media;
    /**
     * Constructor 2
     * @param id -id din baza de date
     * @param materia_id idul materiei
     * @param elev_id idul elevului
     * @param materia numele materiei
     * @param media media
     */
    public Media(Integer id, Integer materia_id, Integer elev_id, String materia, Double media) {
        this.id = id;
        this.materia_id = materia_id;
        this.semestrul_id = elev_id;
        this.materia = materia;
        this.media = media;
    }
    /**
     * Constructor pentru salvare medii noi
     * @param materia_id idul materiei din baza de date
     * @param elev_id id-ul semestrului pentru care se face salvarea
     */
    public Media(Integer semestrul_id, Integer materia_id) {
        this.materia_id = materia_id;
        this.semestrul_id = semestrul_id;
    } 

    @Override
    public String toString() {
        return "Media{" + "id=" + id + ", materia_id=" + materia_id + ", semestrul_id=" + semestrul_id + ", materia=" + materia + ", media=" + media + '}';
    }
  
}