package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Prodavnica;
import model.Proizvod;

import java.util.ArrayList;
import java.util.List;

public class KorisnikStoresController extends Controller {

    @FXML
    private ListView<Prodavnica> prodList;
    @FXML
    BorderPane borderPane;
    private Stage stage;
    private Proizvod p;
    private Aplikacija model;

    private List<Prodavnica> prodavnice;
    public KorisnikStoresController() {
        this.model = Aplikacija.getInstance();
    }

    public void populate() {
        if(prodavnice == null) prodavnice = model.prodavnice;
        TopBarController c = new TopBarController();
        borderPane.setTop(c.create());
        ObservableList<Prodavnica> observableList = FXCollections.observableList(prodavnice);
        prodList.setItems(observableList);
        prodList.setCellFactory(e -> new ProdavnicaCellController(true, this.p));
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void povratak(ActionEvent e) {
        if(p == null) {
            GeneralMainController c = new GeneralMainController();
            SceneSwitcher.switchScene(c, "../view/general_main_view.fxml", "nebitno");
        } else{
            ProizvodDetailsController c = new ProizvodDetailsController();
            SceneSwitcher.switchScene(c, "../view/proizvod_details_view.fxml", p);
        }
    }

    public void setInfo(Object o){
        p = (Proizvod) o;
        prodavnice = p.getProdavnice();
    }
}


