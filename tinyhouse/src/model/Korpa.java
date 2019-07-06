/***********************************************************************
 * Module:  Korpa.java
 * Author:  Gegic
 * Purpose: Defines the Class Korpa
 ***********************************************************************/
package model;
import java.io.Serializable;
import java.util.*;

public class Korpa implements Serializable {
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
        if (!this.stavkeNarudzbine.contains(newStavkaNarudzbine)) {
            this.ukupnaCijena += newStavkaNarudzbine.getUkupno();
            this.stavkeNarudzbine.add(newStavkaNarudzbine);
        }
    }

    /** @pdGenerated default remove
     * @param oldStavkaNarudzbine */
    public void removeStavkaNarudzbine(StavkaNarudzbine oldStavkaNarudzbine) {
        if (oldStavkaNarudzbine == null)
            return;
        if (this.stavkeNarudzbine != null)
            if (this.stavkeNarudzbine.contains(oldStavkaNarudzbine)) {
                this.ukupnaCijena -= oldStavkaNarudzbine.getUkupno();
                this.stavkeNarudzbine.remove(oldStavkaNarudzbine);
            }
    }

    /** @pdGenerated default removeAll */
    public void removeAllStavkaNarudzbine() {
        if (stavkeNarudzbine != null) {
            stavkeNarudzbine.clear();
            ukupnaCijena = 0;
        }
    }

    public float getUkupnaCijena() {
        return ukupnaCijena;
    }

    public void setUkupnaCijena(float ukupnaCijena) {
        this.ukupnaCijena = ukupnaCijena;
    }

    public boolean contains(Proizvod p){
        for(StavkaNarudzbine n : stavkeNarudzbine){
            if(n.getProizvod().equals(p)){
                return true;
            }
        }
        return false;
    }

    public StavkaNarudzbine pronadji(String id){
        for(StavkaNarudzbine s : stavkeNarudzbine){
            if(s.getProizvod().getId() == Integer.valueOf(id)){
                return s;
            }
        }
        return null;
    }

    public void obavljenaKupovina(){
        for(StavkaNarudzbine s : stavkeNarudzbine){
            s.getProizvod().decreaseKolicinaZaOnline(s.getNarucenaKolicina());
        }
        stavkeNarudzbine = new ArrayList<>();
    }
}