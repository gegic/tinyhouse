package model;

import java.util.ArrayList;
import java.util.List;

public class Kateogrija {
    private String naziv;
    private Kateogrija nadKategorija;
    private List<Kateogrija> podKategorije;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Kateogrija getNadKategorija() {
        return nadKategorija;
    }

    public void setNadKategorija(Kateogrija nadKategorija) {
        this.nadKategorija = nadKategorija;
    }

    public List<Kateogrija> getPodKategorije() {
        if (this.podKategorije == null)
            this.podKategorije = new ArrayList<Kateogrija>();
        return this.podKategorije;
    }

    public void setPodKategorije(List<Kateogrija> podKategorije) {
        this.podKategorije = podKategorije;
    }

    public Kateogrija(String naziv, Kateogrija nadKategorija) {
        this.naziv = naziv;
        this.nadKategorija = nadKategorija;
        this.podKategorije = new ArrayList<Kateogrija>();
    }
}
