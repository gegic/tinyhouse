package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import model.Prodavnica;

import java.io.IOException;

public class ProdavnicaCellController extends ListCell<Prodavnica> {

    @FXML
    private Label id_prodavnice;

    @FXML
    private Button izbrisi;

    @FXML
    private AnchorPane box;

    @FXML
    private Label adresa;

    private FXMLLoader mLLoader;

    @FXML
    public void brisanje(ActionEvent e){
        DeleteProdavnicaController c = new DeleteProdavnicaController();
        SceneSwitcher.switchScene(c, "../view/delete_prodavnica_view.fxml", id_prodavnice.getText());
    }

    @FXML
    public void izmena(ActionEvent e){
        ModifyProdavnicaController c = new ModifyProdavnicaController();
        SceneSwitcher.switchScene(c, "../view/modify_prodavnica_view.fxml", id_prodavnice.getText());
    }

    @Override
    protected void updateItem(Prodavnica p, boolean empty) {
        super.updateItem(p, empty);

        if(empty || p == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../view/prodavnica_cell_view.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            id_prodavnice.setText(String.valueOf(p.getIdProdavnice()));
            adresa.setText(String.valueOf(p.getAdresa()));
            setText(null);
            setGraphic(box);
        }

    }

}
