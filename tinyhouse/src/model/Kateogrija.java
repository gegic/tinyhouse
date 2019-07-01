package model;

import java.util.ArrayList;
import java.util.List;

public class Kateogrija {
    private String naziv;
    private Kateogrija natkategorija;
    private List<Kateogrija> potkategorije;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Kateogrija getNatkategorija() {
        return natkategorija;
    }

    public void setNatkategorija(Kateogrija natkategorija) {
        this.natkategorija = natkategorija;
    }

    public List<Kateogrija> getPotkategorije() {
        if (this.potkategorije == null)
            this.potkategorije = new ArrayList<Kateogrija>();
        return this.potkategorije;
    }

    public void setPotkategorije(List<Kateogrija> potkategorije) {
        this.potkategorije = potkategorije;
    }

    public Kateogrija(String naziv, Kateogrija natkategorija) {
        this.naziv = naziv;
        this.natkategorija = natkategorija;
        this.potkategorije = new ArrayList<Kateogrija>();
    }
}
