package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import model.Kategorija;
import model.Narudzbina;

import java.io.IOException;

public class KategorijaCellController extends ListCell<Kategorija> {

    @FXML private Label lbNaziv;
    @FXML private Label lbPutanja;
    @FXML private AnchorPane box;

    private FXMLLoader mLLoader;

    @FXML
    public void brisanje(ActionEvent e){
        DeleteKategorijaController c = new DeleteKategorijaController();
        SceneSwitcher.switchScene(c, "../view/delete_kategorija_view.fxml", lbNaziv.getText());
    }

    @Override
    protected void updateItem(Kategorija k, boolean empty) {
        super.updateItem(k, empty);
        if(empty || k == null) {
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../view/kategorija_cell_view.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            lbNaziv.setText(k.getNaziv());
            lbPutanja.setText(k.getPutanja());
            setText(null);
            setGraphic(box);
        }

    }
}
