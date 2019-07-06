package comparators;
import java.util.Comparator;
import model.Proizvod;

public class ProizvodComparator implements Comparator<Proizvod> {

    private String choice;
    public ProizvodComparator(){

    }

    public ProizvodComparator(String choice) {

        this.choice = choice;
    }



    @Override
    public int  compare(Proizvod k1, Proizvod k2) {
        if (this.choice.equals("price_asc")) {
            if (k1.getTrenutnaCijena().getJedinicnaCena() < k2.getTrenutnaCijena().getJedinicnaCena()) return -1;
            if (k1.getTrenutnaCijena().getJedinicnaCena() > k2.getTrenutnaCijena().getJedinicnaCena()) return 1;
            return 0;
        }
        else if (this.choice.equals("price_desc")) {
            if (k1.getTrenutnaCijena().getJedinicnaCena() > k2.getTrenutnaCijena().getJedinicnaCena()) return -1;
            if (k1.getTrenutnaCijena().getJedinicnaCena() < k2.getTrenutnaCijena().getJedinicnaCena()) return 1;
            return 0;
        }
        else if (this.choice.equals("name_asc"))
            return k1.getNaziv().compareToIgnoreCase(k2.getNaziv());
        else if (this.choice.equals("name_desc"))
            return k2.getNaziv().compareToIgnoreCase(k1.getNaziv());
        else
            return 0;

    }





}