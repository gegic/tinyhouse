package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Korisnik;
import model.Kupac;
import model.TipKorisnika;


import java.io.IOException;

public class RegistrationController extends Controller {


    @FXML private TextField tfIme;
    @FXML private TextField tfPrezime;
    @FXML private TextField tfMail;
    @FXML private TextField tfAdresa;
    @FXML private TextField tfKIme;
    @FXML private PasswordField tfLozinka;
    @FXML private Label lbGreska;


    private Stage stage;

    private Aplikacija model;

    public RegistrationController(){
        this.model = Aplikacija.getInstance();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void povratak(ActionEvent e) throws IOException {
        povratak();
    }

    public void povratak() {
        GeneralMainController c = new GeneralMainController();
        SceneSwitcher.switchScene(c, "../view/general_main_view.fxml");
    }

    @FXML
    public void enter_registracija(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER) {
            registracija();
        }
    }
    @FXML
    public void registrujSe(ActionEvent e) throws IOException {
        registracija();
    }

    public void registracija(){
        if(provera()) {
            Korisnik k = new Korisnik(tfKIme.getText().trim(), tfLozinka.getText(), TipKorisnika.obican);
            model.korisnici.add(k);
            model.addKupci(new Kupac(tfIme.getText().trim(), tfPrezime.getText().trim(), tfAdresa.getText().trim(), tfMail.getText().trim(), k));
            GeneralMainController c = new GeneralMainController();
            SceneSwitcher.switchScene(c, "../view/general_main_view.fxml");
        }
    };

    private boolean provera(){
        if(tfIme.getText().trim().equalsIgnoreCase("") || tfPrezime.getText().trim().equalsIgnoreCase("") ||
                tfMail.getText().trim().equalsIgnoreCase("") || tfAdresa.getText().trim().equalsIgnoreCase("") ||
                tfKIme.getText().trim().equalsIgnoreCase("")  || tfLozinka.getText().trim().equalsIgnoreCase("")){
            lbGreska.setTextFill(Color.RED);;
            lbGreska.setText("Svako polje mora biti popunjeno.");
            return false;
        }
        for (Korisnik k: model.korisnici) {
            if(k.getUsername().equalsIgnoreCase(tfKIme.getText().trim())){
                lbGreska.setTextFill(Color.RED);
                lbGreska.setText("Korisničko ime već postoji, pokušaj neko drugo.");
                return false;
            }
        }
        for (Kupac k: model.kupci){
            if(k.geteMail().equalsIgnoreCase(tfAdresa.getText().trim())){
                lbGreska.setTextFill(Color.RED);
                lbGreska.setText("E-mail već ima nalog, pokušaj ponovo.");
                return false;
            }
        }
        if(tfLozinka.getText().length()<8){
            tfLozinka.setStyle("-fx-border-color: red");
            lbGreska.setTextFill(Color.RED);
            lbGreska.setText("Lozinka mora imati vise od 8 karaktera.");
            return false;
        }

        return true;
    }


}
