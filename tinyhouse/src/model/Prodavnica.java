/***********************************************************************
 * Module:  Mesto.java
 * author:
 * Purpose: Defines the Class Mesto
 ***********************************************************************/
package model;

import java.io.Serializable;
import java.util.List;

public class Prodavnica implements Serializable {
    private int idProdavnice;
    private double geoSirina;
    private double geoDuzina;
    private String adresa;

    private List<Proizvod> proizvodi;

    public Prodavnica() {
        this.idProdavnice = -1;
        this.adresa = "";
        this.geoSirina = -1;
        this.geoDuzina = -1;
    }

    public Prodavnica(int idProdavnice, String adresa) {
        this.idProdavnice = idProdavnice;
        this.adresa = adresa;
        geoDuzina = 0;
        geoSirina = 0;
    }

    public Prodavnica(int idProdavnice, String adresa, double geoSirina, double geoDuzina) {
        this.idProdavnice = idProdavnice;
        this.geoSirina = geoSirina;
        this.geoDuzina = geoDuzina;
        this.adresa = adresa;
    }

    public void dodajProizvod(Proizvod p) {
        // TODO: implement
    }

    /** @pdGenerated default getter */
    public java.util.List<Proizvod> getProizvodi() {
        if (proizvodi == null)
            proizvodi = new java.util.ArrayList<Proizvod>();
        return proizvodi;
    }

    /** @pdGenerated default iterator getter */
    public java.util.Iterator getIteratorProizvodi() {
        if (proizvodi == null)
            proizvodi = new java.util.ArrayList<Proizvod>();
        return proizvodi.iterator();
    }

    /** @pdGenerated default setter
     * @param newProizvodi */
    public void setProizvodi(java.util.List<Proizvod> newProizvodi) {
        removeAllProizvodi();
        for (java.util.Iterator iter = newProizvodi.iterator(); iter.hasNext();)
            addProizvodi((Proizvod)iter.next());
    }

    /** @pdGenerated default add
     * @param newProizvod */
    public void addProizvodi(Proizvod newProizvod) {
        if (newProizvod == null)
            return;
        if (this.proizvodi == null)
            this.proizvodi = new java.util.ArrayList<Proizvod>();
        if (!this.proizvodi.contains(newProizvod))
        {
            this.proizvodi.add(newProizvod);
            newProizvod.addProdavnice(this);
        }
    }

    /** @pdGenerated default remove
     * @param oldProizvod */
    public void removeProizvodi(Proizvod oldProizvod) {
        if (oldProizvod == null)
            return;
        if (this.proizvodi != null)
            if (this.proizvodi.contains(oldProizvod))
            {
                this.proizvodi.remove(oldProizvod);
                oldProizvod.removeProdavnice(this);
            }
    }

    /** @pdGenerated default removeAll */
    public void removeAllProizvodi() {
        if (proizvodi != null)
        {
            Proizvod oldProizvod;
            for (java.util.Iterator iter = getIteratorProizvodi(); iter.hasNext();)
            {
                oldProizvod = (Proizvod)iter.next();
                iter.remove();
                oldProizvod.removeProdavnice(this);
            }
        }
    }

    public int getIdProdavnice() {
        return idProdavnice;
    }

    public void setIdProdavnice(int idProdavnice) {
        this.idProdavnice = idProdavnice;
    }

    public double getGeoSirina() {
        return geoSirina;
    }

    public void setGeoSirina(double geoSirina) {
        this.geoSirina = geoSirina;
    }

    public double getGeoDuzina() {
        return geoDuzina;
    }

    public void setGeoDuzina(double geoDuzina) {
        this.geoDuzina = geoDuzina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}