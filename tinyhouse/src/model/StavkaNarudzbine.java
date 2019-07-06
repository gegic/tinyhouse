/***********************************************************************
 * Module:  StavkaNarudzbenice.java
 * author:
 * Purpose: Defines the Class StavkaNarudzbenice
 ***********************************************************************/
package model;

import java.io.Serializable;

public class StavkaNarudzbine implements Serializable {
    private int narucenaKolicina;
    private float jedinicnaCena;
    private float ukupno;

    public Proizvod proizvod;
    public Narudzbina narudzbina;

    public  StavkaNarudzbine(){
        this.narucenaKolicina = 0;
        this.jedinicnaCena = 0;
        this.ukupno = 0;
    }

    public StavkaNarudzbine(int narucenaKolicina, float jedinicnaCena, Proizvod proizvod) {
        this.narucenaKolicina = narucenaKolicina;
        this.jedinicnaCena = jedinicnaCena;
        this.proizvod = proizvod;
        this.ukupno = this.jedinicnaCena * this.narucenaKolicina;
    }

    public StavkaNarudzbine(int narucenaKolicina, float jedinicnaCena, float ukupno, Proizvod proizvod) {
        this.narucenaKolicina = narucenaKolicina;
        this.jedinicnaCena = jedinicnaCena;
        this.ukupno = ukupno;
        this.proizvod = proizvod;
    }

    public StavkaNarudzbine(int narucenaKolicina, float jedinicnaCena, float ukupno) {
        this.narucenaKolicina = narucenaKolicina;
        this.jedinicnaCena = jedinicnaCena;
        this.ukupno = ukupno;
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
        this.proizvod = newProizvod;
    }

    /**
     * @pdGenerated default parent getter
     */
    public Narudzbina getNarudzbina() {
        return narudzbina;
    }

    /**
     * @param newNarudzbina
     * @pdGenerated default parent setter
     */
    public void setNarudzbina(Narudzbina newNarudzbina) {
        if (this.narudzbina == null || !this.narudzbina.equals(newNarudzbina)) {
            if (this.narudzbina != null) {
                Narudzbina oldNarudzbina = this.narudzbina;
                this.narudzbina = null;
                oldNarudzbina.removeStavke(this);
            }
            if (newNarudzbina != null) {
                this.narudzbina = newNarudzbina;
                this.narudzbina.addStavke(this);
            }
        }
    }

    public int getNarucenaKolicina() {
        return narucenaKolicina;
    }

    public void setNarucenaKolicina(int narucenaKolicina) {
        this.narucenaKolicina = narucenaKolicina;
        this.ukupno = narucenaKolicina * this.jedinicnaCena;
    }

    public float getJedinicnaCena() {
        return jedinicnaCena;
    }

    public void setJedinicnaCena(float jedinicnaCena) {
        this.jedinicnaCena = jedinicnaCena;
        this.ukupno = this.jedinicnaCena * this.narucenaKolicina;
    }

    public float getUkupno() {
        return ukupno;
    }


}