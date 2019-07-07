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
import model.TipKorisnika;

import java.io.IOException;

public class NarudzbinaCellController extends ListCell<Narudzbina> {

    @FXML private Label lbIdNarudzbine;
    @FXML private Label lbAdresa;
    @FXML private Label lbCijena;
    @FXML private AnchorPane box;
    @FXML private Button btPromena;
    @FXML private Button btPromena1;
    @FXML private Label lbTrenutno;
    private Narudzbina narudzbina;

    private FXMLLoader mLLoader;

    @FXML
    public void kompletiranje(ActionEvent e){
        narudzbina.kompletiranaNaruzbina();
        btPromena.setOnAction(this::dostavljeno);
        btPromena.setText("Dostavljeno");
        btPromena1.setOnAction(this::vracanje);
        btPromena1.setText("Vraćanje");
        lbTrenutno.setText(narudzbina.getTrenutno_stanje().toString());
    }

    @FXML
    public void otkazivanje(ActionEvent e){
        narudzbina.otkazivanjeNarudzbine();
        btPromena1.setVisible(false);
        btPromena.setVisible(false);
        lbTrenutno.setText(narudzbina.getTrenutno_stanje().toString());
    }

    public void vracanje(ActionEvent e){
        narudzbina.vracanjeNarudzbine();
        btPromena.setVisible(false);
        btPromena1.setVisible(false);
        lbTrenutno.setText(narudzbina.getTrenutno_stanje().toString());
    }

    @FXML
    public void dostavljeno(ActionEvent e){
        narudzbina.uspesnoDostavljena();
        btPromena.setOnAction(this::vracanje);
        btPromena.setText("Vraćanje");
        btPromena1.setVisible(false);
        lbTrenutno.setText(narudzbina.getTrenutno_stanje().toString());
    }

    private void setButtons(){
        switch(narudzbina.getTrenutno_stanje().toString()){
            case "Odbijena":
                btPromena1.setVisible(false);
                btPromena.setVisible(false);
                break;
            case "Isporučena":
                btPromena.setOnAction(this::vracanje);
                btPromena.setText("Vraćanje");
                btPromena1.setVisible(false);
                break;
            case "U transportu":
                btPromena.setOnAction(this::dostavljeno);
                btPromena.setText("Dostavljeno");
                btPromena1.setOnAction(this::vracanje);
                btPromena1.setText("Vraćanje");
                break;
            default:
                break;
        }
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
            narudzbina = n;
            lbTrenutno.setText(narudzbina.getTrenutno_stanje().toString());
            setButtons();
            lbIdNarudzbine.setText(String.valueOf(n.getBroj()));
            lbAdresa.setText(n.getAdresaIsporuke());
            lbCijena.setText(String.valueOf(n.getCijena()));
            if(Aplikacija.getInstance().getUlogovani().getTip() == TipKorisnika.obican){
                btPromena1.setVisible(false);
                btPromena.setVisible(false);
            }
            setText(null);
            setGraphic(box);
        }

    }

    @FXML
    public void detaljno(ActionEvent e){
        NarudzbinaDetailsController c = new NarudzbinaDetailsController();
        SceneSwitcher.switchScene(c, "../view/narudzbina_details_view.fxml", true, narudzbina);
    }

}
