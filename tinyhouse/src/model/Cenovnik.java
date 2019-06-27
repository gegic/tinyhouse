/***********************************************************************
 * Module:  Cenovnik.java
 * Author:  goca
 * Purpose: Defines the Class Cenovnik
 ***********************************************************************/

import java.util.*;

public class Cenovnik {
   private int brojCenovnika;
   
   public java.util.List<StavkaCenovnika> stavke;
   
   
   /** @pdGenerated default getter */
   public java.util.List<StavkaCenovnika> getStavke() {
      if (stavke == null)
         stavke = new java.util.ArrayList<StavkaCenovnika>();
      return stavke;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavke() {
      if (stavke == null)
         stavke = new java.util.ArrayList<StavkaCenovnika>();
      return stavke.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavke */
   public void setStavke(java.util.List<StavkaCenovnika> newStavke) {
      removeAllStavke();
      for (java.util.Iterator iter = newStavke.iterator(); iter.hasNext();)
         addStavke((StavkaCenovnika)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaCenovnika */
   public void addStavke(StavkaCenovnika newStavkaCenovnika) {
      if (newStavkaCenovnika == null)
         return;
      if (this.stavke == null)
         this.stavke = new java.util.ArrayList<StavkaCenovnika>();
      if (!this.stavke.contains(newStavkaCenovnika))
      {
         this.stavke.add(newStavkaCenovnika);
         newStavkaCenovnika.setCenovnik(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaCenovnika */
   public void removeStavke(StavkaCenovnika oldStavkaCenovnika) {
      if (oldStavkaCenovnika == null)
         return;
      if (this.stavke != null)
         if (this.stavke.contains(oldStavkaCenovnika))
         {
            this.stavke.remove(oldStavkaCenovnika);
            oldStavkaCenovnika.setCenovnik((Cenovnik)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavke() {
      if (stavke != null)
      {
         StavkaCenovnika oldStavkaCenovnika;
         for (java.util.Iterator iter = getIteratorStavke(); iter.hasNext();)
         {
            oldStavkaCenovnika = (StavkaCenovnika)iter.next();
            iter.remove();
            oldStavkaCenovnika.setCenovnik((Cenovnik)null);
         }
      }
   }

}