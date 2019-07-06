package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import model.Aplikacija;
import model.Kategorija;
import model.Proizvod;

import java.io.IOException;
import java.util.ArrayList;


public class FooterController extends Controller{
    @FXML private HBox box;

    private Aplikacija model;

    public FooterController(){model = Aplikacija.getInstance();}

    @FXML
    public void prodavnice(ActionEvent e) {
        KorisnikStoresController c = new KorisnikStoresController();
        SceneSwitcher.switchScene(c, "../view/korisnik_stores_view.fxml",true);
    }

    public HBox create(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/footer_view.fxml"));
        loader.setController(this);
        try {
            loader.load();
            this.stage = SceneSwitcher.getStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return box;
    }
}
