package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import model.Prodavnica;
import model.Proizvod;

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

    @FXML
    private Button btDodaj;

    private Prodavnica p;

    private FXMLLoader mLLoader;

    private boolean read_only;

    private Proizvod previous;

    public ProdavnicaCellController(){
        read_only = false;
    }

    public ProdavnicaCellController(boolean read_only, Proizvod p){
        this.read_only = read_only;
        previous = p;
    }

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
            setButtons();
            setText(null);
            setGraphic(box);
        }

    }

    private void setButtons() {
        id_prodavnice.setText(String.valueOf(p.getIdProdavnice()));
        adresa.setText(String.valueOf(p.getAdresa()));
        if (read_only) {
            izbrisi.setText("Pronađi na karti");
            izbrisi.setOnAction(this::karta);
            btDodaj.setText("Pregledaj proizvode");
            btDodaj.setOnAction(this::pregledProizvoda);
            izbrisi.setVisible(true);
            btDodaj.setVisible(true);

        } else {
            izbrisi.setVisible(true);
            izmeni.setVisible(true);
            btDodaj.setVisible(true);
        }
    }

    private void pregledProizvoda(ActionEvent e){
        ProizvoduprodavniciPreporukeController c = new ProizvoduprodavniciPreporukeController();
        Object[] obs = {this.p, this.previous};
        SceneSwitcher.switchScene(c, "../view/proizvoduprodavnici_preporuke_view.fxml", true, obs);
    }

    private void karta(ActionEvent e){
        KartaController c = new KartaController();
        Object[] obs = {this.p, this.previous};
        SceneSwitcher.switchScene(c, "../view/karta_view.fxml", obs);
    }

    @FXML
    public void dodajProizvode(ActionEvent event){
        ProizvoduprodavniciPreporukeController c = new ProizvoduprodavniciPreporukeController();
        SceneSwitcher.switchScene(c, "../view/proizvoduprodavnici_preporuke_view.fxml", true, this.p);
    }
}
