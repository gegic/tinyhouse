package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Kategorija;
import model.Prodavnica;

public class ModeratorCategoriesController extends Controller {

    @FXML
    private ListView<Kategorija> itemList;

    private Stage stage;

    private Aplikacija model;

    public ModeratorCategoriesController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        ObservableList<Kategorija> observableList = FXCollections.observableList(model.getKategorije());
        itemList.setItems(observableList);
        itemList.setCellFactory(e -> new KategorijaCellController());
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
        SceneSwitcher.switchScene(c, "../view/moderator_main_view.fxml", "nebitno");
    }

    @FXML
    public void addKategorija(ActionEvent e) {
        AddKategorijaController c = new AddKategorijaController();
        SceneSwitcher.switchScene(c, "../view/add_kategorija_view.fxml", true);
    }
}
