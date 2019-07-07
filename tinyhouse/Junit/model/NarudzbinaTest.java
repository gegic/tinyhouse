package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class NarudzbinaTest {
    Proizvod p1 = new Proizvod(1, "Naziv", "Opis");
    StavkaNarudzbine s;
    ArrayList<StavkaNarudzbine> ss = new ArrayList<>();
    Narudzbina n;

    @BeforeEach
    void setUp(){
        p1.setTrenutnaCijena(10, new Date());
        p1.uvecajKolicinu(11);
        s = new StavkaNarudzbine(10, p1.getTrenutnaCijena().getJedinicnaCena(), p1);
        ss.add(s);
        n = new Narudzbina(1, "Adresa", ss, new Kupac("h", "h","h", "h"));
    }
    @Test
    void primljenZahtev() {
        n.primljenZahtev();
        assertEquals("Obrada", n.getTrenutno_stanje().toString());
    }


    @Test
    void otkazivanjeNarudzbine() {
        n.primljenZahtev();
        n.otkazivanjeNarudzbine();
        assertEquals("Odbijena", n.getTrenutno_stanje().toString());
    }

    @Test
    void vracanjeNarudzbine() {
        n.primljenZahtev();
        n.kompletiranaNaruzbina();
        n.uspesnoDostavljena();
        n.vracanjeNarudzbine();
        assertEquals("Odbijena", n.getTrenutno_stanje().toString());
    }

    @Test
    void uspesnoDostavljena() {
        n.primljenZahtev();
        n.kompletiranaNaruzbina();
        n.uspesnoDostavljena();
        assertEquals("Isporučena", n.getTrenutno_stanje().toString());
    }

    @Test
    void kompletiranaNaruzbina() {
        n.primljenZahtev();
        n.kompletiranaNaruzbina();
        assertEquals("U transportu", n.getTrenutno_stanje().toString());
    }
}