package controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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

import java.io.IOException;

public class KupovinaController extends Controller {

    @FXML private Label lbCena;
    @FXML private TextField tfIme;
    @FXML private TextField tfPrezime;
    @FXML private TextField tfMail;
    @FXML private TextField tfAdresaKupca;
    @FXML private TextField tfAdresaIsporuke;
    @FXML private PasswordField tfLozinka;
    @FXML private Label lbGreska;
    @FXML private CheckBox cb;

    private Stage stage;

    private Aplikacija model;

    public KupovinaController(){
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
        KorpaController c = new KorpaController();
        SceneSwitcher.switchScene(c, "../view/korpa_view.fxml", true, "nebitno");
    }

    @FXML
    public void enter_kupi(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER) {
            kupi();
        }
    }
    @FXML
    public void kupi(ActionEvent e) {
        kupi();
    }

    public void kupi(){

    };

    private void checkBoxListener(Boolean newVal){
        if(newVal){
            tfAdresaIsporuke.setPrefHeight(0);
            tfAdresaIsporuke.setVisible(false);
        } else{
            tfAdresaIsporuke.setPrefHeight(40);
            tfAdresaIsporuke.setVisible(true);
        }
    }

    private void setIfUlogovan(){
        Korisnik ulogovani = model.getUlogovani();
        if(ulogovani != null){
            tfIme.setText(ulogovani.getKupac().getIme());
            tfIme.setDisable(true);
            tfPrezime.setText(ulogovani.getKupac().getPrezime());
            tfPrezime.setDisable(true);
            tfMail.setText(ulogovani.getKupac().geteMail());
            tfMail.setDisable(true);
            tfAdresaKupca.setText(ulogovani.getKupac().getAdresa());
            tfAdresaKupca.setDisable(true);
        }
    }

    public void setInfo(String id){
        lbCena.setText(String.valueOf(model.getTrenutnaKorpa().getUkupnaCijena()));
        cb.selectedProperty().addListener(
            (ObservableValue<? extends Boolean> observableValue, Boolean oldVal, Boolean newVal) ->
                    checkBoxListener(newVal));

        setIfUlogovan();
    }
}
