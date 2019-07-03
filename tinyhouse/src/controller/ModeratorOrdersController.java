package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Narudzbina;
import model.Prodavnica;

public class ModeratorOrdersController extends Controller {

    @FXML
    private ListView<Narudzbina> itemList;

    private Stage stage;

    private Aplikacija model;

    public ModeratorOrdersController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        ObservableList<Narudzbina> observableList = FXCollections.observableList(model.narudzbine);
        itemList.setItems(observableList);
        itemList.setCellFactory(e -> new NarudzbinaCellController());
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
}
