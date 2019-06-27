/***********************************************************************
 * Module:  StanjeNarudzbine.java
 * Author:  Gegic
 * Purpose: Defines the Class StanjeNarudzbine
 ***********************************************************************/

import java.util.*;

public abstract class StanjeNarudzbine {
   public Narudzbina narudzbina;
   
   public void entry() {
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
   
   
   /** @pdGenerated default parent getter */
   public Narudzbina getNarudzbina() {
      return narudzbina;
   }
   
   /** @pdGenerated default parent setter
     * @param newNarudzbina */
   public void setNarudzbina(Narudzbina newNarudzbina) {
      if (this.narudzbina == null || !this.narudzbina.equals(newNarudzbina))
      {
         if (this.narudzbina != null)
            this.narudzbina.setTrenutno_stanje(null);
         this.narudzbina = newNarudzbina;
         if (this.narudzbina != null)
            this.narudzbina.setTrenutno_stanje(this);
      }
   }

}