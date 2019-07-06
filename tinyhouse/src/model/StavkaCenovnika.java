/***********************************************************************
 * Module:  StavkaCenovnika.java
 * author:
 * Purpose: Defines the Class StavkaCenovnika
 ***********************************************************************/
package model;

import java.io.Serializable;
import java.util.Date;

public class StavkaCenovnika implements Serializable {
    private float jedinicnaCena;
    private Date pocetakVazenja;
    private Date krajVazenja;

    public Proizvod proizvod;
    public Cenovnik cenovnik;

    public StavkaCenovnika(float jedinicnaCena, Date pocetakVazenja) {
        this.jedinicnaCena = jedinicnaCena;
        this.pocetakVazenja = pocetakVazenja;
        this.krajVazenja = null;
        this.cenovnik = null;
        this.proizvod = null;
    }


    public StavkaCenovnika(float jedinicnaCena, Date pocetakVazenja, Date krajVazenja, Proizvod proizvod, Cenovnik cenovnik) {
        this.jedinicnaCena = jedinicnaCena;
        this.pocetakVazenja = pocetakVazenja;
        this.krajVazenja = krajVazenja;
        this.proizvod = proizvod;
        this.cenovnik = cenovnik;
    }

    /**
     * @pdGenerated default parent getter
     */
    public Proizvod getProizvod() {
        return proizvod;
    }

    /**
     * @param newProizvod
     * @pdGenerated default parent setter
     */
    public void setProizvod(Proizvod newProizvod) {
        if (this.proizvod == null || !this.proizvod.equals(newProizvod)) {
            if (this.proizvod != null) {
                Proizvod oldProizvod = this.proizvod;
                this.proizvod = null;
                oldProizvod.removeCijene(this);
            }
            if (newProizvod != null) {
                this.proizvod = newProizvod;
                this.proizvod.addCijene(this);
            }
        }
    }

    /**
     * @pdGenerated default parent getter
     */
    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    /**
     * @param newCenovnik
     * @pdGenerated default parent setter
     */
    public void setCenovnik(Cenovnik newCenovnik) {
        if (this.cenovnik == null || !this.cenovnik.equals(newCenovnik)) {
            if (this.cenovnik != null) {
                Cenovnik oldCenovnik = this.cenovnik;
                this.cenovnik = null;
                oldCenovnik.removeStavke(this);
            }
            if (newCenovnik != null) {
                this.cenovnik = newCenovnik;
                this.cenovnik.addStavke(this);
            }
        }
    }

    public float getJedinicnaCena() {
        return jedinicnaCena;
    }

    public void setJedinicnaCena(float jedinicnaCena) {
        this.jedinicnaCena = jedinicnaCena;
    }

    public Date getPocetakVazenja() {
        return pocetakVazenja;
    }

    public void setPocetakVazenja(Date pocetakVazenja) {
        this.pocetakVazenja = pocetakVazenja;
    }

    public Date getKrajVazenja() {
        return krajVazenja;
    }

    public void setKrajVazenja(Date krajVazenja) {
        this.krajVazenja = krajVazenja;
    }
}