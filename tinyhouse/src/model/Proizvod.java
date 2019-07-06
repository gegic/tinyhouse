/***********************************************************************
 * Module:  Proizvod.java
 * author:
 * Purpose: Defines the Class Proizvod
 ***********************************************************************/
package model;

import com.sun.javafx.fxml.builder.JavaFXImageBuilder;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Proizvod implements Serializable {
    private int id;
    private String naziv;
    private String opis;
    private transient Image[] slike;
    private String[] paths;
    private Kategorija kategorija;
    private int kolicinaZaOnline;

    private List<Prodavnica> prodavnice;

    public List<Proizvod> slicanProizvod;
    public List<StavkaCenovnika> cijene;

    public StavkaCenovnika trenutnaCijena;

    public Proizvod(){
        id = -1;
        naziv = "";
        opis = "";
        kolicinaZaOnline = -1;
        slike = new Image[3];
        paths = new String[3];
    }

    public Proizvod(int id, String naziv, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.kolicinaZaOnline = 0;
        slike = new Image[3];
        paths = new String[3];

    }

    public Proizvod(int id, String naziv, Kategorija kategorija, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        setKategorija(kategorija);
        this.kolicinaZaOnline = 0;
        slike = new Image[3];
        paths = new String[3];
    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeInt(id);
        stream.writeObject(naziv);
        stream.writeObject(opis);
        stream.writeObject(paths);
        stream.writeObject(kategorija);
        stream.writeInt(kolicinaZaOnline);
        stream.writeObject(slicanProizvod);
        stream.writeObject(prodavnice);
        stream.writeObject(cijene);
        stream.writeObject(trenutnaCijena);
    }
    @SuppressWarnings("unchecked")
    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        id = stream.readInt();
        naziv = (String) stream.readObject();
        opis = (String) stream.readObject();
        paths = (String[]) stream.readObject();
        kategorija = (Kategorija) stream.readObject();
        kolicinaZaOnline = stream.readInt();
        slicanProizvod = (List<Proizvod>)stream.readObject();
        prodavnice = (List<Prodavnica>) stream.readObject();
        cijene = (List<StavkaCenovnika>) stream.readObject();
        trenutnaCijena = (StavkaCenovnika) stream.readObject();


        if(slike == null){
            slike = new Image[3];
        }
        for(int i = 0; i < paths.length; ++i){
            if(paths[i] != null) slike[i] = new Image(paths[i]);
        }
    }


    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija newKategorija) {
        if (this.kategorija == null || !this.kategorija.equals(newKategorija))
        {
            if (this.kategorija != null)
            {
                Kategorija oldKategorija = this.kategorija;
                this.kategorija = null;
                oldKategorija.removeProizvodi(this);
            }
            if (newKategorija != null)
            {
                this.kategorija = newKategorija;
                this.kategorija.addProizvod(this);
            }
        }
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

    /** @pdGenerated default getter */
    public java.util.List<Prodavnica> getProdavnice() {
        if (prodavnice == null)
            prodavnice = new java.util.ArrayList<Prodavnica>();
        return prodavnice;
    }

    /** @pdGenerated default iterator getter */
    public java.util.Iterator getIteratorProdavnice() {
        if (prodavnice == null)
            prodavnice = new java.util.ArrayList<Prodavnica>();
        return prodavnice.iterator();
    }
    /** @pdGenerated default setter
     * @param newProdavnice */
    public void setProdavnice(java.util.List<Prodavnica> newProdavnice) {
        removeAllProdavnice();
        for (java.util.Iterator iter = newProdavnice.iterator(); iter.hasNext();)
            addProdavnice((Prodavnica)iter.next());
    }

    /** @pdGenerated default add
     * @param newProdavnica */
    public void addProdavnice(Prodavnica newProdavnica) {
        if (newProdavnica == null)
            return;
        if (this.prodavnice == null)
            this.prodavnice = new java.util.ArrayList<Prodavnica>();
        if (!this.prodavnice.contains(newProdavnica))
        {
            this.prodavnice.add(newProdavnica);
            newProdavnica.addProizvodi(this);
        }
    }

    /** @pdGenerated default remove
     * @param oldProdavnica */
    public void removeProdavnice(Prodavnica oldProdavnica) {
        if (oldProdavnica == null)
            return;
        if (this.prodavnice != null)
            if (this.prodavnice.contains(oldProdavnica))
            {
                this.prodavnice.remove(oldProdavnica);
                oldProdavnica.removeProizvodi(this);
            }
    }

    /** @pdGenerated default removeAll */
    public void removeAllProdavnice() {
        if (prodavnice != null)
        {
            Prodavnica oldProdavnica;
            for (java.util.Iterator iter = getIteratorProdavnice(); iter.hasNext();)
            {
                oldProdavnica = (Prodavnica)iter.next();
                iter.remove();
                oldProdavnica.removeProizvodi(this);
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

    public void setSlike(Image[] slike, String[] paths) {
        this.slike = slike;
        this.paths = paths;
    }

    public int getKolicinaZaOnline() {
        return kolicinaZaOnline;
    }

    public void setKolicinaZaOnline(int kolicinaZaOnline) {
        this.kolicinaZaOnline = kolicinaZaOnline;
    }

    public void setSlika(Image slika, String path, int index){
        if(index < 3 && index >= 0) {
            this.slike[index] = slika;
            this.paths[index] = path;
        }
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

    public String[] getPaths() {
        return paths;
    }

    public void decreaseKolicinaZaOnline(int k){
        kolicinaZaOnline -= k;
    }
    public void increaseKolicinaZaOnline(int k){
        kolicinaZaOnline += k;
    }
}