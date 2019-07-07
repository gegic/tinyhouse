/***********************************************************************
 * Module:  Isporucena.java
 * Author:  Gegic
 * Purpose: Defines the Class Isporucena
 ***********************************************************************/
package model;

import java.io.Serializable;

public class Isporucena extends StanjeNarudzbine implements Serializable {
    public void otkazivanjeNarudzbine() {
        // TODO: implement
    }

    public void vracanjeNarudzbine() {
        StanjeNarudzbine vracena = new Odbijena(); // <<create>>
        this.narudzbina.promijeniStanje(vracena);;
    }

    public void uspesnoDostavljena() {
        // TODO: implement
    }


    public void entry() {
        // TODO: implement
    }

    public void kompletiranaNaruzbina() {
        // TODO: implement
    }

    @Override
    public String toString() {
        return "Isporučena";
    }
}