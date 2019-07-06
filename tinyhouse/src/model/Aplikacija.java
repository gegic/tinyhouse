
/***********************************************************************
 * Module:  Preduzece.java
 *
 * Purpose: Defines the Class Preduzece
 ***********************************************************************/
package model;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

    private String nazivAplikacije;
    private Korpa trenutnaKorpa;
    public static Aplikacija instance;

    private List<Kategorija> kategorije;

    public List<Narudzbina> narudzbine;
    public Cenovnik cenovnik;
    public List<Proizvod> proizvodi;
    public Korisnik ulogovani;
    public List<Prodavnica> prodavnice;
    public List<Korisnik> korisnici;
    public List<Kupac> kupci;

    public Aplikacija() {
        narudzbine = new ArrayList<>();
        cenovnik = new Cenovnik();
        proizvodi = new ArrayList<>();
        ulogovani = null;
        prodavnice = new ArrayList<>();
        korisnici = new ArrayList<>();
        kupci = new ArrayList<>();
        trenutnaKorpa = new Korpa();
        kategorije = new ArrayList<>();
    }

    public static Aplikacija getInstance() {
        if (instance == null) {
            instance = new Aplikacija();
            instance.ucitaj();
        }
        return instance;
    }

    public static void setInstance(Aplikacija a){
        if(instance == null){
            instance = a;
        }
    }

    public void ukloniIzKorpe(StavkaNarudzbine s){
        trenutnaKorpa.removeStavkaNarudzbine(s);
    }

    public void resetUkupno(float oldValue, float newValue){
        trenutnaKorpa.setUkupnaCijena(trenutnaKorpa.getUkupnaCijena() - oldValue + newValue);
    }

    public void ucitaj() {
        // TODO: load

        if (this.korisnici.isEmpty()) {
            System.err.println("Serijalizacija nije ucitala korisnike. Možda zbog promena u kodu");
            korisnici.add(new Korisnik("admin", "admin", TipKorisnika.admin));
            korisnici.add(new Korisnik("m", "m", TipKorisnika.moderator));
            Korisnik k = new Korisnik("h", "h", TipKorisnika.obican);
            Kupac ja = new Kupac("Haris", "Gegic", "Adresa", "Mail", k);
            kupci.add(ja);
            korisnici.add(k);
            Kategorija kuhinja = new Kategorija("Kuhinja");
            Kategorija kolica = new Kategorija("Kolica", kuhinja);
            Kategorija d = new Kategorija("Na struju", kolica);
            prodavnice.add(new Prodavnica(1, "Kraljevica Marka 1", 45, 18));
            kategorije.add(kuhinja);
            kategorije.add(kolica);
            kategorije.add(d);
            Image i = new Image(getClass().getResourceAsStream("/styles/images/kasewagen.jpg"));
            Image i2 = new Image(getClass().getResourceAsStream("/styles/images/sporet.jpg"));
            Proizvod p = new Proizvod(1, "Kasewagen", kolica, "Kolica za sir. Najbolja na svijetu");
            p.setSlika(i, "/styles/images/kasewagen.jpg", 0);
            p.setSlika(i2, "/styles/images/sporet.jpg",1);
            p.setTrenutnaCijena(75000, new Date());
            p.setKolicinaZaOnline(4);

            Proizvod p1 = new Proizvod(1, "Fleischwagen", kolica, "Kolica za meso. Najbolja na svijetu");
            p1.setSlika(i, 0);
            p1.setSlika(i2, 1);
            p1.setTrenutnaCijena(25000, new Date());
            p1.setKolicinaZaOnline(3);
            proizvodi.add(p1);

            Proizvod p2 = new Proizvod(1, "Zuckiniwagen", kolica, "Kolica za meso. Najbolja na svijetu");
            p2.setSlika(i, 0);
            p2.setSlika(i2, 1);
            p2.setTrenutnaCijena(50000, new Date());
            p2.setKolicinaZaOnline(3);
            proizvodi.add(p2);

            proizvodi.add(p);

            addToKorpa(new StavkaNarudzbine(p.getKolicinaZaOnline(), p.getTrenutnaCijena().getJedinicnaCena(), p));
            kupovina(k.getKupac().getAdresa(), k.getKupac());

        }
    }

    public Kategorija pronadjiKategoriju(String naziv){
        for(Kategorija k : kategorije){
            if(k.getNaziv().equals(naziv)){
                return k;
            }
        }
        return null;
    }

    public void brisanjeKategorije(Kategorija k){
        for(Proizvod p : k.getProizvodi()){
            proizvodi.remove(p);
        }
        for(Kategorija pk : k.getPotkategorije()){
            brisanjeKategorije(pk);
        }
        kategorije.remove(k);
    }

    public void dodavanjeKategorije(String naziv, Kategorija natkategorija){
        Kategorija k;
        if(natkategorija == null){
            k = new Kategorija(naziv);
        } else{
            k = new Kategorija(naziv, natkategorija);
        }

        kategorije.add(k);
    }

    public int uvecajKolicinuProizvoda(int id, int koliko){
        Proizvod p = pronadjiProizvod(id);
        p.uvecajKolicinu(koliko);
        return p.getKolicinaZaOnline();
    }

    public StavkaNarudzbine pronadjiIzKorpe(String id){
        return trenutnaKorpa.pronadji(id);
    }

    public void izmeniProizvod(int id, String naziv, String opis, Image[] slike, String[] paths, float cijena, Kategorija k){
        for(Proizvod p : proizvodi){
            if(p.getId() == id){
                p.setNaziv(naziv);
                p.setOpis(opis);
                p.setSlike(slike, paths);
                p.setTrenutnaCijena(cijena, new Date());
                p.setKategorija(k);
                return;
            }
        }
    }
    public Proizvod pronadjiProizvod(int id){
        for(Proizvod p : proizvodi){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    public boolean brisanjeProizvoda(int id){
        Proizvod p;
        if((p = pronadjiProizvod(id)) != null){
            proizvodi.remove(p);
            return true;
        }
        return false;
    }

    public void dodavanjeProizvoda(int id, String naziv, String opis, Image[] slike, String[] paths, float cijena, Kategorija k){

        Proizvod p = new Proizvod(id, naziv, k, opis);
        p.setTrenutnaCijena(cijena, new Date());
        p.setSlike(slike, paths);
        proizvodi.add(p);
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
        Prodavnica p;
        if((p = pronadji_prodavnicu(id)) != null){
            prodavnice.remove(p);
            return true;
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
        if(id > 10000 || id < 1){
            return "ID mora biti između 1 i 10000";
        }
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
    public void registracija(String username, String password, String ime, String prezime, String adresa, String email) {
        Korisnik k = new Korisnik(username, password, TipKorisnika.obican);
        Kupac ku = new Kupac(ime, prezime, adresa, email, k);
        addKorisnici(k);
        addKupci(ku);
    }

    public void kupovina(String adresa, Kupac k){
        Narudzbina n = new Narudzbina(narudzbine.size(), adresa, trenutnaKorpa.getUkupnaCijena(), trenutnaKorpa.getStavkeNarudzbine(), k);
        trenutnaKorpa.obavljenaKupovina();
        narudzbine.add(n);
    }

    /**
     * @param username
     * @param password
     */
    public Korisnik prijava(String username, String password) {
        for (Korisnik k : korisnici) {
            if (k.provera_informacija(username.toLowerCase(), password)){
                if(k.getTip() == TipKorisnika.obican) trenutnaKorpa = k.getKupac().getKorpa();
                return k;
            }
        }
        return null;
    }

    public void odjava() {
        trenutnaKorpa = new Korpa();
        ulogovani = null;
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
    public java.util.Iterator getIteratorNarudzbina() {
        if (narudzbine == null)
            narudzbine = new ArrayList<Narudzbina>();
        return narudzbine.iterator();
    }

    /**
     * @param newNarudzbina
     * @pdGenerated default setter
     */
    public void setNarudzbine(List<Narudzbina> newNarudzbina) {
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
        if (this.narudzbine == null)
            this.narudzbine = new ArrayList<Narudzbina>();
        if (!this.narudzbine.contains(newNarudzbina))
            this.narudzbine.add(newNarudzbina);
    }

    /**
     * @param oldNarudzbina
     * @pdGenerated default remove
     */
    public void removeNarudzbina(Narudzbina oldNarudzbina) {
        if (oldNarudzbina == null)
            return;
        if (this.narudzbine != null)
            if (this.narudzbine.contains(oldNarudzbina))
                this.narudzbine.remove(oldNarudzbina);
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllNarudzbina() {
        if (narudzbine != null)
            narudzbine.clear();
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

    public Korpa getTrenutnaKorpa() {
        return trenutnaKorpa;
    }

    public void setTrenutnaKorpa(Korpa trenutnaKorpa) {
        this.trenutnaKorpa = trenutnaKorpa;
    }

    public void addToKorpa(StavkaNarudzbine s){trenutnaKorpa.addStavkaNarudzbine(s);}

    public List<Kategorija> getKategorije() {
        return kategorije;
    }

    public void setKategorije(List<Kategorija> kategorije) {
        this.kategorije = kategorije;
    }

    public void addKategorija(Kategorija k){
        if (k == null)
            return;
        if (this.kategorije == null)
            this.kategorije = new ArrayList<Kategorija>();
        if (!this.kategorije.contains(k))
            this.kategorije.add(k);
    }
}