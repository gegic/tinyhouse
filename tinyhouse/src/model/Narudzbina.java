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
    private float cijena;
    public List<StavkaNarudzbine> stavke;
    public StanjeNarudzbine trenutno_stanje;
    public Kupac kupac;

    public Narudzbina(){
        this.broj = -1;
        this.datum = new Date();
        this.adresaIsporuke = "";
        this.stavke = new ArrayList<>();
        cijena = 0;
        this.kupac = null;
        setTrenutno_stanje(new Obrada());

    }

    public Narudzbina(int broj, String adresaIsporuke, List<StavkaNarudzbine> stavke, Kupac kupac){
        this.broj = broj;
        this.datum = new Date();
        this.adresaIsporuke = adresaIsporuke;
        this.stavke = stavke;
        this.kupac = kupac;
        cijena = 0;
        this.kupac.addNarudzbine(this);
        setTrenutno_stanje(new Obrada());
    }

    public Narudzbina(int broj, Date datum, String adresaIsporuke, List<StavkaNarudzbine> stavke, Kupac kupac) {
        this.broj = broj;
        this.datum = datum;
        this.adresaIsporuke = adresaIsporuke;
        this.stavke = stavke;
        this.kupac = kupac;
        this.kupac.addNarudzbine(this);
        setTrenutno_stanje(new Obrada());

        cijena = 0;

    }

    public Narudzbina(int broj, String adresaIsporuke, float cijena, List<StavkaNarudzbine> stavke, Kupac kupac) {
        this.broj = broj;
        this.adresaIsporuke = adresaIsporuke;
        this.cijena = cijena;
        this.stavke = stavke;
        this.kupac = kupac;
        this.kupac.addNarudzbine(this);
        setTrenutno_stanje(new Obrada());
    }

    public Narudzbina(int broj, Date datum, String adresaIsporuke, List<StavkaNarudzbine> stavke, StanjeNarudzbine trenutno_stanje, Kupac kupac) {
        this.broj = broj;
        this.datum = datum;
        this.adresaIsporuke = adresaIsporuke;
        this.stavke = stavke;
        setTrenutno_stanje(trenutno_stanje);
        this.kupac = kupac;
        this.kupac.addNarudzbine(this);
    }

    public Narudzbina(int broj, Date datum, String adresaIsporuke, float cijena, List<StavkaNarudzbine> stavke, StanjeNarudzbine trenutno_stanje, Kupac kupac) {
        this.broj = broj;
        this.datum = datum;
        this.adresaIsporuke = adresaIsporuke;
        this.cijena = cijena;
        this.stavke = stavke;
        this.trenutno_stanje = trenutno_stanje;
        this.kupac = kupac;
    }

    public void primljenZahtev() {
        // TODO: implement
    }

    public void obavijesti() {
        // TODO: implement
    }

    public void otkazivanjeNarudzbine() {
        trenutno_stanje.otkazivanjeNarudzbine();
    }

    public void vracanjeNarudzbine() {
        trenutno_stanje.vracanjeNarudzbine();
    }

    public void uspesnoDostavljena() {
        trenutno_stanje.uspesnoDostavljena();
    }

    public void vracanjeUPromet(){
        for(StavkaNarudzbine s : stavke){
            s.getProizvod().increaseKolicinaZaOnline(s.getNarucenaKolicina());
        }
    };

    public void kompletiranaNaruzbina() {
        trenutno_stanje.kompletiranaNaruzbina();
    }

    /**
     * @param s
     */
    public void promijeniStanje(StanjeNarudzbine s) {
        setTrenutno_stanje(s);
        s.entry();
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

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getAdresaIsporuke() {
        return adresaIsporuke;
    }

    public void setAdresaIsporuke(String adresaIsporuke) {
        this.adresaIsporuke = adresaIsporuke;
    }

    public void setStavkeCijena(ArrayList<StavkaNarudzbine> stavke, int cijena){

    }

    public float getCijena() {
        return cijena;
    }

    public void setCijena(float cijena) {
        this.cijena = cijena;
    }
}
