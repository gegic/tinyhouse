package controller;

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

    public KorpaCellController(){

    }

    @FXML
    public void minus(ActionEvent e){

    }

    @FXML
    public void plus(ActionEvent e){

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

            lbNaziv.setText(s.getProizvod().getNaziv());
            lbCijena.setText(String.valueOf(s.getProizvod().getTrenutnaCijena().getJedinicnaCena()));
            icon.setImage(s.getProizvod().getSlike()[0]);
            setText(null);
            setGraphic(box);
        }

    }

}
