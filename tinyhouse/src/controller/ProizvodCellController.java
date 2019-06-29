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

public class ProizvodCellController extends ListCell<Proizvod> {

    @FXML
    private Label lb_id_proizvoda;

    @FXML
    private Button izbrisi;

    @FXML
    private AnchorPane box;

    @FXML
    private Label lb_kolicina;

    @FXML
    private Label lb_naziv;

    @FXML
    private ImageView icon;

    private FXMLLoader mLLoader;

    @FXML
    public void brisanje(ActionEvent e){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/delete_proizvod_view.fxml"));
            Parent root = loader.load();

            DeleteProizvodController c = loader.getController();
            Stage stage = (Stage)((Scene)((Button)e.getSource()).getScene()).getWindow();
            c.setStage(stage);
            c.setLbIdProizvoda(lb_id_proizvoda.getText());
            c.setLbNaziv(lb_naziv.getText());
            Scene scene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
            stage.setScene(scene);
        } catch(Exception ex){
            System.out.println("Nije moguće učitati scenu.");
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    public void izmena(ActionEvent e) {
    }

    @FXML
    public void uvecanjeKolicine(ActionEvent e){

    }

    @Override
    protected void updateItem(Proizvod p, boolean empty) {
        super.updateItem(p, empty);

        if(empty || p == null) {
            //
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

            lb_id_proizvoda.setText(String.valueOf(p.getId()));
            lb_naziv.setText(p.getNaziv());
            lb_kolicina.setText(String.valueOf(p.getKolicinaZaOnline()));
            icon.setImage(p.getSlike()[0]);
            setText(null);
            setGraphic(box);
        }

    }

}
