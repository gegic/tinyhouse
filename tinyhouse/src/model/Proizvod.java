/***********************************************************************
 * Module:  Proizvod.java
 * author:
 * Purpose: Defines the Class Proizvod
 ***********************************************************************/
package model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Proizvod {
    private int id;
    private String naziv;
    private String opis;
    private Image[] slike;
    private Kateogrija kategorija;
    private int kolicinaZaOnline;

    public List<Proizvod> slicanProizvod;
    public List<ProizvodUProdavnici> prodavnice;
    public List<StavkaCenovnika> cijene;

    public StavkaCenovnika trenutnaCijena;

    public Proizvod(){
        id = -1;
        naziv = "";
        opis = "";
        kolicinaZaOnline = -1;
        slike = new Image[3];
    }

    public Proizvod(int id, String naziv, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.kolicinaZaOnline = 0;
        slike = new Image[3];
    }

    public Proizvod(int id, String naziv, Kateogrija kategorija, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.kategorija = kategorija;
        this.kolicinaZaOnline = 0;
        slike = new Image[3];
    }

    public Kateogrija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kateogrija kategorija) {
        this.kategorija = kategorija;
    }

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
        if(kolicina > 0){
            kolicinaZaOnline += kolicina;
        }
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Image[] getSlike() {
        return slike;
    }

    public void setSlike(Image[] slike) {
        this.slike[0] = slike[0];
        this.slike[1] = slike[1];
        this.slike[2] = slike[2];
    }

    public int getKolicinaZaOnline() {
        return kolicinaZaOnline;
    }

    public void setKolicinaZaOnline(int kolicinaZaOnline) {
        this.kolicinaZaOnline = kolicinaZaOnline;
    }

    public void setSlika(Image slika, int index){
        if(index < 3 && index >= 0)
            this.slike[index] = slika;
    }

    public StavkaCenovnika getTrenutnaCijena() {
        return trenutnaCijena;
    }

    public void setTrenutnaCijena(StavkaCenovnika trenutnaCijena) {
        this.trenutnaCijena = trenutnaCijena;
    }

    public void setTrenutnaCijena(float cijena, Date datumP){
        if(this.trenutnaCijena != null){
            this.trenutnaCijena.setKrajVazenja(datumP);
        }
        this.trenutnaCijena = new StavkaCenovnika(cijena, datumP);
        this.trenutnaCijena.setProizvod(this);
        Aplikacija.getInstance().cenovnik.addStavke(this.trenutnaCijena);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proizvod proizvod = (Proizvod) o;
        return id == proizvod.id &&
                Objects.equals(naziv, proizvod.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void decreaseKolicinaZaOnline(int k){
        kolicinaZaOnline -= k;
    }
}