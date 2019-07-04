package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Aplikacija;

import java.io.IOException;

public class ModeratorMainController extends Controller {

    private Stage stage;

    private Aplikacija model;

    public ModeratorMainController(){
        this.model = Aplikacija.getInstance();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void odjava(ActionEvent e) throws IOException {
        SceneSwitcher.odjava();
    }

    @FXML
    public void pregledajProdavnice(ActionEvent e) {
        ModeratorStoresController c = new ModeratorStoresController();
        SceneSwitcher.switchScene(c, "../view/moderator_stores_view.fxml", true);
    }

    @FXML
    public void pregledajProizvode(ActionEvent e) {
        ModeratorItemsController c = new ModeratorItemsController();
        SceneSwitcher.switchScene(c, "../view/moderator_items_view.fxml", true);
    }

    @FXML
    public void pregledajNarudzbine(ActionEvent e){
        ModeratorOrdersController c = new ModeratorOrdersController();
        SceneSwitcher.switchScene(c, "../view/moderator_orders_view.fxml", true);
    }

    @FXML
    public void pregledajKategorije(ActionEvent e){
        ModeratorCategoriesController c = new ModeratorCategoriesController();
        SceneSwitcher.switchScene(c, "../view/moderator_categories_view.fxml", true);
    }
}

