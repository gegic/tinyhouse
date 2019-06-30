package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Korisnik;

public class AdminUsersController extends Controller {

    @FXML
    private ListView<Korisnik> modList;

    private Stage stage;

    private Aplikacija model;

    public AdminUsersController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        ObservableList<Korisnik> observableList = FXCollections.observableList(model.korisnici);
        modList.setItems(observableList);
        modList.setCellFactory(e -> new KorisnikCellController());
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
        AdminMainController c = new AdminMainController();
        SceneSwitcher.switchScene(c, "../view/admin_main_view.fxml");
    }

    @FXML
    public void addModerator(ActionEvent e) {
        AddModeratorController c = new AddModeratorController();
        SceneSwitcher.switchScene(c, "../view/add_moderator_view.fxml");
    }
}
