/***********************************************************************
 * Module:  StavkaCenovnika.java
 * author:
 * Purpose: Defines the Class StavkaCenovnika
 ***********************************************************************/

import java.util.*;

public class StavkaCenovnika {
   private float jedinicnaCena;
   private Date pocetakVazenja;
   private Date krajVazenja;
   
   public Proizvod proizvod;
   public Cenovnik cenovnik;
   
   
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
            oldProizvod.removeCijene(this);
         }
         if (newProizvod != null)
         {
            this.proizvod = newProizvod;
            this.proizvod.addCijene(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Cenovnik getCenovnik() {
      return cenovnik;
   }
   
   /** @pdGenerated default parent setter
     * @param newCenovnik */
   public void setCenovnik(Cenovnik newCenovnik) {
      if (this.cenovnik == null || !this.cenovnik.equals(newCenovnik))
      {
         if (this.cenovnik != null)
         {
            Cenovnik oldCenovnik = this.cenovnik;
            this.cenovnik = null;
            oldCenovnik.removeStavke(this);
         }
         if (newCenovnik != null)
         {
            this.cenovnik = newCenovnik;
            this.cenovnik.addStavke(this);
         }
      }
   }

}