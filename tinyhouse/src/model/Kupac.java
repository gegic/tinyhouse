/***********************************************************************
 * Module:  Kupac.java
 * author:
 * Purpose: Defines the Class Kupac
 ***********************************************************************/

import java.util.*;

public class Kupac {
   private String ime;
   private String prezime;
   private String adresa;
   private String eMail;
   
   public Prodavnica prodavnica;
   public java.util.List<Proizvod> listaZelja;
   public Korisnik korisnik;
   public java.util.Collection<Narudzbina> narudzbine;
   public java.util.Collection<StavkaNarudzbine> korpa;
   
   /** @param id */
   public boolean obrisiZelju(int id) {
      // TODO: implement
      return false;
   }
   
   /** @param p 
    * @param kolicina */
   public void dodajKorpi(Proizvod p, int kolicina) {
      // TODO: implement
   }
   
   /** @param s */
   public void dodajKorpi(StavkaNarudzbine s) {
      // TODO: implement
   }
   
   /** @param s 
    * @param kolicina */
   public void izmeniKolicinu(StavkaNarudzbine s, int kolicina) {
      // TODO: implement
   }
   
   public void kupi() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default parent getter */
   public Prodavnica getProdavnica() {
      return prodavnica;
   }
   
   /** @pdGenerated default parent setter
     * @param newProdavnica */
   public void setProdavnica(Prodavnica newProdavnica) {
      this.prodavnica = newProdavnica;
   }
   /** @pdGenerated default getter */
   public java.util.List<Proizvod> getListaZelja() {
      if (listaZelja == null)
         listaZelja = new java.util.ArrayList<Proizvod>();
      return listaZelja;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorListaZelja() {
      if (listaZelja == null)
         listaZelja = new java.util.ArrayList<Proizvod>();
      return listaZelja.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newListaZelja */
   public void setListaZelja(java.util.List<Proizvod> newListaZelja) {
      removeAllListaZelja();
      for (java.util.Iterator iter = newListaZelja.iterator(); iter.hasNext();)
         addListaZelja((Proizvod)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProizvod */
   public void addListaZelja(Proizvod newProizvod) {
      if (newProizvod == null)
         return;
      if (this.listaZelja == null)
         this.listaZelja = new java.util.ArrayList<Proizvod>();
      if (!this.listaZelja.contains(newProizvod))
         this.listaZelja.add(newProizvod);
   }
   
   /** @pdGenerated default remove
     * @param oldProizvod */
   public void removeListaZelja(Proizvod oldProizvod) {
      if (oldProizvod == null)
         return;
      if (this.listaZelja != null)
         if (this.listaZelja.contains(oldProizvod))
            this.listaZelja.remove(oldProizvod);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllListaZelja() {
      if (listaZelja != null)
         listaZelja.clear();
   }
   /** @pdGenerated default parent getter */
   public Korisnik getKorisnik() {
      return korisnik;
   }
   
   /** @pdGenerated default parent setter
     * @param newKorisnik */
   public void setKorisnik(Korisnik newKorisnik) {
      this.korisnik = newKorisnik;
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Narudzbina> getNarudzbine() {
      if (narudzbine == null)
         narudzbine = new java.util.HashSet<Narudzbina>();
      return narudzbine;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorNarudzbine() {
      if (narudzbine == null)
         narudzbine = new java.util.HashSet<Narudzbina>();
      return narudzbine.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newNarudzbine */
   public void setNarudzbine(java.util.Collection<Narudzbina> newNarudzbine) {
      removeAllNarudzbine();
      for (java.util.Iterator iter = newNarudzbine.iterator(); iter.hasNext();)
         addNarudzbine((Narudzbina)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newNarudzbina */
   public void addNarudzbine(Narudzbina newNarudzbina) {
      if (newNarudzbina == null)
         return;
      if (this.narudzbine == null)
         this.narudzbine = new java.util.HashSet<Narudzbina>();
      if (!this.narudzbine.contains(newNarudzbina))
      {
         this.narudzbine.add(newNarudzbina);
         newNarudzbina.setKupac(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldNarudzbina */
   public void removeNarudzbine(Narudzbina oldNarudzbina) {
      if (oldNarudzbina == null)
         return;
      if (this.narudzbine != null)
         if (this.narudzbine.contains(oldNarudzbina))
         {
            this.narudzbine.remove(oldNarudzbina);
            oldNarudzbina.setKupac((Kupac)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNarudzbine() {
      if (narudzbine != null)
      {
         Narudzbina oldNarudzbina;
         for (java.util.Iterator iter = getIteratorNarudzbine(); iter.hasNext();)
         {
            oldNarudzbina = (Narudzbina)iter.next();
            iter.remove();
            oldNarudzbina.setKupac((Kupac)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<StavkaNarudzbine> getKorpa() {
      if (korpa == null)
         korpa = new java.util.HashSet<StavkaNarudzbine>();
      return korpa;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKorpa() {
      if (korpa == null)
         korpa = new java.util.HashSet<StavkaNarudzbine>();
      return korpa.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKorpa */
   public void setKorpa(java.util.Collection<StavkaNarudzbine> newKorpa) {
      removeAllKorpa();
      for (java.util.Iterator iter = newKorpa.iterator(); iter.hasNext();)
         addKorpa((StavkaNarudzbine)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaNarudzbine */
   public void addKorpa(StavkaNarudzbine newStavkaNarudzbine) {
      if (newStavkaNarudzbine == null)
         return;
      if (this.korpa == null)
         this.korpa = new java.util.HashSet<StavkaNarudzbine>();
      if (!this.korpa.contains(newStavkaNarudzbine))
         this.korpa.add(newStavkaNarudzbine);
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaNarudzbine */
   public void removeKorpa(StavkaNarudzbine oldStavkaNarudzbine) {
      if (oldStavkaNarudzbine == null)
         return;
      if (this.korpa != null)
         if (this.korpa.contains(oldStavkaNarudzbine))
            this.korpa.remove(oldStavkaNarudzbine);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKorpa() {
      if (korpa != null)
         korpa.clear();
   }

}