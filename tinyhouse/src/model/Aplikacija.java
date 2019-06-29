
/***********************************************************************
 * Module:  Preduzece.java
 *
 * Purpose: Defines the Class Preduzece
 ***********************************************************************/
package model;

import java.util.ArrayList;
import java.util.List;

public class Aplikacija {
    private String nazivAplikacije;

    public static Aplikacija instance;

    public List<Narudzbina> narudzbina;
    public Cenovnik cenovnik;
    public List<Proizvod> proizvodi;
    public Korisnik ulogovani;
    public List<Prodavnica> prodavnice;
    public List<Korisnik> korisnici;
    public List<Kupac> kupci;

    public Aplikacija() {
        narudzbina = new ArrayList<>();
        cenovnik = new Cenovnik();
        proizvodi = new ArrayList<>();
        ulogovani = null;
        prodavnice = new ArrayList<>();
        korisnici = new ArrayList<>();
        kupci = new ArrayList<>();
    }

    public static Aplikacija getInstance() {
        if (instance == null) {
            instance = new Aplikacija();
            instance.ucitaj();
        }
        return instance;
    }

    public void ucitaj() {
        // TODO: load

        if (this.korisnici.isEmpty()) {
            korisnici.add(new Korisnik("admin", "admin", TipKorisnika.admin));
            korisnici.add(new Korisnik("m", "m", TipKorisnika.moderator));
            prodavnice.add(new Prodavnica(1, "Kraljevica Marka 1", 45, 18));
            proizvodi.add(new Proizvod(1, "Kasewagen", "Kolica za sir. Najbolja na svijetu"));
        }
    }

    /**
     * @param sp
     * @param pronadjeni
     */
    public void trazenje(String sp, ArrayList<Proizvod> pronadjeni) {
        // TODO: implement
    }

    public boolean brisanjeModeratora(String k_ime){
        for(Korisnik k : korisnici){
            if(k.getUsername().equals(k_ime)){
                korisnici.remove(k);
                return true;
            }
        }
        return false;
    }

    public boolean brisanjeProdavnice(int id){
        for(Prodavnica p : prodavnice){
            if(p.getIdProdavnice() == id){
                prodavnice.remove(p);
                return true;
            }
        }
        return false;
    }

    public Prodavnica pronadji_prodavnicu(int id) {
        for(Prodavnica p : prodavnice){
            if (p.getIdProdavnice() == id){
                return p;
            }
        }
        return null;
    }

    public String izmeniProdavnicu(int id, String adresa, float g_sirina, float g_duzina){
        if(adresa.length() < 4 || adresa.length() > 25) {
            return "Adresa mora biti između 4 i 25 karaktera duga";
        }
        if(g_sirina > 90 || g_sirina < -90){
            return "Geografska širina mora biti između -90 i 90";
        }
        if(g_duzina > 180 || g_duzina < -180){
            return "Geografska dužina mora biti između -180 i 180";
        }

        for(Prodavnica p : prodavnice){
            if (id == p.getIdProdavnice()){
                p.setAdresa(adresa);
                p.setGeoSirina(g_sirina);
                p.setGeoDuzina(g_duzina);
                return "";
            }
        }
        return "Ne postoji prodavnica sa ovim ID-jem! OVO NE SMIJE DA SE DESI NIKAD";
    }

    public String dodajProdavnicu(int id, String adresa, float g_sirina, float g_duzina){
        if(adresa.length() < 4 || adresa.length() > 25) {
            return "Adresa mora biti između 4 i 25 karaktera duga";
        }
        if(g_sirina > 90 || g_sirina < -90){
            return "Geografska širina mora biti između -90 i 90";
        }
        if(g_duzina > 180 || g_duzina < -180){
            return "Geografska dužina mora biti između -180 i 180";
        }

        for(Prodavnica p : prodavnice){
            if (id == p.getIdProdavnice()){
                return "Već postoji prodavnica sa ovim ID-jem";
            }
        }
        prodavnice.add(new Prodavnica(id, adresa, g_sirina, g_duzina));
        return "";
    }

    public String dodajModeratora(String k_ime, String password){
        String k_ime_lower = k_ime.toLowerCase();
        if(password.length() < 8 || password.length() > 16){
            return "Lozinka mora imati bar 8 karaktera";
        }
        if(k_ime.length() < 6 || k_ime.contains(" ") || k_ime.length() > 10){
            return "Korisničko ime mora imati između 6 i 10 karaktera bez razmaka";

        }
        for(Korisnik k : korisnici){
            if (k.getUsername().equals(k_ime_lower))
                return "Već postoji korisnik sa ovim korisničkim imenom";
        }
        korisnici.add(new Korisnik(k_ime_lower, password, TipKorisnika.moderator));
        return "";
    }
    public void dodajKolicinu() {
        // TODO: implement
    }

    /**
     * @param username
     * @param password
     * @param ime
     * @param prezime
     * @param adresa
     * @param email
     */
    public boolean registracija(String username, String password, String ime, String prezime, String adresa, String email) {
        // TODO: implement
        return false;
    }

    /**
     * @param username
     * @param password
     */
    public Korisnik prijava(String username, String password) {
        for (Korisnik k : korisnici) {
            if (k.provera_informacija(username.toLowerCase(), password))
                return k;
        }
        return null;
    }

    public void odjava() {
        // TODO: implement
    }


    /**
     * @pdGenerated default getter
     */
    public List<Narudzbina> getNarudzbina() {
        if (narudzbina == null)
            narudzbina = new ArrayList<Narudzbina>();
        return narudzbina;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorNarudzbina() {
        if (narudzbina == null)
            narudzbina = new ArrayList<Narudzbina>();
        return narudzbina.iterator();
    }

    /**
     * @param newNarudzbina
     * @pdGenerated default setter
     */
    public void setNarudzbina(List<Narudzbina> newNarudzbina) {
        removeAllNarudzbina();
        for (java.util.Iterator iter = newNarudzbina.iterator(); iter.hasNext(); )
            addNarudzbina((Narudzbina) iter.next());
    }

    /**
     * @param newNarudzbina
     * @pdGenerated default add
     */
    public void addNarudzbina(Narudzbina newNarudzbina) {
        if (newNarudzbina == null)
            return;
        if (this.narudzbina == null)
            this.narudzbina = new ArrayList<Narudzbina>();
        if (!this.narudzbina.contains(newNarudzbina))
            this.narudzbina.add(newNarudzbina);
    }

    /**
     * @param oldNarudzbina
     * @pdGenerated default remove
     */
    public void removeNarudzbina(Narudzbina oldNarudzbina) {
        if (oldNarudzbina == null)
            return;
        if (this.narudzbina != null)
            if (this.narudzbina.contains(oldNarudzbina))
                this.narudzbina.remove(oldNarudzbina);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllNarudzbina() {
        if (narudzbina != null)
            narudzbina.clear();
    }

    /**
     * @pdGenerated default parent getter
     */
    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    /**
     * @param newCenovnik
     * @pdGenerated default parent setter
     */
    public void setCenovnik(Cenovnik newCenovnik) {
        this.cenovnik = newCenovnik;
    }

    /**
     * @pdGenerated default getter
     */
    public List<Proizvod> getProizvodi() {
        if (proizvodi == null)
            proizvodi = new ArrayList<Proizvod>();
        return proizvodi;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorProizvod() {
        if (proizvodi == null)
            proizvodi = new ArrayList<Proizvod>();
        return proizvodi.iterator();
    }

    /**
     * @param newProizvod
     * @pdGenerated default setter
     */
    public void setProizvodi(List<Proizvod> newProizvod) {
        removeAllProizvod();
        for (java.util.Iterator iter = newProizvod.iterator(); iter.hasNext(); )
            addProizvod((Proizvod) iter.next());
    }

    /**
     * @param newProizvod
     * @pdGenerated default add
     */
    public void addProizvod(Proizvod newProizvod) {
        if (newProizvod == null)
            return;
        if (this.proizvodi == null)
            this.proizvodi = new ArrayList<Proizvod>();
        if (!this.proizvodi.contains(newProizvod))
            this.proizvodi.add(newProizvod);
    }

    /**
     * @param oldProizvod
     * @pdGenerated default remove
     */
    public void removeProizvod(Proizvod oldProizvod) {
        if (oldProizvod == null)
            return;
        if (this.proizvodi != null)
            if (this.proizvodi.contains(oldProizvod))
                this.proizvodi.remove(oldProizvod);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllProizvod() {
        if (proizvodi != null)
            proizvodi.clear();
    }

    /**
     * @pdGenerated default parent getter
     */
    public Korisnik getUlogovani() {
        return ulogovani;
    }

    /**
     * @param newKorisnik
     * @pdGenerated default parent setter
     */
    public void setUlogovani(Korisnik newKorisnik) {
        this.ulogovani = newKorisnik;
    }

    /**
     * @pdGenerated default getter
     */
    public List<Prodavnica> getProdavnice() {
        if (prodavnice == null)
            prodavnice = new ArrayList<Prodavnica>();
        return prodavnice;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorProdavnice() {
        if (prodavnice == null)
            prodavnice = new ArrayList<Prodavnica>();
        return prodavnice.iterator();
    }

    /**
     * @param newProdavnice
     * @pdGenerated default setter
     */
    public void setProdavnice(List<Prodavnica> newProdavnice) {
        removeAllProdavnice();
        for (java.util.Iterator iter = newProdavnice.iterator(); iter.hasNext(); )
            addProdavnice((Prodavnica) iter.next());
    }

    /**
     * @param newProdavnica
     * @pdGenerated default add
     */
    public void addProdavnice(Prodavnica newProdavnica) {
        if (newProdavnica == null)
            return;
        if (this.prodavnice == null)
            this.prodavnice = new ArrayList<Prodavnica>();
        if (!this.prodavnice.contains(newProdavnica))
            this.prodavnice.add(newProdavnica);
    }

    /**
     * @param oldProdavnica
     * @pdGenerated default remove
     */
    public void removeProdavnice(Prodavnica oldProdavnica) {
        if (oldProdavnica == null)
            return;
        if (this.prodavnice != null)
            if (this.prodavnice.contains(oldProdavnica))
                this.prodavnice.remove(oldProdavnica);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllProdavnice() {
        if (prodavnice != null)
            prodavnice.clear();
    }

    /**
     * @pdGenerated default getter
     */
    public List<Korisnik> getKorisnici() {
        if (korisnici == null)
            korisnici = new ArrayList<Korisnik>();
        return korisnici;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorKorisnici() {
        if (korisnici == null)
            korisnici = new ArrayList<Korisnik>();
        return korisnici.iterator();
    }

    /**
     * @param newKorisnici
     * @pdGenerated default setter
     */
    public void setKorisnici(List<Korisnik> newKorisnici) {
        removeAllKorisnici();
        for (java.util.Iterator iter = newKorisnici.iterator(); iter.hasNext(); )
            addKorisnici((Korisnik) iter.next());
    }

    /**
     * @param newKorisnik
     * @pdGenerated default add
     */
    public void addKorisnici(Korisnik newKorisnik) {
        if (newKorisnik == null)
            return;
        if (this.korisnici == null)
            this.korisnici = new ArrayList<Korisnik>();
        if (!this.korisnici.contains(newKorisnik))
            this.korisnici.add(newKorisnik);
    }

    /**
     * @param oldKorisnik
     * @pdGenerated default remove
     */
    public void removeKorisnici(Korisnik oldKorisnik) {
        if (oldKorisnik == null)
            return;
        if (this.korisnici != null)
            if (this.korisnici.contains(oldKorisnik))
                this.korisnici.remove(oldKorisnik);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllKorisnici() {
        if (korisnici != null)
            korisnici.clear();
    }

    /**
     * @pdGenerated default getter
     */
    public List<Kupac> getKupci() {
        if (kupci == null)
            kupci = new ArrayList<Kupac>();
        return kupci;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorKupci() {
        if (kupci == null)
            kupci = new ArrayList<Kupac>();
        return kupci.iterator();
    }

    /**
     * @param newKupci
     * @pdGenerated default setter
     */
    public void setKupci(List<Kupac> newKupci) {
        removeAllKupci();
        for (java.util.Iterator iter = newKupci.iterator(); iter.hasNext(); )
            addKupci((Kupac) iter.next());
    }

    /**
     * @param newKupac
     * @pdGenerated default add
     */
    public void addKupci(Kupac newKupac) {
        if (newKupac == null)
            return;
        if (this.kupci == null)
            this.kupci = new ArrayList<Kupac>();
        if (!this.kupci.contains(newKupac))
            this.kupci.add(newKupac);
    }

    /**
     * @param oldKupac
     * @pdGenerated default remove
     */
    public void removeKupci(Kupac oldKupac) {
        if (oldKupac == null)
            return;
        if (this.kupci != null)
            if (this.kupci.contains(oldKupac))
                this.kupci.remove(oldKupac);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllKupci() {
        if (kupci != null)
            kupci.clear();
    }

}