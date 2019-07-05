/***********************************************************************
 * Module:  Obrada.java
 * Author:  Gegic
 * Purpose: Defines the Class Obrada
 ***********************************************************************/
package model;

public class Obrada extends StanjeNarudzbine {
    public void uspesnoDostavljena() {
        // TODO: implement
    }


    public void otkazivanjeNarudzbine() {
        StanjeNarudzbine odbijena = new Odbijena();
        this.narudzbina.promijeniStanje(odbijena);
    }

    public void vracanjeNarudzbine() {
        // TODO: implement
    }

    public void entry() {
        // TODO: implement
    }

    public void kompletiranaNaruzbina() {
        StanjeNarudzbine uTransportu = new UTransportu(); // <<create>>
        this.narudzbina.obavijesti();
        this.narudzbina.promijeniStanje(uTransportu);

    }

    @Override
    public String toString() {
        return "Obrada";
    }
}