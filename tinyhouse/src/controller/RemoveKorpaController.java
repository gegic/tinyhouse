package controller;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Proizvod;
import model.StavkaNarudzbine;

import java.io.IOException;

public class RemoveKorpaController extends Controller {

    @FXML private Label lbNazivProizvoda;
    @FXML private Label lbInfo1;
    @FXML private Label lbInfo;
    @FXML private Button obrisi_button;
    @FXML private Button otkazi_button;
    private Stage stage;

    private StavkaNarudzbine stavka;

    private Aplikacija model;

    public RemoveKorpaController(){
        this.model = Aplikacija.getInstance();
    }

    @FXML
    public void brisi(ActionEvent e){
        brisi();
    }

    @FXML
    public void enter_brisi(KeyEvent e){if (e.getCode() == KeyCode.ENTER) brisi();}

    public void brisi(){
        model.ukloniIzKorpe(stavka);
        povratak();
    }

    @FXML
    public void otkazi(ActionEvent e) throws IOException {
        povratak();
    }

    public void povratak() {
        KorpaController c = new KorpaController();
        SceneSwitcher.switchScene(c, "../view/korpa_view.fxml", true, "nema nista");
    }
    
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setInfo(String idProizvoda) {
        setSizes(stage.getWidth());
        stavka = model.pronadjiIzKorpe(idProizvoda);
        this.lbNazivProizvoda.setText(stavka.getProizvod().getNaziv());
        stage.widthProperty().addListener(
                (ObservableValue<? extends Number> observableValue, Number oldWidth, Number newWidth) ->
        {
            setSizes(newWidth);
        });

        stage.maximizedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
            setSizes(stage.getWidth());
        });
    }

    private void setSizes(Number newWidth){
        int size = newWidth.intValue() / 30;
        int infoSize = newWidth.intValue() / 40;
        if (size > 25) size = 25;
        if(infoSize > 20) infoSize = 20;
        lbNazivProizvoda.setStyle("-fx-font-size: " + size + "px;");
        lbInfo.setStyle("-fx-font-size: " + infoSize + "px;");
        lbInfo1.setStyle("-fx-font-size: " + infoSize + "px;");
        otkazi_button.setStyle("-fx-font-size: " + infoSize + "px;");
        obrisi_button.setStyle("-fx-font-size: " + infoSize + "px;");
    }
}


