package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Prodavnica;

public class ModeratorStoresController extends Controller {

    @FXML
    private ListView<Prodavnica> prodList;

    private Stage stage;

    private Aplikacija model;

    public ModeratorStoresController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        ObservableList<Prodavnica> observableList = FXCollections.observableList(model.prodavnice);
        prodList.setItems(observableList);
        prodList.setCellFactory(e -> new ProdavnicaCellController());
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void odjava(ActionEvent e) {
        SceneSwitcher.odjava();
    }

    @FXML
    public void povratak(ActionEvent e) {
        ModeratorMainController c = new ModeratorMainController();
        SceneSwitcher.switchScene(c, "../view/moderator_main_view.fxml");
    }

    @FXML
    public void addProdavnica(ActionEvent e) {
        AddProdavnicaController c = new AddProdavnicaController();
        SceneSwitcher.switchScene(c, "../view/add_prodavnica_view.fxml");
    }
}
