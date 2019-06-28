/***********************************************************************
 * Module:  Cenovnik.java
 * author:
 * Purpose: Defines the Class Cenovnik
 ***********************************************************************/
package model;

import java.util.ArrayList;
import java.util.List;

public class Cenovnik {
    private int brojCenovnika;

    public List<StavkaCenovnika> stavke;


    /**
     * @pdGenerated default getter
     */
    public List<StavkaCenovnika> getStavke() {
        if (stavke == null)
            stavke = new ArrayList<StavkaCenovnika>();
        return stavke;
    }

    /**
     * @pdGenerated default iterator getter
     */
    public java.util.Iterator getIteratorStavke() {
        if (stavke == null)
            stavke = new ArrayList<StavkaCenovnika>();
        return stavke.iterator();
    }

    /**
     * @param newStavke
     * @pdGenerated default setter
     */
    public void setStavke(List<StavkaCenovnika> newStavke) {
        removeAllStavke();
        for (java.util.Iterator iter = newStavke.iterator(); iter.hasNext(); )
            addStavke((StavkaCenovnika) iter.next());
    }

    /**
     * @param newStavkaCenovnika
     * @pdGenerated default add
     */
    public void addStavke(StavkaCenovnika newStavkaCenovnika) {
        if (newStavkaCenovnika == null)
            return;
        if (this.stavke == null)
            this.stavke = new ArrayList<StavkaCenovnika>();
        if (!this.stavke.contains(newStavkaCenovnika)) {
            this.stavke.add(newStavkaCenovnika);
            newStavkaCenovnika.setCenovnik(this);
        }
    }

    /**
     * @param oldStavkaCenovnika
     * @pdGenerated default remove
     */
    public void removeStavke(StavkaCenovnika oldStavkaCenovnika) {
        if (oldStavkaCenovnika == null)
            return;
        if (this.stavke != null)
            if (this.stavke.contains(oldStavkaCenovnika)) {
                this.stavke.remove(oldStavkaCenovnika);
                oldStavkaCenovnika.setCenovnik((Cenovnik) null);
            }
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllStavke() {
        if (stavke != null) {
            StavkaCenovnika oldStavkaCenovnika;
            for (java.util.Iterator iter = getIteratorStavke(); iter.hasNext(); ) {
                oldStavkaCenovnika = (StavkaCenovnika) iter.next();
                iter.remove();
                oldStavkaCenovnika.setCenovnik((Cenovnik) null);
            }
        }
    }

}