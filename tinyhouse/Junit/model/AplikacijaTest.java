package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AplikacijaTest {

    private static Aplikacija a;

    @BeforeEach
    void setUp() {
        a = Aplikacija.getInstance();
    }

    @Test
    void prijavaTest() {
        Korisnik k = a.prijava("admin", "admin");
        assertEquals(k.getUsername(), a.getUlogovani().getUsername());
        a.odjava();
    }

    @Test
    void odjavaTest() {
        a.odjava();
        assertEquals(0, a.getTrenutnaKorpa().getStavkeNarudzbine().size());
        assertNull(a.getUlogovani());
    }

    @Test
    void dodavanjeKategorijeTest() {
        a.dodavanjeKategorije("Kategorija", null);
        assertEquals(1, a.getKategorije().size());
        a.brisanjeKategorije(a.getKategorije().get(0));
    }

    @Test
    void brisanjeKategorijeTest(){
        a.dodavanjeKategorije("Kategorija", null);
        Kategorija k = a.getKategorije().get(0);
        a.brisanjeKategorije(k);
        assertEquals(0, a.getKategorije().size());
    }

    @Test
    void registracijaTest(){
        a.odjava();
        a.registracija("h", "h", "h", "h", "h", "h");
        Korisnik k = a.prijava("h", "h");
        assertEquals(k, a.getUlogovani());
        assertEquals(2, a.getKorisnici().size());
        a.odjava();
    }

    @Test
    void searchTest() {
        a.dodavanjeProizvoda(1, "Kolica", "Opis kolica", null, null, 10, null);
        a.dodavanjeProizvoda(2, "Kola", "Najbolja kola na svijetu", null, null, 10, null);
        assertEquals(2, a.search("KOL").size());
        assertEquals(1, a.search("svijet").size());
    }

    @Test
    void kupovinaTest(){
        a.kupovina("Adresa", new Kupac("h", "h", "h", "h"));
        assertEquals(1, a.getNarudzbine().size());
    }
}