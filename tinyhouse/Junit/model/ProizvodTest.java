package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProizvodTest {
    Proizvod p1 = new Proizvod(1, "Kolica", "Opis");
    Proizvod p2 = new Proizvod(2, "Kola", "Opis");

    @Test
    void uvecajKolicinu() {
        assertEquals(0, p1.getKolicinaZaOnline());
        p1.uvecajKolicinu(10);
        assertEquals(10, p1.getKolicinaZaOnline());
    }

    @Test
    void addSlicanProizvod() {
        p1.addSlicanProizvod(p2);
        assertEquals(1, p1.getSlicanProizvod().size());
        assertEquals(1, p2.getSlicanProizvod().size());
        assertEquals(p2, p1.getSlicanProizvod().get(0));
        assertEquals(p1, p2.getSlicanProizvod().get(0));
    }

    @Test
    void setTrenutnaCijena() {
        p1.setTrenutnaCijena(10, new Date());
        assertEquals(10, p1.getTrenutnaCijena().getJedinicnaCena());
        assertEquals(1, p1.getCijene().size());
    }
}