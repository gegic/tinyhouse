package controller;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Kategorija;
import model.Prodavnica;
import model.Proizvod;

import java.io.IOException;

public class DeleteKategorijaController extends Controller {

    @FXML private Label lbNazivKategorije;

    @FXML private Label lbPutanja;

    @FXML private Button btObrisi;

    @FXML private CheckBox cb;

    private Kategorija k;

    private Stage stage;

    private Aplikacija model;

    public DeleteKategorijaController(){
        this.model = Aplikacija.getInstance();
    }

    @FXML
    public void brisi(ActionEvent e){
        brisi();
    }

    @FXML
    public void enter_brisi(KeyEvent e){if (e.getCode() == KeyCode.ENTER && cb.isSelected()) brisi();}

    public void brisi(){
        model.brisanjeKategorije(k);
        povratak();
    }

    @FXML
    public void otkazi(ActionEvent e) {
        povratak();
    }

    public void povratak() {
        ModeratorCategoriesController c = new ModeratorCategoriesController();
        SceneSwitcher.switchScene(c, "../view/moderator_categories_view.fxml", true);
    }
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    public void setInfo(String naziv_kategorije) {
        k = model.pronadjiKategoriju(naziv_kategorije);
        lbNazivKategorije.setText(naziv_kategorije);
        lbPutanja.setText(k.getPutanja());

        if(!k.getPotkategorije().isEmpty() || !k.getProizvodi().isEmpty()){
            btObrisi.setDisable(true);
            cb.setVisible(true);
            cb.selectedProperty().addListener(
                    (ObservableValue<? extends Boolean> observableValue, Boolean oldVal, Boolean newVal) -> {
                        if(newVal) btObrisi.setDisable(false);
                        else btObrisi.setDisable(true);
                    });
        }
    }
}


