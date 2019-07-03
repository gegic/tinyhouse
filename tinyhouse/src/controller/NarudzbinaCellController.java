package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.Aplikacija;
import model.Narudzbina;
import model.Proizvod;

import java.io.IOException;

public class NarudzbinaCellController extends ListCell<Narudzbina> {

    @FXML private Label lbIdNarudzbine;
    @FXML private Label lbAdresa;
    @FXML private Label lbCijena;
    @FXML private AnchorPane box;

    private FXMLLoader mLLoader;

    @FXML
    public void promenaStanja(ActionEvent e){

    }

    @Override
    protected void updateItem(Narudzbina n, boolean empty) {
        super.updateItem(n, empty);
        if(empty || n == null) {
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../view/narudzbina_cell_view.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            lbIdNarudzbine.setText(String.valueOf(n.getBroj()));
            lbAdresa.setText(n.getAdresaIsporuke());
            lbCijena.setText(String.valueOf(n.getCijena()));
            setText(null);
            setGraphic(box);
        }

    }


}
