package controller;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.Aplikacija;
import model.Proizvod;
import model.StavkaCenovnika;
import model.StavkaNarudzbine;

import java.io.IOException;

public class KorpaCellController extends ListCell<StavkaNarudzbine> {

    @FXML private Label lbNaziv;
    @FXML private Label lbCijena;
    @FXML private TextField tfKolicina;
    @FXML private Button btMinus;
    @FXML private Button btPlus;
    @FXML private ImageView icon;
    @FXML private AnchorPane box;

    private FXMLLoader mLLoader;
    private StavkaNarudzbine stavka;

    private KorpaController parent;
    public KorpaCellController(){

    }

    public KorpaCellController(KorpaController c){
        parent = c;
    }

    @FXML
    public void minus(ActionEvent e){
        int newValue = Integer.valueOf(tfKolicina.getText()) - 1;
        tfKolicina.setText(String.valueOf(newValue));
    }

    @FXML
    public void plus(ActionEvent e){
        int newValue = Integer.valueOf(tfKolicina.getText())+ 1;
        tfKolicina.setText(String.valueOf(newValue));
    }
    @FXML
    public void checkKolicina(ActionEvent e){

    }

    @Override
    protected void updateItem(StavkaNarudzbine s, boolean empty) {
        super.updateItem(s, empty);
        if(empty || s == null) {
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../view/korpa_cell_view.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            stavka = s;
            lbNaziv.setText(s.getProizvod().getNaziv());
            lbNaziv.maxWidthProperty().bind(SceneSwitcher.getStage().widthProperty().divide(7));
            lbCijena.setText(String.valueOf(s.getProizvod().getTrenutnaCijena().getJedinicnaCena()));
            tfKolicina.textProperty().addListener(
                    (ObservableValue<? extends String> observable, String oldValue, String newValue) ->
                    {
                        if (!newValue.matches("\\d*")) newValue = newValue.replaceAll("[^\\d]", "");
                        if(!newValue.equals("")) {
                            if (Integer.valueOf(newValue) <= 1) btMinus.setDisable(true);
                            else btMinus.setDisable(false);
                            if (Integer.valueOf(newValue) >= stavka.getProizvod().getKolicinaZaOnline()) {
                                newValue = String.valueOf(stavka.getProizvod().getKolicinaZaOnline());
                                btPlus.setDisable(true);
                            } else {
                                btPlus.setDisable(false);
                            }
                            float oldVal = stavka.getUkupno();
                            stavka.setNarucenaKolicina(Integer.valueOf(newValue));
                            lbCijena.setText(String.valueOf(stavka.getUkupno()));
                            parent.resetUkupno(oldVal, stavka.getUkupno());
                        }
                        tfKolicina.setText(newValue);
                    });
            icon.setImage(s.getProizvod().getSlike()[0]);
            setText(null);
            setGraphic(box);
        }

    }

    @FXML
    public void ukloniIzKorpe(ActionEvent e){
        RemoveKorpaController c = new RemoveKorpaController();
        SceneSwitcher.switchScene(
                c, "../view/remove_korpa_view.fxml", String.valueOf(stavka.getProizvod().getId()));
    }
}
