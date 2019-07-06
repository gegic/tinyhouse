/***********************************************************************
 * Module:  UTransportu.java
 * Author:  Gegic
 * Purpose: Defines the Class UTransportu
 ***********************************************************************/
package model;

public class UTransportu extends StanjeNarudzbine {
    public void otkazivanjeNarudzbine() {
        // TODO: implement
    }

    public void vracanjeNarudzbine() {
        StanjeNarudzbine vracena = new Odbijena(); // <<create>>
        this.narudzbina.promijeniStanje(vracena);
    }

    public void uspesnoDostavljena() {
        StanjeNarudzbine isporucena = new Isporucena();
        this.narudzbina.promijeniStanje(isporucena);
    }


    public void entry() {
        // TODO: implement
    }

    public void kompletiranaNaruzbina() {
        // TODO: implement
    }

    @Override
    public String toString() {
        return "U transportu";
    }
}