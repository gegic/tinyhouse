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
import model.TipKorisnika;

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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/delete_prodavnica_view.fxml"));
            Parent root = loader.load();

            DeleteProdavnicaController c = loader.getController();
            Stage stage = (Stage)((Scene)((Button)e.getSource()).getScene()).getWindow();
            c.setStage(stage);
            c.setId_prodavnice(Integer.valueOf(id_prodavnice.getText()));
            c.setAdresa(adresa.getText());
            Scene scene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
            stage.setScene(scene);
        } catch(Exception ex){
            System.out.println("Nije moguće učitati scenu.");
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    public void izmena(ActionEvent e){
        //TODO: izmena da se uradi
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
