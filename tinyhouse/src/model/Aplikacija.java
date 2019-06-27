/***********************************************************************
 * Module:  Preduzece.java
 * Author:  goca
 * Purpose: Defines the Class Preduzece
 ***********************************************************************/

import java.util.*;

public class Aplikacija {
   private String nazivAplikacije;
   
   public static Aplikacija instance;
   
   public java.util.List<Narudzbina> narudzbina;
   public Cenovnik cenovnik;
   public java.util.List<Proizvod> proizvod;
   public Korisnik ulogovani;
   public java.util.List<Prodavnica> prodavnice;
   public java.util.List<Korisnik> korisnici;
   public java.util.List<Kupac> kupci;
   
   public static Aplikacija getInstance() {
      // TODO: implement
      return null;
   }
   
   /** @param sp 
    * @param pronadjeni */
   public void trazenje(String sp, ArrayList<Proizvod> pronadjeni) {
      // TODO: implement
   }
   
   public void dodajKolicinu() {
      // TODO: implement
   }
   
   /** @param username 
    * @param password 
    * @param ime 
    * @param prezime 
    * @param adresa 
    * @param email */
   public boolean registracija(String username, String password, String ime, String prezime, String adresa, String email) {
      // TODO: implement
      return false;
   }
   
   /** @param username 
    * @param password */
   public Korisnik prijava(String username, String password) {
      // TODO: implement
      return null;
   }
   
   public void odjava() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Narudzbina> getNarudzbina() {
      if (narudzbina == null)
         narudzbina = new java.util.ArrayList<Narudzbina>();
      return narudzbina;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorNarudzbina() {
      if (narudzbina == null)
         narudzbina = new java.util.ArrayList<Narudzbina>();
      return narudzbina.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newNarudzbina */
   public void setNarudzbina(java.util.List<Narudzbina> newNarudzbina) {
      removeAllNarudzbina();
      for (java.util.Iterator iter = newNarudzbina.iterator(); iter.hasNext();)
         addNarudzbina((Narudzbina)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newNarudzbina */
   public void addNarudzbina(Narudzbina newNarudzbina) {
      if (newNarudzbina == null)
         return;
      if (this.narudzbina == null)
         this.narudzbina = new java.util.ArrayList<Narudzbina>();
      if (!this.narudzbina.contains(newNarudzbina))
         this.narudzbina.add(newNarudzbina);
   }
   
   /** @pdGenerated default remove
     * @param oldNarudzbina */
   public void removeNarudzbina(Narudzbina oldNarudzbina) {
      if (oldNarudzbina == null)
         return;
      if (this.narudzbina != null)
         if (this.narudzbina.contains(oldNarudzbina))
            this.narudzbina.remove(oldNarudzbina);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNarudzbina() {
      if (narudzbina != null)
         narudzbina.clear();
   }
   /** @pdGenerated default parent getter */
   public Cenovnik getCenovnik() {
      return cenovnik;
   }
   
   /** @pdGenerated default parent setter
     * @param newCenovnik */
   public void setCenovnik(Cenovnik newCenovnik) {
      this.cenovnik = newCenovnik;
   }
   /** @pdGenerated default getter */
   public java.util.List<Proizvod> getProizvod() {
      if (proizvod == null)
         proizvod = new java.util.ArrayList<Proizvod>();
      return proizvod;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProizvod() {
      if (proizvod == null)
         proizvod = new java.util.ArrayList<Proizvod>();
      return proizvod.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProizvod */
   public void setProizvod(java.util.List<Proizvod> newProizvod) {
      removeAllProizvod();
      for (java.util.Iterator iter = newProizvod.iterator(); iter.hasNext();)
         addProizvod((Proizvod)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProizvod */
   public void addProizvod(Proizvod newProizvod) {
      if (newProizvod == null)
         return;
      if (this.proizvod == null)
         this.proizvod = new java.util.ArrayList<Proizvod>();
      if (!this.proizvod.contains(newProizvod))
         this.proizvod.add(newProizvod);
   }
   
   /** @pdGenerated default remove
     * @param oldProizvod */
   public void removeProizvod(Proizvod oldProizvod) {
      if (oldProizvod == null)
         return;
      if (this.proizvod != null)
         if (this.proizvod.contains(oldProizvod))
            this.proizvod.remove(oldProizvod);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProizvod() {
      if (proizvod != null)
         proizvod.clear();
   }
   /** @pdGenerated default parent getter */
   public Korisnik getUlogovani() {
      return ulogovani;
   }
   
   /** @pdGenerated default parent setter
     * @param newKorisnik */
   public void setUlogovani(Korisnik newKorisnik) {
      this.ulogovani = newKorisnik;
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
         this.prodavnice.add(newProdavnica);
   }
   
   /** @pdGenerated default remove
     * @param oldProdavnica */
   public void removeProdavnice(Prodavnica oldProdavnica) {
      if (oldProdavnica == null)
         return;
      if (this.prodavnice != null)
         if (this.prodavnice.contains(oldProdavnica))
            this.prodavnice.remove(oldProdavnica);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProdavnice() {
      if (prodavnice != null)
         prodavnice.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Korisnik> getKorisnici() {
      if (korisnici == null)
         korisnici = new java.util.ArrayList<Korisnik>();
      return korisnici;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKorisnici() {
      if (korisnici == null)
         korisnici = new java.util.ArrayList<Korisnik>();
      return korisnici.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKorisnici */
   public void setKorisnici(java.util.List<Korisnik> newKorisnici) {
      removeAllKorisnici();
      for (java.util.Iterator iter = newKorisnici.iterator(); iter.hasNext();)
         addKorisnici((Korisnik)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKorisnik */
   public void addKorisnici(Korisnik newKorisnik) {
      if (newKorisnik == null)
         return;
      if (this.korisnici == null)
         this.korisnici = new java.util.ArrayList<Korisnik>();
      if (!this.korisnici.contains(newKorisnik))
         this.korisnici.add(newKorisnik);
   }
   
   /** @pdGenerated default remove
     * @param oldKorisnik */
   public void removeKorisnici(Korisnik oldKorisnik) {
      if (oldKorisnik == null)
         return;
      if (this.korisnici != null)
         if (this.korisnici.contains(oldKorisnik))
            this.korisnici.remove(oldKorisnik);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKorisnici() {
      if (korisnici != null)
         korisnici.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Kupac> getKupci() {
      if (kupci == null)
         kupci = new java.util.ArrayList<Kupac>();
      return kupci;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKupci() {
      if (kupci == null)
         kupci = new java.util.ArrayList<Kupac>();
      return kupci.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKupci */
   public void setKupci(java.util.List<Kupac> newKupci) {
      removeAllKupci();
      for (java.util.Iterator iter = newKupci.iterator(); iter.hasNext();)
         addKupci((Kupac)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKupac */
   public void addKupci(Kupac newKupac) {
      if (newKupac == null)
         return;
      if (this.kupci == null)
         this.kupci = new java.util.ArrayList<Kupac>();
      if (!this.kupci.contains(newKupac))
         this.kupci.add(newKupac);
   }
   
   /** @pdGenerated default remove
     * @param oldKupac */
   public void removeKupci(Kupac oldKupac) {
      if (oldKupac == null)
         return;
      if (this.kupci != null)
         if (this.kupci.contains(oldKupac))
            this.kupci.remove(oldKupac);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKupci() {
      if (kupci != null)
         kupci.clear();
   }

}