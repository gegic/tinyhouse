package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import model.Aplikacija;
import model.Prodavnica;
import model.TipKorisnika;

import java.io.IOException;

public class ProdavnicaCellController extends ListCell<Prodavnica> {

    @FXML
    private Label id_prodavnice;

    @FXML
    private Button izbrisi;

    @FXML
    private Button izmeni;

    @FXML
    private AnchorPane box;

    @FXML
    private Label adresa;

    private Prodavnica p;

    private FXMLLoader mLLoader;

    @FXML
    public void brisanje(ActionEvent e){
        DeleteProdavnicaController c = new DeleteProdavnicaController();
        SceneSwitcher.switchScene(c, "../view/delete_prodavnica_view.fxml", p);
    }

    @FXML
    public void izmena(ActionEvent e){
        ModifyProdavnicaController c = new ModifyProdavnicaController();
        SceneSwitcher.switchScene(c, "../view/modify_prodavnica_view.fxml", p);
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
            this.p = p;
            id_prodavnice.setText(String.valueOf(p.getIdProdavnice()));
            adresa.setText(String.valueOf(p.getAdresa()));
            if(Aplikacija.getInstance().getUlogovani().getTip() == TipKorisnika.moderator){
                izbrisi.setVisible(true);
                izmeni.setVisible(true);
            }
            setText(null);
            setGraphic(box);
        }

    }

}
