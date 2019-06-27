/***********************************************************************
 * Module:  ProizvodUProdavnici.java
 * Author:  Gegic
 * Purpose: Defines the Class ProizvodUProdavnici
 ***********************************************************************/

import java.util.*;

public class ProizvodUProdavnici {
   private int fizickaKolicina;
   
   public Prodavnica prodavnica;
   public Proizvod proizvod;
   
   
   /** @pdGenerated default parent getter */
   public Prodavnica getProdavnica() {
      return prodavnica;
   }
   
   /** @pdGenerated default parent setter
     * @param newProdavnica */
   public void setProdavnica(Prodavnica newProdavnica) {
      if (this.prodavnica == null || !this.prodavnica.equals(newProdavnica))
      {
         if (this.prodavnica != null)
         {
            Prodavnica oldProdavnica = this.prodavnica;
            this.prodavnica = null;
            oldProdavnica.removeProizvodi(this);
         }
         if (newProdavnica != null)
         {
            this.prodavnica = newProdavnica;
            this.prodavnica.addProizvodi(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Proizvod getProizvod() {
      return proizvod;
   }
   
   /** @pdGenerated default parent setter
     * @param newProizvod */
   public void setProizvod(Proizvod newProizvod) {
      if (this.proizvod == null || !this.proizvod.equals(newProizvod))
      {
         if (this.proizvod != null)
         {
            Proizvod oldProizvod = this.proizvod;
            this.proizvod = null;
            oldProizvod.removeProdavnice(this);
         }
         if (newProizvod != null)
         {
            this.proizvod = newProizvod;
            this.proizvod.addProdavnice(this);
         }
      }
   }

}