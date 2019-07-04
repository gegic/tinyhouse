package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Aplikacija;
import model.Korisnik;
import model.TipKorisnika;

public class RegistrovaniProfilController extends Controller {

    @FXML private Label lbPrezimeIIme, lbUsername, lbAdresa, lbeMail;

    private Korisnik ulogovani;
    private Aplikacija model;
    public RegistrovaniProfilController(){
        model = Aplikacija.getInstance();
        ulogovani = Aplikacija.getInstance().getUlogovani();
        iniit();
    }

    private void iniit(){
        if(ulogovani.getTip()== TipKorisnika.obican){
            lbPrezimeIIme.setText(ulogovani.getKupac().getPrezime() + " " + ulogovani.getKupac().getIme());
            lbUsername.setText(ulogovani.getUsername());
            lbAdresa.setText(ulogovani.getKupac().getAdresa());
            lbeMail.setText(ulogovani.getKupac().geteMail());
        }
        else {
            lbPrezimeIIme.setText(ulogovani.getUsername());
            lbUsername.setText(ulogovani.getUsername());
            lbAdresa.setText("//");
            lbeMail.setText("//");
        }
    }

    @FXML
    public void odjava(ActionEvent e) {
        SceneSwitcher.odjava();
    }

    @FXML
    public void povratak(ActionEvent e) {
        if(ulogovani.getTip()==TipKorisnika.admin){
            GeneralMainController c = new GeneralMainController();
            SceneSwitcher.switchScene(c, "../view/admin_main_view.fxml", "nebitno");
        }

    }
}
