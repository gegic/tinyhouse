/***********************************************************************
 * Module:  Narudzbenica.java
 * author:
 * Purpose: Defines the Class Narudzbenica
 ***********************************************************************/
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Narudzbina {
    private int broj;
    private Date datum;
    private String adresaIsporuke;
    private StanjeNarudzbine stanje;

    public List<StavkaNarudzbine> stavke;
    public StanjeNarudzbine trenutno_stanje;
    public Kupac kupac;

    public void primljenZahtev() {
        // TODO: implement
    }

    public void obavijesti() {
        // TODO: implement
    }

    public void otkazivanjeNarudzbine() {
        // TODO: implement
    }

    public void vracanjeNarudzbine() {
        // TODO: implement
    }

    public boolean uspesnoDostavljena() {
        // TODO: implement
        return false;
    }

    public void kompletiranaNaruzbina() {
        // TODO: implement
    }

    /**
     * @param s
     */
    public void promijeniStanje(StanjeNarudzbine s) {
        // TODO: implement
    }


    /**
     * @pdGenerated default getter
     */
    public List<StavkaNarudzbine> getStavke() {
        if (stavke == null)
            stavke = new ArrayList<StavkaNarudzbine>();
        return stavke;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorStavke() {
        if (stavke == null)
            stavke = new ArrayList<StavkaNarudzbine>();
        return stavke.iterator();
    }

    /**
     * @param newStavke
     * @pdGenerated default setter
     */
    public void setStavke(List<StavkaNarudzbine> newStavke) {
        removeAllStavke();
        for (java.util.Iterator iter = newStavke.iterator(); iter.hasNext(); )
            addStavke((StavkaNarudzbine) iter.next());
    }

    /**
     * @param newStavkaNarudzbine
     * @pdGenerated default add
     */
    public void addStavke(StavkaNarudzbine newStavkaNarudzbine) {
        if (newStavkaNarudzbine == null)
            return;
        if (this.stavke == null)
            this.stavke = new ArrayList<StavkaNarudzbine>();
        if (!this.stavke.contains(newStavkaNarudzbine)) {
            this.stavke.add(newStavkaNarudzbine);
            newStavkaNarudzbine.setNarudzbina(this);
        }
    }

    /**
     * @param oldStavkaNarudzbine
     * @pdGenerated default remove
     */
    public void removeStavke(StavkaNarudzbine oldStavkaNarudzbine) {
        if (oldStavkaNarudzbine == null)
            return;
        if (this.stavke != null)
            if (this.stavke.contains(oldStavkaNarudzbine)) {
                this.stavke.remove(oldStavkaNarudzbine);
                oldStavkaNarudzbine.setNarudzbina((Narudzbina) null);
            }
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllStavke() {
        if (stavke != null) {
            StavkaNarudzbine oldStavkaNarudzbine;
            for (java.util.Iterator iter = getIteratorStavke(); iter.hasNext(); ) {
                oldStavkaNarudzbine = (StavkaNarudzbine) iter.next();
                iter.remove();
                oldStavkaNarudzbine.setNarudzbina((Narudzbina) null);
            }
        }
    }

    /**
     * @pdGenerated default parent getter
     */
    public StanjeNarudzbine getTrenutno_stanje() {
        return trenutno_stanje;
    }

    /**
     * @param newStanjeNarudzbine
     * @pdGenerated default parent setter
     */
    public void setTrenutno_stanje(StanjeNarudzbine newStanjeNarudzbine) {
        if (this.trenutno_stanje == null || !this.trenutno_stanje.equals(newStanjeNarudzbine)) {
            if (this.trenutno_stanje != null)
                this.trenutno_stanje.setNarudzbina(null);
            this.trenutno_stanje = newStanjeNarudzbine;
            if (this.trenutno_stanje != null)
                this.trenutno_stanje.setNarudzbina(this);
        }
    }

    /**
     * @pdGenerated default parent getter
     */
    public Kupac getKupac() {
        return kupac;
    }

    /**
     * @param newKupac
     * @pdGenerated default parent setter
     */
    public void setKupac(Kupac newKupac) {
        if (this.kupac == null || !this.kupac.equals(newKupac)) {
            if (this.kupac != null) {
                Kupac oldKupac = this.kupac;
                this.kupac = null;
                oldKupac.removeNarudzbine(this);
            }
            if (newKupac != null) {
                this.kupac = newKupac;
                this.kupac.addNarudzbine(this);
            }
        }
    }

}