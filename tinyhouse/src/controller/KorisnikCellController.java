package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import model.Korisnik;
import model.TipKorisnika;

import java.io.File;
import java.io.IOException;

public class KorisnikCellController extends ListCell<Korisnik> {

    @FXML
    private ImageView icon;

    @FXML
    private Label korisnicko_ime;

    @FXML
    private Button izbrisi;

    @FXML
    private HBox box;

    @FXML
    private Region region;

    private FXMLLoader mLLoader;


    @Override
    protected void updateItem(Korisnik k, boolean empty) {
        super.updateItem(k, empty);

        if(empty || k == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../view/useritem.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            korisnicko_ime.setText(String.valueOf(k.getUsername()));
            if(k.getTip() == TipKorisnika.obican) {
                Image image = new Image(getClass().getResourceAsStream("/styles/images/usericon.png"));
                icon.setImage(image);
            } else if (k.getTip() == TipKorisnika.admin){
                Image image = new Image(getClass().getResourceAsStream("/styles/images/adminicon.png"));
                icon.setImage(image);
            }
            setText(null);
            setGraphic(box);
        }

    }

}
