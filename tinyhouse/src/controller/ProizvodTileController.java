package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Aplikacija;
import model.Proizvod;

import java.io.IOException;

public class ProizvodTileController{
    @FXML
    private Label lbNaziv;

    @FXML
    private Label lbCijena;

    @FXML
    private ImageView ivItem;

    @FXML
    private AnchorPane box;

    @FXML
    private AnchorPane apDetaljnije;

    private Aplikacija model;

    private String id_proizvoda;

    private Proizvod p;

    public ProizvodTileController(){
        model = Aplikacija.getInstance();
    }

    public AnchorPane create(Proizvod p){
        this.p = p;
        id_proizvoda = String.valueOf(p.getId());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/proizvod_tile_view.fxml"));
            loader.setController(this);
            loader.load();

            ivItem.setImage(p.getSlike()[0]);
            lbNaziv.setText(p.getNaziv());
            lbCijena.setText(String.valueOf(p.getTrenutnaCijena().getJedinicnaCena()) + " RSD");
        } catch(IOException e) {
            e.printStackTrace();
        }
        return box;
    }

    @FXML
    public void detaljnije() {
        ProizvodDetailsController c = new ProizvodDetailsController();
        SceneSwitcher.switchScene(c, "../view/proizvod_details_view.fxml", p);
    };

    @FXML
    public void hover_started() {
        apDetaljnije.setVisible(true);
    }

    @FXML
    public void hover_stopped() {
        apDetaljnije.setVisible(false);
    }


}
