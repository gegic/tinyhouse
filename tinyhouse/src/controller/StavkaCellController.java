package controller;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.StavkaNarudzbine;

import java.io.IOException;

public class StavkaCellController extends ListCell<StavkaNarudzbine> {

    @FXML private Label lbNaziv;
    @FXML private Label lbCijena;
    @FXML private Label lbKolicina;
    @FXML private ImageView icon;
    @FXML private AnchorPane box;

    private FXMLLoader mLLoader;
    private StavkaNarudzbine stavka;

    private KorpaController parent;
    public StavkaCellController(){

    }

    @Override
    protected void updateItem(StavkaNarudzbine s, boolean empty) {
        super.updateItem(s, empty);
        if(empty || s == null) {
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../view/stavka_cell_view.fxml"));
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
            lbCijena.setText(String.valueOf(s.getUkupno()));
            lbKolicina.setText(String.valueOf(s.getNarucenaKolicina()));
            icon.setImage(s.getProizvod().getSlike()[0]);
            setText(null);
            setGraphic(box);
        }

    }
}
