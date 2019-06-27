/***********************************************************************
 * Module:  Narudzbenica.java
 * author:
 * Purpose: Defines the Class Narudzbenica
 ***********************************************************************/

import java.util.*;

public class Narudzbina {
   private int broj;
   private Date datum;
   private String adresaIsporuke;
   private StanjeNarudzbine stanje;
   
   public java.util.Collection<StavkaNarudzbine> stavke;
   public StanjeNarudzbine trenutno_stanje;
   public Kupac kupac;
   
   public void primljenZahtev() {
      // TODO: implement
   }
   
   public void obavijesti() {
      // TODO: implement
   }
   
   public void otkazivanjeNarudzbine() {
      // TODO: implement
   }
   
   public void vracanjeNarudzbine() {
      // TODO: implement
   }
   
   public boolean uspesnoDostavljena() {
      // TODO: implement
      return false;
   }
   
   public void kompletiranaNaruzbina() {
      // TODO: implement
   }
   
   /** @param s */
   public void promijeniStanje(StanjeNarudzbine s) {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<StavkaNarudzbine> getStavke() {
      if (stavke == null)
         stavke = new java.util.HashSet<StavkaNarudzbine>();
      return stavke;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavke() {
      if (stavke == null)
         stavke = new java.util.HashSet<StavkaNarudzbine>();
      return stavke.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavke */
   public void setStavke(java.util.Collection<StavkaNarudzbine> newStavke) {
      removeAllStavke();
      for (java.util.Iterator iter = newStavke.iterator(); iter.hasNext();)
         addStavke((StavkaNarudzbine)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaNarudzbine */
   public void addStavke(StavkaNarudzbine newStavkaNarudzbine) {
      if (newStavkaNarudzbine == null)
         return;
      if (this.stavke == null)
         this.stavke = new java.util.HashSet<StavkaNarudzbine>();
      if (!this.stavke.contains(newStavkaNarudzbine))
      {
         this.stavke.add(newStavkaNarudzbine);
         newStavkaNarudzbine.setNarudzbina(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaNarudzbine */
   public void removeStavke(StavkaNarudzbine oldStavkaNarudzbine) {
      if (oldStavkaNarudzbine == null)
         return;
      if (this.stavke != null)
         if (this.stavke.contains(oldStavkaNarudzbine))
         {
            this.stavke.remove(oldStavkaNarudzbine);
            oldStavkaNarudzbine.setNarudzbina((Narudzbina)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavke() {
      if (stavke != null)
      {
         StavkaNarudzbine oldStavkaNarudzbine;
         for (java.util.Iterator iter = getIteratorStavke(); iter.hasNext();)
         {
            oldStavkaNarudzbine = (StavkaNarudzbine)iter.next();
            iter.remove();
            oldStavkaNarudzbine.setNarudzbina((Narudzbina)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public StanjeNarudzbine getTrenutno_stanje() {
      return trenutno_stanje;
   }
   
   /** @pdGenerated default parent setter
     * @param newStanjeNarudzbine */
   public void setTrenutno_stanje(StanjeNarudzbine newStanjeNarudzbine) {
      if (this.trenutno_stanje == null || !this.trenutno_stanje.equals(newStanjeNarudzbine))
      {
         if (this.trenutno_stanje != null)
            this.trenutno_stanje.setNarudzbina(null);
         this.trenutno_stanje = newStanjeNarudzbine;
         if (this.trenutno_stanje != null)
            this.trenutno_stanje.setNarudzbina(this);
      }
   }
   /** @pdGenerated default parent getter */
   public Kupac getKupac() {
      return kupac;
   }
   
   /** @pdGenerated default parent setter
     * @param newKupac */
   public void setKupac(Kupac newKupac) {
      if (this.kupac == null || !this.kupac.equals(newKupac))
      {
         if (this.kupac != null)
         {
            Kupac oldKupac = this.kupac;
            this.kupac = null;
            oldKupac.removeNarudzbine(this);
         }
         if (newKupac != null)
         {
            this.kupac = newKupac;
            this.kupac.addNarudzbine(this);
         }
      }
   }

}