package model;

import java.io.Serializable;
import java.util.*;

public class Kategorija implements Serializable {
    private String naziv;
    private String putanja;
    private Kategorija natkategorija;
    private List<Kategorija> potkategorije;
    private List<Proizvod> proizvodi;

    public Kategorija(){
        this("");
    }

    public Kategorija(String naziv) {
        this.naziv = naziv;
        setPutanja();
        this.potkategorije = new ArrayList<>();
        this.proizvodi = new ArrayList<>();
    }

    public Kategorija(String naziv, Kategorija natkategorija){
        this.naziv = naziv;
        this.natkategorija = natkategorija;
        natkategorija.addPotkategorija(this);
        setPutanja();
        this.potkategorije = new ArrayList<>();
        this.proizvodi = new ArrayList<>();
    }

    public Kategorija(String naziv, String putanja, Kategorija natkategorija, List<Kategorija> potkategorije) {
        this.naziv = naziv;
        this.putanja = putanja;
        this.natkategorija = natkategorija;
        this.potkategorije = potkategorije;
        this.proizvodi = new ArrayList<>();
    }

    public Kategorija(String naziv, String putanja, Kategorija natkategorija, List<Kategorija> potkategorije, List<Proizvod> proizvodi) {
        this.naziv = naziv;
        this.putanja = putanja;
        this.natkategorija = natkategorija;
        this.potkategorije = potkategorije;
        this.proizvodi = proizvodi;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Kategorija getNatkategorija() {
        return natkategorija;
    }

    public void setNatkategorija(Kategorija natkategorija) {
        this.natkategorija = natkategorija;
    }

    public List<Kategorija> getPotkategorije() {
        if (this.potkategorije == null)
            this.potkategorije = new ArrayList<Kategorija>();
        return this.potkategorije;
    }

    public void setPotkategorije(List<Kategorija> potkategorije) {
        this.potkategorije = potkategorije;
    }

    public void addPotkategorija(Kategorija potkategorija){
        if(potkategorija == null) return;
        if(this.potkategorije == null) this.potkategorije = new ArrayList<>();
        if(potkategorija.getNatkategorija() == this){
            this.potkategorije.add(potkategorija);
        } else if(potkategorija.getNatkategorija() == null){
            potkategorija.setNatkategorija(this);
            this.potkategorije.add(potkategorija);
        } else{
            return;
        }
    }

    public void setPutanja(){
        if(natkategorija == null) putanja = naziv;
        else putanja = natkategorija.getPutanja() + " > " + naziv;
    }



    public String getPutanja() {
        return putanja;
    }

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    public void addProizvod(Proizvod newProizvod) {
        if (newProizvod == null)
            return;
        if (this.proizvodi == null)
            this.proizvodi = new java.util.ArrayList<Proizvod>();
        if (!this.proizvodi.contains(newProizvod))
        {
            this.proizvodi.add(newProizvod);
            newProizvod.setKategorija(this);
        }
    }

    public void removeProizvodi(Proizvod oldProizvod) {
        if (oldProizvod == null)
            return;
        if (this.proizvodi != null)
            if (this.proizvodi.contains(oldProizvod))
            {
                this.proizvodi.remove(oldProizvod);
                oldProizvod.setKategorija((Kategorija)null);
            }
    }

    public ArrayList<Proizvod> getAllProizvodi(){
        Set<Proizvod> skup = new HashSet<>(proizvodi);
        for(Kategorija pk : potkategorije){
            skup.addAll(pk.getAllProizvodi());
        }
        ArrayList<Proizvod> lista = new ArrayList<>(skup);
        return lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategorija that = (Kategorija) o;
        return Objects.equals(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv);
    }

    @Override
    public String toString() {
        return putanja;
    }
}
