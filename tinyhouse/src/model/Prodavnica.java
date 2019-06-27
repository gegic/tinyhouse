/***********************************************************************
 * Module:  Mesto.java
 * author:
 * Purpose: Defines the Class Mesto
 ***********************************************************************/

import java.util.*;

public class Prodavnica {
   private int idProdavnice;
   private int geoSirina;
   private int geoDuzina;
   private String adresa;
   
   public java.util.List<ProizvodUProdavnici> proizvodi;
   
   /** @param p 
    * @param kolicina */
   public void dodajProizvod(Proizvod p, int kolicina) {
      // TODO: implement
   }
   
   /** @param p 
    * @param kolicina */
   public void izmeniKolicinu(Proizvod p, int kolicina) {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<ProizvodUProdavnici> getProizvodi() {
      if (proizvodi == null)
         proizvodi = new java.util.ArrayList<ProizvodUProdavnici>();
      return proizvodi;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProizvodi() {
      if (proizvodi == null)
         proizvodi = new java.util.ArrayList<ProizvodUProdavnici>();
      return proizvodi.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProizvodi */
   public void setProizvodi(java.util.List<ProizvodUProdavnici> newProizvodi) {
      removeAllProizvodi();
      for (java.util.Iterator iter = newProizvodi.iterator(); iter.hasNext();)
         addProizvodi((ProizvodUProdavnici)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProizvodUProdavnici */
   public void addProizvodi(ProizvodUProdavnici newProizvodUProdavnici) {
      if (newProizvodUProdavnici == null)
         return;
      if (this.proizvodi == null)
         this.proizvodi = new java.util.ArrayList<ProizvodUProdavnici>();
      if (!this.proizvodi.contains(newProizvodUProdavnici))
      {
         this.proizvodi.add(newProizvodUProdavnici);
         newProizvodUProdavnici.setProdavnica(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldProizvodUProdavnici */
   public void removeProizvodi(ProizvodUProdavnici oldProizvodUProdavnici) {
      if (oldProizvodUProdavnici == null)
         return;
      if (this.proizvodi != null)
         if (this.proizvodi.contains(oldProizvodUProdavnici))
         {
            this.proizvodi.remove(oldProizvodUProdavnici);
            oldProizvodUProdavnici.setProdavnica((Prodavnica)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProizvodi() {
      if (proizvodi != null)
      {
         ProizvodUProdavnici oldProizvodUProdavnici;
         for (java.util.Iterator iter = getIteratorProizvodi(); iter.hasNext();)
         {
            oldProizvodUProdavnici = (ProizvodUProdavnici)iter.next();
            iter.remove();
            oldProizvodUProdavnici.setProdavnica((Prodavnica)null);
         }
      }
   }

}