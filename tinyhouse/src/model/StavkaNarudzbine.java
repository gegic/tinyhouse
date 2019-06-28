/***********************************************************************
 * Module:  StavkaNarudzbenice.java
 * author:
 * Purpose: Defines the Class StavkaNarudzbenice
 ***********************************************************************/
package model;

public class StavkaNarudzbine {
    private int narucenaKolicina;
    private float jedinicnaCena;
    private float ukupno;

    public Proizvod proizvod;
    public Narudzbina narudzbina;


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

}