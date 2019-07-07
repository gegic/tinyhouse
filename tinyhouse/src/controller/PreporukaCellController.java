package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Aplikacija;
import model.Proizvod;

import java.io.IOException;

public class PreporukaCellController extends ListCell<Proizvod> {
    @FXML
    private Label lbNaziv;

    @FXML
    private Label lbCijena;

    @FXML
    private VBox vbox;

    @FXML
    private AnchorPane box;

    @FXML
    private ImageView ivItem;

    private Aplikacija model;

    private Proizvod p;

    private FXMLLoader mLLoader;


    public PreporukaCellController(){
        model = Aplikacija.getInstance();
    }

    @Override
    public void updateItem(Proizvod p, boolean empty){
        super.updateItem(p, empty);
        if(empty || p == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../view/preporuka_cell_view.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            this.p = p;
            String id_proizvoda = String.valueOf(p.getId());

            ivItem.setImage(p.getSlike()[0]);
            lbNaziv.setText(p.getNaziv());
            lbCijena.setText(String.valueOf(p.getTrenutnaCijena().getJedinicnaCena()) + " RSD");

            setText(null);
            setGraphic(box);
        }
    }

    @FXML
    public void detaljnije() {
        ProizvodDetailsController c = new ProizvodDetailsController();
        SceneSwitcher.switchScene(c, "../view/proizvod_details_view.fxml", p);
    };

    @FXML
    public void hoverStarted() {
        lbCijena.setVisible(true);
        lbNaziv.setVisible(true);
    }

    @FXML
    public void hoverStopped() {
        lbCijena.setVisible(false);
        lbNaziv.setVisible(false);
    }


}
