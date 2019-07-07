package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Proizvod;

public class ModeratorItemsController extends Controller {

    @FXML
    private ListView<Proizvod> itemsList;

    private Stage stage;

    private Aplikacija model;

    public ModeratorItemsController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        ObservableList<Proizvod> observableList = FXCollections.observableList(model.proizvodi);
        itemsList.setItems(observableList);
        itemsList.setCellFactory(e -> new ProizvodCellController());
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
    public void povratak(ActionEvent e){
        ModeratorMainController c = new ModeratorMainController();
        SceneSwitcher.switchScene(c, "../view/moderator_main_view.fxml", "nebitno");
    }

    @FXML
    public void addProizvod(ActionEvent e) {
        AddProizvodController c = new AddProizvodController();
        SceneSwitcher.switchScene(c, "../view/add_proizvod_view.fxml", true);
    }
}
