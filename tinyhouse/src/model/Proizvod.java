/***********************************************************************
 * Module:  Proizvod.java
 * author:
 * Purpose: Defines the Class Proizvod
 ***********************************************************************/
package model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Proizvod {
    private int id;
    private String naziv;
    private String opis;
    private Image[] slike;
    private int kolicinaZaOnline;

    public List<Proizvod> slicanProizvod;
    public List<ProizvodUProdavnici> prodavnice;
    public List<StavkaCenovnika> cijene;

    /**
     * @param kolicina
     */
    public void umanjiKolicinu(int kolicina) {
        // TODO: implement
    }

    /**
     * @param kolicina
     */
    public void uvecajKolicinu(int kolicina) {
        // TODO: implement
    }

    /**
     * @param kolicina
     */
    public void kupljeno(int kolicina) {
        // TODO: implement
    }

    /**
     * @param kolicina
     */
    public void restokovano(int kolicina) {
        // TODO: implement
    }


    /**
     * @pdGenerated default getter
     */
    public List<Proizvod> getSlicanProizvod() {
        if (slicanProizvod == null)
            slicanProizvod = new ArrayList<Proizvod>();
        return slicanProizvod;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorSlicanProizvod() {
        if (slicanProizvod == null)
            slicanProizvod = new ArrayList<Proizvod>();
        return slicanProizvod.iterator();
    }

    /**
     * @param newSlicanProizvod
     * @pdGenerated default setter
     */
    public void setSlicanProizvod(List<Proizvod> newSlicanProizvod) {
        removeAllSlicanProizvod();
        for (java.util.Iterator iter = newSlicanProizvod.iterator(); iter.hasNext(); )
            addSlicanProizvod((Proizvod) iter.next());
    }

    /**
     * @param newProizvod
     * @pdGenerated default add
     */
    public void addSlicanProizvod(Proizvod newProizvod) {
        if (newProizvod == null)
            return;
        if (this.slicanProizvod == null)
            this.slicanProizvod = new ArrayList<Proizvod>();
        if (!this.slicanProizvod.contains(newProizvod))
            this.slicanProizvod.add(newProizvod);
    }

    /**
     * @param oldProizvod
     * @pdGenerated default remove
     */
    public void removeSlicanProizvod(Proizvod oldProizvod) {
        if (oldProizvod == null)
            return;
        if (this.slicanProizvod != null)
            if (this.slicanProizvod.contains(oldProizvod))
                this.slicanProizvod.remove(oldProizvod);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllSlicanProizvod() {
        if (slicanProizvod != null)
            slicanProizvod.clear();
    }

    /**
     * @pdGenerated default getter
     */
    public List<ProizvodUProdavnici> getProdavnice() {
        if (prodavnice == null)
            prodavnice = new ArrayList<ProizvodUProdavnici>();
        return prodavnice;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorProdavnice() {
        if (prodavnice == null)
            prodavnice = new ArrayList<ProizvodUProdavnici>();
        return prodavnice.iterator();
    }

    /**
     * @param newProdavnice
     * @pdGenerated default setter
     */
    public void setProdavnice(List<ProizvodUProdavnici> newProdavnice) {
        removeAllProdavnice();
        for (java.util.Iterator iter = newProdavnice.iterator(); iter.hasNext(); )
            addProdavnice((ProizvodUProdavnici) iter.next());
    }

    /**
     * @param newProizvodUProdavnici
     * @pdGenerated default add
     */
    public void addProdavnice(ProizvodUProdavnici newProizvodUProdavnici) {
        if (newProizvodUProdavnici == null)
            return;
        if (this.prodavnice == null)
            this.prodavnice = new ArrayList<ProizvodUProdavnici>();
        if (!this.prodavnice.contains(newProizvodUProdavnici)) {
            this.prodavnice.add(newProizvodUProdavnici);
            newProizvodUProdavnici.setProizvod(this);
        }
    }

    /**
     * @param oldProizvodUProdavnici
     * @pdGenerated default remove
     */
    public void removeProdavnice(ProizvodUProdavnici oldProizvodUProdavnici) {
        if (oldProizvodUProdavnici == null)
            return;
        if (this.prodavnice != null)
            if (this.prodavnice.contains(oldProizvodUProdavnici)) {
                this.prodavnice.remove(oldProizvodUProdavnici);
                oldProizvodUProdavnici.setProizvod((Proizvod) null);
            }
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllProdavnice() {
        if (prodavnice != null) {
            ProizvodUProdavnici oldProizvodUProdavnici;
            for (java.util.Iterator iter = getIteratorProdavnice(); iter.hasNext(); ) {
                oldProizvodUProdavnici = (ProizvodUProdavnici) iter.next();
                iter.remove();
                oldProizvodUProdavnici.setProizvod((Proizvod) null);
            }
        }
    }

    /**
     * @pdGenerated default getter
     */
    public List<StavkaCenovnika> getCijene() {
        if (cijene == null)
            cijene = new ArrayList<StavkaCenovnika>();
        return cijene;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorCijene() {
        if (cijene == null)
            cijene = new ArrayList<StavkaCenovnika>();
        return cijene.iterator();
    }

    /**
     * @param newCijene
     * @pdGenerated default setter
     */
    public void setCijene(List<StavkaCenovnika> newCijene) {
        removeAllCijene();
        for (java.util.Iterator iter = newCijene.iterator(); iter.hasNext(); )
            addCijene((StavkaCenovnika) iter.next());
    }

    /**
     * @param newStavkaCenovnika
     * @pdGenerated default add
     */
    public void addCijene(StavkaCenovnika newStavkaCenovnika) {
        if (newStavkaCenovnika == null)
            return;
        if (this.cijene == null)
            this.cijene = new ArrayList<StavkaCenovnika>();
        if (!this.cijene.contains(newStavkaCenovnika)) {
            this.cijene.add(newStavkaCenovnika);
            newStavkaCenovnika.setProizvod(this);
        }
    }

    /**
     * @param oldStavkaCenovnika
     * @pdGenerated default remove
     */
    public void removeCijene(StavkaCenovnika oldStavkaCenovnika) {
        if (oldStavkaCenovnika == null)
            return;
        if (this.cijene != null)
            if (this.cijene.contains(oldStavkaCenovnika)) {
                this.cijene.remove(oldStavkaCenovnika);
                oldStavkaCenovnika.setProizvod((Proizvod) null);
            }
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllCijene() {
        if (cijene != null) {
            StavkaCenovnika oldStavkaCenovnika;
            for (java.util.Iterator iter = getIteratorCijene(); iter.hasNext(); ) {
                oldStavkaCenovnika = (StavkaCenovnika) iter.next();
                iter.remove();
                oldStavkaCenovnika.setProizvod((Proizvod) null);
            }
        }
    }

}