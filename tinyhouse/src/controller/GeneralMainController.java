package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Proizvod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GeneralMainController extends Controller {

    @FXML private BorderPane borderPane;

    private TopBarController tbc;
    private Aplikacija model;

    public GeneralMainController() {
        model = Aplikacija.getInstance();
    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setInfo(Object o){
        TopBarController c = new TopBarController();
        borderPane.setTop(c.create());
    }

    @FXML
    public void prodavnice(ActionEvent e) {
        KorisnikStoresController c = new KorisnikStoresController();
        SceneSwitcher.switchScene(c, "../view/korisnik_stores_view.fxml",true);
    }
}
