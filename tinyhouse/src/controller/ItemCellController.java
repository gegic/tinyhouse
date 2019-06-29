package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Korisnik;
import model.Prodavnica;
import model.Proizvod;
import model.TipKorisnika;

import java.io.IOException;

public class ItemCellController extends ListCell<Proizvod> {

    @FXML
    private Label lbIdItem;

    @FXML
    private Button izbrisi;

    @FXML
    private AnchorPane box;

    @FXML
    private Label lbKolicina;

    private FXMLLoader mLLoader;

    @FXML
    public void brisanje(ActionEvent e){

    }

    @FXML
    public void izmena(ActionEvent e) {
    }

    @Override
    protected void updateItem(Proizvod p, boolean empty) {
        super.updateItem(p, empty);

        if(empty || p == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../view/proizvod_cell_view.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            lbIdItem.setText(String.valueOf("DJE JE NAZIV"));
            lbKolicina.setText(String.valueOf("A DJE KOLICINA"));
            setText(null);
            setGraphic(box);
        }

    }

}
