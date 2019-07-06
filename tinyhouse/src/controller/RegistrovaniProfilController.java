package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import model.Aplikacija;
import model.Korisnik;
import model.TipKorisnika;

public class RegistrovaniProfilController extends Controller {

    @FXML private Label lbImePrezime, lbKorisnickoIme, lbAdresa, lbEmail;
    @FXML private Button btIzmena, btZelje, btNarudzbine;
    @FXML private BorderPane borderPane;

    private Korisnik ulogovani;
    private Aplikacija model;

    public RegistrovaniProfilController(){
        model = Aplikacija.getInstance();
        ulogovani = Aplikacija.getInstance().getUlogovani();
    }

    public void setInfo(Object o){
        TopBarController c = new TopBarController();
        borderPane.setTop(c.create());
        if(ulogovani.getTip()== TipKorisnika.obican){
            lbImePrezime.setText(ulogovani.getKupac().getPrezime() + " " + ulogovani.getKupac().getIme());
            lbKorisnickoIme.setText(ulogovani.getUsername());
            lbAdresa.setText(ulogovani.getKupac().getAdresa());
            lbEmail.setText(ulogovani.getKupac().geteMail());
        }
        else {
            lbImePrezime.setText(ulogovani.getUsername());
            lbKorisnickoIme.setText(ulogovani.getUsername());
            lbAdresa.setVisible(false);
            lbEmail.setVisible(false);
            btNarudzbine.setVisible(false);
            btZelje.setVisible(false);
        }
    }

    @FXML
    public void povratak(ActionEvent e) {
        if (ulogovani.getTip() == TipKorisnika.obican){
            GeneralMainController c = new GeneralMainController();
            SceneSwitcher.switchScene(c, "../view/general_main_view.fxml", "nebitno");
        } else if (ulogovani.getTip() == TipKorisnika.moderator){
            ModeratorMainController c = new ModeratorMainController();
            SceneSwitcher.switchScene(c, "../view/moderator_main_view.fxml");
        } else{
            AdminMainController c = new AdminMainController();
            SceneSwitcher.switchScene(c, "../view/admin_main_view.fxml");
        }
    }
}
