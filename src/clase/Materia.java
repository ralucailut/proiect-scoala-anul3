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
public class Materia {
    public Integer id;
    public Integer materia_id;
    public Integer clasa_id;
    
    public String nume_materie;
    public String nume_clasa;

    public Materia(Integer id, Integer materia_id, Integer clasa_id, String nume_materie, String nume_clasa) {
        this.id = id;
        this.materia_id = materia_id;
        this.clasa_id = clasa_id;
        this.nume_materie = nume_materie;
        this.nume_clasa = nume_clasa;
    }

    public Materia(Integer materia_id, String nume_materie) {
        this.materia_id = materia_id;
        this.nume_materie = nume_materie;
    }
}
