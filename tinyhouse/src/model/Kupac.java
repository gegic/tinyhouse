/***********************************************************************
 * Module:  Kupac.java
 * author:
 * Purpose: Defines the Class Kupac
 ***********************************************************************/
package model;

import java.util.ArrayList;
import java.util.List;

public class Kupac {
    private String ime;
    private String prezime;
    private String adresa;
    private String eMail;
    private Korpa korpa;

    public Prodavnica prodavnica;
    public List<Proizvod> listaZelja;
    public Korisnik korisnik;
    public List<Narudzbina> narudzbine;


    public Kupac(String ime, String prezime, String adresa, String eMail, Korisnik korisnik) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.eMail = eMail;
        this.korisnik = korisnik;
        this.korisnik.setInformacije(this);
        korpa = new Korpa();
    }

    public Kupac(String ime, String prezime, String adresa, String eMail, Korpa korpa,
                 Prodavnica prodavnica, List<Proizvod> listaZelja, Korisnik korisnik, List<Narudzbina> narudzbine) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.eMail = eMail;
        this.korpa = korpa;
        this.prodavnica = prodavnica;
        this.listaZelja = listaZelja;
        this.korisnik = korisnik;
        this.narudzbine = narudzbine;
    }

    /**
     * @param id
     */
    public boolean obrisiZelju(int id) {
        // TODO: implement
        return false;
    }

    /**
     * @param p
     * @param kolicina
     */
    public void dodajKorpi(Proizvod p, int kolicina) {
        // TODO: implement
    }

    /**
     * @param s
     */
    public void dodajKorpi(StavkaNarudzbine s) {
        // TODO: implement
    }

    /**
     * @param s
     * @param kolicina
     */
    public void izmeniKolicinu(StavkaNarudzbine s, int kolicina) {
        // TODO: implement
    }

    public void kupi() {
        // TODO: implement
    }


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
        this.prodavnica = newProdavnica;
    }

    /**
     * @pdGenerated default getter
     */
    public List<Proizvod> getListaZelja() {
        if (listaZelja == null)
            listaZelja = new ArrayList<Proizvod>();
        return listaZelja;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorListaZelja() {
        if (listaZelja == null)
            listaZelja = new ArrayList<Proizvod>();
        return listaZelja.iterator();
    }

    /**
     * @param newListaZelja
     * @pdGenerated default setter
     */
    public void setListaZelja(List<Proizvod> newListaZelja) {
        removeAllListaZelja();
        for (java.util.Iterator iter = newListaZelja.iterator(); iter.hasNext(); )
            addListaZelja((Proizvod) iter.next());
    }

    /**
     * @param newProizvod
     * @pdGenerated default add
     */
    public void addListaZelja(Proizvod newProizvod) {
        if (newProizvod == null)
            return;
        if (this.listaZelja == null)
            this.listaZelja = new ArrayList<Proizvod>();
        if (!this.listaZelja.contains(newProizvod))
            this.listaZelja.add(newProizvod);
    }

    /**
     * @param oldProizvod
     * @pdGenerated default remove
     */
    public void removeListaZelja(Proizvod oldProizvod) {
        if (oldProizvod == null)
            return;
        if (this.listaZelja != null)
            if (this.listaZelja.contains(oldProizvod))
                this.listaZelja.remove(oldProizvod);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllListaZelja() {
        if (listaZelja != null)
            listaZelja.clear();
    }

    /**
     * @pdGenerated default parent getter
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * @param newKorisnik
     * @pdGenerated default parent setter
     */
    public void setKorisnik(Korisnik newKorisnik) {
        this.korisnik = newKorisnik;
    }

    /**
     * @pdGenerated default getter
     */
    public List<Narudzbina> getNarudzbine() {
        if (narudzbine == null)
            narudzbine = new ArrayList<Narudzbina>();
        return narudzbine;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorNarudzbine() {
        if (narudzbine == null)
            narudzbine = new ArrayList<Narudzbina>();
        return narudzbine.iterator();
    }

    /**
     * @param newNarudzbine
     * @pdGenerated default setter
     */
    public void setNarudzbine(List<Narudzbina> newNarudzbine) {
        removeAllNarudzbine();
        for (java.util.Iterator iter = newNarudzbine.iterator(); iter.hasNext(); )
            addNarudzbine((Narudzbina) iter.next());
    }

    /**
     * @param newNarudzbina
     * @pdGenerated default add
     */
    public void addNarudzbine(Narudzbina newNarudzbina) {
        if (newNarudzbina == null)
            return;
        if (this.narudzbine == null)
            this.narudzbine = new ArrayList<Narudzbina>();
        if (!this.narudzbine.contains(newNarudzbina)) {
            this.narudzbine.add(newNarudzbina);
            newNarudzbina.setKupac(this);
        }
    }

    /**
     * @param oldNarudzbina
     * @pdGenerated default remove
     */
    public void removeNarudzbine(Narudzbina oldNarudzbina) {
        if (oldNarudzbina == null)
            return;
        if (this.narudzbine != null)
            if (this.narudzbine.contains(oldNarudzbina)) {
                this.narudzbine.remove(oldNarudzbina);
                oldNarudzbina.setKupac((Kupac) null);
            }
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllNarudzbine() {
        if (narudzbine != null) {
            Narudzbina oldNarudzbina;
            for (java.util.Iterator iter = getIteratorNarudzbine(); iter.hasNext(); ) {
                oldNarudzbina = (Narudzbina) iter.next();
                iter.remove();
                oldNarudzbina.setKupac((Kupac) null);
            }
        }
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public String geteMail() {
        return eMail;
    }

    public Korpa getKorpa() {
        return korpa;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa = korpa;
    }
}