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
public class Elev {
    public Integer id;
    public String Nume;
    public String Prenume;
    public String Initiala_tatalui;
    public String CNP;
    public String Volum_matricol;
    public String Pagina_matricol;
    public String adresa_elev;
    public String adresa_parinti;
    public String locul_nasterii;
    public String nationalitate;
    public String nume_mama;
    public String nume_tata;
    public Boolean inmatriculat;
    public Boolean transferat;
    public String observatii;

    public Elev(Integer id, String Nume, String Prenume, String Initiala_tatalui, String CNP, String Volum_matricol, String Pagina_matricol, String adresa_elev, String adresa_parinti, String locul_nasterii, String nationalitate, String nume_tata, String nume_mama, Boolean inmatriculat, Boolean transferat, String observatii) {
        this.id = id;
        this.Nume = Nume;
        this.Prenume = Prenume;
        this.Initiala_tatalui = Initiala_tatalui;
        this.CNP = CNP;
        this.Volum_matricol = Volum_matricol;
        this.Pagina_matricol = Pagina_matricol;
        this.adresa_elev = adresa_elev;
        this.adresa_parinti = adresa_parinti;
        this.locul_nasterii = locul_nasterii;
        this.nationalitate = nationalitate;
        this.nume_mama = nume_mama;
        this.nume_tata = nume_tata;
        this.inmatriculat = inmatriculat;
        this.transferat = transferat;
        this.observatii = observatii;
    }
     
    public String NumeComplet() {
        return Nume+" "+Initiala_tatalui+". "+Prenume;
    }
    public String NrMatricol() {
        return Volum_matricol+" / "+Pagina_matricol;
    }

    @Override
    public String toString() {
        return "Elev{" + "id=" + id + ", Nume=" + Nume + ", Prenume=" + Prenume + ", Initiala_tatalui=" + Initiala_tatalui + ", CNP=" + CNP + ", Volum_matricol=" + Volum_matricol + ", Pagina_matricol=" + Pagina_matricol + ", adresa_elev=" + adresa_elev + ", adresa_parinti=" + adresa_parinti + ", locul_nasterii=" + locul_nasterii + ", nationalitate=" + nationalitate + ", nume_mama=" + nume_mama + ", nume_tata=" + nume_tata + ", inmatriculat=" + inmatriculat + ", transferat=" + transferat + ", observatii=" + observatii + '}';
    }

    
    
}
