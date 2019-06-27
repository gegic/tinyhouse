/***********************************************************************
 * Module:  Proizvod.java
 * Author:  goca
 * Purpose: Defines the Class Proizvod
 ***********************************************************************/

import java.util.*;

public class Proizvod {
   private String naziv;
   private String opis;
   private Image[] slike;
   private int kolicinaZaOnline;
   
   public java.util.List<Proizvod> slicanProizvod;
   public java.util.Collection<ProizvodUProdavnici> prodavnice;
   public java.util.List<StavkaCenovnika> cijene;
   
   /** @param kolicina */
   public void umanjiKolicinu(int kolicina) {
      // TODO: implement
   }
   
   /** @param kolicina */
   public void uvecajKolicinu(int kolicina) {
      // TODO: implement
   }
   
   /** @param kolicina */
   public void kupljeno(int kolicina) {
      // TODO: implement
   }
   
   /** @param kolicina */
   public void restokovano(int kolicina) {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Proizvod> getSlicanProizvod() {
      if (slicanProizvod == null)
         slicanProizvod = new java.util.ArrayList<Proizvod>();
      return slicanProizvod;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSlicanProizvod() {
      if (slicanProizvod == null)
         slicanProizvod = new java.util.ArrayList<Proizvod>();
      return slicanProizvod.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSlicanProizvod */
   public void setSlicanProizvod(java.util.List<Proizvod> newSlicanProizvod) {
      removeAllSlicanProizvod();
      for (java.util.Iterator iter = newSlicanProizvod.iterator(); iter.hasNext();)
         addSlicanProizvod((Proizvod)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProizvod */
   public void addSlicanProizvod(Proizvod newProizvod) {
      if (newProizvod == null)
         return;
      if (this.slicanProizvod == null)
         this.slicanProizvod = new java.util.ArrayList<Proizvod>();
      if (!this.slicanProizvod.contains(newProizvod))
         this.slicanProizvod.add(newProizvod);
   }
   
   /** @pdGenerated default remove
     * @param oldProizvod */
   public void removeSlicanProizvod(Proizvod oldProizvod) {
      if (oldProizvod == null)
         return;
      if (this.slicanProizvod != null)
         if (this.slicanProizvod.contains(oldProizvod))
            this.slicanProizvod.remove(oldProizvod);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSlicanProizvod() {
      if (slicanProizvod != null)
         slicanProizvod.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<ProizvodUProdavnici> getProdavnice() {
      if (prodavnice == null)
         prodavnice = new java.util.HashSet<ProizvodUProdavnici>();
      return prodavnice;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProdavnice() {
      if (prodavnice == null)
         prodavnice = new java.util.HashSet<ProizvodUProdavnici>();
      return prodavnice.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProdavnice */
   public void setProdavnice(java.util.Collection<ProizvodUProdavnici> newProdavnice) {
      removeAllProdavnice();
      for (java.util.Iterator iter = newProdavnice.iterator(); iter.hasNext();)
         addProdavnice((ProizvodUProdavnici)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProizvodUProdavnici */
   public void addProdavnice(ProizvodUProdavnici newProizvodUProdavnici) {
      if (newProizvodUProdavnici == null)
         return;
      if (this.prodavnice == null)
         this.prodavnice = new java.util.HashSet<ProizvodUProdavnici>();
      if (!this.prodavnice.contains(newProizvodUProdavnici))
      {
         this.prodavnice.add(newProizvodUProdavnici);
         newProizvodUProdavnici.setProizvod(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldProizvodUProdavnici */
   public void removeProdavnice(ProizvodUProdavnici oldProizvodUProdavnici) {
      if (oldProizvodUProdavnici == null)
         return;
      if (this.prodavnice != null)
         if (this.prodavnice.contains(oldProizvodUProdavnici))
         {
            this.prodavnice.remove(oldProizvodUProdavnici);
            oldProizvodUProdavnici.setProizvod((Proizvod)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProdavnice() {
      if (prodavnice != null)
      {
         ProizvodUProdavnici oldProizvodUProdavnici;
         for (java.util.Iterator iter = getIteratorProdavnice(); iter.hasNext();)
         {
            oldProizvodUProdavnici = (ProizvodUProdavnici)iter.next();
            iter.remove();
            oldProizvodUProdavnici.setProizvod((Proizvod)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<StavkaCenovnika> getCijene() {
      if (cijene == null)
         cijene = new java.util.ArrayList<StavkaCenovnika>();
      return cijene;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCijene() {
      if (cijene == null)
         cijene = new java.util.ArrayList<StavkaCenovnika>();
      return cijene.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCijene */
   public void setCijene(java.util.List<StavkaCenovnika> newCijene) {
      removeAllCijene();
      for (java.util.Iterator iter = newCijene.iterator(); iter.hasNext();)
         addCijene((StavkaCenovnika)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaCenovnika */
   public void addCijene(StavkaCenovnika newStavkaCenovnika) {
      if (newStavkaCenovnika == null)
         return;
      if (this.cijene == null)
         this.cijene = new java.util.ArrayList<StavkaCenovnika>();
      if (!this.cijene.contains(newStavkaCenovnika))
      {
         this.cijene.add(newStavkaCenovnika);
         newStavkaCenovnika.setProizvod(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaCenovnika */
   public void removeCijene(StavkaCenovnika oldStavkaCenovnika) {
      if (oldStavkaCenovnika == null)
         return;
      if (this.cijene != null)
         if (this.cijene.contains(oldStavkaCenovnika))
         {
            this.cijene.remove(oldStavkaCenovnika);
            oldStavkaCenovnika.setProizvod((Proizvod)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCijene() {
      if (cijene != null)
      {
         StavkaCenovnika oldStavkaCenovnika;
         for (java.util.Iterator iter = getIteratorCijene(); iter.hasNext();)
         {
            oldStavkaCenovnika = (StavkaCenovnika)iter.next();
            iter.remove();
            oldStavkaCenovnika.setProizvod((Proizvod)null);
         }
      }
   }

}