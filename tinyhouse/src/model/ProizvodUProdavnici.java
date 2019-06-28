/***********************************************************************
 * Module:  ProizvodUProdavnici.java
 * Author:  Gegic
 * Purpose: Defines the Class ProizvodUProdavnici
 ***********************************************************************/

package model;

public class ProizvodUProdavnici {
    private int fizickaKolicina;

    public Prodavnica prodavnica;
    public Proizvod proizvod;


    /**
     * @pdGenerated default parent getter
     */
    public Prodavnica getProdavnica() {
        return prodavnica;
    }

    /**
     * @param newProdavnica
     * @pdGenerated default parent setter
     */
    public void setProdavnica(Prodavnica newProdavnica) {
        if (this.prodavnica == null || !this.prodavnica.equals(newProdavnica)) {
            if (this.prodavnica != null) {
                Prodavnica oldProdavnica = this.prodavnica;
                this.prodavnica = null;
                oldProdavnica.removeProizvodi(this);
            }
            if (newProdavnica != null) {
                this.prodavnica = newProdavnica;
                this.prodavnica.addProizvodi(this);
            }
        }
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
                oldProizvod.removeProdavnice(this);
            }
            if (newProizvod != null) {
                this.proizvod = newProizvod;
                this.proizvod.addProdavnice(this);
            }
        }
    }

}