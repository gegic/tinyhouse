/***********************************************************************
 * Module:  StanjeNarudzbine.java
 * Author:  Gegic
 * Purpose: Defines the Class StanjeNarudzbine
 ***********************************************************************/
package model;

import java.io.Serializable;

public abstract class StanjeNarudzbine implements Serializable {
    protected Narudzbina narudzbina;

    public void entry() {
        // TODO: implement
    }

    public void otkazivanjeNarudzbine() {
        // TODO: implement
    }

    public void vracanjeNarudzbine() {
        // TODO: implement
    }

    public void uspesnoDostavljena() {
        // TODO: implement
    }


    public void kompletiranaNaruzbina() {
        // TODO: implement
    }


    /**
     * @pdGenerated default parent getter
     */
    public Narudzbina getNarudzbina() {
        return narudzbina;
    }

    /**
     * @param newNarudzbina
     * @pdGenerated default parent setter
     */
    public void setNarudzbina(Narudzbina newNarudzbina) {
        if (this.narudzbina == null || !this.narudzbina.equals(newNarudzbina)) {
            this.narudzbina = newNarudzbina;
            if (this.narudzbina != null && this.narudzbina.getTrenutno_stanje() != this)
                this.narudzbina.setTrenutno_stanje(this);
        }
    }

    public abstract String toString();
}