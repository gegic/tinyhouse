/***********************************************************************
 * Module:  Korpa.java
 * Author:  Gegic
 * Purpose: Defines the Class Korpa
 ***********************************************************************/
package model;
import java.util.*;

public class Korpa {
    private float ukupnaCijena;

    public List<StavkaNarudzbine> stavkeNarudzbine;

    public Korpa(){
        ukupnaCijena = 0;
        stavkeNarudzbine = new ArrayList<>();
    }


    /** @pdGenerated default getter */
    public List<StavkaNarudzbine> getStavkeNarudzbine() {
        if (stavkeNarudzbine == null)
            stavkeNarudzbine = new ArrayList<StavkaNarudzbine>();
        return stavkeNarudzbine;
    }

    /** @pdGenerated default iterator getter */
    public java.util.Iterator getIteratorStavkaNarudzbine() {
        if (stavkeNarudzbine == null)
            stavkeNarudzbine = new ArrayList<StavkaNarudzbine>();
        return stavkeNarudzbine.iterator();
    }

    /** @pdGenerated default setter
     * @param newStavkaNarudzbine */
    public void setStavkeNarudzbine(List<StavkaNarudzbine> newStavkaNarudzbine) {
        removeAllStavkaNarudzbine();
        for (java.util.Iterator iter = newStavkaNarudzbine.iterator(); iter.hasNext();)
            addStavkaNarudzbine((StavkaNarudzbine)iter.next());
    }

    /** @pdGenerated default add
     * @param newStavkaNarudzbine */
    public void addStavkaNarudzbine(StavkaNarudzbine newStavkaNarudzbine) {
        if (newStavkaNarudzbine == null)
            return;
        if (this.stavkeNarudzbine == null)
            this.stavkeNarudzbine = new ArrayList<StavkaNarudzbine>();
        if (!this.stavkeNarudzbine.contains(newStavkaNarudzbine))
            this.stavkeNarudzbine.add(newStavkaNarudzbine);
    }

    /** @pdGenerated default remove
     * @param oldStavkaNarudzbine */
    public void removeStavkaNarudzbine(StavkaNarudzbine oldStavkaNarudzbine) {
        if (oldStavkaNarudzbine == null)
            return;
        if (this.stavkeNarudzbine != null)
            if (this.stavkeNarudzbine.contains(oldStavkaNarudzbine))
                this.stavkeNarudzbine.remove(oldStavkaNarudzbine);
    }

    /** @pdGenerated default removeAll */
    public void removeAllStavkaNarudzbine() {
        if (stavkeNarudzbine != null)
            stavkeNarudzbine.clear();
    }

}